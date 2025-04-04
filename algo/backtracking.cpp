#include <iostream>
#include <vector>
using namespace std;

// Variables globales
vector<int> T; // Tableau d'entiers
int n;         // Taille du tableau

// Fonction de backtracking
bool backtracking(vector<int>& B, int x, int i) {
    // Cas de base : somme atteinte
    if (x == 0) {
        return true;
    }

    // Cas de base : fin du tableau sans trouver de solution
    if (i == n) {
        return false;
    }

    // Ne pas inclure T[i] dans la somme
    B[i] = 0;
    if (backtracking(B, x, i + 1)) {
        return true;
    }

    // Inclure T[i] dans la somme, si possible
    if (x >= T[i]) {
        B[i] = 1;
        if (backtracking(B, x - T[i], i + 1)) {
            return true;
        }
    }

    // Réinitialisation avant de remonter dans l'arbre
    B[i] = 0;
    return false;
}

// Fonction principale
void solve(int x) {
    vector<int> B(n, 0); // Initialisation de B avec des 0
    if (backtracking(B, x, 0)) {
        cout << "Solution trouvée : ";
        for (int i = 0; i < n; ++i) {
            if (B[i] == 1) {
                cout << T[i] << " ";
            }
        }
        cout << endl;
    } else {
        cout << "Aucune solution." << endl;
    }
}

// Programme principal
int main() {
    // Exemple : tableau et somme cible
    T = {2, 2, 1, 3, 5};
    n = T.size();
    int x;
    cout << "Entrez la somme cible x : ";
    cin >> x;

    solve(x);

    return 0;
}
