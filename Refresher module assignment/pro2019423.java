import java.util.Calendar;
import java.util.Date;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class patient
{
    String name;
    int age;
    char tower;
    Date dorep,dorecovery;      //date of reporting //date of recovery
    Boolean infected;

    patient(String n, int a, char c, Date d)
    {
        name=n;
        age=a;
        tower= c;
        dorep=d;

        Calendar calendar=Calendar.getInstance();
        calendar.setTime(d);
        calendar.add(Calendar.DATE,21);
        dorecovery=calendar.getTime();
        infected=true;
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


class guitableworld extends JFrame
{
    guitableworld(patient p[], Date givendate,boolean tas, boolean tbs, boolean tcs, boolean tds)
    {

        for(int i=0;i<20;i++)
        {
            if(givendate.after(p[i].dorecovery) || givendate.before(p[i].dorep))
                p[i].setinftofalse();
            else
                p[i].setinftotrue();
        }

        int ninfa=0;
        int ninfb=0;
        int ninfc=0;
        int ninfd=0;
        String s[][]=new String[20][5];
        String[] columnNames = { "Name", "Age", "Tower", "Status" ,"Recovery date"};
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

        JTable jTable=new JTable(s,columnNames);
        jTable.setBounds(30,40,200,300);
        JScrollPane sp = new JScrollPane(jTable);


        if(tas)
            add(jLabel1);
        if(tbs)
            add(jLabel2);
        if(tcs)
            add(jLabel3);
        if(tds)
            add(jLabel4);

        add(sp);

        FlowLayout flowLayout=new FlowLayout();
        setLayout(flowLayout);
        setTitle("Final Stats");
        setSize(500,450);
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
}

class guiwork extends JFrame
{
    guiwork(patient p[])
    {
        JLabel jLabel1=new JLabel("Enter date");
        JLabel jLabel2=new JLabel("Enter month in number");
        JLabel jLabel3=new JLabel("Select Tower");

        JTextField jTextField1=new JTextField(10);//to enter date
        JTextField jTextField2=new JTextField(10);//to input other no.
        //JTextField jTextField3=new JTextField(20);//to show result
        JButton jButton=new JButton("click to show the stats");

        JCheckBox jCheckBoxa=new JCheckBox("A");
        JCheckBox jCheckBoxb=new JCheckBox("B");
        JCheckBox jCheckBoxc=new JCheckBox("C");
        JCheckBox jCheckBoxd=new JCheckBox("D");

        //jTextField1.setText("22");
        //jTextField2.setText("6");

        jButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                int a = Integer.parseInt(jTextField1.getText());
                int b = Integer.parseInt(jTextField2.getText());
                Date givend=new Date(2020,b-1,a);
                guitableworld obj2=new guitableworld(p,givend, jCheckBoxa.isSelected(),jCheckBoxb.isSelected(),jCheckBoxc.isSelected(),jCheckBoxd.isSelected());

            }
        });


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
        patient[] patientarray=new patient[20];

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

        guiwork obj= new guiwork(patientarray);
        //System.out.println("This is the last line");

    }
}

