import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;


public class LoginFrame extends JFrame implements ActionListener {

    Container container = getContentPane();
    JLabel userLabel = new JLabel("USERNAME");
    JLabel passwordLabel = new JLabel("PASSWORD");
    JTextField userTextField = new JTextField();
    JPasswordField passwordField = new JPasswordField();
    JButton loginButton = new JButton("LOGIN");
    JButton resetButton = new JButton("Register");
    JCheckBox showPassword = new JCheckBox("Show Password");
    ArrayList<User> all_users = new ArrayList<>();
    ArrayList <ticket> all_tickets = new ArrayList<>();
    ArrayList <company> all_company = new ArrayList<>();


    LoginFrame(ArrayList<User> all_users,ArrayList <ticket> all_tickets ,ArrayList <company> all_company) {
        setLayoutManager();
        setLocationAndSize();
        addComponentsToContainer();
        addActionEvent();
        this.all_users=all_users;
        this.all_tickets=all_tickets;
        this.all_company=all_company;

    }

    public void setLayoutManager() {
        container.setLayout(null);
    }

    public void setLocationAndSize() {
        userLabel.setBounds(50, 150, 100, 30);
        passwordLabel.setBounds(50, 220, 100, 30);
        userTextField.setBounds(150, 150, 150, 30);
        passwordField.setBounds(150, 220, 150, 30);
        showPassword.setBounds(150, 250, 150, 30);
        loginButton.setBounds(50, 300, 100, 30);
        resetButton.setBounds(200, 300, 100, 30);


    }

    public void addComponentsToContainer() {
        container.add(userLabel);
        container.add(passwordLabel);
        container.add(userTextField);
        container.add(passwordField);
        container.add(showPassword);
        container.add(loginButton);
        container.add(resetButton);
    }

    public void addActionEvent() {
        loginButton.addActionListener(this);
        resetButton.addActionListener(this);
        showPassword.addActionListener(this);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        //Coding Part of LOGIN button
        if (e.getSource() == loginButton) {
            String userText;
            String pwdText;
            userText = userTextField.getText();
            pwdText = passwordField.getText();
            for (int i = 0; i <all_users.size() ; i++) {
                if(userText.equals((all_users.get(i).UserName))){
                    if(pwdText.equals((all_users.get(i).Password))){
                        JOptionPane.showMessageDialog(this, "Login Successful");
                        jobSearchGUI jSearch = new jobSearchGUI(all_tickets,all_company);
                        this.setVisible(false);
                        jSearch.setVisible(true);
                        return;
                    }
                    else{
                        JOptionPane.showMessageDialog(this, "Wrong Password");
                        return;
                    }
                }
            }
            JOptionPane.showMessageDialog(this, "Invalid Username or Password");


        }
        //Coding Part of RESET button
        if (e.getSource() == resetButton) {
            all_users.add(new User(userTextField.getText(),passwordField.getText()));
        }
        //Coding Part of showPassword JCheckBox
        if (e.getSource() == showPassword) {
            if (showPassword.isSelected()) {
                passwordField.setEchoChar((char) 0);
            } else {
                passwordField.setEchoChar('*');
            }


        }
    }



}
