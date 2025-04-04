#!/bin/bash

if [ "$#" -ne 2 ]; then
    echo "Erreur: Veuillez fournir le répertoire source et le répertoire de destination."
    exit 1
fi

source_dir="$1"
dest_dir="$2"

# Vérifier si le répertoire source existe
if [ ! -d "$source_dir" ]; then
    echo "Erreur: Le répertoire source n'existe pas."
    exit 1
fi

mkdir -p "$dest_dir"

for file in "$source_dir"/*.mp3; do
    # Vérifier si le fichier existe (évite une erreur si aucun .mp3 n'est trouvé)
    [ -e "$file" ] || continue
    
    filename=$(basename "$file")

    # Extraire les parties du nom de fichier
    year=$(echo "$filename" | cut -d'-' -f1)
    genre=$(echo "$filename" | cut -d'-' -f2)
    album=$(echo "$filename" | cut -d'-' -f3)
    name=$(echo "$filename" | cut -d'-' -f4-)

    # Construire le chemin de destination
    dest_path="$dest_dir/$genre/$year/$album"
    mkdir -p "$dest_path"

    # Copier sans écraser si un fichier du même nom existe déjà
    if [ ! -e "$dest_path/$name" ]; then
        cp "$file" "$dest_path/$name"
    else
        echo "Attention: $name existe déjà dans $dest_path. Ignoré."
    fi
done

