import javax.swing.*;

    public class Cocktail_view extends JFrame {
        public Cocktail_view()
        {
            this.setTitle("Bar_Dodo");
            this.setSize(480, 320);
            this.setLocationRelativeTo(null);
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            this.setContentPane(new Cocktail_pan());
            this.setVisible(true);
        }
    }


