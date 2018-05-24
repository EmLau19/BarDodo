import com.pi4j.io.gpio.*;

import javax.xml.transform.Result;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Vanne_Controller {

    GpioController gpio;
    GpioPinDigitalOutput vanne1;
    GpioPinDigitalOutput vanne2;
    Ingredient ingredientV1;
    Ingredient ingredientV2;
    HashMap <String, GpioPinDigitalOutput> quelleVanne = new HashMap<>();

    public Vanne_Controller() {
        try {
            Statement state = Bar_Dodo_main.conn.createStatement();
            String requestV1 = "SELECT parametres.ID_Ingredient, parametres.Vanne, ingredient.Name FROM parametres\n" +
                    "INNER JOIN ingredient ON ingredient.ID = parametres.ID_Ingredient\n" +
                    "WHERE parametres.vanne=\"1\"; ";
            String requestV2 = "SELECT parametres.ID_Ingredient, parametres.Vanne, ingredient.Name FROM parametres\n" +
                    "INNER JOIN ingredient ON ingredient.ID = parametres.ID_Ingredient\n" +
                    "WHERE parametres.vanne=\"2\"; ";
            ResultSet answer1 = state.executeQuery(requestV1);
            ResultSet answer2 = state.executeQuery(requestV2);

            gpio = GpioFactory.getInstance();
            vanne1 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_01, "vanne", PinState.LOW); // la c'est branche au pin 1 ah ouais ouais ouais
            vanne2 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_02, "vanne", PinState.LOW);
            ingredientV1 = new Ingredient(answer1.getString("Name"),  -1, -1);
            ingredientV2 = new Ingredient(answer2.getString("Name"),  -1, -1);
            quelleVanne.put(ingredientV1.getName(), vanne1);
            quelleVanne.put(ingredientV2.getName(), vanne2);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    void Preparer_cocktail(Cocktail cocktail_select)
    {
        long duree;
        for (int i=0; i<cocktail_select.getComposition().size(); i++)
        {
            duree = cocktail_select.getComposition().get(i).getDuree()*cocktail_select.getComposition().get(i).getQuantite();
            String ingredient = cocktail_select.getComposition().get(i).getName();
            quelleVanne.get(ingredient).pulse(duree);

        }







    }



}
