import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;



class Catalogue {
    ArrayList<Livre> livres = new ArrayList<>();

    public void ajouter(Livre livre) {
        for (Livre l : livres) {
            if (l.titre.equalsIgnoreCase(livre.titre) && l.auteur.equalsIgnoreCase(livre.auteur)) {
                System.out.println("Le livre '" + l.titre + "' de l'auteur '" + l.auteur + "' existe déjà.");
                return;
            }
        }
        livres.add(livre);
        System.out.println("Le livre '" + livre.titre + "' de l'auteur '" + livre.auteur + "' a été ajouté avec succès.");
    }

    public void supprimer(String titre, String auteur) {
        for (Livre l : livres) {
            if (l.titre.equalsIgnoreCase(titre) && l.auteur.equalsIgnoreCase(auteur)) {
                livres.remove(l);
                System.out.println("Le livre '" + l.titre + "' de l'auteur '" + l.auteur + "' a été supprimé.");
                return;
            }
        }
        System.out.println("Le livre '" + titre + "' de l'auteur '" + auteur + "' n'existe pas dans le catalogue.");
    }

    public void modifier(String titre, String auteur, String nouveauTitre, String nouvelAuteur, String nouvelleCategorie, double nouvelleEdition) {
        for (Livre l : livres) {
            if (l.titre.equalsIgnoreCase(titre) && l.auteur.equalsIgnoreCase(auteur)) {
                l.titre = nouveauTitre;
                l.auteur = nouvelAuteur;
                l.categorie = nouvelleCategorie;
                l.edition = nouvelleEdition;
                System.out.println("Le livre a été modifié avec succès : " + nouveauTitre);
                return;
            }
        }
        System.out.println("Le livre '" + titre + "' de l'auteur '" + auteur + "' n'existe pas dans le catalogue.");
    }

    public void classer(String critere) {
        if (critere.equalsIgnoreCase("auteur")) {
            Collections.sort(livres, Comparator.comparing(l -> l.auteur));
            System.out.println("Livres classés par auteur :");
        } else if (critere.equalsIgnoreCase("categorie")) {
            Collections.sort(livres, Comparator.comparing(l -> l.categorie));
            System.out.println("Livres classés par catégorie :");
        } else {
            System.out.println("Critère de classement invalide. Utilisez 'auteur' ou 'categorie'.");
            return;
        }
        for (Livre l : livres) {
            System.out.println(l);
        }
    }

    public void afficherCatalogue() {
        if (livres.isEmpty()) {
            System.out.println("Le catalogue est vide.");
        } else {
            System.out.println("Catalogue des livres :");
            for (Livre l : livres) {
                System.out.println(l);
            }
        }
    }
}
