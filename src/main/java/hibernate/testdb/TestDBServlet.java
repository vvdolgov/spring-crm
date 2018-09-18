package hibernate.testdb;

import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;

@WebServlet("/test")
public class TestDBServlet extends javax.servlet.http.HttpServlet {
    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        String jdbcUrl = "jdbc:mysql://localhost:3306/web_customer_tracker?useSSL=false&serverTimezone=UTC";
        String user = "springstudent";
        String pass = "springstudent";
        String driver = "com.mysql.jdbc.Driver";
        try{
            PrintWriter out = response.getWriter();
            Class.forName(driver);
            System.out.println("Connection to database: "+jdbcUrl);
            Connection myConn = DriverManager.getConnection(jdbcUrl, user, pass);
            myConn.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}
