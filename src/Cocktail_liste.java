import javax.swing.*;
import java.util.ArrayList;

public class Cocktail_liste{
    ArrayList<JRadioButton> liste_radio;
    int size;

    public ArrayList<JRadioButton> getListe_radio() {
        return liste_radio;
    }

    public void setListe_radio(ArrayList<JRadioButton> liste_radio) {
        this.liste_radio = liste_radio;
    }

    Cocktail_liste()
    {

        this.liste_radio = new ArrayList<JRadioButton>();
        ArrayList <Cocktail> liste_cocktail = Bar_Dodo_main.getListeNom(Bar_Dodo_main.conn);
        this.size = liste_cocktail.size();
        for (int i=0; i<liste_cocktail.size(); i++)
        {
            liste_radio.add(new JRadioButton(liste_cocktail.get(i).getName()));
            liste_radio.get(i).setActionCommand(liste_cocktail.get(i).getName());


        }
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}