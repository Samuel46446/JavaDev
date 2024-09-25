package testing;

public final class TD4
{
    private TD4() {}

    /* Fonction basique renvoie un message incluant les deux paramètre */
    public static void message(String nom, String prenom)
    {
        System.out.println("Le cours d’algorithmique est bientôt fini. Bon courage à vous "+prenom+" "+nom+" pour la suite");
    }

    /* MTCOM Procédure */
    public static void commission(double ca)
    {
        double taux;
        final double lim1 = 10000;
        final double lim2 = 20000;
        final double lim3 = 30000;

        if(ca > lim3)
        {
            taux = ca * 0.20;
        }
        else if(ca <= lim1 || ca <= lim2)
        {
            taux = ca * 0.12;
        }
        else if(ca < lim2 || ca <= lim3)
        {
            taux = ca * 0.15;
        }
        else
        {
            taux = ca * 0.10;
        }
        Utils.msgLn("La prime touché est de : "+taux+" €");
    }

    /* Prend en paramètre un entier et retourne l'entier du paramètre au cube */
    public static int cube3(int nombre)
    {
        return nombre * nombre * nombre;
    }

    /* Prends en paramètre successif un double puis calcule la moyenne */
    public static double moyenne(double... notes)
    {
        double sommeNote = 0.0;
        for(double n : notes)
        {
            if(n > 20 || n < 0)
            {
                System.out.println("Une note invalide à été saisie est ramplacé par un 0 !");
                n=0;
            }
            sommeNote=sommeNote+n;
        }
        return sommeNote/notes.length;
    }
}
