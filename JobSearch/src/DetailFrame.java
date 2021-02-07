import java.io.Serializable;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
public class DetailFrame extends JFrame implements ActionListener{
    Container container = getContentPane();
    JLabel nameLabel = new JLabel("name");
    JLabel historyLabel = new JLabel("location");
    JLabel jobTitleLabel = new JLabel("Description");
    JLabel wageLabel = new JLabel("Employees");
    JLabel cityLabel = new JLabel("Field");

    JLabel nameLabel2 = new JLabel("name");
    JLabel historyLabel2 = new JLabel("history");
    JLabel jobTitleLabel2 = new JLabel("jobTitle");
    JLabel wageLabel2 = new JLabel("wage");
    JLabel cityLabel2 = new JLabel("city");

    JLabel state= new JLabel("if you want to send your resume clicl on submit");
    JLabel emailLabel = new JLabel("put your email here");
    JTextField emailTextField = new JTextField();
    private JButton button = new JButton("Submit");

    Detail detail;
    DetailFrame(Detail detail) {
        this.setSize(400, 700);
        setLocationAndSize();
        setLayoutManager();
        this.detail=detail;
        container.add(nameLabel);
        container.add(historyLabel);
        container.add(jobTitleLabel);
        container.add(wageLabel);
        container.add(cityLabel);

        container.add(button);
        container.add(nameLabel2);
        container.add(historyLabel2);
        container.add(jobTitleLabel2);
        container.add(wageLabel2);
        container.add(cityLabel2);
        container.add(state);

        container.add(emailLabel);
        container.add(emailTextField);
        nameLabel2.setText(this.detail.name);
        historyLabel2.setText(this.detail.history);
        jobTitleLabel2.setText(this.detail.jobTitle);
        wageLabel2.setText(String.valueOf(this.detail.wage));
        cityLabel2.setText(this.detail.city);
        button.addActionListener(this::actionPerformed);

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

        nameLabel2.setBounds(150, 150, 100, 30);
        historyLabel2.setBounds(150, 220, 100, 30);
        jobTitleLabel2.setBounds(150, 290, 100, 30);
        wageLabel2.setBounds(150, 360, 100, 30);
        cityLabel2.setBounds(150, 430, 100, 30);

        button.setBounds(50, 570, 80, 30);
        state.setBounds(50, 50, 300, 30);
        emailLabel.setBounds(50, 100, 200, 30);
        emailTextField.setBounds(200, 100, 100, 30);






    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == button) {
           state.setText("submited");
           button.setEnabled(false);
        }

    }


    }
