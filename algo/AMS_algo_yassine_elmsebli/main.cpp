#include"Graphe.h"
int main(){
    Graphe ar("arctest.csv","nodetest.csv");
    ar.lecture_noeud();
    ar.lecture_arc();
    Noeud* cc;
    ar.parcours_recursif(152376,25288725,cc);
    ar.find(152376.0,152380.0);
    
}