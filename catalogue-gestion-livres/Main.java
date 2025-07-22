

public class Main {
    public static void main(String[] args) {
        Catalogue catalogue = new Catalogue();
        catalogue.ajouter(new Livre("Le Seigneur des Anneaux", "J.R.R. Tolkien", "Fantasy", 1954));
        catalogue.ajouter(new Livre("Les Misérables", "Victor Hugo", "Drame", 1862));
        catalogue.ajouter(new Livre("1984", "George Orwell", "Science-Fiction", 1949));
        catalogue.afficherCatalogue();
        System.out.println("\n--- Classement par auteur ---");
        catalogue.classer("auteur");
        System.out.println("\n--- Classement par catégorie ---");
        catalogue.classer("categorie");
        System.out.println("\n--- Test d'un critère invalide ---");
        catalogue.classer("année");
    }
}