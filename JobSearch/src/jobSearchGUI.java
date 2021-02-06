import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.stream.Collectors;


public class jobSearchGUI extends JFrame implements ActionListener {
        private final String WINDOWS_TITLE = "jobs search";
        private final int WIDTH = 500, HEIGHT = 500;
        private final int X = 100, Y = 100;
        ArrayList<ticket> searchedTickets;
        ArrayList<ticket> all_ticket;
     String column[]={"company","title","contract","min_wage","mux_wage","town","description"};
     Container container = getContentPane();
     JLabel cityLabel=new JLabel("city:");
     JLabel salaryLabel=new JLabel("min salary:");
     JTextField citySearch=new JTextField();
     JTextField salary=new JTextField();
     JButton searchButton =new JButton ("Search");
     JCheckBox juniorButton =new JCheckBox ("Junior");
     JCheckBox seniorButton =new JCheckBox ("Senior");
     JCheckBox partTimeButton =new JCheckBox ("PartTime");
     JCheckBox fullButton =new JCheckBox ("FullTime");
     JCheckBox internButton =new JCheckBox ("Intern");
     JTable jobTable;
     JPanel panel = new JPanel();

    public jobSearchGUI(ArrayList<ticket> all_ticket) {
            super();
            panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
            this.all_ticket=all_ticket;
            this.setTitle(WINDOWS_TITLE);
            this.setLayout(null);
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            this.setSize(WIDTH, HEIGHT);
            this.setLocation(X, Y);
            this.setVisible(true);
            this.setResizable(true);
            setLocationAndSize();
            addComponentsToContainer();
            addActionEvent();

        }


    public void setLocationAndSize() {
        cityLabel.setBounds(400, 0, 100, 30);
        citySearch.setBounds(400,30,100,30);
        seniorButton.setBounds(400,60,100,30);
        juniorButton.setBounds(400, 90, 100, 30);
        partTimeButton.setBounds(400, 120, 100, 30);
        fullButton.setBounds(400, 150, 100, 30);
        internButton.setBounds(400,180,100, 30);
        salaryLabel.setBounds(400, 210, 100, 30);
        salary.setBounds(400, 240, 100, 30);
        searchButton.setBounds(400, 270, 100, 30);
        panel.setBounds(0, 0, 400, 500);

    }

    public void addComponentsToContainer() {
        container.add(searchButton);
        container.add(citySearch);
        container.add(searchButton);
        container.add(seniorButton);
        container.add(juniorButton);
        container.add(partTimeButton);
        container.add(fullButton);
        container.add(internButton);
        container.add(salary);
        container.add(panel);
        container.add(cityLabel);
        container.add(salaryLabel);
    }

    public void addActionEvent() {
        searchButton.addActionListener(this);
    }
    public ticket returnData(){
        String resultTown = citySearch.getText();
        String contract;
        int resultSalary=0;
        try {
             resultSalary= Integer.parseInt(salary.getText());
        }catch (NumberFormatException e){
             resultSalary=0;
        }
        if(seniorButton.isSelected())
            contract="senior";
        else if(juniorButton.isSelected())
            contract="junior";
        else if(partTimeButton.isSelected())
            contract="partTime";
        else if(fullButton.isSelected())
            contract="fullTime";
        else if(internButton.isSelected())
            contract="intern";
        else
            contract = "not";


        ticket result_ticket = new ticket(null, null, contract,resultSalary,0, resultTown, null);
        return(result_ticket);
    }

