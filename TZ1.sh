#!/bin/bash

echo "Входная директория:"
read  input_dir # Принять входную директорию
echo "Выходная директория:"
read  output_dir # Принять выходную директорию
dir_list=() # Список посещенных директорий
dir_list_block=() # Список директорий, у которых нет права доступа x, на выполнение 
dir_list_hidden=$(find "$input_dir" -type d -name '.*') # Список скрытых директорий
all_files_list=() # Список всех файлов, вложенных во входную директорию, которые копируются
level1_files_dict=() # Список всех файлов, непосредственно вложенных во входную директорию
files_list_block=() # Список файлов, у которых нет права доступа r, на чтение 
files_list_hidden=$(find "$input_dir" -type f -name '.*') # Список скрытых файлов
files_list_links=() # Список файлов-ссылок 

# Функция для обработки файлов и директорий
process() {
    local curr_dir="$1"
    # Перебор всех элементов в текущей директории
    for i in "$curr_dir"/*; do
        if [[ -d "$i" ]]; then # Если элемент - директория
            if [[ ! -x "$i" ]]; then
                dir_list_block+=("$i") # Если нет прав на выполнение, добавить в список директорий без права доступа
            else
		dir_list+=("$i") # Иначе добавить директорию в список и рекурсивно обработать ее содержимое
		process "$i"
  	    fi
        elif [[ -f "$i" ]]; then  # Если элемент - файл
            if [[  ! -r "$i" ]]; then  # Если нет прав на чтение, добавить в список файлов, не имеющих доступ
                files_list_block+=("$i")
            elif [[ -h "$i" ]]; then  # Если файл - символическая ссылка, добавить в список файлов-ссылок
                files_list_links+=("$i")
            else # Иначе добавить файл в список
		all_files_list+=("$i")
                name_of_file=$(basename "$i")
		if [[ "$i" == "$input_dir/$name_of_file" ]]; then # Проверка, принадлежит ли файл прямо к входной директории
        		level1_files_dict+=("$i")
	  	fi
                if [[ -e "$output_dir/$name_of_file" ]]; then # Проверка существования файла с таким же именем в выходной директории
                    change_for_same_files=1  # Если файл существует, добавить число
                    while [[ -e "$output_dir/$name_of_file.$change_for_same_files" ]]; do
                        change_for_same_files=$((change_for_same_files + 1))
                    done
                    cp -p "$i" "$output_dir/$name_of_file.$change_for_same_files"
                else
                    cp -p "$i" "$output_dir" # Иначе просто скопировать в выходную директорию
                fi
            fi
        fi
    done
}
# Вызов функции для обработки файлов и директорий во входной директории
process "$input_dir"
# Вывод информации о посещенных и пропущенных элементах
if [[ ${#dir_list[@]} -gt 0 ]]; then
    echo "В результате были посещены следующие директории:"
    printf '%s\n' "${dir_list[@]}"
fi
if [[ ${#dir_list_block[@]} -gt 0 ]]; then
    echo "Были пропущены директории, к которым нет доступа:"
    printf '%s\n' "${dir_list_block[@]}"
fi
if [[ ${#dir_list_hidden[@]} -gt 0 ]]; then
    echo "Были пропущены скрытые директории:"
    printf '%s\n' "${dir_list_hidden[@]}"
fi
if [[ ${#all_files_list[@]} -gt 0 ]]; then
    echo "В результате были скопированы следующие файлы:"
    printf '%s\n' "${all_files_list[@]}"
    if [[ ${#level1_files_dict[@]} -gt 0 ]]; then
    echo "Из них непосредственно вложены во входную директорию файлы:"
    printf '%s\n' "${level1_files_dict[@]}"
    fi
else
    echo "В результате было скопировано 0 файлов."
fi
if [[ ${#files_list_block[@]} -gt 0 ]]; then
    echo "Были проигнорированы файлы, к которым нет доступа чтения:"
    printf '%s\n' "${files_list_block[@]}"
fi
if [[ ${#files_list_hidden[@]} -gt 0 ]]; then
    echo "Были проигнорированы скрытые файлы:"
    printf '%s\n' "${files_list_hidden[@]}"
fi
if [[ ${#files_list_links[@]} -gt 0 ]]; then
    echo "Не учитывались файлы-ссылки:"
    printf '%s\n' "${files_list_links[@]}"
fi
