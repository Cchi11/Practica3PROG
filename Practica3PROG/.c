#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>
#define MAX_F 7
#define MAX_C 7
#define MAX 80
void construir_matriu_xifrat(char matriu_x[][7])
{
    char par1[7]="XIFRAT";
    char par2[7]="NORMAL";
    int i=1; int j=1; int cont=0;
    matriu_x[0][0]=' ';
    while (i<7)
    {
        matriu_x[0][i]=par1[i-1];
        i++;
    }
    while(j<7)
    {
       matriu_x[j][0]=par2[j-1];
       j++;
    }

    for(i=1;i<7;i++)
    {
        for(j=1;j<7;j++)
        {
            if(cont<26)
            {
                matriu_x[i][j]='A'+cont;
            }
            else
            {
                if(cont==26)
                 {
                     matriu_x[i][j]=' ';
                 }

                else
                {
                    matriu_x[i][j]='0'+cont-26;
                }
            }
         cont++;
        }
    }

    for(i=0;i<7;i++)
    {
        for(j=0;j<7;j++)
        {
            printf("%c", matriu_x[i][j]);
        }
        printf("\n");
    }


}
void mostra_menu()
{
    printf("1-Cacular el factorial\n");
    printf("2-Calcular les variacions(sense repeticio)\n");
    printf("3-Sortir del programa\n");
    printf("Quina opcio vols?:\n");
}
void majuscules(char frase[MAX])
{
    int i=0;
    while(frase[i]!='0')
    {
        if((frase[i]>='a')&&(frase[i]<='z'))
        {
           frase[i]=frase[i]-32;
        }
        i++;
    }
}
bool buscar_lletra(char matriu_x[][7], char lletra, char *lletra_x1, char *lletra_x2)
{
    int f,c;
    bool trobat=false;
    for (int f=1; f<7; f++)
    {
        for (int c=1; c<7; c++)
        {
            if (matriu_x[f][c]== lletra)
                { 
                *lletra_x1= matriu_x[f][0]; 
                *lletra_x2= matriu_x[0][c];
                trobat=true;
                }
        }
    }
    return trobat;
}
void xifrar_frase(char frase[MAX], char matriu_x[][7], char frase_xifrada[160])
{
    int i=0;
    int j=0;
    char lletra,lletra_x1, lletra_x2;
    majuscules(frase);
    while(frase[i]!='\0')
    {
      frase[i]=lletra;
      if(buscar_lletra(matriu_x, lletra, &lletra_x1, &lletra_x2))
      {
          frase_xifrada[j]=lletra_x1; j++;
          frase_xifrada[j]=lletra_x2; j++;
      }
      i++;
    }
    
    frase_xifrada[j]='\0';
}

int main()
{
    int num; char frase[MAX]; char matriu_x[MAX_F][MAX_C]; char frase_xifrada[160];
    construir_matriu_xifrat(matriu_x);
    printf("Introdueix una frase per xifrar\n");
    fgets(frase,MAX,stdin);
    xifrar_frase(frase, matriu_x, frase_xifrada);
    printf("Frase xifrada: %s\n", frase_xifrada);
    return 0;
}