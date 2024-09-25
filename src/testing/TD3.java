package testing;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*TP3*/
public final class TD3
{
    private TD3(){}

    /*
     * Fait la somme de 3 nombre entrer
     */
    public static void sum(Scanner sc)
    {
        System.out.print("Entrez la valeur 1 : ");
        int a = sc.nextInt();
        System.out.print("Entrez la valeur 2 : ");
        int b = sc.nextInt();
        System.out.print("Entrez la valeur 3 : ");
        int c = sc.nextInt();

        System.out.println("Resultat -> "+(a+b+c));
    }

    /*
     * Permet de faire une moyenne parmis celle saisie, l'utilisateur peut saisir -1 pour arrêter la saisie
     */
    public static void moy(Scanner sc)
    {
        List<Integer> notes = new ArrayList<>();
        int in = 0;
        while(in != -1)
        {
           System.out.print("Entrez une note (saisir -1 pour confirmer) : ");
           in = sc.nextInt();
           notes.add(in);
        }

        int length = notes.size();
        int sum = 0;

        for(Integer n : notes)
        {
            sum=sum+n;
        }

        System.out.println("La moyenne est de : " + (sum/length));
    }

    /*
     * Fait la factorisation de n'importe quel entier entrer
     */
    public static void facto(Scanner sc)
    {
        System.out.print("Entrez un nombre à factorisé : ");
        int nbr = sc.nextInt();

        for(int i = nbr-1; i > 0; i--)
        {
            System.out.println(i);
            nbr=nbr*i;
        }
        System.out.println("La factorisation donne : " + nbr);
    }

    /* Une adaptation du programme précédent */
    @Deprecated
    public static int facto(int nbr)
    {
        return Utils.facto(nbr);
    }
    /*
     * Une véritable application permettant de rentrer des notes, de voir le nombre d'étudiant
     * noté, et la moyenne général et personnel de chacun
     */
    public static void registryNote(Scanner sc)
    {
        final int max = 30;
        int[][] notes = new int[max][5];

        for (int i = 0; i < notes.length; i++) {
            for (int j = 0; j < notes[i].length; j++) {
                notes[i][j] = -1;
            }
        }
        //List<Integer> notes = new ArrayList<>();
        int in = 1;
        while(!(in > 5) && !(in < 1))
        {
            Utils.msgLn("Que voulez vous faire : ");
            Utils.msgLn("(1) Entrer des notes");
            Utils.msgLn("(2) Nombre de note par étudiant");
            Utils.msgLn("(3) Moyenne de chaque étudiant");
            Utils.msgLn("(4) Nombre d’étudiants notés");
            Utils.msgLn("(5) Moyenne générale");
            in = sc.nextInt();

            switch(in) {
                case 1:
                    int etudiant = 0;
                    int noteetu = 0;
                    int noteEnter = 0;
                    while (true) {
                        System.out.print("Veuillez entrez un identifiant d'étudiant (entre 0 et 29), entrez autre chose pour quitter : ");
                        etudiant = sc.nextInt();
                        if (etudiant >= 0 && etudiant <= 29) {
                            while (true) {
                                System.out.print("Veuillez entrez un identifiant de note (entre 0 et 4), entrez autre chose pour quitter : ");
                                noteetu = sc.nextInt();
                                if (noteetu >= 0 && noteetu <= 4) {
                                    System.out.print("Veuillez entrez la note (entre 0 et 20), entrez autre chose pour quitter : ");
                                    noteEnter = sc.nextInt();
                                    if (noteEnter >= 0 && noteEnter <= 20) {
                                        notes[etudiant][noteetu] = noteEnter;
                                    } else {
                                        break;
                                    }
                                } else {
                                    break;
                                }
                            }
                        } else {
                            break;
                        }
                    }
                    break;
                case 2:
                    int noteValide = 0;
                    for (int i = 0; i < notes.length; i++) {
                        for (int k = 0; k < notes[i].length; k++) {
                            if (notes[i][k] != -1) {
                                noteValide = noteValide + 1;
                            }
                        }

                        System.out.println("Etudiant " + i + " à " + noteValide + " notes");
                    }
                    sc.nextLine();
                    break;
                case 3:
                    int sum = 0;
                    int length = 0;
                    for (int i = 0; i < notes.length; i++) {
                        sum = 0;
                        length = 0;
                        for (int k = 0; k < notes[i].length; k++) {
                            if (notes[i][k] != -1) {
                                sum = sum + notes[i][k];
                                length = length + 1;
                            }
                        }
                        if (length == 0) {
                            System.out.println("Il n'y a pas de note pour l'Etudiant " + i);
                        } else {
                            System.out.println("Etudiant " + i + " à " + (sum / length) + " de moyenne");
                        }
                    }
                    sc.nextLine();
                    break;
                case 4:
                    System.out.println("Il y a en tout " + max + " étudiants !");
                    break;
                case 5:
                    int sumc = 0;
                    int lengthc = 0;
                    int calculTotal = 0;
                    for (int i = 0; i < notes.length; i++) {
                        for (int k = 0; k < notes[i].length; k++) {
                            if (notes[i][k] != -1) {
                                sumc = sumc + notes[i][k];
                                lengthc = lengthc + 1;
                            }
                        }
                    }
                    if (lengthc == 0) {
                        System.out.println("La classe ne contient aucun étudiant avec une note veuillez en rentrer !");
                    }
                    calculTotal = calculTotal + (sumc / lengthc);
                    System.out.println("La moyenne des étudiants de cette classe est de : " + calculTotal);
                    sc.nextLine();
                    break;
                default:
                    System.out.println("Cette entier ne correspond à rien dans la liste des choix, veuillez réessayer");
                    break;
            }
        }
    }

