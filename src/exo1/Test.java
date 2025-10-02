package exo1;

import java.util.*;

public class Test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Distributeur distributeur = new Distributeur();
        Map<String, CompteBancaire> comptes = new HashMap<>();

        // Initialiser quelques billets dans le DAB
        distributeur.ajouterBillets(50, 10);  // 10 billets de 50€
        distributeur.ajouterBillets(20, 20);  // 20 billets de 20€
        distributeur.ajouterBillets(10, 30);  // 30 billets de 10€

        boolean running = true;
        while (running) {
            System.out.println("\n--- Menu Distributeur ---");
            System.out.println("1. Créer un compte");
            System.out.println("2. Déposer de l'argent");
            System.out.println("3. Retirer de l'argent");
            System.out.println("4. Afficher solde");
            System.out.println("5. Afficher billets du DAB");
            System.out.println("0. Quitter");
            System.out.print("Choix : ");
            int choix = scanner.nextInt();
            scanner.nextLine(); // vider la ligne

            switch (choix) {
                case 1:
                    System.out.print("Nom du client : ");
                    String nom = scanner.nextLine();
                    String numero = UUID.randomUUID().toString().substring(0, 8);
                    CompteBancaire compte = new CompteBancaire(numero, nom, 0);
                    comptes.put(numero, compte);
                    System.out.println("Compte créé avec succès. Numéro : " + numero);
                    break;

                case 2:
                    System.out.print("Numéro de compte : ");
                    String numDepot = scanner.nextLine();
                    CompteBancaire cDepot = comptes.get(numDepot);
                    if (cDepot != null) {
                        System.out.print("Montant à déposer : ");
                        double montantDepot = scanner.nextDouble();
                        cDepot.deposer(montantDepot);
                    } else {
                        System.out.println("Compte introuvable.");
                    }
                    break;

                case 3:
                    System.out.print("Numéro de compte : ");
                    String numRetrait = scanner.nextLine();
                    CompteBancaire cRetrait = comptes.get(numRetrait);
                    if (cRetrait != null) {
                        System.out.print("Montant à retirer : ");
                        int montant = scanner.nextInt();
                        boolean success = distributeur.retirerArgent(cRetrait, montant);
                        if (success) {
                            System.out.println("Retrait effectué avec succès.");
                        } else {
                            System.out.println("Retrait impossible (fonds insuffisants ou billets indisponibles).");
                        }
                    } else {
                        System.out.println("Compte introuvable.");
                    }
                    break;

                case 4:
                    System.out.print("Numéro de compte : ");
                    String numSolde = scanner.nextLine();
                    CompteBancaire cSolde = comptes.get(numSolde);
                    if (cSolde != null) {
                        cSolde.afficherSolde();
                    } else {
                        System.out.println("Compte introuvable.");
                    }
                    break;

                case 5:
                    distributeur.afficherBilletsDisponibles();
                    break;

                case 0:
                    running = false;
                    System.out.println("Fermeture du distributeur.");
                    break;

                default:
                    System.out.println("Choix invalide.");
            }
        }

        scanner.close();
    }
}
