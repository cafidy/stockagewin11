#!/bin/bash

# 1. Afficher les nombres de 1 à 40
echo "Nombres de 1 à 40 :"
for i in {1..40}; do
  echo $i
done

echo "----------------------"

# 2. Afficher les nombres pairs de 1 à 40
echo "Nombres pairs de 1 à 40 :"
for i in {2..40..2}; do
  echo $i
done

echo "----------------------"

# 3. Afficher la somme des nombres de 1 à 40
sum=0
for i in {1..40}; do
  sum=$((sum + i))
done
echo "La somme des nombres de 1 à 40 est : $sum"

echo "----------------------"

# 4. Afficher les tables de multiplication de 1 à 10
echo "Tables de multiplication de 1 à 10 :"
for i in {1..10}; do
  for j in {1..10}; do
    echo "$i x $j = $((i * j))"
  done
  echo "------------------"
done

echo "----------------------"

# 5. Créer 99 fichiers vides nommés fichier1 à fichier99
echo "Création de 99 fichiers..."
for i in {1..99}; do
  touch "fichier$i"
done
echo "99 fichiers créés."

echo "----------------------"

# 6. Créer un fichier fichier0 contenant 99 fois un prénom (passé en argument)
if [ -z "$1" ]; then
  echo "Usage: $0 <prénom>"
  exit 1
fi

echo "Création du fichier fichier0 avec 99 fois le prénom $1..."
for i in {1..99}; do
  echo "$1" >> fichier0
done
echo "Fichier fichier0 créé."

echo "----------------------"

# 7. Compter le nombre de fichiers et de dossiers dans un répertoire (passé en argument)
if [ -z "$2" ]; then
  echo "Usage: $0 <prénom> <chemin_du_répertoire>"
  exit 1
fi

if [ ! -d "$2" ]; then
  echo "Le répertoire '$2' n'existe pas."
  exit 1
fi

nb_fichiers=$(find "$2" -type f | wc -l)
nb_dossiers=$(find "$2" -type d | wc -l)

echo "Dans le répertoire '$2' :"
echo "- Nombre de fichiers : $nb_fichiers"
echo "- Nombre de dossiers : $nb_dossiers"
