#!/bin/bash

if [ ! -d "$1" ] || [ ! -d "$2" ]; then
    echo "$0 <input_directory> <output_directory>"
    exit 1
fi

input_dir=$1
output_dir=$2

shopt -s globstar

for file in "$input_dir"/**; do
    if [ -f "$file" ]; then
        filename=$(basename "$file")
        new_file="$output_dir/$filename"
        
        if [ -f "$new_file" ]; then
            base="${filename%.*}"
            ext="${filename##*.}"
            i=1
            while [ -f "$output_dir/$base-$i.$ext" ]; do
                let i++
            done
            cp "$file" "$output_dir/$base-$i.$ext"
        else
            cp "$file" "$new_file"
        fi
    fi
done

