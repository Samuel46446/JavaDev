package testing;

import java.util.Scanner;

public final class TD53
{
    private TD53() {}

    public static void tab2DimDefault(int[][] tab1)
    {
        for(int i = 0; i < tab1.length; i++)
        {
            for(int k = 0; k < tab1[i].length; k++)
            {
                tab1[i][k]=0;
            }
        }

        for(int i = 0; i < tab1.length; i++)
        {
            for(int k = 0; k < tab1[i].length; k++)
            {
                System.out.print(tab1[i][k]+"|");
            }
            System.out.println();
        }
    }

    /*
     * Exercice 2 :
     * Affiche le tableau à deux dimension 1 x 2 qui donne : 1 | 2
     * 
     * Exercice 3 :
     * La même chose
     * 
     * Exercice 4 :
     * 0 | 1 | 2
     * 
     * Exercice 5:
     * 
     * 1 | 3 | 5
     * 
     * 0 | 0 | 0
     */

     public static double tab2DimPlusGrand(double[][] tab1)
     {
        double valMax = 0.0;

        for(int i = 0; i < tab1.length; i++)
        {
            for(int k = 0; k < tab1[i].length; k++)
            {
                if(tab1[i][k] > valMax)
                {
                    valMax = tab1[i][k];
                }
            }
        }
        return valMax;
     }

    private static void addImpair(char[][] grid, int ligne, char pionChar)
    {
        grid[ligne][1] = pionChar;
        grid[ligne][3] = pionChar;
        grid[ligne][5] = pionChar;
        grid[ligne][7] = pionChar;
        grid[ligne][9] = pionChar;
    }

    private static void addPair(char[][] grid, int ligne, char pionChar)
    {
        grid[ligne][0] = pionChar;
        grid[ligne][2] = pionChar;
        grid[ligne][4] = pionChar;
        grid[ligne][6] = pionChar;
        grid[ligne][8] = pionChar;
    }

    private static char[][] checkCollision(char[][] grid, int xOld, int yOld, int xNew, int yNew, char voidChar, char pionChar)
    {
        char[][] tab = new char[10][10];
        tab = grid;
        if(xNew <= 10 && xNew >= 0 && yNew <= 10 && yNew >= 0)
        {
            if(grid[xNew][yNew] == voidChar)
            {
                grid[xOld][yOld] = voidChar;
                grid[xNew][yNew] = pionChar;
            }
        }
        return tab;
    }

     public static void jeuDeDame(Scanner sc)
     {
        System.out.println("Bienvennue dans le jeu de Dame !");
        final char voidChar = 'O';
        final char pionChar = 'X';
        int playerPosX;
        int playerPosY;
        int input;
        char[][] grid = new char[10][10];

        for(int i = 0; i < grid.length; i++)
        {
            for(int k = 0; k < grid[i].length; k++)
            {
                grid[i][k] = voidChar;
            }
        }

        addImpair(grid, 0, pionChar);
        addImpair(grid, 2, pionChar);
        addImpair(grid, 6, pionChar);
        addImpair(grid, 8, pionChar);

        addPair(grid, 1, pionChar);
        addPair(grid, 3, pionChar);
        addPair(grid, 7, pionChar);
        addPair(grid, 9, pionChar);

        do { 
            do {
                for(int i = 0; i < grid.length; i++)
                {
                    for(int k = 0; k < grid[i].length; k++)
                    {
                        System.out.print(grid[i][k]);
                    }
                    System.out.println();
                }
                System.out.print("Veuillez entrer la position x du pion : ");
                playerPosX = sc.nextInt();
                System.out.print("Veuillez entrer la position y du pion : ");
                playerPosY = sc.nextInt();
            } while(playerPosX <= 10 && playerPosX >= 0 && playerPosY <= 10 && playerPosY >= 0 && grid[playerPosX][playerPosY] == voidChar);
            System.out.println("Que voulez vous faire ?");
            System.out.println("0 -> se déplacer en haut à gauche");
            System.out.println("1 -> se déplacer en haut à droite");
            System.out.println("2 -> se déplacer en bas à gauche");
            System.out.println("3 -> se déplacer en bas à droite");
            System.out.println("4 -> Quitter");
            input = sc.nextInt();

            switch (input) {
                case 0:
                int newPosX = playerPosX - 1;
                int newPosY = playerPosY - 1;
                grid = checkCollision(grid, playerPosX, playerPosY, newPosX, newPosY, voidChar, pionChar);
                /*if(colission)
                {
                    grid[playerPosX][playerPosY] = voidChar;
                    grid[newPosX][newPosY] = pionChar;
    
                    playerPosX = newPosX;
                    playerPosY = newPosY;
                    System.out.println("La pièce à bien réussis à se déplacer"); 
                }
                else
                {
                    System.out.println("La pièce n'a pas réussis à se déplacer"); 
                }*/
                    break;
                case 1:
                    /*grid[playerPosX][playerPosY] = voidChar;
                    playerPosX -= 1;
                    playerPosY += 1;
                    grid[playerPosX][playerPosY] = pionChar;*/
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    System.out.println("Vous quittez le jeu de dame");
                    break;
                default:
                    System.out.println("Valeur non valide");
                break;
            }
        } while (input != 4);

     }
}