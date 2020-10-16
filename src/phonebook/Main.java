/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phonebook;

import java.util.Scanner;

/**
 *
 * @author 1styrGroupB
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        Scanner input = new Scanner(System.in);
        App pbApp = new App();

        while (true) {
            switch (pbApp.userChoice()) {
                case "1":
                    pbApp.addContact(); // we call the addCard method in App class
                    break;
                case "2":
                    pbApp.updateContact(); //we call ediCard in the App class
                    break;
                case "3":
                    pbApp.deleteContact(); // we call the removeCard in the App class
                    break;

                case "4":
                    pbApp.searchOneContact();
                    break;
                    
                case "5":
                    pbApp.displayAllContact();
                    break;
                default:
                    System.out.println("Invalid Input!!");
            }
        }
    }

}