    public ArrayList<ticket> search(ticket restult_ticket,ArrayList<ticket> all_tickets){
        ArrayList<ticket>searched_tickets=new ArrayList<>();

        if(!(restult_ticket.getContract().equals("not")) && !(restult_ticket.getTown().equals(""))) {
            System.out.println("it was me first");
            searched_tickets = (ArrayList<ticket>) all_tickets.stream().filter(c -> c.getMin_wage() >= restult_ticket.getMin_wage() && c.getTown().equals(restult_ticket.getTown()) && c.getContract().equals(restult_ticket.getContract())).collect(Collectors.toList());
        }
        else if(!(restult_ticket.getContract().equals("not")) && (restult_ticket.getTown().equals(""))) {
            System.out.println("it was me second");
            searched_tickets = (ArrayList<ticket>) all_tickets.stream().filter(c -> c.getMin_wage() >= restult_ticket.getMin_wage() && c.getContract().equals(restult_ticket.getContract())).collect(Collectors.toList());
        }
        else if((restult_ticket.getContract().equals("not")) && !(restult_ticket.getTown().equals(""))) {
            System.out.println("it was me third");
            searched_tickets = (ArrayList<ticket>) all_tickets.stream().filter(c -> c.getMin_wage() >= restult_ticket.getMin_wage() && c.getTown().equals(restult_ticket.getTown())).collect(Collectors.toList());
        }
        else
            //((restult_ticket.getContract().equals(null)) && (restult_ticket.getTown().equals("")))
        {
            System.out.println("it was me last");
            searched_tickets = (ArrayList<ticket>) all_tickets.stream().filter(c -> c.getMin_wage() >= restult_ticket.getMin_wage()).collect(Collectors.toList());
        }
        /* for (int i = 0; i < all_tickets.size(); i++) {
            if(!(all_tickets.get(i).getContract().equals(restult_ticket.getContract())) & !(restult_ticket.getContract().equals(null)))
                break;
            else if(! (all_tickets.get(i).getMin_wage() >= restult_ticket.getMin_wage()) )
                break;
            else if(!(all_tickets.get(i).getTown().equals(restult_ticket.getTown())) & !(restult_ticket.getTown().equals(null)))
                break;
            else
                searched_tickets.add(all_tickets.get(i));

        }*/
        return searched_tickets;
    }



    @Override
    public void actionPerformed(ActionEvent e ) {
        if(e.getSource() == searchButton){
            ticket jSearch = returnData();
            searchedTickets=search(jSearch, all_ticket);
            System.out.println("company");
            System.out.println(jSearch.getCompany());
            System.out.println("title");
            System.out.println(jSearch.getTitle());
            System.out.println("contract");
            System.out.println(jSearch.getContract());
            System.out.println("min");
            System.out.println(jSearch.getMin_wage());
            System.out.println("max");
            System.out.println(jSearch.getMax_wage());
            System.out.println("town");
            System.out.println(jSearch.getTown());
            System.out.println("description");
            System.out.println(jSearch.getDescription());

            String [][] jobss=new String[searchedTickets.size()][7];
            for (int i = 0; i <searchedTickets.size() ; i++) {
                jobss[i][0]= searchedTickets.get(i).getCompany();
                jobss[i][1]= searchedTickets.get(i).getTitle();
                jobss[i][2]= searchedTickets.get(i).getContract();
                jobss[i][3]= String.valueOf(searchedTickets.get(i).getMin_wage());
                jobss[i][4]= String.valueOf(searchedTickets.get(i).getMax_wage());
                jobss[i][5]=searchedTickets.get(i).getTown();
                jobss[i][6]=searchedTickets.get(i).getDescription();
            }
            //panel.removeAll();
            jobTable = new JTable(jobss, column);
            panel.add(new JScrollPane(jobTable));
            jobTable.addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent me) {
                        // to detect doble click events
                        JTable target = (JTable)me.getSource();
                        int row = target.getSelectedRow(); // select a row
                        int column = target.getSelectedColumn(); // select a column
                        Detail detail=new Detail(jobTable.getValueAt(row, 0).toString(),jobTable.getValueAt(row, 1).toString(),"ff",200,"teh","khob");
                        DetailFrame detailFrame=new DetailFrame(detail);
                        detailFrame.setVisible(true);
                       

                }
            });
            repaint();
            revalidate();
        }
    }

}

