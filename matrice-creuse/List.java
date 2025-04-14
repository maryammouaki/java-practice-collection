public class Liste {
    private Noeud tete;

    public Liste() {
        this.tete = null;
    }

    public void ajouterEnTete(Element data) {
        Noeud nouveauNoeud = new Noeud(data);
        nouveauNoeud.setSuivant(tete);
        tete = nouveauNoeud;
    }

    public void ajouterAPosition(Element data, int position) {
        if (position < 0) {
            throw new IllegalArgumentException("La position ne peut pas être négative.");
        }
        Noeud nouveauNoeud = new Noeud(data);
        if (position == 0) {
            ajouterEnTete(data);
            return;
        }
        Noeud courant = tete;
        int index = 0;
        while (courant != null && index < position - 1) {
            courant = courant.getSuivant();
            index++;
        }
        if (courant == null) {
            throw new IndexOutOfBoundsException("Position invalide.");
        }
        nouveauNoeud.setSuivant(courant.getSuivant());
        courant.setSuivant(nouveauNoeud);
    }

    public void supprimerAPosition(int position) {
        if (position < 0) {
            throw new IllegalArgumentException("La position ne peut pas être négative.");
        }
        if (tete == null) {
            throw new IllegalStateException("La liste est vide.");
        }
        if (position == 0) {
            tete = tete.getSuivant();
            return;
        }
        Noeud courant = tete;
        int index = 0;
        while (courant != null && index < position - 1) {
            courant = courant.getSuivant();
            index++;
        }
        if (courant == null || courant.getSuivant() == null) {
            throw new IndexOutOfBoundsException("Position invalide.");
        }
        courant.setSuivant(courant.getSuivant().getSuivant());
    }

    public int chercherPosition(Element element) {
        Noeud courant = tete;
        int position = 0;
        while (courant != null) {
            if (courant.getData().equals(element)) {
                return position;
            }
            courant = courant.getSuivant();
            position++;
        }
        throw new IllegalArgumentException("L'élément " + element + " n'existe pas dans la liste.");
    }

    public void afficher() {
        Noeud courant = tete;
        while (courant != null) {
            System.out.print(courant.getData() + " -> ");
            courant = courant.getSuivant();
        }
        System.out.println("null");
    }
}
