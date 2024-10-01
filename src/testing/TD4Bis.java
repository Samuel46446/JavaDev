package testing;

import java.util.Scanner;

public final class TD4Bis
{
    private TD4Bis() {}

    /* Optimized method in Utils class */
    public static int factoriel(int nbr)
    {
        int entier = nbr;
        for(int i = nbr-1; i > 0; i--)
        {
            entier=entier*i;
        }
        return entier;
    }

    public static void initFacto(int nbr)
    {
        Utils.msgLn("Factoriel avec une var en trop : " + factoriel(nbr));
        Utils.msgLn("Factoriel optimisé : " + Utils.facto(nbr));
    }

    public static void convertisseurDollarEur(double somme, char signeDevise)
    {
        final double euros = 0.90; //Pour 1$
        final double dollar = 1.11; //Pour 1€
        switch (signeDevise)
        {
            case '$' -> System.out.println("La somme de " + somme + " euros en $ donne " + (somme*dollar) + " $ !");
            case '€' -> System.out.println("La somme de " + somme + " $ en euros donne " + (somme*euros) + " € !");
            default -> System.out.println("erreur variable");
        }
    }

    public static void boucleConv(Scanner sc, double somme, char signeDevise)
    {
        String c;
        do {
            convertisseurDollarEur(somme, signeDevise);
            System.out.print("Voulez vous continuer, entrez q pour quitter et autre chose pour arrêter");
            c = sc.nextLine();
        }while(!"q".equals(c));
    }

    public static String pays(String level)
    {
        return switch (level) {
            case "France" -> "Paris";
            case "Italie" -> "Rome";
            case "Espagne" -> "Barcelone";
            case "Allemagne" -> "Berlin";
            case "Pologne" -> "Varsovie";
            case "République Tchèque" -> "Prague";
            case "Angleterre" -> "Londre";
            case "Portugal" -> "Lisbonne";
            case "Pays-Bas" -> "Amsterdam";
            default -> "Listanbourg";
        };
    }

    public static void appelPays(String... pays)
    {
        for(String s : pays)
        {
            System.out.println(pays(s));
        }
    }

    public static int cube(int nbr)
    {
        return nbr * nbr * nbr;
    }

    public static void expose369(int nbr)
    {
        System.out.println(cube(nbr));
        System.out.println(nbr * nbr * nbr * nbr * nbr * nbr);
        System.out.println(nbr * nbr * nbr * nbr * nbr * nbr * nbr * nbr * nbr);
    }

    public static int valPos(int[] nbr)
    {
        int pos = 0;
        for(int i : nbr)
        {
            if(i >= 0)
            {
                pos=pos+1;
            }
        }
        return pos;
    }

    public static int valNeg(int[] nbr)
    {
        int neg = 0;
        for(int i : nbr)
        {
            if(i < 0)
            {
                neg=neg+1;
            }
        }
        return neg;
    }

    public static void testingValPosandNeg()
    {
        int tab[]={1,-1,9,8,-88,-55,40,55};
        for(int i : tab)
        {
            System.out.print(i+" ");
        }
        System.out.println();
        System.out.println(valPos(tab));
        System.out.println(valNeg(tab));
    }
}