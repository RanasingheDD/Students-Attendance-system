import java.util.ArrayList;

interface db {
    String url = "jdbc:mysql://localhost:3306/db1";
    String username = "root";
    String password = "Dishan2002@#";
    String query1 = "select * from students";
    String query2 = "INSERT INTO students (name, number) VALUES (?, ?)";
    String query3 = "INSERT INTO lectures (name, number) VALUES (?, ?)";
    String query4 = "select * from admin";
    String query5 = "select * from lectures";
    String query6 = "SELECT number FROM students";
    ArrayList<String> stu_name = new ArrayList<>();
    ArrayList<String> stu_num  = new ArrayList<>();
    ArrayList<String> lec_name = new ArrayList<>();
    ArrayList<String> lec_num  = new ArrayList<>();

     void add();
    }

