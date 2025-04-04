#include <ncurses.h>
#include "labIO.h"
#include<iostream>
#include<fstream>
#include<time.h>
#include<cstring>
using namespace std;
void init(pile & p, int taille)
{
	p.taille=taille;
	p.nbe=0;
	p.T=new couple[taille];
}
bool empiler(pile & p, couple c)
{
	if((p.nbe)<p.taille)
	{	
		p.T[p.nbe]=c;
		(p.nbe)++;
		return true;
	}
	else
	{
		cout<<"la pile est pleine"<<endl ;
		exit(1) ;
	}
}
couple depiler(pile & p)
{
	if(p.nbe>0)
	{
		p.nbe--;
		return(p.T[p.nbe]);
	}
	else
	{
		cout<<"la pile est vide"<<endl;
		exit(1);
	}
}
bool vide(pile & P)
{
	if(P.nbe==0) return true;
	else return false;
}
void init(Case & c)
{
	c.N=c.S=c.E=c.W=false;
	c.etat=false;
}

void init(laby & L, int p, int q)
{
	L.p=p; L.q=q;
	L.tab=new Case *[p];
	for(int i=0;i<p;i++) L.tab[i]=new Case[q];
	for(int i=0;i<p;i++)
	{
		for(int j=0;j<q;j++) init(L.tab[i][j]);
	}
}

void ran(char arr[]){

	for (int i = 0; i < 4; i++)
	{

		int swap = rand()%4;
		char tem=arr[i];
		arr[i]=arr[swap];
		arr[swap]=tem;
	}
	
}
void deplacer(laby &L)
{
    int i = 0, j = 0, x;
    while (i != L.p-1 || j != L.q-1)
    {
		Mark_Case(i,j);
        x = LireCommande();
        if (x == 3)
        {
            if (L.tab[i][j].E)
            {
				UMark_Case(i,j);
                j++;
                
            }
            else
            {
                UMark_Case(i,j);
                
            }
        }
        if (x == 6)
        {
            if (L.tab[i][j].S)
            {
				UMark_Case(i,j);
                i++;
                
            }
            else
            {
                UMark_Case(i,j);
                
            }
        }
        if (x == 9)
        {
            if (L.tab[i][j].W)
            {
				UMark_Case(i,j);
                j--;
            }
            else
            {
                UMark_Case(i,j);
				
            }
        }
        if (x == 12)
        {
            if (L.tab[i][j].N)
            {
				UMark_Case(i,j);
                i--;
            }
            else
            {
				UMark_Case(i,j);
				
            }
        }
        if (x == -1)
        {
			clear();
            exit(1);
        }
    }
    if ((i = L.p-1) && (j = L.q-1))
    {
        
        exit(1);
    }
}
laby * My_Creation(int p, int q) {
	srand(time(NULL));
	char arr[5];
	strcpy(arr,"NWSE");
	laby *L6=new laby;
	init(*L6,p,q);
	pile* pil;
	pil=new pile;
	init((*pil),p*q);
	couple deux;
	deux.i=0;
	deux.j=0;
	L6->tab[deux.i][deux.j].etat=true;
	empiler((*pil),deux);
	while (!vide(*pil))
	{
		ran(arr);
		cout<<arr<<endl;
		deux=depiler((*pil));
		(*L6).tab[deux.i][deux.j].etat=true;
		for (int i = 0; i < 4; i++)
		{
			
			
			if (arr[i]=='N' && deux.i>0 &&(*L6).tab[deux.i-1][deux.j].etat==false)
				{
					(*L6).tab[deux.i-1][deux.j].S=true;
					(*L6).tab[deux.i][deux.j].N=true;
					empiler((*pil),deux);
					deux.i=deux.i-1;
					empiler((*pil),deux);
					break;

				}
			else if (arr[i]=='S' && deux.i<p-1 &&(*L6).tab[deux.i+1][deux.j].etat==false)
				{
					(*L6).tab[deux.i+1][deux.j].N=true;
					(*L6).tab[deux.i][deux.j].S=true;
					empiler((*pil),deux);
					deux.i=deux.i+1;
					empiler((*pil),deux);
					break;

				}
			else if (arr[i]=='E' && deux.j<q-1 &&(*L6).tab[deux.i][deux.j+1].etat==false)
				{
					(*L6).tab[deux.i][deux.j+1].W=true;
					(*L6).tab[deux.i][deux.j].E=true;
					empiler((*pil),deux);
					deux.j=deux.j+1;
					empiler((*pil),deux);

					break;

				}
			else if (arr[i]=='W' && deux.j>0 &&(*L6).tab[deux.i][deux.j-1].etat==false)
				{
					(*L6).tab[deux.i][deux.j-1].E=true;
					(*L6).tab[deux.i][deux.j].W=true;
					empiler((*pil),deux);
					deux.j=deux.j-1;
					empiler((*pil),deux);
					break;

				}
			
			
				
		}
		
	}
	
	
	return(L6);
}
pile *explorer(laby&L){
	pile *pil;
	pil=new pile;
	init((*pil),L.p*L.q);
	couple deux;
	deux.i=0;
	deux.j=0;
	srand(time(NULL));
	char arr[5];
	strcpy(arr,"NWSE");
	empiler((*pil),deux);
	while (deux.i!=L.p-1 && deux.j!=L.q-1)
	{
		ran(arr);
		deux=depiler((*pil));
		
		L.tab[deux.i][deux.j].marq=true;
		for (int i = 0; i < 4; i++)
		{
			
			
			if (arr[i]=='N' && deux.i>0 &&L.tab[deux.i-1][deux.j].marq==false && L.tab[deux.i][deux.j].N==true)
				{
					
					empiler((*pil),deux);
					deux.i=deux.i-1;
					empiler((*pil),deux);
					break;

				}
			else if (arr[i]=='S' && deux.i<L.p-1 &&L.tab[deux.i+1][deux.j].marq==false && L.tab[deux.i][deux.j].S==true)
				{
				
					empiler((*pil),deux);
					deux.i=deux.i+1;
					empiler((*pil),deux);
					break;

				}
			else if (arr[i]=='E' && deux.j<L.q-1 &&L.tab[deux.i][deux.j+1].marq==false && L.tab[deux.i][deux.j].E==true )
				{
					
					empiler((*pil),deux);
					deux.j=deux.j+1;
					empiler((*pil),deux);

					break;

				}
			else if (arr[i]=='W' && deux.j>0 &&L.tab[deux.i][deux.j-1].marq==false && L.tab[deux.i][deux.j].W==true)
				{
					
					empiler((*pil),deux);
					deux.j=deux.j-1;
					empiler((*pil),deux);
					break;

				}
			
			
				
		}

	}
	return pil;
	


}
void affiche_chemin(pile &P)
{
	for (int i = 0; i < P.nbe; i++)
	{
		Mark_Case(P.T[i].i,P.T[i].j);
	}
	

}
void ecrire_Laby(const char *filename, laby *L) {
    ofstream my_cout;
    my_cout.open(filename);

    my_cout << L->p << " " << L->q << endl;

    for (int i = 0; i < L->p; i++) {
        for (int j = 0; j < L->q; j++) {
            my_cout << L->tab[i][j].W << " " << L->tab[i][j].N << " " << L->tab[i][j].S << " " << L->tab[i][j].E << " ";
        }
        my_cout << endl;
    }

    my_cout.close();
}

