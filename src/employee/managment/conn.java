package employee.managment;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class conn {

    Connection conn;

    Statement stmt;

    public conn() {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/EmployeeMenagement","root","");
            stmt = conn.createStatement();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
