/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phonebook;

import java.util.*;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author 1styrGroupB
 */
public class App {

    Scanner input = new Scanner(System.in);

    ArrayList<PhoneBook> pb = new ArrayList<>();

    public String userChoice() {

        System.out.println("Phone Book Options\n1 - Add Contact\n2 - Update Contact\n3 - Delete Contact\n4 - Search Contact(by:Id)\n5 -Display Contacts");
        System.out.println("Choice: ");
        String userChoice = input.nextLine();

        return userChoice;

    }

    public void addContact() {

        PhoneBook phonebook = new PhoneBook();

        Random random = new Random();
        int intRandom = random.nextInt(500);
        String randomNumber = Integer.toString(intRandom);

        phonebook.setId(randomNumber);

        System.out.println("User Id: " + randomNumber);

        System.out.println("User Firstname: ");
        phonebook.setFirstName(input.nextLine());

        System.out.println("User Lastname: ");
        phonebook.setLastName(input.nextLine());

        System.out.println("Phone Number: ");
        String phoneNumber = input.nextLine();
        while (!isPhoneNumberValidator(phoneNumber)) {
            System.out.println("Invalid Phone Number! Try Again ");
            System.out.print("Phone Number: ");
            phoneNumber = input.nextLine();
        }

        phonebook.setPhoneNumber(phoneNumber);

        System.out.println("User Email: ");
        String email = input.nextLine();
        while (!isEmailValidator(email)) {
            System.out.println("Invalid Email! Try Again!");
            System.out.println("Email: ");
            email = input.nextLine();
        }
        phonebook.setEmail(email);

        System.out.println("Adress: ");
        phonebook.setAddress(input.nextLine());
        System.out.println("");
        pb.add(phonebook);

    }

    public void updateContact() {
        if (!pb.isEmpty()) {

            System.out.println("Enter Id: ");
            String userInput = input.nextLine();

            pb.forEach((list) -> {
                if (userInput.equals(list.getId())) {

                    System.out.println("User Id: " + list.getId());
                    System.out.println("FirstName: " + list.getFirstName());
                    System.out.println("LastName: " + list.getLastName());
                    System.out.println("Phone Numer: " + list.getPhoneNumber());
                    System.out.println("Email: " + list.getEmail());
                    System.out.println("Adress: " + list.getAddress());
                    System.out.println("");

                    System.out.println("User Firstname: ");
                    list.setFirstName(input.nextLine());

                    System.out.println("User Lastname: ");
                    list.setLastName(input.nextLine());

                    System.out.println("Phone Number: ");
                    String phoneNumber = input.nextLine();
                    while (!isPhoneNumberValidator(phoneNumber)) {
                        System.out.println("Invalid Phone Number! Try Again ");
                        System.out.print("Phone Number: ");
                        phoneNumber = input.nextLine();
                    }

                    list.setPhoneNumber(phoneNumber);

                    System.out.println("User Email: ");
                    String email = input.nextLine();
                    while (!isEmailValidator(email)) {
                        System.out.println("Invalid Email! Try Again!");
                        System.out.println("Email: ");
                        email = input.nextLine();
                    }
                    list.setEmail(email);

                    System.out.println("Adress: ");
                    list.setAddress(input.nextLine());

                }

            });

            System.out.println("Updated Successfully");
            System.out.println("");
            System.out.println("");

        } else {
            System.out.println("Update Failed!");

        }

    }

    public void deleteContact() {
        if (!pb.isEmpty()) {

            System.out.println("Enter Id: ");
            String userInput = input.nextLine();
            PhoneBook object = null;
            for (PhoneBook information : pb) {

                if (userInput.equals(information.getId())) {
                    System.out.println("User Id: " + information.getId());
                    System.out.println("FirstName: " + information.getFirstName());
                    System.out.println("LastName: " + information.getLastName());
                    System.out.println("Phone Numer: " + information.getPhoneNumber());
                    System.out.println("Email: " + information.getEmail());
                    System.out.println("Adress: " + information.getAddress());
                    System.out.println("");
                    System.out.println("");

                    object = information;
                    break;
                }

            }

            if (pb.remove(object)) {
                System.out.println("Succesfully Removed");

            } else {
                System.out.println("Not Found");
                System.out.println("");

            }
        } else {

            System.out.println("Failed to Delete!");
            System.out.println("");

        }

    }

    public void searchOneContact() {
        if (!pb.isEmpty()) {

            System.out.println("Enter Id: ");
            String userInput = input.nextLine();
            pb.forEach((list) -> {

                if (userInput.equals(list.getId())) {
                    System.out.println("User Id: " + list.getId());
                    System.out.println("FirstName: " + list.getFirstName());
                    System.out.println("LastName: " + list.getLastName());
                    System.out.println("Phone Numer: " + list.getPhoneNumber());
                    System.out.println("Email: " + list.getEmail());
                    System.out.println("Adress: " + list.getAddress());
                    System.out.println("");

                } else {
                    System.out.println("Id does not Exist!");
                    System.out.println("");

                }

            });

        } else {
            System.out.println("List is Empty");
        }

    }
    
    //Method to display Contact List
    public void displayAllContact() {
        if (!pb.isEmpty()) {

            Collections.sort(pb);
            pb.forEach((list) -> {

                System.out.println("User Id: " + list.getId());
                System.out.println("FirstName: " + list.getFirstName());
                System.out.println("LastName: " + list.getLastName());
                System.out.println("Phone Numer: " + list.getPhoneNumber());
                System.out.println("Email: " + list.getEmail());
                System.out.println("Adress: " + list.getAddress());
                System.out.println("");
                System.out.println("");

            });
        } else {

            System.out.println("Contact List Is empty");

        }

    }
    //Check if Number is Numeric (True or False)
        private boolean isNumeric(String contactNumber) {
            try {
                Long.parseLong(contactNumber);
                return true;
            } catch (NumberFormatException e) {
                return false;
            }
        }
    
    //method to check email format
    public boolean isEmailValidator(String email) {
        String regex = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
        return email.matches(regex);
    }

    // method to check if number is numeric 
    private boolean isPhoneNumberValidator(String contactNumber) {
        boolean exist = true;
        if (!isNumeric(contactNumber)) {
            return false;
        }
        for (int index = 0; index < pb.size(); index++) {
            if (pb.get(index).getPhoneNumber().equals(contactNumber)) {
                System.out.println("Phone Number Already exists");
                exist = false;
                break;
            }
        }

        return exist;
    }

}
