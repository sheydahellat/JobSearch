import java.io.Serializable;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
public class Detail {
    private String name;
    private String history;
    private String jobTitle;
    private int wage;
    private String city;
    private String description;


    public Detail(String name, String history, String jobTitle, int wage, String city, String description) {
        this.name = name;
        this.history = history;
        this.jobTitle = jobTitle;
        this.wage = wage;
        this.city = city;
        this.description = description;
    }


}
