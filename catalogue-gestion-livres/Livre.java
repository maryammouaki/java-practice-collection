

class Livre {
    String titre;
    String auteur;
    String categorie;
    double edition;

    public Livre(String t, String a, String c, double e) {
        this.titre = t;
        this.auteur = a;
        this.categorie = c;
        this.edition = e;
    }

    @Override
    public String toString() {
        return "Titre: " + titre + ", Auteur: " + auteur + ", Catégorie: " + categorie + ", Édition: " + edition;
    }
}
