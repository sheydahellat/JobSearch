import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;


public class jobSearchGUI extends JFrame implements ActionListener {
        private final String WINDOWS_TITLE = "jobs search";
        private final int WIDTH = 500, HEIGHT = 500;
        private final int X = 100, Y = 100;
        ArrayList<Job> jobs;
    String column[]={"city","salary","partTime","fullTime","intern","senior","junior"};
    String data[][] = {{"hey ", "hey"}, {"hey", "hey"}, {"hey", "hey"}, {"hey", "hey"}, {"hey", "hey"}, {"hey", "hey"}
            , {"hey", "hey"}, {"hey", "hey"}, {"hey", "hey"}, {"hey", "hey"}, {"hey", "hey"}, {"hey", "hey"}, {"hey", "hey"}, {"hey", "hey"}
            , {"hey", "hey"}, {"hey", "hey"}};
    String columns[] = {"First", "Second"};
     //String jobss[][]=new String [jobs.size()][7];
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
    // JTable jobTable=new JTable(jobss,column);
     JTable jobTable;
     //JScrollPane scrollBar1=new JScrollPane(jobTable);
     //jobtable tu balai
    JPanel panel = new JPanel();

    public jobSearchGUI(ArrayList<Job> jobs) {
            super();
            panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
            this.jobs=jobs;
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
       /* String jobss[][]=new String [jobs.size()][7];
         for (int i = 0; i <jobs.size() ; i++) {
                jobss[i][0]= jobs.get(i).town;
                jobss[i][1]= Integer.toString(jobs.get(i).salary);
                jobss[i][2]= String.valueOf(jobs.get(i).senior);
                jobss[i][3]= String.valueOf(jobs.get(i).junior);
                jobss[i][4]= String.valueOf(jobs.get(i).partTime);
                jobss[i][5]=String.valueOf(jobs.get(i).fullTime);
                jobss[i][6]=String.valueOf(jobs.get(i).intern);
        }*/

        }


           // searchButton.addActionListener(e -> jobTable.setModel(DbUtils.resultSetToTableModel(new Job().search(citySearch.getText(), panel))));

    public void setLocationAndSize() {
        //jobTable.setBounds(0, 0, 400, 500);
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
        //container.add(scrollBar1);
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
    public Job returnData(){
        String resultTown = citySearch.getText();
        int resultSalary;
        try {
             resultSalary= Integer.parseInt(salary.getText());
        }catch (NumberFormatException e){
             resultSalary=0;
        }

        boolean resultSenior=seniorButton.isSelected();
        boolean resultJunior=juniorButton.isSelected();
        boolean resultPartTime=partTimeButton.isSelected();
        boolean resultFullTime=fullButton.isSelected();
        boolean resultIntern=internButton.isSelected();
        Job searchResultJob = new Job(resultTown,resultSalary,resultSenior,resultJunior,resultPartTime,resultFullTime,resultIntern);
        return(searchResultJob);
    }

    @Override
    public void actionPerformed(ActionEvent e ) {
        if(e.getSource() == searchButton){
            Job jSearch = returnData();
            System.out.println(jSearch.town);
            System.out.println(Integer.toString(jSearch.salary));
            System.out.println(String.valueOf(jSearch.senior));
            System.out.println(String.valueOf(jSearch.junior));
            System.out.println(String.valueOf(jSearch.partTime));
            System.out.println(String.valueOf(jSearch.fullTime));
            System.out.println(String.valueOf(jSearch.intern));
            String [][] jobss=new String[jobs.size()][7];
            for (int i = 0; i <jobs.size() ; i++) {
                jobss[i][0]= jobs.get(i).town;
                jobss[i][1]= Integer.toString(jobs.get(i).salary);
                jobss[i][2]= String.valueOf(jobs.get(i).senior);
                jobss[i][3]= String.valueOf(jobs.get(i).junior);
                jobss[i][4]= String.valueOf(jobs.get(i).partTime);
                jobss[i][5]=String.valueOf(jobs.get(i).fullTime);
                jobss[i][6]=String.valueOf(jobs.get(i).intern);
            }
            //panel.removeAll();
            jobTable = new JTable(jobss, column);
            panel.add(new JScrollPane(jobTable));
            repaint();
            revalidate();
        }
    }

}

