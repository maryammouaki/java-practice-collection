
public class Noeud {
    private Element data;
    private Noeud suivant;

    public Noeud(Element data) {
        this.data = data;
        this.suivant = null;
    }

    public Element getData() {
        return data;
    }

    public void setData(Element data) {
        this.data = data;
    }

    public Noeud getSuivant() {
        return suivant;
    }

    public void setSuivant(Noeud suivant) {
        this.suivant = suivant;
    }
}