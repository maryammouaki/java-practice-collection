public class Matrice {
    private Liste elements;

    public Matrice() {
        this.elements = new Liste();
    }

    public void ajouterElement(int ligne, int colonne, double valeur) {
        if (valeur == 0) {
            return; 
        }
        Element nouvelElement = new Element(ligne, colonne, valeur);
        Noeud courant = elements.tete;
        Noeud precedent = null;

        while (courant != null) {
            Element elementCourant = courant.getData();
            if (elementCourant.equals(nouvelElement)) {
                elementCourant.setValeur(valeur); 
                return;
            }
            if (elementCourant.getLigne() > ligne ||
                (elementCourant.getLigne() == ligne && elementCourant.getColonne() > colonne)) {
                break;
            }
            precedent = courant;
            courant = courant.getSuivant();
        }

        if (precedent == null) {
            elements.ajouterEnTete(nouvelElement);
        } else {
            elements.ajouterAPosition(nouvelElement, elements.chercherPosition(precedent.getData()) + 1);
        }
    }

    public void supprimerElement(int ligne, int colonne) {
        Element elementASupprimer = new Element(ligne, colonne, 0);
        try {
            int position = elements.chercherPosition(elementASupprimer);
            elements.supprimerAPosition(position);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    public Matrice somme(Matrice autreMatrice) {
        Matrice resultat = new Matrice();
        Noeud courant1 = this.elements.tete;
        Noeud courant2 = autreMatrice.elements.tete;

        while (courant1 != null || courant2 != null) {
            if (courant1 != null && (courant2 == null ||
                courant1.getData().getLigne() < courant2.getData().getLigne() ||
                (courant1.getData().getLigne() == courant2.getData().getLigne() &&
                 courant1.getData().getColonne() < courant2.getData().getColonne()))) {
                resultat.ajouterElement(courant1.getData().getLigne(), courant1.getData().getColonne(), courant1.getData().getValeur());
                courant1 = courant1.getSuivant();
            } else if (courant2 != null && (courant1 == null ||
                       courant2.getData().getLigne() < courant1.getData().getLigne() ||
                       (courant2.getData().getLigne() == courant1.getData().getLigne() &&
                        courant2.getData().getColonne() < courant1.getData().getColonne()))) {
                resultat.ajouterElement(courant2.getData().getLigne(), courant2.getData().getColonne(), courant2.getData().getValeur());
                courant2 = courant2.getSuivant();
            } else {
                double nouvelleValeur = courant1.getData().getValeur() + courant2.getData().getValeur();
                resultat.ajouterElement(courant1.getData().getLigne(), courant1.getData().getColonne(), nouvelleValeur);
                courant1 = courant1.getSuivant();
                courant2 = courant2.getSuivant();
            }
        }
        return resultat;
    }

    public void afficher() {
        elements.afficher();
    }
}