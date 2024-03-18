
package ATMprojet;

import java.util.Scanner;

// Class Main
public class Main {               

    private static double soldeEnBanque = 1000.0; 

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);    

        System.out.println("Bienvenue a l'ATM!");
        while (true) {
            afficherMenu();

            int choix = scanner.nextInt();

            switch (choix) {
                case 1:
                    afficherSolde();
                    break;
                case 2:
                    deposerArgent(scanner);
                    break;
                case 3:
                    retirerArgent(scanner);
                    break;
                case 4:
                    quitter();
                    break;
                default:
                    System.out.println("Choix invalide. Veuillez choisir a nouveau.");
            }
        }
    }

    private static void afficherMenu() {
        System.out.println("Menu :");
        System.out.println("1. Verifier le solde");
        System.out.println("2. Deposer de l'argent");
        System.out.println("3. Retirer de l'argent");
        System.out.println("4. Quitter");
        System.out.print("Choisissez une option : ");
    }

    private static void afficherSolde() {
        System.out.println("Votre solde en banque est : $"  + soldeEnBanque);
    }

    private static void deposerArgent(Scanner scanner) {
        double montantDepot;
        try {
            montantDepot = scanner.nextDouble();
            if (montantDepot > 0) {
                soldeEnBanque += montantDepot;
                System.out.println("Depot de $" + montantDepot + " effectue avec succes.");
            } else {
                System.out.println("Veuillez entrer un montant valide.");
            }
        } catch (Exception e) {
            System.out.println("Erreur lors de la saisie du montant. Assurez-vous d'entrer un nombre.");
            scanner.nextLine();                                 
        }
    }

    private static void retirerArgent(Scanner scanner) {
        double montantRetrait;
        try {
            montantRetrait = scanner.nextDouble();
            if (montantRetrait > 0 && montantRetrait <= soldeEnBanque) {
                soldeEnBanque -= montantRetrait;
                System.out.println("Retrait de $" + montantRetrait + " effectue avec succes.");
            } else {
                System.out.println("Solde insuffisant.");
            }
        } catch (Exception e) {
            System.out.println("Erreur lors de la saisie du montant. Assurez-vous d'entrer un nombre.");
            scanner.nextLine(); 
        }
    }

    private static void quitter() {
        System.out.println("Merci d'avoir utilise notre service ATM. A bientot!");
        System.exit(0);
    }
}

