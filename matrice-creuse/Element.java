public class Element {
    private int ligne;
    private int colonne;
    private double valeur;

    public Element(int ligne, int colonne, double valeur) {
        this.ligne = ligne;
        this.colonne = colonne;
        this.valeur = valeur;
    }

    public int getLigne() {
        return ligne;
    }

    public int getColonne() {
        return colonne;
    }

    public double getValeur() {
        return valeur;
    }

    public void setValeur(double valeur) {
        this.valeur = valeur;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Element other = (Element) obj;
        return ligne == other.ligne && colonne == other.colonne;
    }

    @Override
    public String toString() {
        return "(" + ligne + ", " + colonne + ", " + valeur + ")";
    }
}