package testing;

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
     * 
     */
}