import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Login {
    public static void main(String[] a) throws IOException, ClassNotFoundException {
        ArrayList <User> all_users = new ArrayList<>();
        all_users.add(new User("sheyda","1234"));
        LoginFrame frame = new LoginFrame(all_users);
        frame.setTitle("Login Form");
        frame.setVisible(true);
        frame.setBounds(10, 10, 470, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);




        File database = new File("database.txt");
        ObjectInputStream reader = new ObjectInputStream(new FileInputStream(database));
        ObjectOutputStream writer = new ObjectOutputStream(new FileOutputStream(database));


        ArrayList <ticket> all_tickets = new ArrayList<>();


        ticket ticket1 = new ticket("snapp", "product manager", "senior",1000,1500,"tehran","full time,insurance");
        ticket ticket2 = new ticket("tapsi", "DevOps", "senior",900,1000,"tehran","full time");
        ticket ticket3 = new ticket("namava", "backend developer", "junior",500,600,"tehran","part time");
        all_tickets.add(ticket1);
        all_tickets.add(ticket2);
        all_tickets.add(ticket3);


//        write_list_to_file(all_tickets, writer);
        read_list_from_file(all_tickets,reader);
        for (int i = 0 ; i < all_tickets.size() ; i++){

            System.out.println(all_tickets.get(i).getTitle());
        }
    }


    static void write_list_to_file(ArrayList list , ObjectOutputStream writer) throws IOException {
        for (int i = 0 ; i < list.size() ; i++) {
            writer.writeObject(list.get(i));

        }

    }

    static void read_list_from_file(ArrayList list , ObjectInputStream reader) throws IOException, ClassNotFoundException {
        for (int i = 0 ; reader.available()>0 ; i++) {
            ticket t = (ticket) reader.readObject();
            list.add(t);

        }
        System.out.println(list.size());

    }
}