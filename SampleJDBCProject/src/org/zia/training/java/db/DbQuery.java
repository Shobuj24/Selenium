package org.zia.training.java.db;

//STEP 1. Import required packages
import java.sql.*;

/*
 * 
 * URL resource of this sample code is from - http://www.tutorialspoint.com/jdbc/jdbc-sample-code.htm
 * 
 * One of many Video Tutorial for installing MySQL database, setup and other functionalities -
 * https://www.youtube.com/watch?v=oE4D7FmP2Lw
 * 
 */

public class DbQuery {
 // JDBC driver name and database URL
 //static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
 //static final String DB_URL = "jdbc:mysql://localhost/myschema";
 //static final String JDBC_DRIVER = "oracle.jdbc.driver.OracleDriver"; 
 //static final String DB_URL = "jdbc:oracle:thin:@localhost:1521:xe","tahsan","tahsan";

 //  MySQL Database credentials
// static final String USER = "root";
// static final String PASS = "siman123";
 
 public static void main(String[] args) {
 Connection conn = null;
 Statement stmt = null;
 try{
    //STEP 2: Register JDBC driver
    //Class.forName("com.mysql.jdbc.Driver"); // For MySQL DB
    Class.forName("oracle.jdbc.driver.OracleDriver"); // For Oracle DB

    //STEP 3: Open a connection
    System.out.println("Connecting to database...");
    //conn = DriverManager.getConnection(DB_URL,USER,PASS);
    conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","zia","zia123");  
    		  

    //STEP 4: Execute a query
    System.out.println("Creating statement...");
    stmt = conn.createStatement();
    String sql;
    //sql = "SELECT id, first_name, last_name, phone FROM javatraining.users";
    //sql = "SELECT id, firstname, lastname, phone FROM isb.contacts";
    sql = "SELECT id, firstname, lastname, phone FROM zia.users";
    ResultSet rs = stmt.executeQuery(sql);

    //STEP 5: Extract data from result set
    while(rs.next()){
       //Retrieve by column name
//       int id  = rs.getInt("id");
//       String firstName = rs.getString("first_name");
//       String lastName = rs.getString("last_name");
//       String phone = rs.getString("phone");
    	
    	int id  = rs.getInt("id");
        String firstName = rs.getString("firstname");
        String lastName = rs.getString("lastname");
        String phone = rs.getString("phone");

       //Display values
       System.out.println("ID        : " + id);
       System.out.println("First Name: " + firstName);
       System.out.println("Last Name : " + lastName);
       System.out.println("Phone     : " + phone + "\n\n");
    }
    //STEP 6: Clean-up environment
    rs.close();
    stmt.close();
    conn.close();
 }catch(SQLException se){
    //Handle errors for JDBC
    se.printStackTrace();
 }catch(Exception e){
    //Handle errors for Class.forName
    e.printStackTrace();
 }finally{
    //finally block used to close resources
    try{
       if(stmt!=null)
          stmt.close();
    }catch(SQLException se2){
    }// nothing we can do
    try{
       if(conn!=null)
          conn.close();
    }catch(SQLException se){
       se.printStackTrace();
    }//end finally try
 }//end try
 System.out.println("Goodbye!");
}//end main
}//end FirstExample
