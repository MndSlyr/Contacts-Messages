import java.util.ArrayList;
import java.util.Scanner;

import Contact.Contact;
import Message.Message;

public class main{
    
    private static Scanner scanner , scanner1;
    private static ArrayList<Contact> contacts;
    private static int id = 0;
    public static void main (String[] args) {
        contacts = new ArrayList<>();
        System.out.println("Welcome");
        showInitialOptions();
    }

    private static void showInitialOptions(){
        System.out.println("Please select one : " +
                            "\n\t1. Manage Contacts" +
                            "\n\t2. Messages" +
                            "\n\t3. Quit");

        scanner = new Scanner(System.in);
        scanner1 = new Scanner(System.in);
        int choice = scanner.nextInt();
        switch(choice){
            case 1 :
                manageContacts();
                break;
            case 2 :
                manageMessages();
                break;
            default :
                break;
        }
    }

    private static void manageMessages() {
        System.out.println("Please select one: " +
                            "\n\t1. Show all messages" +
                            "\n\t2. Send a message" +
                            "\n\t3. Go Back");
        int choice = scanner.nextInt();
        switch(choice){
            case 1:
                showAllMessages();
                break;
            case 2:
                sendAMessage();
                break;
            default:
                showInitialOptions();
        }
    }

    private static void sendAMessage() {
        System.out.println("Enter the receiver's name");
        String name = scanner1.nextLine();
        boolean valid = false;
        for(Contact c : contacts){
            if(c.getName().equals(name)){
                valid = true;
                break;
            }
        }
        if(!valid){
            System.out.println("NO SUCH CONTACT!! \nAdd this contact!!");
            showInitialOptions();
        }
        else{
            System.out.println("What are you going to say");
            String text = scanner1.nextLine();
            if(text.equals("")){
                System.out.println("Please Enter some message");
                sendAMessage();
            }
            else{
                id++;
                Message newMessage = new Message(text , name , id);
                for(Contact c : contacts){
                    if(c.getName().equals(name)){
                        ArrayList<Message> newMessages = c.getMessage();
                        newMessages.add(newMessage);
                        Contact currentContact = c;
                        currentContact.setMessage(newMessages);
                        contacts.remove(c);
                        contacts.add(currentContact);
                        System.out.println("Message Sent!!");
                    }
                }
            }
        }
        showInitialOptions();
    }

    private static void showAllMessages() {
        ArrayList<Message> allMessages = new ArrayList<>();
        for(Contact c : contacts){
            allMessages.addAll(c.getMessage());
        }
        if(allMessages.size() > 0){
            for(Message m : allMessages){
                m.getDetails();
                System.out.println("--------------");
            }
        }
        else{
            System.out.println("You don't have any messages");
        }
        showInitialOptions();
    }

    private static void manageContacts(){
        System.out.println("Please Select One : " +
                            "\n\t1. Show all contacts" +
                            "\n\t2. Add a new contact" +
                            "\n\t3. Search for a contact" +
                            "\n\t4. Delete a contact" +
                            "\n\t5. Go Back");
        
        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                showAllContacts();
                break;
            case 2:
                addNewContact();
                break;
            case 3:
                searchForContact();
                break;
            case 4:
                deleteContact();
                break;
            default:
                showInitialOptions();
                break;
        }
    }

    private static void deleteContact() {
        System.out.println("Delete a contact through..." +
                            "\n\t1. Name" +
                            "\n\t2. Number" +
                            "\n\t3. Email");
        int choice = scanner.nextInt();
        boolean valid = false;
        switch (choice) {
            case 1:
                System.out.println("Enter the contact name");
                String name = scanner1.nextLine();
                for(Contact c : contacts){
                    if(c.getName().equals(name)){
                        contacts.remove(c);
                        valid = true;
                        break;
                    }
                }
                if(!valid){
                    System.out.println("No such Contact!!");
                }
                break;
            case 2:
                System.out.println("Enter the contact number");
                String number = scanner1.nextLine();
                for(Contact c : contacts){
                    if(c.getNumber().equals(number)){
                        contacts.remove(c);
                        valid = true;
                        break;
                    }
                }
                if(!valid){
                    System.out.println("No such Contact!!");
                }
                break;
            case 3:
                System.out.println("Enter the contact's email");
                String email = scanner1.nextLine();
                for(Contact c : contacts){
                    if(c.getEmail().equals(email)){
                        contacts.remove(c);
                        valid = true;
                        break;
                    }
                }
                if(!valid){
                    System.out.println("No such Contact!!");
                }
                break;
            default:
                break;
        }
        showInitialOptions();
    }

    private static void searchForContact() {
        System.out.println("Searching a contact through..." +
                            "\n\t1. Name" +
                            "\n\t2. Number" +
                            "\n\t3. Email");
        int choice = scanner.nextInt();
        boolean valid = false;
        switch (choice) {
            case 1:
                System.out.println("Enter the contact name");
                String name = scanner1.nextLine();
                for(Contact c : contacts){
                    if(c.getName().equals(name)){
                        c.getDetails();
                        valid = true;
                        break;
                    }
                }
                if(!valid){
                    System.out.println("No such Contact!!");
                }
                break;
            case 2:
                System.out.println("Enter the contact number");
                String number = scanner1.nextLine();
                for(Contact c : contacts){
                    if(c.getNumber().equals(number)){
                        c.getDetails();
                        valid = true;
                        break;
                    }
                }
                if(!valid){
                    System.out.println("No such Contact!!");
                }
                break;
            case 3:
                System.out.println("Enter the contact's email");
                String email = scanner1.nextLine();
                for(Contact c : contacts){
                    if(c.getEmail().equals(email)){
                        c.getDetails();
                        valid = true;
                        break;
                    }
                }
                if(!valid){
                    System.out.println("No such Contact!!");
                }
                break;
            default:
                break;
        }
        showInitialOptions();
    }

    private static void addNewContact() {
        System.out.println("Adding a new contact..." +
                            "\nEnter the Phone Number : ");
        String number = scanner1.nextLine();
        System.out.print("Enter the Name : ");
        String name = scanner1.nextLine();
        System.out.print("\nEnter the Email : ");
        String email = scanner1.nextLine();

        if(number == "" || name == "" || email == ""){
            System.out.println("Re-enter the details");
            addNewContact();
        }
        
        boolean valid = false;
        for(Contact c: contacts){
            if(c.getName() == name){
                valid = true;
                break;
            }
        }
        if(valid){
            System.out.println("Contact already exists!!");
            addNewContact();
        }
        Contact contact = new Contact(name , number , email);
        contacts.add(contact);
        System.out.println(name + " Added Successfully!");
        showInitialOptions();
    }

    private static void showAllContacts() {
        if(contacts.size() == 0){
            System.out.println("No Contacts!!");
        }
        for(Contact c : contacts){
            c.getDetails();
            System.out.println("------------------");
        }
        showInitialOptions();
    }
}