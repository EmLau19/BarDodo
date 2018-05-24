import javax.xml.transform.Result;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class Cocktail {

    ArrayList <Ingredient> composition;
    String name;
    int id;

    public ArrayList<Ingredient> getComposition() {
        return composition;
    }

    public void setComposition(ArrayList<Ingredient> composition) {
        this.composition = composition;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    Cocktail(int p_id, Connection conn)
    {
        try
        {
            this.id = p_id;
            Statement state = conn.createStatement();
            String request = "SELECT cocktail.name as cocktail_name, ingredient.name as ingredient_name, recette.Quantité as quantite, ingredient.temps_1cl " +
                    "FROM cocktail " +
                    "INNER JOIN recette ON cocktail.ID = recette.ID_Cocktail " +
                    "INNER JOIN ingredient ON recette.ID_Ingredient = ingredient.ID " +
                    "WHERE cocktail.ID = " + this.id;
            ResultSet answer = state.executeQuery(request);
            answer.next();

            this.name = answer.getString("cocktail_name");

            composition = new ArrayList<Ingredient>();

            do
            {
                composition.add(new Ingredient(answer.getString("ingredient_name"), answer.getInt("quantite"), answer.getInt("temps_1cl")));
            }while(answer.next());
        }
        catch (Exception e) {

            e.printStackTrace();

        }

    }

    Cocktail (String p_name)
    {
        try
        {
            this.name = p_name;
            Statement state = Bar_Dodo_main.conn.createStatement();
            String request = "SELECT cocktail.ID as cocktail_ID, cocktail.name as cocktail_name, ingredient.name as ingredient_name, recette.Quantité as quantite " +
                    "FROM cocktail " +
                    "INNER JOIN recette ON cocktail.ID = recette.ID_Cocktail " +
                    "INNER JOIN ingredient ON recette.ID_Ingredient = ingredient.ID " +
                    "WHERE cocktail.name = \"" + this.name + "\"";

            ResultSet answer = state.executeQuery(request);
            answer.next();

            this.id = answer.getInt("cocktail_ID");

            composition = new ArrayList<Ingredient>();

            do
            {
                composition.add(new Ingredient(answer.getString("ingredient_name"), answer.getInt("quantite"), answer.getInt("temps_1cl")));
            }while(answer.next());
        }
        catch (Exception e) {

            e.printStackTrace();

        }
    }

    Cocktail (String p_name, int p_id)
    {
        this.name = p_name;
        this.id = p_id;
    }

    @Override
    public String toString()
    {
        String res = name + "\n\nRecette :\n";
        for (int i = 0; i<composition.size(); i++)
        {
            res = res + composition.get(i).name + " - " + composition.get(i).quantite + "\n";
        }

        return res;
    }

}
