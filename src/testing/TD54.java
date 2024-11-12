package testing;

public final class TD54
{
    private TD54() {}

    public static class Fournisseur
    {
        public String n;
        public String tel;
        public String lastC;
        public double mnt;

        public Fournisseur(String name, String telephone, String lastCommande, double montantCA)
        {
            this.n = name;
            this.tel = telephone;
            this.lastC = lastCommande;
            this.mnt = montantCA;
        }
    }

    public static void ex1()
    {
        Fournisseur[] staff = new Fournisseur[100];

        staff[0] = new Fournisseur("Sam", "06891066", "01-11-23", 23000);
        staff[1] = new Fournisseur("Gerard", "06474966", "01-11-23", 6000);
        staff[2] = new Fournisseur("John", "09251066", "01-11-23", 55000);
        staff[3] = new Fournisseur("Margot", "06479996", "01-11-23", 4500);

        Fournisseur plusGrand = new Fournisseur("none", "0", "0", 0);

        for(Fournisseur f : staff)
        {
            if(f != null)
            {
                if(f.mnt > plusGrand.mnt)
                {
                    plusGrand = f;
                }
            }
        }

        System.out.println("Le fournisseur le plus grand est " + plusGrand.n + " avec un montant de : " + plusGrand.mnt + " € ");
    }
}