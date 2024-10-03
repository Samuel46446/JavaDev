package testing;

import java.util.Scanner;

public final class TD5
{
    private TD5() {}

    public static int[] tableauDefaut(int size)
    {
        int table[] = new int[size];

        for(int i = 0; i < size; i++)
        {
            table[i]=0;
        }
        return table;
    }

    public static void testtableauDefaut()
    {
        int tab[] = tableauDefaut(7);
        for(int i : tab)
        {
            System.out.println(i);
        }

        tab[1]=55;
        tab[0]=99;
        tab[2]=33;
        tab[4]=84;
        for(int i : tab)
        {
            System.out.println(i);
        }
    }

    public static char[] latinAlphabet()
    {
        return new char[]{'a', 'e', 'i', 'o', 'u', 'y'};
    }

    public static void noteSaisie(Scanner sc)
    {
        int notes[] = new int[9];
        for(int i = 0; i < 9; i++)
        {
            int saisie = -1;
            do { 
                System.out.print("Saisir la note "+(i+1)+" du tableau : ");
                saisie = sc.nextInt();
            } while (saisie < 0 || saisie > 20);
            notes[i]=saisie;
        }

        System.out.println("Résultat : ");
        for(int i : notes)
        {
            System.out.println(i);
        }
    }

    /* 
     * Exercice 4 :
     * on écrit quand on remplace la valeur 
     * 
    for (int i = 0; i < tab.length; i++) {
        tab[i] = 10;
        System.out.println(tab[i]);
    }
    * Exercice 5
    * qu'une seule boucle au lieu d'avoir k et i on n'a un simple i comme l'exercice 4
    *
    * Exercice 6
    1
    1
    2
    3
    5
    8
    13
     */
}