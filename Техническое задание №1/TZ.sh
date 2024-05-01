#!/bin/bash
echo "Входная директория:"
read  input_dir # принять входную директорию
echo "Выходная директория"
read  output_dir # принять выходную директорию
dir_list=()
dir_list_block=()
dir_list_hidden=()
level1_files_list=()
all_files_list=()
files_list_block=()
files_list_hidden=()
files_list_links=()

for i in "$input_dir"/*; do
	if [[ -d "$i" ]]; then
		if [[ ! -x "$i" ||  ! -r "$i" ]]; then
			dir_list_block+=("$i")
		elif [[ "$(basename "$i")" = ".*" ]]; then
			dir_list_hidden+=("$i")
		else
			dir_list+=("$i")
		fi
	elif [[ -f "$i" ]]; then
		if [[ ! -w "$i"  || ! -r "$i" ]]; then
			files_list_block+=("$i")
		elif [[ "$(basename "$i")" = ".*" ]]; then
			files_list_hidden+=("$i")
		elif [[  -h "$i" ]]; then
			files_list_links+=("$i")
		else
			if [[ $(basename "$i" | grep -c '/') -eq 0 ]]; then 
				level1_files_list+=("$i")
			fi
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
			all_files_list+=("$i")
		fi
	fi
done 
echo "В результате были посещены следующие директории:"
echo "$dir_list"
echo "Однако попались директории, к которым нет доступа:"
echo  "$dir_list_block"
echo "А также скрытые директории:"
echo "$dir_list_hidden"
echo "Такие директории не учитывались"
echo "В результате были скопированы следующие файлы:"
echo  "$all_files_list"
echo "Однако были проигнорированы файлы, к которым нет доступа чтения и записи:"
echo  "$files_list_block"
echo "А также скрытые файлы:"
echo  "$files_list_hidden"
echo "И не учитывались файлы-ссылки"
echo  "$files_list_links"
