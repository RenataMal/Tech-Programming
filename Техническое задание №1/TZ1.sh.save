#!/bin/bash
read  input_dir # принять входную директорию
read  output_dir # принять выходную директорию
dir_list=($(find "$input_dir" -type d)) # список директориев, находящихся во входной директории
level1_files_list=($(find "$input_dir" -maxdepth 1 -type f)) # список файлов, находящихся непосредственно во входной директории 
all_file_list=($(find "$input_dir" -type f)) # список всех файлов, вложенных во входную директорию
for i in "${all_file_list[@]}"; do # перебираем все файлы входной директории
    name_of_file=$(basename "$i")
    if [[ -e "$output_dir/$name_of_file" ]]; then # если уже существует файл с таким же названием в выходной директории
        change_for_same_files=1 
        while [[ -e "$output_dir/$name_of_file.$change_for_same_files" ]]; do # добавляем номер к названию файла, пока не найдем отличающееся имя
             change_for_same_files=$((change_for_same_files + 1))
        done 
        cp -p "$i" "$output_dir/$name_of_file.$change_for_same_files" #копируем файл с уникальным именем
    else 
        cp -p "$i" "$output_dir" #копируем файл в выходную директорию
    fi
done
