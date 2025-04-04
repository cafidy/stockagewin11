#!/bin/bash

# Exercice 1: Vérifier si trois arguments sont passés
if [ "$#" -ne 3 ]; then
    echo "Erreur: Vous devez passer exactement 3 arguments."
    exit 1
fi

# Exercice 2: Vérifier si un nombre est inférieur ou égal à 10
if [ "$1" -le 10 ]; then
    echo "$1 est inférieur ou égal à 10."
else
    echo "$1 est supérieur à 10."
fi

# Exercice 3: Vérifier si un nombre est entre 10 et 20
if [ "$1" -ge 10 ] && [ "$1" -le 20 ]; then
    echo "$1 est compris entre 10 et 20."
else
    echo "$1 n'est pas compris entre 10 et 20."
fi

# Exercice 4: Vérifier si un nombre est positif, négatif ou nul
if [ "$1" -gt 0 ]; then
    echo "$1 est positif."
elif [ "$1" -lt 0 ]; then
    echo "$1 est négatif."
else
    echo "$1 est nul."
fi

# Exercice 5: Calcul de la somme et de la différence de deux nombres
somme=$(($1 + $2))
difference=$(($1 - $2))
echo "Somme: $somme"
echo "Différence: $difference"

# Exercice 6: Vérifier si un nombre est un entier
if [[ "$1" =~ ^-?[0-9]+$ ]]; then
    echo "$1 est un entier."
    exit 1
else
    echo "$1 n'est pas un entier."
    exit 0
fi

# Exercice 7: Vérifier si un argument est un fichier ou un dossier
if [ -f "$1" ]; then
    echo "fichier"
elif [ -d "$1" ]; then
    echo "dossier"
else
    echo "Ce n'est ni un fichier ni un dossier."
fi

# Exercice 8: Comparer le nombre de fichiers dans deux dossiers
if [ -d "$1" ] && [ -d "$2" ]; then
    count1=$(ls -1 "$1" | wc -l)
    count2=$(ls -1 "$2" | wc -l)
    if [ "$count1" -gt "$count2" ]; then
        echo "Le dossier $1 contient plus de fichiers ($count1) que $2 ($count2)."
    else
        echo "Le dossier $2 contient plus de fichiers ($count2) que $1 ($count1)."
    fi
else
    echo "Un ou les deux arguments ne sont pas des dossiers valides."
fi

# Fonction get_number_i: Extrait le numéro i d'un fichier nomf.i.tar.gz
get_number_i() {
    local filename="$1"
    if [[ "$filename" =~ ^.+\.([0-9]+)\.tar\.gz$ ]]; then
        echo "${BASH_REMATCH[1]}"
    else
        echo "Nom de fichier invalide" >&2
        return 1
    fi
}

# Fonction get_max_number_i: Trouve le plus grand i pour log_file.i.tar.gz
get_max_number_i() {
    local logFile="$1"
    local max=-1
    for file in ${logFile}.*.tar.gz; do
        if [[ "$file" =~ ^${logFile}\.[0-9]+\.tar\.gz$ ]]; then
            num=$(get_number_i "$file")
            if [[ "$num" =~ ^[0-9]+$ ]] && [ "$num" -gt "$max" ]; then
                max=$num
            fi
        fi
    done
    echo "$max"
}

# Fonction rotation_log: Effectue la rotation des logs
rotation_log() {
    local logFile="$1"
    local max=$(get_max_number_i "$logFile")
    
    for ((i=max; i>=0; i--)); do
        if [ -f "${logFile}.${i}.tar.gz" ]; then
            mv "${logFile}.${i}.tar.gz" "${logFile}.$((i+1)).tar.gz"
        fi
    done
    
    if [ -f "$logFile" ]; then
        tar -czf "${logFile}.0.tar.gz" "$logFile"
        > "$logFile"
    fi
}
