import java.util.Calendar;
import java.util.Date;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class patient           //this is the class to store our data
{
    String name;
    int age;
    char tower;
    Date dorep,dorecovery;      //date of reporting //date of recovery
    Boolean infected;

    patient(String n, int a, char c, Date d)    //constructor of our class
    {
        name=n;
        age=a;
        tower= c;
        dorep=d;        //date of reporting
            //here we are finding the recovery date and storing it in dorecovery obj
        Calendar calendar=Calendar.getInstance();   //we are using Calendar class to find the recovery date
        calendar.setTime(d);
        calendar.add(Calendar.DATE,21);     //after 21 days the person recovers
        dorecovery=calendar.getTime();
        infected=true;      //initialise this boolean as true, as we are having data of infected people
    }

    void setinftofalse()
    {
        this.infected=false;
    }

    void setinftotrue()
    {
        this.infected=true;
    }


}


class guitableworld extends JFrame      //this is the class we call when a click is done//this class shows the table in gui
{
    guitableworld(patient p[], Date givendate,boolean tas, boolean tbs, boolean tcs, boolean tds)
    {

        //checking if the person is still infected or not, considering the reporting date is the first day of being ill
        for(int i=0;i<20;i++)
        {
            if(givendate.after(p[i].dorecovery) || givendate.before(p[i].dorep))
                p[i].setinftofalse();
            else
                p[i].setinftotrue();
        }

        //making int variables to store number of infected in each tower
        int ninfa=0;
        int ninfb=0;
        int ninfc=0;
        int ninfd=0;
        String s[][]=new String[20][5]; //making stirng array to show in the table
        String[] columnNames = { "Name", "Age", "Tower", "Status" ,"Recovery date"};    //title of the tables

        for(int i=0;i<20;i++)
        {

            s[i][0]=p[i].name;
            s[i][1]=p[i].age+"";
            s[i][4]=(p[i].dorecovery.getDate()+"")+"/"+(p[i].dorecovery.getMonth()+1+"")+"/2020";
//            s[i][2]= (p[i].tower+"").toUpperCase()+"";

            if(p[i].tower=='a')
            {
                if(p[i].infected)
                {
                    ninfa++;
                    s[i][3]="ACTIVE";
                }
                else
                    s[i][3]="INACTIVE";

                s[i][2]= "A";

            }

            if(p[i].tower=='b')
            {

                if (p[i].infected)
                {
                    s[i][3] = "ACTIVE";
                    ninfb++;
                } else
                    s[i][3] = "INACTIVE";

                s[i][2] = "B";
            }

            if(p[i].tower=='c')
            {

                if(p[i].infected)
                {
                    ninfc++;
                    s[i][3]="ACTIVE";
                }
                else
                    s[i][3]="INACTIVE";

                s[i][2]= "C";

            }

            if(p[i].tower=='d')
            {

                if(p[i].infected)
                {
                    ninfd++;
                    s[i][3]="ACTIVE";
                }

                else
                    s[i][3]="INACTIVE";

                s[i][2]= "D";
            }

        }

        JLabel jLabel1=new JLabel("   Total number of active cases of Tower A:"+ninfa);
        JLabel jLabel2=new JLabel("   Total number of active cases of Tower B:"+ninfb);
        JLabel jLabel3=new JLabel("   Total number of active cases of Tower C:"+ninfc);
        JLabel jLabel4=new JLabel("   Total number of active cases of Tower D:"+ninfd);

        JTable jTable=new JTable(s,columnNames);        //making a object of jtable class to show the table setting rows and coloumns
        jTable.setBounds(30,40,200,300);        //setting the size of the window
        JScrollPane sp = new JScrollPane(jTable);   //to show the title of the table

        //we are displaying the label only if the tower was selected
        if(tas)
            add(jLabel1);
        if(tbs)
            add(jLabel2);
        if(tcs)
            add(jLabel3);
        if(tds)
            add(jLabel4);

        //adding the table to the gui window
        add(sp);

        //setting the default like size of window,layout ,visibility and oberation on exit
        FlowLayout flowLayout=new FlowLayout();
        setLayout(flowLayout);
        setTitle("Final Stats");
        setSize(500,450);
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);      //will not stop the program on exiting will just close that window
    }
}

