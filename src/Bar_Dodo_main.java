import java.sql.*;
import java.util.ArrayList;

public class Bar_Dodo_main {
    static  Connection conn;
    public static void main(String[] args)
    {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Driver O.K.");

            String url = "jdbc:mysql://localhost:3306/bar_dodo";
            String user = "root";
            String passwd = "";
            conn = DriverManager.getConnection(url, user, passwd);

            Cocktail rhumAnanou = new Cocktail(1, conn);
            System.out.println(rhumAnanou.toString());
        }
        catch (Exception e) {

            e.printStackTrace();

        }

        Cocktail_view fen = new Cocktail_view();


    }

public static ArrayList <Cocktail> getListeNom (Connection conn) {
    try {
        Statement state = conn.createStatement();
        String request = "SELECT cocktail.Name, cocktail.ID FROM cocktail;";
        ResultSet res = state.executeQuery(request);
        ArrayList<Cocktail> liste_name = new ArrayList<Cocktail>();

        while (res.next()) {
            liste_name.add(new Cocktail(res.getString("name"), res.getInt("ID")));
        }
        return liste_name;
    } catch (Exception e) {

        e.printStackTrace();
        return  null;
    }


}

}

