import java.io.IOException;
import java.sql.*;
import java.util.Scanner;

public class Main {
    public static boolean check_column_status() {
        boolean status = false;
        String tableName = MarkSheet.jCombo_Module.getSelectedItem().toString();
        String columnName =controller.getTime();
        try (Connection connection = DriverManager.getConnection(db.url, db.username, db.password)) {
            String sql = "SELECT COUNT(*) AS column_count " +
                    "FROM information_schema.columns " +
                    "WHERE table_schema = ? " +
                    "AND table_name = ? " +
                    "AND column_name = ?";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setString(1, "db1");
                statement.setString(2, tableName);
                statement.setString(3, columnName);

                try (ResultSet resultSet = statement.executeQuery()) {
                    if (resultSet.next()) {
                        int columnCount = resultSet.getInt("column_count");
                        if (columnCount > 0) {
                            System.out.println("Column exists.");
                            status= true;
                        } else {
                            //methanin wenne db eke me namin column ekk thiyeda balanawa. nattan aluth ekk hadanawa.
                            // methanta it passe enna ona marksheet2 eke thiyena ok button eke code eken kotasak.
                            //sql eke aluthen hadana columns wala null value nathi wena vidiyata values pirenna ona.
                            //eka hadagann baruwa inne
                            String sql0 = "ALTER TABLE " + tableName + " ADD " + controller.getTime() + " VARCHAR(255) UNIQUE";
                            statement.executeUpdate(sql0);
                            System.out.println("New columns added successfully.");
                            status= true;
                        }
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return status;
    }

    public static void main(String[] args) throws IOException, SQLException, ClassNotFoundException {
        controller1 controller1 = new controller1();
        controller1.setVisible(true);
    }
}
