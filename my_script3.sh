#!/bin/bash

if [ ! -d "$1" ] || [ ! -d "$2" ]; then
    echo "$0 <input_directory> <output_directory>"
    exit 1
fi

input_dir=$1
output_dir=$2

mkdir -p $output_dir

find $input_dir -type f | while read file; do
    filename=$(basename "$file")
    new_file="$output_dir/$filename"

    i=1
    while [ -e "$new_file" ]; do
        base=${filename%.*}
        ext=${filename##*.}
        if [ "$base" != "$ext" ]; then
            new_file="$output_dir/${base}_$i.$ext"
        else
            new_file="$output_dir/${base}_$i"
        fi
        let i++
    done

    cp "$file" "$new_file"
done
