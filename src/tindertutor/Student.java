/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tindertutor;

/**
 *
 * @author adamoc
 */
public class Student {
    
   private String s_name , s_pass , s_email , s_module , s_course , s_type;
   private double s_year , s_price , s_location;
   
   
   
   public String getStudentName(){
      return this.s_name;
   }
   
   public String getStudentPass() {
       return this.s_pass;
   }
   
   public String getStudentEmail() {
       return this.s_email;
   }
   
   public String getStudentModule() {
       return this.s_module;
   }
   
   public String getStudentCourse() {
       return this.s_course;
   }
   
   public String getStudentType() {
       return this.s_type;
   }
   
   public double getStudentYear() {
       return this.s_year;
   }
    
   public double getStudentPrice() {
        return this.s_price;
   }
   
   public double getStudentLocation() {
        return this.s_location;
   }
   
   public void setStudentName(String name){
       s_name = name;
   }
   public void setStudentPass(String password){
       s_pass = password;
   }
   public void setStudentEmail(String email){
       s_email = email;
   }
   public void setStudentModule(String module){
       s_module = module;
   }
   public void setStudentCourse(String course){
       s_course = course;
   }
   public void setStudentType(String type){
       s_type = type;
   }
   public void setStudentYear(double year){
       s_year = year;
   }
   public void setStudentPrice(double price){
       s_price = price;
   }
   public void setStudentLocation(double location){
       s_location = location;
   }
   
   @Override
   public String toString() {
       return s_name + "," + s_email+ "," + s_pass + "," + s_year + "," + s_course + "," + s_module + "," + s_location + "," + s_price + "," + s_type;
   }
   
   
    
   
}
