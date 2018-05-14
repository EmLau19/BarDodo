import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Cocktail_pan extends JPanel {

    ButtonGroup group = new ButtonGroup();
    Cocktail_liste liste_breuvage = new Cocktail_liste();
    Cocktail current_cocktail;
    JTextArea compo;
    JScrollPane scrollPane;
    BoxLayout layout_liste;
    JPanel pan_liste_name;
    Cocktail_pan()
    {

        compo = new JTextArea(15,15);
        scrollPane = new JScrollPane(compo);
        compo.setVisible(false);
        compo.setEditable(false);
        pan_liste_name = new JPanel();
        pan_liste_name.setLayout(new BoxLayout(pan_liste_name, BoxLayout.Y_AXIS));
        this.add(pan_liste_name);
        this.add(scrollPane);
        for (int i=0; i<liste_breuvage.getSize(); i++)
        {
            group.add(liste_breuvage.getListe_radio().get(i));
            pan_liste_name.add(liste_breuvage.getListe_radio().get(i));


            liste_breuvage.getListe_radio().get(i).addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    current_cocktail = new Cocktail(group.getSelection().getActionCommand());
                    compo.setText(current_cocktail.toString());
                    compo.setVisible(true);

                }
            });
        }

    }
}
