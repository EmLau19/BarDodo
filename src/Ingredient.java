public class Ingredient {

    String name;
    long quantite;
    long duree;

    public long getDuree() {
        return duree;
    }

    public void setDuree(int duree) {
        this.duree = duree;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getQuantite() {
        return quantite;
    }

    public void setQuantite(long quantite) {
        this.quantite = quantite;
    }

    Ingredient(String p_name, long p_quantite, long p_duree)
    {
        this.name = p_name;
        this.quantite = p_quantite;
        this.duree = p_duree; // DUREE 1CL
    }
}
