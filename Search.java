/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca_2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

/**
 *
 * @author Emersson Eduardo
 */
public class Search {

        // method to Search the officer in the list file with the data as name, rank, department and the namefile to work with them in this code
   public static void search(ArrayList<String> NameOfficer, ArrayList<String> PoliceRank, ArrayList<String> Department, Scanner mykb) {  
       
    // funtion/metod collection sort to sort the list of Nameofficer compare ignoring the case
        Collections.sort(NameOfficer, String :: compareToIgnoreCase);
       
        displayOfficers(NameOfficer);// call method to show the data of the NameOfficer 
        // scanner and input String to ask for the name of the officer plus. trim to avoid if the user enter a blank space the code will be able to find the officer
        System.out.print("Enter Officer name: ");
        String officerName = mykb.nextLine().trim();

        // variable int with the info from the Arraylist where use the value input for the user and the name from the ArrayList
        int result = binarySearch(NameOfficer, officerName);
        
        if (result != -1) {// if the result find an officer the result will be 0 or grater and then print the info of the officer
            System.out.println("**************************************");
            System.out.println("Officer Found: ");
            System.out.println(" ");
            System.out.println("Name: " + NameOfficer.get(result));
            System.out.println("");
            System.out.println("Rank: " + PoliceRank.get(result));
            System.out.println("");
            System.out.println("Department: " + Department.get(result));
            System.out.println("");
            System.out.println("**************************************");
        } else {
            System.out.println("Officer not found .");// if the officername isn't exist NameOfficer the if will be -1 and it print this section 
        }
    }
    
   // method with the logarithm binary to search the officer in the list  with the ArrayList to search the list the officer and the string officer
    private static int binarySearch(ArrayList<String> array, String target) {
        // the name of these parameters is array with the NameOfficer and String target  from binarySearch
        
        // initializes a these variables to each get the range left and right of the index 
        int left = 0; // left side of the index
        // 0,1,2,3,4,5
        //start in 0 position
        int right = array.size() - 1; // right side of the index -1 indicate start and the right side
        // 0,1,2,3,4,5
        //start in 5 position 

        // while loop to the middle of the index
        // while left be less equal that right then the will run the next code
        while (left <= right) {
            
            // variable int mid  apply to find the name in the index.
            int mid = left + (right - left) / 2;
            //example 0,1,2,3,4,5,6,7,8,9  index of 10 i want to search value 6
            // middlepoint = 0 +(9-0)/2 = 4 + 1 in leftside then is 5 now
            // the middle point is menor yet that 6 then the code execute again
            // 5,6,7,8,9
            // middlepoint = 5 +(9-5)/2 = 7 then now is grant that 6 then -1 to right side is now 6
            // 5,6,
            // middlepoint = 5 +(6-5)/2 =  5 now the value is menor that 6 the +1 to left side and now is 6
            // 6  leftpoint and right point are the same because there inst more index just cheange the values in the formula and will get our value after 4 interation.
            // middlepoint = 6 +(6-6)/2 =  6  
           
            
        if (array.get(mid).trim().equalsIgnoreCase(target)) {
            //this if  make that Array get the middle and comparte with the target/ input of user if is the same return the value to mid
            return mid; // return the value to mid, if not find the value equal then run the next part
            
            //this if  make that Array get the middle and comparte with the target/input of user if value is less that the target in this case -1 then the loop start to search to the left side of index
        } else if (array.get(mid).compareToIgnoreCase(target) < 0) { // then run this code
            
            left = mid + 1; // left is mid +1 and start to serach in the left side
            
        } else {
            right = mid - 1; // right is mid -1 and start to search in the right side 
        }// in this case these else code does the explanation of the binary form trying to search the number 6
        }
        return -1; // Return -1 becausse the value is not in the list
    }
    
    private static void displayOfficers(ArrayList<String> NameOfficer) {
        
        //prints to show the list of the officer sorted
        System.out.println("******************");
        System.out.println("List of Officers:");
        System.out.println("");
        
           // this variable int store the the number of rows/ lines from the arraylist  in this case 20
           int limit = Math.min(20, NameOfficer.size()); // Asegúrate de no superar el tamaño de la lista
            // when only put the number 20 in i<20 when the list doesn't show it.
            for (int i = 0; i < limit; i++) {// loop to print the 20 first in the list with theirs name
                System.out.println("");
                System.out.println("Name : " + NameOfficer.get(i));
                System.out.println("");
            }
            
            }

    }

 