import javax.swing.*;
import java.sql.*;
public abstract class Admin {
    private static String db_username1;
    private static String db_password1;

    public static void login(String username, String password) throws SQLException {
        Connection connection = DriverManager.getConnection(db.url, db.username, db.password);
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(db.query4);
        while (resultSet.next()) {
            db_username1 = resultSet.getString(1);
            db_password1 = resultSet.getString(2);

            if (username.equals(db_username1) && password.equals(db_password1)) {

                System.out.println();
                System.out.println("Login Successful ! ");
                System.out.println();
                System.out.println("=================");
                System.out.println("  Welcome Admin");
                System.out.println("=================");
                controller_all all = new controller_all();
                all.setVisible(true);

            }

        }
        connection.close();
    }
}
