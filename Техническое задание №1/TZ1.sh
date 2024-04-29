#!/bin/bash
echo "input_dir"
read  input_dir # принять входную директорию
echo "output_dir"
read  output_dir # принять выходную директорию
dir_list=()
level1_files_list=()
all_file_list=()
for i in "$input_dir"/*; do
	if [[ -d "$i" && -x "$i" && ! "$(basename "$i")" = ".*" ]]; then
		dir_list+=("$i")
	fi
	if [[ -f "$i" && $(basename "$i" | grep -c '/') -eq 0 && ! -h "$i" && -x "$i" && "$(basename "$i")" != .* ]]; then
		level1_files_list+=("$i")
	elif [[ -f "$i" && ! -h "$i" && -x "$i" && ! "$(basename "$i")" = ".*" ]]; then
		all_file_list+=("$i")
	fi
done
for i in "${all_file_list[@]}"; do # перебираем все файлы входной директории
    name_of_file=$(basename "$i")
    if [ -e "$output_dir/$name_of_file" ]; then # если уже существует файл с таким же названием в выходной директории
        change_for_same_files=1 
        while [ -e "$output_dir/$name_of_file.$change_for_same_files" ]; do # добавляем номер к названию файла, пока не найдем отличающееся имя
             change_for_same_files=$((change_for_same_files + 1))
        done 
        cp -p "$i" "$output_dir/$name_of_file.$change_for_same_files" #копируем файл с уникальным именем
    else 
        cp -p "$i" "$output_dir" #копируем файл в выходную директорию
    fi
done

