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




        File database = new File("database");
        ObjectInputStream database_reader = new ObjectInputStream(new FileInputStream(database));


        File companies_database = new File("companies database");
        ObjectInputStream companies_database_reader = new ObjectInputStream(new FileInputStream(companies_database));


        ArrayList <ticket> all_tickets = new ArrayList<>();
        ArrayList <company> companies_list = new ArrayList<>();

        ticket ticket1 = new ticket("snapp", "product manager", "senior",1000,1500,"tehran","full time,insurance");
        ticket ticket2 = new ticket("tapsi", "DevOps", "senior",900,1000,"tehran","full time");
        ticket ticket3 = new ticket("namava", "backend developer", "junior",500,600,"isfahan","part time");
        all_tickets.add(ticket1);
        all_tickets.add(ticket2);
       all_tickets.add(ticket3);

        company c1 = new company("snapp","tehran","IT",200,"saadatabad","شرکت اسنپ(سهامی خاص)");
        company c2 = new company("tapsi","tehran","transport",150,"seyedkhandan","شرکت تپسی");
        company c3 = new company("namava","isfahan","telecom",110,"emam square","شرکت نماوا شعبه ی اصفهان");
//        companies_list.add(c1);
//        companies_list.add(c2);
//        companies_list.add(c3);

         jobSearchGUI jSearch = new jobSearchGUI(all_tickets);




//        write_list_to_file(all_tickets, database);
//        write_list_to_file(companies_list,companies_database);
//        System.out.println(database_reader.readByte());
//        ArrayList <company> c = new ArrayList<>();
        read_list_from_file(companies_list,companies_database_reader , 2);
        read_list_from_file(all_tickets,database_reader,1);
        for (int i = 0 ; i < companies_list.size() ; i++){

            System.out.println(companies_list.get(i).getName());
        }

        for (ticket t:all_tickets
             ) {
            System.out.println(t.getTitle());
        }



    }


    static void write_list_to_file(ArrayList list, File file) throws IOException {
        ObjectOutputStream writer = new ObjectOutputStream(new FileOutputStream(file));
        writer.writeObject(list);

        writer.flush();
        writer.close();
    }

    static void read_list_from_file(ArrayList list, ObjectInputStream reader, int type) throws IOException, ClassNotFoundException {
        try {

            ArrayList<ticket> t ;
            ArrayList<company> c ;




                switch (type){

                    case 1: {
                        t = (ArrayList<ticket>) reader.readObject();
                        for (ticket t1:t) {
                            list.add(t1);
//                            System.out.println(t1.getTitle());
                        }

                        break;
                    }

                    case 2: {
                        c = (ArrayList<company>) reader.readObject();
                        for (company c1:c) {
                            list.add(c1);
//                            System.out.println(c1.getName());
                        }
                        break;
                    }





                }


            System.out.println(list.size());

        }catch (EOFException e){
            System.out.println("file is empty");
        }

    }




}