class guiwork extends JFrame        //this class performs the basic gui operation to take input from the user
{
    guiwork(patient p[])
    {
        //making obj of jlabel to show text
        JLabel jLabel1=new JLabel("Enter date");
        JLabel jLabel2=new JLabel("Enter month in number");
        JLabel jLabel3=new JLabel("Select Tower");

        //making obj of textfield
        JTextField jTextField1=new JTextField(10);//to enter date
        JTextField jTextField2=new JTextField(10);//to input other no.
        //JTextField jTextField3=new JTextField(20);//to show result
        JButton jButton=new JButton("click to show the stats"); //making obj for the click

        //making obj of checkbox  this will show checkbox to user
        JCheckBox jCheckBoxa=new JCheckBox("A");
        JCheckBox jCheckBoxb=new JCheckBox("B");
        JCheckBox jCheckBoxc=new JCheckBox("C");
        JCheckBox jCheckBoxd=new JCheckBox("D");

        //jTextField1.setText("22");
        //jTextField2.setText("6");

        jButton.addActionListener(new ActionListener() {        //this will be called when we click
            @Override
            public void actionPerformed(ActionEvent e)
            {
                int a = Integer.parseInt(jTextField1.getText());        //reading data from the textfield
                int b = Integer.parseInt(jTextField2.getText());
                Date givend=new Date(2020,b-1,a);       //creating new date obj which was selected
                //here we call class guitableworld to show the table
                guitableworld obj2=new guitableworld(p,givend, jCheckBoxa.isSelected(),jCheckBoxb.isSelected(),jCheckBoxc.isSelected(),jCheckBoxd.isSelected());

            }
        });


        //we are adding all the obj to the screen
        add(jLabel1);
        add(jTextField1);
        add(jLabel2);
        add(jTextField2);
        add(jLabel3);
        add(jCheckBoxa);
        add(jCheckBoxb);
        add(jCheckBoxc);
        add(jCheckBoxd);
        add(jButton);


        //setting the default like size of window,layout ,visibility and oberation on exit
        FlowLayout flowLayout=new FlowLayout();
        setLayout(flowLayout);
        setTitle("Demo");
        setSize(300,200);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}



public class pro2019423
{
    public static void main(String[] args)
    {
        patient[] patientarray=new patient[20]; //creating a array of class patient to store our data
        //here we are hard coding our data by making objects of class patient
        patientarray[0]=new patient("Flora",6,'a',new Date(2020,3,1));
        patientarray[1]=new patient("Denys",24,'b',new Date(2020,3,1));
        patientarray[2]=new patient("Jim",42,'c',new Date(2020,4,18));
        patientarray[3]=new patient("Hazel",87,'d',new Date(2020,5,23));
        patientarray[4]=new patient("Caery",72,'a',new Date(2020,5,1));
        patientarray[5]=new patient("David",7,'b',new Date(2020,5,14));
        patientarray[6]=new patient("Kevim",37,'d',new Date(2020,5,5));
        patientarray[7]=new patient("Tom",67,'d',new Date(2020,5,20));
        patientarray[8]=new patient("Bob",74,'a',new Date(2020,6,4));
        patientarray[9]=new patient("Rachel",48,'c',new Date(2020,6,24));
        patientarray[10]=new patient("Thomas",21,'c',new Date(2020,5,11));
        patientarray[11]=new patient("Mary",17,'d',new Date(2020,5,21));
        patientarray[12]=new patient("Smith",89,'a',new Date(2020,7,7));
        patientarray[13]=new patient("Pearson",47,'b',new Date(2020,5,4));
        patientarray[14]=new patient("Anderson",62,'b',new Date(2020,6,27));
        patientarray[15]=new patient("Johnson",10,'d',new Date(2020,7,1));
        patientarray[16]=new patient("Robertz",50,'a',new Date(2020,7,9));
        patientarray[17]=new patient("Julie",86,'b',new Date(2020,4,2));
        patientarray[18]=new patient("Edith",42,'d',new Date(2020,5,7));
        patientarray[19]=new patient("John",95,'d',new Date(2020,5,1));

        guiwork obj= new guiwork(patientarray);     //we are calling our gui class
        //System.out.println("This is the last line");

    }
}

