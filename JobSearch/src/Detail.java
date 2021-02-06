import java.io.Serializable;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
public class Detail {
    public String name;
    public String history;
    public String jobTitle;
    public int wage;
    public String city;
    public String description;


    public Detail(String name, String history, String jobTitle, int wage, String city, String description) {
        this.name = name;
        this.history = history;
        this.jobTitle = jobTitle;
        this.wage = wage;
        this.city = city;
        this.description = description;
    }


}