    /*
     * Une version améliorer du convertiseur £ to € ou l'inverse, fonctionnant désormais avec une
     * boucle il suffit à l'utilisateur d'entrer q pour l'arrêter
     */
    public static void betterConvertisseur(Scanner sc)
    {
        final String quitter = "q"; //Valeur qui permet de quitter la boucle
        final double euros = 1.18; //Pour 1£
        final double sterling = 0.84; //Pour 1€
        double somme;
        String signeDevise;

        do{
            System.out.print("Entrez la somme que vous souhaitez convertir : ");
            somme = sc.nextDouble();
            System.out.print("Entrez une devise valide entre euros et sterling (entrez q pour quitter) : ");
            signeDevise = sc.next();

            if(null == signeDevise)
            {
                System.out.println("entrez une valeur parmis euros ou sterling entrez q pour quitter.");
            }
            else switch (signeDevise) {
                case "euros" -> System.out.println("La somme de " + somme + " euros en £ donne " + (somme*sterling) + " £ !");
                case "sterling" -> System.out.println("La somme de " + somme + " £ en euros donne " + (somme*euros) + " euros !");
                default -> System.out.println("devise non reconnu veuillez réessayer");
            }
        }while(!quitter.equals(signeDevise));
    }

    /*
     * Une version améliorer permettant d'enchainer plusieurs calcul, entrez oui pour continuer et
     * non pour l'arrêter
     */
    public static void betterCalculatrice(Scanner sc)
    {
        String restart = "oui";
        do
        { 
            Utils.msg("Entrez le premier nombre du calcul : ");
            double nb1 = sc.nextDouble();
            Utils.msg("Entrez un signe de calcul valide (+ - * /) : ");
            char signe = sc.next().charAt(0);
            Utils.msg("Entrez le deuxième nombre du calcul : ");
            double nb2 = sc.nextDouble();
            switch (signe) {
                case '*' -> Utils.msgLn("Résultat -> "+ (nb1*nb2));
                case '+' -> Utils.msgLn("Résultat -> "+ (nb1+nb2));
                case '-' -> Utils.msgLn("Résultat -> "+ (nb1-nb2));
                case '/' -> {
                    if(nb2 != 0)
                    {
                        Utils.msgLn("Résultat -> "+ (nb1/nb2));
                    }
                    else {
                        Utils.msgLn("Division par 0 Imposible (Erreur)");
                    }
                }
                default -> Utils.msgLn("Signe Invalide");
            }
            Utils.msg("Voulez vous continuer (oui) ou arrêter (non), actuellement mis sur : " + restart + " -> ");
            restart = sc.next();
        }while("oui".equals(restart));
        Utils.msgLn("Arrêt de la calculatrice !");
    }

    /*
     * Une version améliorer de la fonction prime permettant de saisir plusieurs Prime de chaque
     * Commerciaux
     */
    public static void betterPrime(Scanner sc)
    {
        List<String> nameCommercial = new ArrayList<>();
        List<Double> primeCommercial = new ArrayList<>();
        Utils.msg("Entrez le nombre de Commerciaux : ");
        int nbrCommerciaux = sc.nextInt();

        for(int i = 0; i < nbrCommerciaux; i++)
        {
            Utils.msg("Entrez le nom du Commercial "+(i+1)+" : ");
            String name = sc.next();
            nameCommercial.add(i, name);
            Utils.msg("Entrez le chiffre d'affaires du Commercial ("+nameCommercial.get(i)+") : ");
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
            if(ca < 2000)
            {
                primeCommercial.add(i, 0.0);
                //Utils.msgLn("Pas de Prime");
            }
            else
            {
                primeCommercial.add(i, t1+t2+t3);
                //Utils.msgLn("La prime touché est de : "+(t1+t2+t3)+" €");
            }
        }
        
        if(primeCommercial.size() == nameCommercial.size())
        {
            for(int i = 0; i < nameCommercial.size(); i++)
            {
                if(primeCommercial.get(i) == 0.0)
                {
                    Utils.msgLn("Pas de Prime pour le Commercial ("+nameCommercial.get(i)+") : "+primeCommercial.get(i)+" €");
                }
                else {
                    Utils.msgLn("La prime touché pour le Commercial ("+nameCommercial.get(i)+") est de : "+primeCommercial.get(i)+" €");
                }
            }
        }
        else {
            Utils.msgLn("Erreur il manque une valeur dans l'une des listes");
        }
    }
}