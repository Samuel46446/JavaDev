package exo1;

public class CompteBancaire
{
    private final String numeroCompte;
    private final String nomClient;
    private double solde;

    public CompteBancaire(String numeroCompte, String nomClient, double solde)
    {
        this.numeroCompte = numeroCompte;
        this.nomClient = nomClient;
        this.solde = solde;
    }

    public String getNumeroCompte()
    {
        return numeroCompte;
    }

    public String getNomClient()
    {
        return nomClient;
    }

    public void afficherSolde()
    {
        System.out.println(solde);
    }

    public double getSolde()
    {
        return this.solde;
    }

    public void retirer(double montant)
    {
        if (this.solde-montant > 0)
        {
            this.solde -= montant;
        }
        else
        {
            System.out.println("Montant invalide pour le retrait.");
        }
    }

    public void deposer(double montant)
    {
        if (montant > 0)
        {
            this.solde += montant;
        }
        else
        {
            System.out.println("Montant invalide pour le dépôt.");
        }
    }
}
