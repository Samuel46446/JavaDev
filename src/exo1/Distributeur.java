package exo1;

import java.util.HashMap;
import java.util.Map;

public class Distributeur
{
    private final Map<Integer,Integer> distributeur; // valeur du billet → quantité disponible

    public Distributeur()
    {
        this.distributeur = new HashMap<>();
    }

    public void ajouterBillets(int valeur, int quantite)
    {
        if (quantite > 0)
        {
            this.distributeur.put(valeur, quantite);
        }
        else
        {
            System.out.println("Quantité invalide pour le billet.");
        }
    }

    public void afficherBilletsDisponibles()
    {
        System.out.println("Billets disponibles :");
        for (Map.Entry<Integer, Integer> entry : this.distributeur.entrySet())
        {
            System.out.println("Valeur : " + entry.getKey() + ", Quantité : " + entry.getValue());
        }
    }

    public boolean retirerArgent(CompteBancaire compteBancaire, int montant)
    {
        if(compteBancaire.getSolde() - montant >= 0)
        {
            int montantRestant = montant;
            for (Map.Entry<Integer, Integer> entry : this.distributeur.entrySet())
            {
                int valeurBillet = entry.getKey();
                int quantiteBillet = entry.getValue();

                while (montantRestant >= valeurBillet && quantiteBillet > 0)
                {
                    montantRestant -= valeurBillet;
                    quantiteBillet--;
                    compteBancaire.retirer(valeurBillet);
                }
                this.distributeur.put(valeurBillet, quantiteBillet);
            }

            if (montantRestant == 0)
            {
                System.out.println("Retrait effectué avec succès.");
                return true;
            }
            else
            {
                System.out.println("Montant non disponible dans le DAB.");
                return false;
            }
        }
        else
        {
            System.out.println("Montant invalide pour le retrait.");
            return false;
        }
    }
}