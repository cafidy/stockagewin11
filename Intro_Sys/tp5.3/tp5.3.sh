#!/bin/bash

file="file.txt"

get_note_matiere() {
    while IFS= read -r line; do
        uapv=$(echo "$line" | cut -d'-' -f1)
        name=$(echo "$line" | cut -d'-' -f2)
        surname=$(echo "$line" | cut -d'-' -f3)
        matiere=$(echo "$line" | cut -d'-' -f4)
        note=$(echo "$line" | cut -d'-' -f5)

        if [ "$matiere" = "$1" ] && [ "$note" -ge 10 ]; then
            echo "$name" "$note"
        fi
    done < "$file"
}



file="file.txt"

get_moyenne() {
    moyenne=0
    cpt=0

    while IFS= read -r line; do
        uapv=$(echo "$line" | cut -d'-' -f1)
        name=$(echo "$line" | cut -d'-' -f2)
        surname=$(echo "$line" | cut -d'-' -f3)
        matiere=$(echo "$line" | cut -d'-' -f4)
        note=$(echo "$line" | cut -d'-' -f5)

        if [ "$name" = "$1" ]; then
            moyenne=$((moyenne + note))
            cpt=$((cpt + 1))
        fi
    done < "$file"

    if [ "$cpt" -eq 0 ]; then
        echo "Aucune note trouvée pour $1."
    else
        moyenne_finale=$(echo "scale=2; $moyenne / $cpt" | bc)
        echo "Moyenne de $1 : $moyenne_finale"
    fi
}


to_xml(){
  echo "<students>" > students.xml
  while IFS= read -r line || [ -n "$line" ]; do
    uapv=$(echo "$line" | cut -d'-' -f1)
    name=$(echo "$line" | cut -d'-' -f2)
    surname=$(echo "$line" | cut -d'-' -f3)
    matiere=$(echo "$line" | cut -d'-' -f4)
    note=$(echo "$line" | cut -d'-' -f5)
    {
      echo "  <student>"
      echo "    <surname>$surname</surname>"
      echo "    <name>$name</name>"
      echo "    <course>$matiere</course>"
      echo "    <note>$note</note>"
      echo "  </student>"
    } >> students.xml
  done < notes.txt
  echo "</students>" >> students.xml
  echo "Conversion terminée avec succès. Le fichier students.xml a été créé."
}

