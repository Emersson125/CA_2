/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ca_2;

import static ca_2.optionSort.optionsSort.ASCENDANT;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Emersson Eduardo
 */
public class CA_2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       
        ArrayList<String> NameOfficer = new ArrayList<>(); // arrayList type String to store data from the list 
        ArrayList<String> PoliceRank = new ArrayList<>(); // arrayList type String to store data from the list
        ArrayList<String> Department = new ArrayList<>(); // arrayList type String to store data from the list
       // ArrayList<String> Namearchive = new ArrayList<>();  
        
        Scanner mykb = new Scanner(System.in);   //  scanner to get the input of the user
        System.out.println("*****************************");// text to print and ask for the file to read the user  
        System.out.println(" Police Department. ");
        System.out.println(" Enter the name file to read:");
        System.out.println("*****************************");
        System.out.println("Example.");
        System.out.println("C:\\Users\\Emersson Eduardo\\Desktop\\Applicant_officers.txt");
        System.out.println("");
        
        String filename = mykb.nextLine(); // variable to store the name of the file that will be use it in the other classes 
        
            // method to read the file, variable name   , method to read each line of the file, name of the file   
        try(BufferedReader br = new BufferedReader(new FileReader(filename))){ 
            
            String info_file;// variable to store the data of the file
            
            while((info_file = br.readLine()) != null){// while loop, will work meanwhile data of info_file isn't null 
            
            // will store the data of the info_file into the array splitdata, but if the info from the info_file will be separete/split if has a comma   
            String[] splitdata = info_file.split(",");
            
                if(splitdata.length == 3){// if  splitdata is greater or menor that 3 section  will skip the if and will be print the else error data
                    // example eduardo, sargent, asult     will be stored
                    //         john, k-9 unit              will print error
                    //         Kein, private, bombs,39     will print error
                 
                // variable string, name of array splitdata with its index and trim to avoid error for spaces in the file   
                String name = splitdata[0].trim();        // variable String to store the inf name that is the first split 
                String police = splitdata[1].trim();      //variable String to store the inf Rank that is the second split
                String department = splitdata[2].trim();  // variable String to store the inf Deparment that is the third split
                
                //way to send the info from the array after separate to the ArrayList. 
         
                NameOfficer.add(name);  //ArrayList add the name from string name
                PoliceRank.add(police);  //ArrayList add the name from string polica
                Department.add(department); //ArrayList add the name from string department
              //  Namearchive.add(filename);
                
                    
                }else{
                    System.out.println("Error to read Line !!!");// error to print if the split is not equal to 3
                }
            }
            
            System.out.println("File read successfully."); // error when finish to read of the dato of the file
         
         
        }catch(IOException e){
            System.out.println("Error Redading file: " + e.getMessage());// if there is any problem reading the data will print this message
        }
         
        System.out.println("*****************************");// print after read the file to idicate that is correct and we can manipulate the file 
        System.out.println("Police Department. ");
        System.out.println("");
       // System.out.println(NameOfficer );
       // System.out.println(PoliceRank );
       // System.out.println(Department );
            
           
        for (int i = 0; i < NameOfficer.size(); i++) { 
      //  System.out.println("Name: " + NameOfficer.get(i) + ", --- Rank:" + PoliceRank.get(i) + ", --- Department: " + Department.get(i));      
       }  
        MainMenu(NameOfficer, PoliceRank, Department, filename);       // method main menu to display it after read the file and print the last print 
    }
     
    
     // method Main menu contain the info to display the menu to manipulate the info inside of the file.
                              // bring from the top the info of the names, rank of the officers, the department and the name of the file to modify
    public static void MainMenu (ArrayList<String> NameOfficer, ArrayList<String> PoliceRank, ArrayList<String> Department,String filename){
        Scanner mykb = new Scanner(System.in); // scanner to get the input of user
        
        boolean exit = false; //  variable boolean initialize false to when user press 5 the value turn true and will finish the menu display
    
        while(!exit){// while loop meanwhile user not press exit/5 the while print this menu and the switch with the enum menu 
            System.out.println("************ menu ************"); // these prints display a simple menu to the user and ask for one of these option
            System.out.println("");
            System.out.println("Please enter a number of these options.");
            System.out.println("");
            
            // for bucle. to get all the files from Menuoptions 
                // class MenuOption , variable name (:) bucle for each calling the values of Menuoptions
            for(MenuOptions option : MenuOptions.values()){
                System.out.println(option.getOption() + " , " + option.getDescription());      // this print the ootion and the descripcion inside MenuOptions
                // example: 1, this a option.
                // example: Sort Officers, this is a discription
            }
            System.out.println(" ");                     // menu display it to ask the user for a integer option to mannage the menu
            System.out.println("Select a Option");
            System.out.println("");
            int option = mykb.nextInt();     // int variable  with scanner to keep the value int
            mykb.nextLine();     // this value keep the input in String to avoid problem in the main menu example when i tried to use the search give a error 
            
            //class name, variable is a someone option from MenuOptions and will get the int option to apply in the switch
            MenuOptions menuoptions = MenuOptions.fromOption(option);
          
            if (menuoptions != null){// if the value get from menuoption has exist run the code inside the if
                //in other words if user doesn't press any option the menu won't work
                
                switch (menuoptions){ // but if the user press any option can get acess to any of these cases
                    
                    case SORT:// case to sort the officer linked to the class with the code to do this task.
                        System.out.println("Sort Officers");
                        System.out.println("");
                        optionSort.optionSort(NameOfficer, PoliceRank, Department); 
                        //class name . name method and its parameters
                        break;
                        
                    case SEARCH:// case to search the officer linked to the class with the code to do this task.
                        System.out.println("Search an officer");
                        System.out.println("");
                        Search.search(NameOfficer, PoliceRank, Department, mykb);
                        //class name . name method and its parameters
                        break;
                        
                    case ADD_OFFICER:// case to Add and Remove the officer linked to the class with the code to do this task.
                        System.out.println("Add new officer");
                        System.out.println("");
                        Addnew.addRemoveOfficer(NameOfficer, PoliceRank, Department, mykb, filename);
                        //class name . name method and its parameters
                        break;
                        
                    case GENERATE_RANDOM_OFFICER:// case to generate the officer linked to the class with the code to do this task.
                        System.out.println("");
                        System.out.println("Create a ramdom officers");
                        Generateofficer.generateRandomPeople(NameOfficer, PoliceRank, Department, mykb, filename);
                        //class name . name method and its parameters
                        break;
                        
                    case EXIT: //case exit 
                        exit = true;// just add the value true of exit and will be executed just when the user press 5 
                        // and will finish the program and will print it these prints on the output
                        System.out.println("Exit of Police Department Database.");
                        System.out.println("Start the programm again to read another file.");
                        break;                       
                }
                             
            }else{// else display it when the user enter any value doesn't acepted for the menu 
                System.out.println("");
                System.out.println("Please select a correct option!");
            }    
        }     
    
    }

   
}
    

