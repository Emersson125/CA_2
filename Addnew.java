/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca_2;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Emersson Eduardo
 */
public class Addnew {//  class addnew
    
    public enum newofficer{ // method enum
        // enum memus options.  options, desccription          
        ADD_NEW_OFFICER(1, "Add new officer. "),
        REMOVE_OFFICER(2, "Remove officer. ");
        
        //instances variable that stored the value of the enum 
        private final int option; //option with value int
        private final String description; // desccription with value String
        
        // Constructor method for enum values got from instances variables to called to method
        newofficer( int option, String description){  // this method recived two paramaters option and description from the private static 
        this.option = option;
        this.description = description;   
        }
        
        // getter metod 
        // help us to get access to the constant values int valuos from enum menu
        public int getoption(){
        return option;
        }   
        // getter metod 
        // help us to get access to the constant values String values from enum menu
        public String getdescription(){
            return description;
        }
        
        @Override // work to overwrite the method
        public String toString(){
            return option + "." + description;
        }
        
      // method to get the parameters from newofficer throug a int optionofficer
        public static newofficer fromofficer(int optionofficer){
            for( newofficer office : newofficer.values()){// loop to get the values form enum Newofficer
                if(office.getoption() == optionofficer){ // if to indicate if the option selected for the user is equal to the value from enum menu will return the value
                    return office;// variable return 
                }
            }
            return null; // this variable return null doesn't finish the loop until the user select one option correctly
        }
                
           
    }
    // method addRemoveOfficer  with the values in Arraylist from the file read in the main menu, as name, rank, department, scanner and the name of the file that the user put in the reader
    public static void addRemoveOfficer( ArrayList<String> NameOfficer, ArrayList<String> PoliceRank, ArrayList<String> Department, Scanner mykb,String filename){
        // prins to display a menu with the option from enum new officer trough a loop for
        System.out.println("************ Add and remove ************");
        System.out.println("");
        
        //loop for to print the parameters from newofficer and display the int option and the String description
        for(Addnew.newofficer newoffice : Addnew.newofficer.values()){
            System.out.println(newoffice.getoption() + "," + newoffice.getdescription());  
        }
         // menu to ask for a option to the user
        System.out.println(" ");
        System.out.println("Select an Option");
        System.out.println("");
         
        // variable int to store the selection of the user 
        int addremove = mykb.nextInt();
        mykb.nextLine(); // variable to clean the scan afte enter any value in this case avoid error with Strings
       
        // call the data from the class and the enum
        //classname.enummethod, variable  = classname.enum class.method to get values fromofficer will be manipulated and store it for the int addremove
        Addnew.newofficer addremoveoption = Addnew.newofficer.fromofficer(addremove);
        
        if (addremoveoption !=null){//i used a if to create a menu option with int.    if the variable got from addremoveoption is not null run the switch
            switch(addremoveoption){// switch, case displayed the enum menu with a case to select the option of add or remove officer
                
                case ADD_NEW_OFFICER: // enum ddescription
                System.out.println("******** Add new officer. ***********"); // menu to displayed  the methos add new officer
                System.out.println("");
                addOfficer( NameOfficer,PoliceRank,Department,mykb,filename); // called method with its parameters.
                break;
                
                case REMOVE_OFFICER:// enum ddescription
                System.out.println("******** remove an officer. ***********");// menu to displayed  the methos remove new officer
                System.out.println("");
                removeOfficer( NameOfficer,PoliceRank,Department,mykb, filename);// called method with its parameters.
                break;          
            }
        }else{
                System.out.println("");//i didnt put a message because i wouldn't like to display nathing here 
        }
     
    }
 // method addRemoveOfficer  with the values in Arraylist from the file read in the main menu, as name, rank, department, scanner and the name of the file that the user put in the reader
    public static void addOfficer( ArrayList<String> NameOfficer, ArrayList<String> PoliceRank, ArrayList<String> Department, Scanner mykb,String filename){
        
        // this method collect the information in small menus to added into the arrays after the user finish to insert the data the code 
        //add the information in the filename to update the data base
        System.out.print("Enter Name of the officer: ");// menu name officer 
        System.out.println("");
        String name = mykb.nextLine(); // variable string to store the name.

    // menu to store the rank officer
        System.out.print("Enter Rank of the officer: ");
        System.out.println("");
        String rank = mykb.nextLine();// variable string to store the rank.

    // menu to store the deparment 
        System.out.print("Enter Department: ");
        System.out.println("");
        String department = mykb.nextLine();// variable string to store the rank.

    // add to collect the information from the variables and send to the Array list to manage that info and write in the file name through the filewriter
        // ArrayList    variable 
        NameOfficer.add(name); 
        PoliceRank.add(rank);
        Department.add(department);
        
        // the bufferedwrite will write the values got variables and will put into file 
        try (BufferedWriter bwriter = new BufferedWriter(new FileWriter(filename, true))) {
            bwriter.write(name + "," + rank + "," + department);// use the variable bwriter and add the values from variable
            bwriter.newLine(); // this is to each time that enter a new user jump new line
            System.out.println("Officer information saved successfully to file.");// and if all its right at the momment to write the file this massege apears
        } catch (IOException e) {
            System.out.println("Error saving officer information: " + e.getMessage()); //any erro this messages apears
        }
        
        System.out.println("**********NEW OFFICER **********");// menu simple to display that the new office is crated sucessful
        System.out.println("");
        System.out.println("Officer added sucessful!");
        System.out.println("");
        System.out.println("Officer: " + name + " with rank " + rank + " has beed added at the Departmen: " + department);
}
     
