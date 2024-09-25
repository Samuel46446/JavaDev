package testing;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import static testing.TD3.*;

public final class TD31Bis
{
    private TD31Bis() {}

    /*
     * Possibilité de faire une fonction pour ces 2 exercices
     */
    public static void ex1(Scanner sc)
    {
        int i;
        do { 
            Utils.msg("Entrez un nombre entre 1 et 3 : ");
            i = sc.nextInt();
        } while (!(i <= 3) || !(i >= 1));
        Utils.msgLn("Bravo vous êtes sortie de la boucle !");
    }
    
    public static void ex2(Scanner sc)
    {
        int i;
        do { 
            Utils.msg("Entrez un nombre entre 10 et 20 : ");
            i = sc.nextInt();
            if(i < 10)
            {
                Utils.msgLn("C'est plus");
            }
            else if(i > 20)
            {
                Utils.msgLn("C'est moins");
            }
        } while (!(i <= 20) || !(i >= 10));
        Utils.msgLn("Bravo vous êtes sortie de la boucle !");
    }

    public static void ex3(Scanner sc)
    {
        Utils.msg("Entrez un nombre les 10 suivants s'écriront : ");
        int val = sc.nextInt();
        for(int i = val+1; i < (val+11); i++)
        {
            Utils.msgLn("\""+i+"\"");
        }
        Utils.msgLn("Bravo tous ces numéros sont gagnant !");
    }

    /*
     * Table de multiplication
     */
    public static void ex4(Scanner sc)
    {
        Utils.msg("Entrez un nombre pour connaitre sa table de multiplication : ");
        int val = sc.nextInt();
        Utils.msgLn("[Table de "+val+"]");
        for(int i = 1; i < 11; i++)
        {
            Utils.msgLn(val+" x "+i+" = "+(val*i));
        }
    }

    public static void ex5(Scanner sc)
    {
        Utils.msg("Entrez un nombre pour connaitre sont calcul : ");
        int val = sc.nextInt();
        int valpt = val;
        String tab = "";
 
        for (int k = 0; k < valpt; k++)
        {
            if(k > 0)
            {
                tab=tab+" + ";
            }

            if(!(val - k < 0))
            {
                val = val - (1+k);
                System.out.println(1+k);
                tab=tab+(1+k);
            }
            
            if(val == 0)
            {
                break;
            }
        }

        System.out.println(val);
        System.out.println(tab + " = " + valpt);
    }

    public static void ex6(Scanner sc)
    {
        Utils.msg("Entrez un nombre pour connaitre sont calcul factoriel : ");
        int val = sc.nextInt();
        String tab = "";
 
        for (int k = 1; k < val+1; k++)
        {
            if(k > 1)
            {
                tab=tab+" x ";
            }
            tab=tab+k;
        }
        System.out.println(tab);
    }

    public static void ex7(Scanner sc)
    {
        int nombre[] = new int[20];
        int max = 0;
        int id = 0;

        for(int i = 0; i < nombre.length; i++)
        {
            Utils.msg("Entrez le nombre " + (i+1)+ " : ");
            int saisie = sc.nextInt();
            nombre[i]=saisie;
        }

        for(int i = 0; i < nombre.length; i++)
        {
            if(nombre[i] > max)
            {
                max=nombre[i];
                id=i+1;
            }
        }

        Utils.msgLn("Le nombre le plus grand est : "+max+" au numéros "+id);
    }

    public static void ex8(Scanner sc)
    {
        List<Integer> nombre = new ArrayList<>();
        int max = 0;
        int id = 0;
        Utils.msg("Entrez le nombre " + 1 + " : "); //Premier nombre obligatoire
        int saisie = sc.nextInt();
        int clock = 0;

        do { 
            nombre.add(clock,saisie);
            clock++;
            Utils.msg("Entrez le nombre " + (clock+1)+ " : ");
            saisie = sc.nextInt();
        } while (saisie != 0);

        for(int i = 0; i < nombre.size(); i++)
        {
            if(nombre.get(i) > max)
            {
                max=nombre.get(i);
                id=i+1;
            }
        }

        Utils.msgLn("Le nombre le plus grand est : "+max+" au numéros "+id);
    }

    public static void ex9(Scanner sc)
    {
        List<Integer> items = new ArrayList<>();
        Utils.msg("Entrez le prix de l'article " + 1 + " : ");
        int saisie = sc.nextInt();
        int clock = 0;
        int facture = 0;

        do{
            items.add(clock, saisie);
            clock++;
            Utils.msg("Entrez le prix de l'article " + (clock+1) + " : ");
            saisie = sc.nextInt();
        }while(saisie != 0);

        for(Integer i : items)
        {
            facture=facture+i;
        }

        do {
            Utils.msg("Entrez un paiement espèce (Reste "+facture+") : ");
            int argent = sc.nextInt();
            facture=facture-argent;
        } while (facture != 0);
        Utils.msgLn("Vous avez payé vos articles !");
    }

    public static void ex10(Scanner sc)
    {
        Utils.msg("Entrez le nombre de chevaux partant : ");
        int n = sc.nextInt();
        Utils.msg("Entrez le nombre de chevaux joués : ");
        int p = sc.nextInt();
        int x = facto(n) / facto(n-p);
        int y = facto(n) / (facto(p)*facto(n-p));
        Utils.msgLn("Dans l'ordre : une chance sur "+x+" de gagner");
        Utils.msgLn("Dans le désordre : une chance sur "+y+" de gagner");
    }
}