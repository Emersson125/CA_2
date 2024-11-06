/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca_2;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
/**
 *
 * @author Emersson Eduardo
 */
public class optionSort{// class optionSort 

    
    public enum optionsSort{
        
        // enum memus options.  options, desccription    
        ASCENDANT(1, "Ascending Order"),
        DESCENDANT(2, "Descending Order");
        
        //instances variable that stored the value of the enum
        private final int code;
        private final String description;
        
        // Constructor method from enum values got from instances variables to called to using.
        optionsSort(int code, String description){// this method recived two paramaters option and description from the private static 
            this.code = code;
            this.description = description;
            
        }
        // getter metod 
        // help us to get access to the constant values code values from enum menu
        public int getCode(){
            return code;
        }
        // getter metod 
        // help us to get access to the constant values int values from enum menu
        public String getDescription(){
            return description;
        }
        
        // method to get the parameters from optionSort throug a int optionsort
        public static optionsSort fromOption(int optionsort) {
        for (optionsSort menuOptionSort : optionsSort.values()) {
            if (menuOptionSort.getCode() == optionsort) {
                return menuOptionSort;
            }
        }
        return null; // this variable return null doesn't finish the loop until the user select one option
    }      
    }
    
    
    // method addRemoveOfficer  with the values in Arraylist from the file read in the main menu, as name, rank, department.
     public static void optionSort(ArrayList<String> NameOfficer, ArrayList<String> PoliceRank, ArrayList<String> Department) {
         
        Scanner mykb = new Scanner(System.in); // scan to get the input of the user 
        System.out.println("************ Sort Options ************");// menu simple to display a sort options
        System.out.println("");

        //loop for to get values from optionSort enum menu  and loop each for to get values for enum values
        for (optionSort.optionsSort sortOption : optionSort.optionsSort.values()) {
            System.out.println(sortOption.getCode() + " , " + sortOption.getDescription()); // value to print the value int code and the String description
        }

        System.out.println(" "); // menu simple to ask for option 
        System.out.println("Select a Sort Option");
         System.out.println("");
        int sortOptionCode = mykb.nextInt(); // variable int to store the input of the user 
        mykb.nextLine(); // // variable to clean the scan afte enter any value in this case avoid error with Strings

        // call the data from the class and the enum
        //classname.enummethod, variable  = classname.enum class.method to get values fromOption will be manipulated and store it for the int sortOptionCode
        optionSort.optionsSort selectedSortOption = optionSort.optionsSort.fromOption(sortOptionCode);

        if (selectedSortOption != null) {// if variable selectedSortOption is not null then will run the code
            switch (selectedSortOption) {// switch case, with the option from enum method
                case ASCENDANT: // enum ddescription
                    System.out.println("******** Ascendant sort list. ***********");
                    System.out.println("");
                    sortOfficers(NameOfficer, PoliceRank, Department, true);// called below method with its parameters.
                    break;

                case DESCENDANT: // enum ddescription
                    System.out.println("******** Descendant sort list. ***********");
                    System.out.println("");
                    sortOfficers(NameOfficer, PoliceRank, Department, false);// called below method with its parameters.
                    break;
            }  
        } else {
            System.out.println("Invalid sorting option!");
        }
        printSortList(NameOfficer, PoliceRank, Department);//called this method to show the list sorted 
    }
     
     // method to sort list with the data from the filename and and the algorihtm to sorted the officer ascendant and descendant 
     public static void sortOfficers(ArrayList<String> NameOfficer, ArrayList<String> PoliceRank, ArrayList<String> Department, boolean ascending) {
         
         
        // loop for to get the the string form ArrayLiat Nameofficer
        // doing a bubblesort that mean that each interation will reduce a number of comparation 
        for (int i = 0; i < NameOfficer.size() - 1; i++) {
            
            //is to compared adjacent elements in the list after each pass of the outer loop the the loop over.
            for (int j = 0; j < NameOfficer.size() - i - 1; j++) {
                
                if (ascending) {// Ascending loop
                    // values got from ArrayList NameOfficer compare and ignorecase with NameOfficer + and eliminated the spaces grater that 0.
                    //this if works,   NameOfficer.get(j) is greater that NameOfficer.get(j + 1) then the value move to keep the ascendant orden
                    if (NameOfficer.get(j).compareToIgnoreCase(NameOfficer.get(j + 1).trim()) > 0) {
                        // change the position of the index name in orden ascendant
                        Collections.swap(NameOfficer, j, j + 1);
                        //change the position of the index rank and department in orden ascendant
                        Collections.swap(PoliceRank, j, j + 1);
                        Collections.swap(Department, j, j + 1);
                        //https://codegym.cc/groups/posts/bubble-sort
                    }
                } else {
                    // values got from ArrayList NameOfficer compare and ignorecase with NameOfficer + and eliminated the spaces grater that 0.
                    //this if works,   NameOfficer.get(j) is less that NameOfficer.get(j + 1) then the keep the Descendant orden
                    if (NameOfficer.get(j).compareToIgnoreCase(NameOfficer.get(j + 1).trim()) < 0) {
                        /// change the position of the index name in orden ascendant
                        Collections.swap(NameOfficer, j, j + 1);
                        //change the position of the index rank and department in orden ascendant
                        Collections.swap(PoliceRank, j, j + 1);
                        Collections.swap(Department, j, j + 1);
                    }
                }
            }
        }
     }
     
     // method printSortList with the values in Arraylist from the file read in the main menu, as name, rank, department.
     public static void printSortList(ArrayList<String> NameOfficer, ArrayList<String> PoliceRank, ArrayList<String> Department) {
        
         // this menu print the list of the oficcer in the list after they have been sorted 
        System.out.println("****************************** ");
        System.out.println("Sorted Officers List:");
        System.out.println("");
        
        // this variable int store the the number of rows/ lines from the arraylist  in this case 20
        int limit = Math.min(20, NameOfficer.size());
        // when only put the number 20 in i<20 when i added a new officer the list doesn't show it.
        for (int i = 0; i < limit; i++) {// loop to print the 20 first in the list with theirs name, rank, deparment.
            System.out.println("Name: " + NameOfficer.get(i) + ", Rank: " + PoliceRank.get(i) + ", Department: " + Department.get(i));
            System.out.println("");
        }
    }
     
     
}


