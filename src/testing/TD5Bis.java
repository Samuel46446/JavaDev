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
}
