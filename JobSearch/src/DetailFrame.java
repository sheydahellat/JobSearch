import java.io.Serializable;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
public class DetailFrame extends JFrame implements ActionListener{
    Container container = getContentPane();
    JLabel nameLabel = new JLabel("name");
    JLabel historyLabel = new JLabel("history");
    JLabel jobTitleLabel = new JLabel("jobTitle");
    JLabel wageLabel = new JLabel("wage");
    JLabel cityLabel = new JLabel("city");
    JLabel descriptionLabel = new JLabel("description");
    JLabel nameLabel2 = new JLabel("name");
    JLabel historyLabel2 = new JLabel("history");
    JLabel jobTitleLabel2 = new JLabel("jobTitle");
    JLabel wageLabel2 = new JLabel("wage");
    JLabel cityLabel2 = new JLabel("city");
    JLabel descriptionLabel2 = new JLabel("description");
    private JButton button = new JButton("Submit");
    Detail detail;
    DetailFrame(Detail detail) {
        this.setSize(700, 700);
        setLocationAndSize();
        setLayoutManager();
        container.add(nameLabel);
        container.add(historyLabel);
        container.add(jobTitleLabel);
        container.add(wageLabel);
        container.add(cityLabel);
        container.add(descriptionLabel);
        container.add(button);
        container.add(nameLabel2);
        container.add(historyLabel2);
        container.add(jobTitleLabel2);
        container.add(wageLabel2);
        container.add(cityLabel2);
        container.add(descriptionLabel2);
        this.detail=detail;
    }
    DetailFrame() {
        this.setSize(700, 700);
        setLocationAndSize();
        setLayoutManager();
        container.add(nameLabel);
        container.add(historyLabel);
        container.add(jobTitleLabel);
        container.add(wageLabel);
        container.add(cityLabel);
        container.add(descriptionLabel);
        container.add(button);
        container.add(nameLabel2);
        container.add(historyLabel2);
        container.add(jobTitleLabel2);
        container.add(wageLabel2);
        container.add(cityLabel2);
        container.add(descriptionLabel2);

    }



    public void setLayoutManager() {
        container.setLayout(null);
    }


    public void setLocationAndSize() {
        nameLabel.setBounds(50, 150, 100, 30);
        historyLabel.setBounds(50, 220, 100, 30);
        jobTitleLabel.setBounds(50, 290, 100, 30);
        wageLabel.setBounds(50, 360, 100, 30);
        cityLabel.setBounds(50, 430, 100, 30);
        descriptionLabel.setBounds(50, 500, 100, 30);
        nameLabel2.setBounds(100, 150, 100, 30);
        historyLabel2.setBounds(100, 220, 100, 30);
        jobTitleLabel2.setBounds(100, 290, 100, 30);
        wageLabel2.setBounds(100, 360, 100, 30);
        cityLabel2.setBounds(100, 430, 100, 30);
        descriptionLabel2.setBounds(150, 500, 100, 30);
        button.setBounds(50, 570, 80, 30);





    }


    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
