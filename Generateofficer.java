/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca_2;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

/**
 *
 * @author Emersson Eduardo
 */
public class Generateofficer {
    
    // method to generated a random officer to test the menu 
    public static void generateRandomPeople(ArrayList<String> NameOfficer, ArrayList<String> PoliceRank, ArrayList<String> Department, Scanner mykb,  String filename) {
       
        String[] randomNames = {"Alex Johnson", "Morgan Black", "Jordan Smith", "Taylor Grey", "Chris Hunter", "Roger Perez", "Dante Salazar"}; // array with a few names to crceate a ramdom officers
        String[] ranks = {"Lieutenant", "Chief of police", "Assistant Police Chief" , "Sergeant Detective"};// array with a few ranks to crceate a ramdom officers
        String[] departments = {"Investigation", "Patrol", "Forensics", "Company", "Intel"}; // array with a few deparments to create theirs officers
        
        // variable  random that use a random method
        Random random = new Random();
        System.out.println("Enter how many random Officers do you need?");// scanner to ask for the a number of officers need to created with the arrays info
        int numberOfPeople = mykb.nextInt();
        mykb.nextLine();// variable to clean the input of the user
        
        Set<String> uniqueCombinations = new HashSet<>();// Sets do not allow duplicates, which helps prevent repeated combinations.
        
        // the bufferedwrite will write the values got variables and will put into file 
        try (FileWriter fwriter = new FileWriter(filename, true); 
             // this buffered writer help to write the text back to the file   
             BufferedWriter bwriter = new BufferedWriter(fwriter);
                // rpint writer help to write with the format of the infomartion
             PrintWriter out = new PrintWriter(bwriter)) {
            
            // loop to indicate how many officer needs create 
            for (int i = 0; i < numberOfPeople; i++) {
                // will use it these varibles to store the data crated for the loop
                String name, rank, dept, combination;
                
                do{// this loop do-while, use the arrays info inside the array to create the new officer with name, rank, departament
                    
                name = randomNames[random.nextInt(randomNames.length)];              
                rank = ranks[random.nextInt(ranks.length)];              
                dept = departments[random.nextInt(departments.length)];
                
                combination = name + "," + rank + "," + dept;// variable to show the result of the combination
                
                } while (uniqueCombinations.contains(combination)); // this repit the process if there are these conbination in the list 
                
                uniqueCombinations.add(combination); // this add the unique combinations and added to the combination to avoid repite them
                NameOfficer.add(name);// send name of officer to the arraylist 
                PoliceRank.add(rank);// send rank of officer to the arraylist
                Department.add(dept);// send Department of officer to the arraylist

                    // print the combinantion created 
                    System.out.println("");                 
                    System.out.println("Generated and Saved Officer: " + "Name: " + name + ", Rank: " + rank + ", Department: " + dept);
                }
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());// message error if something going wrong
        }
    }
    
}
