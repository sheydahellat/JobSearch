import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Login {
    public static void main(String[] a) throws FileNotFoundException {
        ArrayList <User> all_users = new ArrayList<>();
        all_users.add(new User("sheyda","1234"));
        LoginFrame frame = new LoginFrame(all_users);
        frame.setTitle("Login Form");
        frame.setVisible(true);
        frame.setBounds(10, 10, 470, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);


        File database = new File("database.txt");
        Scanner reader = new Scanner(new BufferedInputStream(new FileInputStream(database)));
        BufferedOutputStream writer = new BufferedOutputStream(new FileOutputStream(database));


        ArrayList <ticket> all_tickets = new ArrayList<>();


    }
}