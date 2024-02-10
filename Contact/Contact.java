package Contact;
import java.util.ArrayList;

import Message.Message;
public class Contact{
    private String name , number , email;
    private ArrayList<Message> messages;

    public Contact(String name , String number, String email , ArrayList<Message> messages){
        this.name = name;
        this.number = number;
        this.email = email;
        this.messages = messages;
    }

    public Contact(String name , String number, String email){
        this.name = name;
        this.number = number;
        this.email = email;
        this.messages = new ArrayList<>();
    }

    public void getDetails(){
        System.out.println("Name : " + this.name + "" +
                            "\nContact Number : " + this.number + "" + 
                            "\nEmail : " + this.email);
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getNumber(){
        return number;
    }

    public void setNumber(String number){
        this.number = number;
    }

    public String getEmail(){
        return email;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public ArrayList<Message> getMessage(){
        return messages;
    }

    public void setMessage(ArrayList<Message> messages){
        this.messages = messages;
    }
} 