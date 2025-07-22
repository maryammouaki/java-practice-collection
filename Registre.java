import java.util.LinkedList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

// Classe pour gérer une adresse
class Adresse {
    private int numero;
    private String rue;
    private String ville;

    public Adresse(int numero, String rue, String ville) {
        this.numero = numero;
        this.rue = rue;
        this.ville = ville;
    }

    public String getVille() {
        return ville;
    }

    @Override
    public String toString() {
        return numero + " " + rue + ", " + ville;
    }
}

// Classe de base pour une personne
class Personne {
    private String nom;
    private String prenom;
    private Adresse adresse;

    public Personne(String nom, String prenom, Adresse adresse) {
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public Adresse getAdresse() {
        return adresse;
    }
}

// Classe pour un employé, hérite de Personne
class Employe extends Personne implements Comparable<Employe> {
    private String code;
    private double salaire;

    public Employe(String code, double salaire, String nom, String prenom, Adresse adresse) {
        super(nom, prenom, adresse);
        this.code = code;
        this.salaire = salaire;
    }

    public String getCode() {
        return code;
    }

    public double getSalaire() {
        return salaire;
    }

    @Override
    public int compareTo(Employe autre) {
        return this.code.compareTo(autre.code); // Trie les employés par code
    }

    @Override
    public String toString() {
        return code + "/" + getNom() + "/" + getPrenom() + "/" + getAdresse() + "/" + salaire;
    }
}

// Classe pour gérer le registre des employés
public class Registre {
    private LinkedList<Employe> employes;
    private Scanner scanner;

    public Registre() {
        employes = new LinkedList<>();
        scanner = new Scanner(System.in);
    }

    // Ajouter un employé
    public void ajouterEmploye(Employe employe) {
        employes.add(employe);
        System.out.println("Employé ajouté : " + employe);
    }

    // Supprimer un employé par code
    public boolean supprimerEmploye(String code) {
        for (Employe employe : employes) {
            if (employe.getCode().equals(code)) {
                employes.remove(employe);
                System.out.println("Employé avec code " + code + " supprimé.");
                return true;
            }
        }
        System.out.println("Aucun employé trouvé avec le code " + code + ".");
        return false;
    }

    // Trier par code
    public void trierParCode() {
        employes.sort(null); // Utilise compareTo pour trier par code
        System.out.println("Employés triés par code.");
    }

    // Trier par salaire
    public void trierParSalaire() {
        employes.sort((e1, e2) -> Double.compare(e1.getSalaire(), e2.getSalaire()));
        System.out.println("Employés triés par salaire.");
    }

    // Filtrer selon un prédicat
    public Registre filtrer(Predicate<Employe> p) {
        Registre resultat = new Registre();
        for (Employe employe : employes) {
            if (p.test(employe)) {
                resultat.ajouterEmploye(employe);
            }
        }
        return resultat;
    }

