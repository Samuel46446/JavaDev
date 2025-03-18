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

    public static class JeudeDame
    {
        private static final char voidChar = 'O';
        private static final char pionChar = 'X';

        protected static int playerPosX;
        protected static int playerPosY;
        protected static int input;
        private static final char[][] grid = new char[10][10];
        
        public static void main(String[] args)
        {
                    Scanner sc = new Scanner(System.in);
                    System.out.println("Bienvennue dans le jeu de Dame !");
            
                    for(int i = 0; i < grid.length; i++)
                    {
                        for(int k = 0; k < grid[i].length; k++)
                        {
                            grid[i][k] = voidChar;
                        }
                    }
            
                    addImpair(0, pionChar);
                    addImpair( 2, pionChar);
                    addImpair(6, pionChar);
                    addImpair(8, pionChar);
            
                    addPair(1, pionChar);
                    addPair(3, pionChar);
                    addPair(7, pionChar);
                    addPair(9, pionChar);
            
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
                } while(playerPosX <= 9 && playerPosX >= 0 && playerPosY <= 9 && playerPosY >= 0 && grid[playerPosX][playerPosY] == voidChar);
                System.out.println("Que voulez vous faire ?");
                System.out.println("0 -> se déplacer en haut à gauche");
                System.out.println("1 -> se déplacer en haut à droite");
                System.out.println("2 -> se déplacer en bas à gauche");
                System.out.println("3 -> se déplacer en bas à droite");
                System.out.println("4 -> Quitter");
                input = sc.nextInt();
                //int newPosX;
                //int newPosY;

                switch (input) {
                    case 0:
                    int newPosX0 = playerPosX - 1;
                    int newPosY0 = playerPosY - 1;
                    checkCollision(newPosX0, newPosY0, voidChar, pionChar);
                        break;
                    case 1:
                    int newPosX1 = playerPosX + 1;
                    int newPosY1 = playerPosY - 1;
                    checkCollision(newPosX1, newPosY1, voidChar, pionChar);
                        break;
                    case 2:
                    int newPosX2 = playerPosX - 1;
                    int newPosY2 = playerPosY + 1;
                    checkCollision(newPosX2, newPosY2, voidChar, pionChar);
                        break;
                    case 3:
                    int newPosX3 = playerPosX + 1;
                    int newPosY3 = playerPosY + 1;
                    checkCollision(newPosX3, newPosY3, voidChar, pionChar);
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
        
        private static void addImpair(int ligne, char pionChar)
        {
            grid[ligne][1] = pionChar;
            grid[ligne][3] = pionChar;
            grid[ligne][5] = pionChar;
            grid[ligne][7] = pionChar;
            grid[ligne][9] = pionChar;
        }

        private static void addPair(int ligne, char pionChar)
        {
            grid[ligne][0] = pionChar;
            grid[ligne][2] = pionChar;
            grid[ligne][4] = pionChar;
            grid[ligne][6] = pionChar;
            grid[ligne][8] = pionChar;
        }

        private static void checkCollision(int xNew, int yNew, char voidChar, char pionChar)
        {
            if(xNew <= 9 && xNew >= 0 && yNew <= 9 && yNew >= 0)
            {
                if(grid[xNew][yNew] == voidChar)
                {
                    grid[playerPosX][playerPosY] = voidChar;
                    grid[xNew][yNew] = pionChar;
                    System.out.println("Le pion a été déplacé");
                }
                else
                {
                    System.out.println("Le pion n'a pas réussi à être déplacé");
                }
            }
            else
            {
                System.out.println("l'une des valeur de position est incorrecte");
            }
        }

    }
}