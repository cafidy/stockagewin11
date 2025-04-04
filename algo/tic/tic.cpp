#include"tic.h"

tic::tic(){
    for (int i = 0; i < 3; ++i) {
        for (int j = 0; j < 3; ++j) {
            board[i][j] = ' ';
        }
    }
    po='X';
}

void tic::drawboard() 
{ 
    cout << "-------------\n"; 
    for (int i = 0; i < 3; i++) { 
        cout << "| "; 
        for (int j = 0; j < 3; j++) { 
            cout << board[i][j] << " | "; 
        } 
        cout << "\n-------------\n"; 
    } 
} 
  

bool tic::checkwin(char player) 
{ 
    
    for (int i = 0; i < 3; i++) { 
        if (board[i][0] == player && board[i][1] == player 
            && board[i][2] == player) 
            return true;
        if (board[0][i] == player && board[1][i] == player 
            && board[2][i] == player) 
            return true; 
    } 
    if (board[0][0] == player && board[1][1] == player 
        && board[2][2] == player) 
        return true; 
    if (board[0][2] == player && board[1][1] == player 
        && board[2][0] == player) 
        return true; 
    return false; 
}
void tic::available(){
    size_c=0;
    for (int i = 0; i < 3; i++)
    {
        cerr<<"pass1"<<endl;
        for (int  j= 0; j < 3; j++)
        {
            cerr<<"pass2"<<endl;
            if (board[i][j]==' ')
            {
                cerr<<"pass3"<<endl;
                l[size_c]=i;
                c[size_c]=j;
                size_c++;
                cerr<<"pass4"<<endl;
                
            }
            
        }
        
    }
    cerr<<"pass5"<<endl;
    
}
int tic::play_ro() {
   
    for (int i = 0; i < 3; i++) {
        int cp = 0;
        for (int j = 0; j < 3; j++) {
            if (board[i][j] == po) cp++;
        }
        if (cp == 2) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == ' ') {
                    po_l = i;
                    po_c = j;
                    return 1; 
                }
            }
        }
    }
    for (int j = 0; j < 3; j++) {
        int cp = 0;
        for (int i = 0; i < 3; i++) {
            if (board[i][j] == po) cp++;
        }
        if (cp == 2) {
            for (int i = 0; i < 3; i++) {
                if (board[i][j] == ' ') {
                    po_l = i;
                    po_c = j;
                    return 1; 
                }
            }
        }
    }
    if (board[0][0] == po && board[1][1] == po && board[2][2] == ' ') { po_l = 2; po_c = 2; return 1; }
    if (board[2][2] == po && board[1][1] == po && board[0][0] == ' ') { po_l = 0; po_c = 0; return 1; }
    if (board[0][2] == po && board[1][1] == po && board[2][0] == ' ') { po_l = 2; po_c = 0; return 1; }
    if (board[2][0] == po && board[1][1] == po && board[0][2] == ' ') { po_l = 0; po_c = 2; return 1; }

   
    char opponent = (po == 'X') ? 'O' : 'X';
    for (int i = 0; i < 3; i++) {
        int cp = 0;
        for (int j = 0; j < 3; j++) {
            if (board[i][j] == opponent) cp++;
        }
        if (cp == 2) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == ' ') {
                    po_l = i;
                    po_c = j;
                    return 1; 
                }
            }
        }
    }
    for (int j = 0; j < 3; j++) {
        int cp = 0;
        for (int i = 0; i < 3; i++) {
            if (board[i][j] == opponent) cp++;
        }
        if (cp == 2) {
            for (int i = 0; i < 3; i++) {
                if (board[i][j] == ' ') {
                    po_l = i;
                    po_c = j;
                    return 1; 
                }
            }
        }
    }
    if (board[0][0] == opponent && board[1][1] == opponent && board[2][2] == ' ') { po_l = 2; po_c = 2; return 1; }
    if (board[2][2] == opponent && board[1][1] == opponent && board[0][0] == ' ') { po_l = 0; po_c = 0; return 1; }
    if (board[0][2] == opponent && board[1][1] == opponent && board[2][0] == ' ') { po_l = 2; po_c = 0; return 1; }
    if (board[2][0] == opponent && board[1][1] == opponent && board[0][2] == ' ') { po_l = 0; po_c = 2; return 1; }


    if (board[1][1] == ' ') { po_l = 1; po_c = 1; return 1; } 
    if (board[0][0] == ' ') { po_l = 0; po_c = 0; return 1; } 
    if (board[0][2] == ' ') { po_l = 0; po_c = 2; return 1; } 
    if (board[2][0] == ' ') { po_l = 2; po_c = 0; return 1; } 
    if (board[2][2] == ' ') { po_l = 2; po_c = 2; return 1; } 

    
    available();
    if (size_c == 0) {
        return 0; 
    }
    int randomNumber = rand() % size_c;
    po_c = c[randomNumber];
    po_l = l[randomNumber];
    return 1;
}



int tic::game() {
    char player = 'X'; 
    int row, col; 
    int turn; 
  
    cout << "Welcome to Tic-Tac-Toe!\n"; 
    string pa;
    while (true) {
        cout << "Press PVP to play with another person or PVE to play against the computer" << endl;
        cin >> pa;
        
        if (pa != "PVP" && pa != "PVE") {
            cout << "This is not a valid mode, try again" << endl;
        } else {
            break; 
        }
    }
    int umber = rand() % 2;
    if (umber==1)
    {
        player='X';
    }else{
        player='O';
    }
    
    
    for (turn = 0; turn < 9; turn++) { 
        drawboard(); 

        if (pa == "PVP") {
            while (true) { 
                cout << "Player " << player << ", enter row (0-2) and column (0-2): "; 
                cin >> row >> col; 
    
                if (row < 0 || row > 2 || col < 0 || col > 2 || board[row][col] != ' ') { 
                    cout << "Invalid move. Try again.\n"; 
                } else { 
                    break; 
                } 
            } 
            
            board[row][col] = player; 
            

            if (checkwin(player)) { 
                drawboard(); 
                cout << "Player " << player << " wins!\n"; 
                return 0; 
            } 
    

            player = (player == 'X') ? 'O' : 'X'; 
        } else { 

            if (player == po) {

                play_ro();
                cerr << "Computer plays: row=" << po_l << ", col=" << po_c << endl;
                board[po_l][po_c] = po; 
                
                if (checkwin(po)) { 
                    cout << "Computer (Player " << po << ") wins!\n"; 
                    return 0; 
                } 
                
                player = (player == 'X') ? 'O' : 'X'; 
            } else {

                while (true) { 
                    cout << "Player " << player << ", enter row (0-2) and column (0-2): "; 
                    cin >> row >> col; 
                    if (row < 0 || row > 2 || col < 0 || col > 2 || board[row][col] != ' ') { 
                        cout << "Invalid move. Try again.\n"; 
                    } else { 
                        break; 
                    } 
                } 
                
                board[row][col] = player; 


                if (checkwin(player)) { 
                    drawboard(); 
                    cout << "Player " << player << " wins!\n"; 
                    return 0; 
                } 

                player = (player == 'X') ? 'O' : 'X'; 
            }
        }
    } 
  
    drawboard(); 
    cout << "It's a draw!\n"; 
    return 0; 
}