    // method addRemoveOfficer  with the values in Arraylist from the file read in the main menu, as name, rank, department, scanner and the name of the file that the user put in the reader
    public static void removeOfficer(ArrayList<String> NameOfficer, ArrayList<String> PoliceRank, ArrayList<String> Department, Scanner mykb, String filename) {
    
      //menu simple to display and aks for name of user to remove  
    System.out.println(" ****************************** ");
    System.out.print("Enter the name of the officer to remove: ");
    System.out.println("");
    
    String remove = mykb.nextLine(); // variable String to store the input of user 
    
    // varibale int with method index to find in the ArrayList NameOfficer  
    int index = NameOfficer.indexOf(remove.trim());
    
    // if the Index Of the officer exist the if el will remove the value of these three values ArrayList 
    if (index != -1) {
        // Eliminat the index data from name, rank, department.
        NameOfficer.remove(index);
        PoliceRank.remove(index);
        Department.remove(index);
        System.out.println("");// menu to display that the police has been removed
        System.out.println("Officer " + remove + " has been removed from the list.");
        System.out.println("");
        // call the method updatefile to do the update of the list in the document txt
        updateFile(NameOfficer, PoliceRank, Department, filename);
    } else {
        System.out.println("");  // menu to display that the user is no found in the list and it hasn't removed
        System.out.println("Officer " + remove + " not found in the list.");
        System.out.println("");
    }
}
    
// Method to update the data after get the value in the methods  add and remove to writer in the file and avoid problem when store data in
public static void updateFile(ArrayList<String> NameOfficer, ArrayList<String> PoliceRank, ArrayList<String> Department, String filename) {
    
    try (BufferedWriter bwriter = new BufferedWriter(new FileWriter(filename))) {
        
        // overwriter the listit with the new data.
        for (int i = 0; i < NameOfficer.size(); i++) {
            bwriter.write(NameOfficer.get(i) + "," + PoliceRank.get(i) + "," + Department.get(i));
            bwriter.newLine();// 
        }
        System.out.println("File updated successfully after deletion.");// message to indicate that all it's fine
        
    } catch (IOException e) {
        
        System.out.println("Error updating file: " + e.getMessage());// message to indicate if something its wrong
    }
}
   
}
    

