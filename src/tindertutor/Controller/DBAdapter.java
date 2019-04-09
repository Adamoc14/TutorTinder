/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tindertutor.Controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author adamoc
 */
public class DBAdapter {
    
    
    public Boolean sendMessage(String text ,int s_id , int t_id){
        try{
            DBAdapter dbadapter = new DBAdapter();
            Connection c = dbadapter.getConnection();
            PreparedStatement insert = c.prepareStatement("INSERT INTO Messages(Message_Content,Student_ID,Tutor_ID)VALUES('" + text + "' ,'" + s_id + "','" + t_id + "')");
            insert.executeUpdate();
            return true;
            
        } catch(Exception p){
            System.out.println(p);
        }
        return null;
    }
    
    /*This function connects to the database and checks whether the person is indeed in the database
    by using the username and password and checking whether the returned resultset is empty or not and returning 
    a true or false accordingly 
    */
    public Boolean DBCheckLoginDetails(String Username , String ST_Password){
       try{
          Connection c = getConnection(); 
          PreparedStatement check = c.prepareStatement("SELECT User_Name, Students_Password FROM Student_Users WHERE User_Name = '" + Username + "' AND Students_Password = '" + ST_Password + "' UNION SELECT User_Name, Tutors_Password FROM Tutor_Users WHERE User_Name = '" + Username + "' AND Tutors_Password = '" + ST_Password + "' ;");
          ResultSet success = check.executeQuery();
          if(success.next()){
             return true;
          } else {
             return false;
          }
       } catch(Exception ec){
           System.out.println(ec);
       }
       return null;
   }
    
    
    /*This connects to database and checks based on username and password whether the person signed in 
    is a student or tutor by throwing in their username and password into both tables and returning a resultset for 
    each and if they're not empty then return the respective type 
    */
   public String DBCheckUser(String Username , String ST_Password){
       try{
          Connection c = getConnection(); 
          PreparedStatement studentCheck = c.prepareStatement("SELECT User_Name, Students_Password FROM Student_Users WHERE User_Name = '" + Username + "' AND Students_Password = '" + ST_Password + "';");
          ResultSet studentLoggedIn = studentCheck.executeQuery();
          
          Connection d = getConnection();
          PreparedStatement tutorCheck = d.prepareStatement("SELECT User_Name, Tutors_Password FROM Tutor_Users WHERE User_Name = '" + Username + "' AND Tutors_Password = '" + ST_Password + "';");
          ResultSet tutorLoggedIn  = tutorCheck.executeQuery();
          
          if(studentLoggedIn.next()){
              return "Student";
          } 
          
          if(tutorLoggedIn.next()){
              return "Tutor";
          }
          
       } catch(Exception ec){
           System.out.println(ec);
       }
       return null;
   }
   
   
   
   
   /*This works with the database and connects to it and based on the username and password given retrieves a 
   result set with their data in it
   */
    
   public ResultSet DBRetrievePreferences(String Username , String ST_Password){
       try{
          Connection c = getConnection(); 
          PreparedStatement check = c.prepareStatement("SELECT S_Name , User_Name, Students_Password , College_ModuleCode , Student_Location , Grind_Type FROM Student_Users WHERE User_Name = '" + Username + "' AND Students_Password = '" + ST_Password + "' UNION SELECT T_Name , User_Name, Tutors_Password , Subject_Area , Tutor_Location , Grind_Type FROM Tutor_Users WHERE User_Name = '" + Username + "' AND Tutors_Password = '" + ST_Password + "' ;");
          ResultSet success = check.executeQuery();
          return success;
       } catch(Exception e){
           System.out.println(e);
       }
       return null;
   }
   
   
    
   //This connects the program to the database and then prepares the SQL statement to query the database and create the table   
    public void createTable() throws Exception{
        try{
            Connection con = getConnection();
            PreparedStatement create = con.prepareStatement("CREATE TABLE Tutor_Users(TutorID int NOT NULL AUTO_INCREMENT , T_Name VARCHAR(20) , User_Name VARCHAR(20) , Tutors_Password VARCHAR(20) , Subject_Area VARCHAR(250) , Qualifications VARCHAR(250) , Tutor_Location VARCHAR(250) , Grind_Type VARCHAR(20) , Tutor_Price float(10) , PRIMARY KEY(TutorID));");
            create.executeUpdate();
            
        } catch(Exception i){
            System.out.println(i);
        } finally{System.out.println("Table has been created");}
    }
    
    
    
    
    /*This sets up the driver and setup for the connection to the database which i use 
    throughout this app for other functions 
    */
    public Connection getConnection() throws Exception {
        try {
            String driver = "com.mysql.cj.jdbc.Driver";
            String url = "jdbc:mysql://192.168.64.2/Tinder_Tutor";
            String username = "Adam";
            String password = "gaelic football";
            Class.forName(driver);
            Connection conn = DriverManager.getConnection(url , username , password);
            System.out.println("Connected");
            return conn;
        } catch(ClassNotFoundException | SQLException e){
            System.out.println(e);
        }
        return null;
        
    }
    
    
    
    
}
