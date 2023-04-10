import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/?user=root";
        String user = "root";
        String pass = "Une2-co-a_caa";

        try {
            Connection connection = DriverManager.getConnection(url,user,pass);

            Statement statement = connection.createStatement();



            ResultSet resultSet = statement.executeQuery("SELECT * FROM skillbox.courses");
            while (resultSet.next()) {
                String goodName = resultSet.getString("name");
                System.out.println(goodName);
            }

            connection.close();
            statement.close();
            resultSet.close();

        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}



