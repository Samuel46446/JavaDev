package testing;

import java.util.Scanner;

public final class TD2 {

    private TD2(){}

    public static void prime(Scanner sc, boolean debugMod)
    {
        System.out.print("Entrez le chiffre d'affaires : ");
        double ca = sc.nextDouble();
        double settingt1 = 0;
        double settingt2 = 0;
        double settingt3 = 0;

        final double lim1 = 2000;
        final double lim2 = 10000;
        final double lim3 = 20000;

        while (ca > lim3) {
            ca = ca - 10;
            settingt3 = settingt3+10;
        }

        while (ca > lim2) {
            ca = ca - 10;
            settingt2 = settingt2+10;
        }

        while (ca > lim1) {
            ca = ca - 10;
            settingt1 = settingt1+10;
        }
        double t1 = settingt1 * 0.05;
        double t2 = settingt2 * 0.10;
        double t3 = settingt3 * 0.25;
        if(debugMod)
        {
            System.out.println(settingt1);
            System.out.println(settingt2);
            System.out.println(settingt3);
        }
        if(ca < 2000)
        {
            System.out.println("Pas de Prime");
        }
        System.out.println("La prime touché est de : "+(t1+t2+t3)+" €");
    }

    public static void calculatrice(Scanner sc)
    {
        System.out.print("Entrez le premier nombre du calcul : ");
        double nb1 = sc.nextDouble();
        System.out.print("Entrez un signe de calcul valide (+ - * /) : ");
        char signe = sc.next().charAt(0);
        System.out.print("Entrez le deuxième nombre du calcul : ");
        double nb2 = sc.nextDouble();

        switch (signe) {
            case '*' -> System.out.println("Résultat -> "+ (nb1*nb2));
            case '+' -> System.out.println("Résultat -> "+ (nb1+nb2));
            case '-' -> System.out.println("Résultat -> "+ (nb1-nb2));
            case '/' -> {
                if(nb2 != 0)
                {
                    System.out.println("Résultat -> "+ (nb1/nb2));
                }
                else {
                    System.out.println("Division par 0 (Erreur)");
                }
            }
            default -> System.out.println("Signe Invalide");
        }
    }

    public static void convertisseur(Scanner sc)
    {
        final double euros = 1.18; //Pour 1£
        final double sterling = 0.84; //Pour 1€
        System.out.print("Entrez la somme que vous souhaitez convertir : ");
        double somme = sc.nextDouble();
        System.out.print("Entrez une devise valide entre euros et sterling : ");
        String signeDevise = sc.next();

        if("euros".equals(signeDevise))
        {
            System.out.println("La somme de " + somme + " euros en £ donne " + (somme*sterling) + " £ !");
        }
        else if ("sterling".equals(signeDevise))
        {
            System.out.println("La somme de " + somme + " £ en euros donne " + (somme*euros) + " euros !");
        }
        else
        {
            System.out.println("erreur variable" + "\\u00A3" + " " + "\\u20AC");
        }
    }
}
