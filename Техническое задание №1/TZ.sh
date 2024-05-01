#!/bin/bash

echo "Входная директория:"
read  input_dir # принять входную директорию
echo "Выходная директория"
read  output_dir # принять выходную директорию
dir_list=()
dir_list_block=()
dir_list_hidden=()
all_files_list=()
files_list_block=()
files_list_hidden=()
files_list_links=()

# Рекурсивная функция для обхода всех файлов и директорий
process_files() {
    local current_dir="$1"

    for i in "$current_dir"/*; do
        if [[ -d "$i" ]]; then
            dir_list+=("$i")
            if [[ ! -x "$i" || ! -r "$i" ]]; then
                dir_list_block+=("$i")
            elif [[ "$(basename "$i")" = ".*" ]]; then
                dir_list_hidden+=("$i")
            fi
            process_files "$i"  # Рекурсивный вызов для обработки поддиректорий
        elif [[ -f "$i" ]]; then
            all_files_list+=("$i")
            if [[ ! -w "$i" || ! -r "$i" ]]; then
                files_list_block+=("$i")
            elif [[ "$(basename "$i")" = ".*" ]]; then
                files_list_hidden+=("$i")
            elif [[ -h "$i" ]]; then
                files_list_links+=("$i")
            else
                name_of_file=$(basename "$i")
                if [ -e "$output_dir/$name_of_file" ]; then
                    change_for_same_files=1
                    while [ -e "$output_dir/$name_of_file.$change_for_same_files" ]; do
                        change_for_same_files=$((change_for_same_files + 1))
                    done
                    cp -p "$i" "$output_dir/$name_of_file.$change_for_same_files"
                else
                    cp -p "$i" "$output_dir"
                fi
            fi
        fi
    done
}

# Вызов рекурсивной функции для обработки всех файлов и директорий
process_files "$input_dir"

echo "В результате были посещены следующие директории:"
printf '%s\n' "${dir_list[@]}"
echo "Однако попались директории, к которым нет доступа:"
printf '%s\n' "${dir_list_block[@]}"
echo "А также скрытые директории:"
printf '%s\n' "${dir_list_hidden[@]}"
echo "Такие директории не учитывались"
echo "В результате были скопированы следующие файлы:"
printf '%s\n' "${all_files_list[@]}"
echo "Однако были проигнорированы файлы, к которым нет доступа чтения и записи:"
printf '%s\n' "${files_list_block[@]}"
echo "А также скрытые файлы:"
printf '%s\n' "${files_list_hidden[@]}"
echo "И не учитывались файлы-ссылки"
printf '%s\n' "${files_list_links[@]}"
