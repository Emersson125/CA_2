/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca_2;

/**
 *
 * @author Emersson Eduardo
 */
public enum MenuOptions {  // method enum to determinated a constant values in this case options and descriptions
    // value name and its value int and value description 
    SORT(1, "Sort Officers"),
    SEARCH(2, "Search Officers"),
    ADD_OFFICER(3, "Add and Remove officer"),
    GENERATE_RANDOM_OFFICER(4, "Generate a Random Officer"),
    EXIT(5, "Exit");

    //instances variable that stored the value of the enum 
    private final int option; //option with value int
    private final String description;  // desccription with value String

    // Constructor for enum values got from instances variables
    MenuOptions(int option, String description) {
        this.option = option;
        this.description = description;
    }
     
    //getter metod 
    // help us to get access to the constant values 
    public int getOption() {//return the int option values from the enum
        return option;
    }

    public String getDescription() {//return the String description values from the enum
        return description;
    }

    // Method to retrieve MenuOption by number
    
    public static MenuOptions fromOption(int option) {
        for (MenuOptions menuOption : MenuOptions.values()) {
            if (menuOption.getOption() == option) {
                return menuOption;
            }
        }
        return null; // return null or nathing if the user put an invalid option
    }

    @Override
    //
    public String toString() {
        return option + ". " + description;
    }
}
