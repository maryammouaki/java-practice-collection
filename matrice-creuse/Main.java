

public class Main {
    public static void main(String[] args) {
        Matrice matrice1 = new Matrice();
        matrice1.ajouterElement(2, 5, 7.5);
        matrice1.ajouterElement(2, 7, 2.9);
        matrice1.ajouterElement(3, 5, 4.5);

        Matrice matrice2 = new Matrice();
        matrice2.ajouterElement(2, 5, 3.0);
        matrice2.ajouterElement(3, 5, 1.5);
        matrice2.ajouterElement(4, 8, 6.0);

        System.out.println("Matrice 1 :");
        matrice1.afficher();

        System.out.println("\nMatrice 2 :");
        matrice2.afficher();

        Matrice resultat = matrice1.somme(matrice2);
        System.out.println("\nSomme des matrices :");
        resultat.afficher();

        matrice1.supprimerElement(2, 5);
        System.out.println("\nMatrice 1 après suppression de (2, 5) :");
        matrice1.afficher();
    }
}
