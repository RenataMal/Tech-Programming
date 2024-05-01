#!/bin/bash

echo "Входная директория:"
read  input_dir # принять входную директорию
echo "Выходная директория:"
read  output_dir # принять выходную директорию
dir_list=()
dir_list_block=()
dir_list_hidden=$(find "$input_dir" -type d -name '.*')
all_files_list=()
level1_files_dict=()
files_list_block=()
files_list_hidden=$(find "$input_dir" -type f -name '.*')
files_list_links=()
process() {
    local current_dir="$1"
    for i in "$current_dir"/*; do
        if [[ -d "$i" ]]; then
            if [[ ! -x "$i" ]]; then
                dir_list_block+=("$i")
            else
		dir_list+=("$i")
		process "$i"
  	    fi
        elif [[ -f "$i" ]]; then
            if [[  ! -r "$i" ]]; then
                files_list_block+=("$i")
            elif [[ -h "$i" ]]; then
                files_list_links+=("$i")
            else
		all_files_list+=("$i")
                name_of_file=$(basename "$i")
		if [[ "$i" == "$input_dir/$name_of_file" ]]; then
        		level1_files_dict+=("$i")
	  	fi
                if [[ -e "$output_dir/$name_of_file" ]]; then
                    change_for_same_files=1
                    while [[ -e "$output_dir/$name_of_file.$change_for_same_files" ]]; do
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

process "$input_dir"

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