laby *lire_Laby(const char  *filename){
	ifstream my_cin;

	my_cin.open(filename);

	laby *L;
	L=new laby;
	my_cin>>(*L).p>>(*L).q;
	init((*L),(*L).p,(*L).q);

	for(int i=0;i<(*L).p;i++)
	{
		for(int j=0;j<(*L).q;j++)
		{
			my_cin>>(*L).tab[i][j].W>>(*L).tab[i][j].N>>(*L).tab[i][j].S>>(*L).tab[i][j].E;
		}
	}
	return L;
}
void printGame() {
    cout << "  GGG    A   M   M  EEEEE\n";
    cout << " G      A A  MM MM  E\n";
    cout << " G  GG AAAAA M M M  EEEE\n";
    cout << " G   G A   A M   M  E\n";
    cout << "  GGG  A   A M   M  EEEEE\n";
}



int main()
{
	int m ;
	printGame();
	cout<<"int m";
	cin>>m;
	InitCurses();
	
	laby * labyrinth=My_Creation(7,2);
	if (m==2)
	{
		Show_Lab(*labyrinth);
		deplacer(*labyrinth);
		if (deplacer(*labyrinth)==labyrinth->tab[7-1][6-1])
		{
			clear();
			cout<<"gg";
		}
		
	}
	if (m==4)
	{
		Show_Lab(*labyrinth);
		pile * pil;
		pil=explorer(*labyrinth);
		affiche_chemin((*pil));
	}
	
		
	
	
	
	
	
	
	
	
	
	
	
	
    int ch = wgetch(stdscr) ;
    EndCurses();
	
}