    // Sauvegarder les fiches de paie dans un fichier
    public void sauvegarderFiches(String fichier) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fichier))) {
            for (Employe employe : employes) {
                writer.write(employe.toString());
                writer.newLine();
            }
            System.out.println("Fiches de paie sauvegardées dans " + fichier);
        }
    }

    // Sélectionner les employés par ville
    public List<Employe> selectionnerParVille(String ville) {
        List<Employe> resultat = new LinkedList<>();
        for (Employe employe : employes) {
            if (employe.getAdresse().getVille().equalsIgnoreCase(ville)) {
                resultat.add(employe);
            }
        }
        return resultat;
    }

    // Afficher le registre
    public void afficher() {
        if (employes.isEmpty()) {
            System.out.println("Le registre est vide.");
        } else {
            System.out.println("Liste des employés :");
            for (Employe employe : employes) {
                System.out.println("- " + employe);
            }
        }
    }

    // Menu interactif
    public void menu() {
        while (true) {
            System.out.println("\n=== Gestion du Registre des Employés ===");
            System.out.println("1. Ajouter un nouvel employé");
            System.out.println("2. Supprimer un employé");
            System.out.println("3. Trier les employés par code");
            System.out.println("4. Trier les employés par salaire");
            System.out.println("5. Filtrer les employés par salaire minimum");
            System.out.println("6. Afficher les employés d'une ville");
            System.out.println("7. Sauvegarder les fiches de paie");
            System.out.println("8. Afficher le registre");
            System.out.println("9. Quitter");
            System.out.print("Choisissez une option (1-9) : ");

            int choix;
            try {
                choix = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Veuillez entrer un numéro valide.");
                continue;
            }

            switch (choix) {
                case 1: // Ajouter un employé
                    System.out.print("Code de l'employé : ");
                    String code = scanner.nextLine();
                    System.out.print("Nom : ");
                    String nom = scanner.nextLine();
                    System.out.print("Prénom : ");
                    String prenom = scanner.nextLine();
                    System.out.print("Numéro de rue : ");
                    int numero;
                    try {
                        numero = Integer.parseInt(scanner.nextLine());
                    } catch (NumberFormatException e) {
                        System.out.println("Numéro invalide, employé non ajouté.");
                        break;
                    }
                    System.out.print("Rue : ");
                    String rue = scanner.nextLine();
                    System.out.print("Ville : ");
                    String ville = scanner.nextLine();
                    System.out.print("Salaire : ");
                    double salaire;
                    try {
                        salaire = Double.parseDouble(scanner.nextLine());
                    } catch (NumberFormatException e) {
                        System.out.println("Salaire invalide, employé non ajouté.");
                        break;
                    }
                    Adresse adresse = new Adresse(numero, rue, ville);
                    Employe employe = new Employe(code, salaire, nom, prenom, adresse);
                    ajouterEmploye(employe);
                    break;

                case 2: // Supprimer un employé
                    System.out.print("Entrez le code de l'employé à supprimer : ");
                    String codeSuppr = scanner.nextLine();
                    supprimerEmploye(codeSuppr);
                    break;

                case 3: // Trier par code
                    trierParCode();
                    afficher();
                    break;

                case 4: // Trier par salaire
                    trierParSalaire();
                    afficher();
                    break;

                case 5: // Filtrer par salaire minimum
                    System.out.print("Entrez le salaire minimum : ");
                    double salaireMin;
                    try {
                        salaireMin = Double.parseDouble(scanner.nextLine());
                    } catch (NumberFormatException e) {
                        System.out.println("Salaire invalide.");
                        break;
                    }
                    Registre filtre = filtrer(emp -> emp.getSalaire() >= salaireMin);
                    filtre.afficher();
                    break;

                case 6: // Afficher par ville
                    System.out.print("Entrez la ville : ");
                    String villeRecherche = scanner.nextLine();
                    List<Employe> employesVille = selectionnerParVille(villeRecherche);
                    if (employesVille.isEmpty()) {
                        System.out.println("Aucun employé trouvé dans " + villeRecherche + ".");
                    } else {
                        System.out.println("Employés à " + villeRecherche + " :");
                        for (Employe emp : employesVille) {
                            System.out.println("- " + emp);
                        }
                    }
                    break;

                case 7: // Sauvegarder
                    System.out.print("Entrez le nom du fichier (ex. fiches.txt) : ");
                    String fichier = scanner.nextLine();
                    try {
                        sauvegarderFiches(fichier);
                    } catch (IOException e) {
                        System.out.println("Erreur lors de la sauvegarde : " + e.getMessage());
                    }
                    break;

                case 8: // Afficher
                    afficher();
                    break;

                case 9: // Quitter
                    System.out.println("Merci d'avoir utilisé le registre. Au revoir !");
                    scanner.close();
                    return;

                default:
                    System.out.println("Option invalide, veuillez choisir entre 1 et 9.");
            }
        }
    }

    // Main pour lancer le programme
    public static void main(String[] args) {
        Registre registre = new Registre();
        registre.menu();
    }
}