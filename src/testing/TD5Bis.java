package testing;

import java.util.Scanner;

public final class TD5Bis
{
    private TD5Bis() {}

    public static void entrerDeNombre(Scanner sc)
    {
        Utils.msg("Entrez le nombre de valeur que vous souhaitez entrer : ");
        int max = sc.nextInt();

        int storageNumber[] = new int[max];

        for(int i = 0; i < max; i++)
        {
            Utils.msg("Entrez la valeur " + i + " : ");
            storageNumber[i] = sc.nextInt();
        }

        /*
         * Re-use the methods
         */
        int nbNotePos = TD4Bis.valPos(storageNumber);
        int nbNoteNeg = TD4Bis.valNeg(storageNumber);
        System.out.println("Le nombre de valeur positif est de "+nbNotePos);
        System.out.println("Le nombre de valeur négative est de "+nbNoteNeg);
    }

    public static int sommeTableau(int[] tab)
    {
        int sommeTab = 0;
        for(int i : tab)
        {
            sommeTab = sommeTab + i;
        }
        return sommeTab;
    }

    public static int[] fusion2Tableau(int[] tab1, int[] tab2)
    {
        int tabFinal[];
        if(tab1.length == tab2.length)
        {
            tabFinal = new int[tab2.length];
            for(int i = 0; i < tab2.length; i++)
            {
                tabFinal[i] = tab1[i] + tab2[i];
            }
        }
        else {
            System.out.println("Les tableaux d'entiers n'ont pas la même longueur.");
            tabFinal = new int[1];
            return tabFinal;
        }
        return tabFinal;
    }

    public static void testFusion2Tableau()
    {
        int tab1[] = {4,8,7,9,1,5,4,6};
        int tab2[] = {7,6,5,2,1,3,7,4};

        int tabFinal[] = fusion2Tableau(tab1, tab2);

        for(int i : tabFinal)
        {
            System.out.println(i);
        }
    }

    public static int multi2Tableau(int[] tab1, int[] tab2)
    {
        int result = 0;
        for(int i : tab1)
        {
            for(int k : tab2)
            {
                result=result+(i*k);
            }
        }
        return result;
    }

    public static void testMulti2Tab()
    {
        int tab1[] = {4,8,7,12};
        int tab2[] = {3,6};
        System.out.println(multi2Tableau(tab1, tab2));
    }

    public static void tabEntrerPlus1(Scanner sc)
    {
        Utils.msg("Entrez le nombre de valeur que vous souhaitez entrer : ");
        int max = sc.nextInt();

        int storageNumber[] = new int[max];

        for(int i = 0; i < max; i++)
        {
            Utils.msg("Entrez la valeur " + i + " : ");
            storageNumber[i] = sc.nextInt();
        }

        for(int i = 0; i < storageNumber.length; i++)
        {
            storageNumber[i]=storageNumber[i]+1;
        }
        //Affichage
        for(int i : storageNumber)
        {
            System.out.println(i);
        }
    }

    public static void tabResearchVal(Scanner sc)
    {
        Utils.msg("Entrez le nombre de valeur que vous souhaitez entrer : ");
        int max = sc.nextInt();
        int storageNumber[] = new int[max];
        int nbGrand = 0;
        int nbGrandId = -1;

        for(int i = 0; i < max; i++)
        {
            Utils.msg("Entrez la valeur " + i + " : ");
            storageNumber[i] = sc.nextInt();
        }

        for(int i = 0; i < storageNumber.length; i++)
        {
            if(storageNumber[i] > nbGrand)
            {
                nbGrand=storageNumber[i];
                nbGrandId=i;
            }
        }

        System.out.println("Le nombre le plus grand est "+nbGrand+" à l'id -> "+nbGrandId);
    }

    public static void moyClassSup(Scanner sc)
    {
        Utils.msg("Entrez le nombre de note que vous souhaitez entrer : ");
        int max = sc.nextInt();
        int storageNumber[] = new int[max];
        int sommeNote = 0;

        for(int i = 0; i < max; i++)
        {
            Utils.msg("Entrez la note " + i + " : ");
            storageNumber[i] = sc.nextInt();
        }

        for(int i : storageNumber)
        {
            sommeNote=sommeNote+i;
        }

        int moyenneGen = sommeNote/storageNumber.length;
        int nbEleveSupMoy = 0;
        
        for(int i = 0; i < storageNumber.length; i++)
        {
            if(storageNumber[i] > moyenneGen)
            {
                nbEleveSupMoy = nbEleveSupMoy + 1;
            }
        }

        System.out.println("La moyenne est de " + moyenneGen + " est "+nbEleveSupMoy+" éléve on eu une note supérieur à la moyenne");
    }
}