import java.util.Scanner;

class Working       //this is the class which will handle all our queries
{
    int NoOfPatient=0;
    Working(int n)          //constructor of our class
    {
        NoOfPatient=n;
    }

    void RmAccPatient(Patient p[])      //query 2
    {
        System.out.println("Patients with these ID's were admitted");
        for(int i=0;i<NoOfPatient;i++)
        {
            if(p[i]!=null)
            {
                if(p[i].IsAdmitted())
                {
                    System.out.println(p[i].unid);
                    p[i]=null;
                }
            }
        }
    }

    void RmHospitals(HCInstitute h[])       //query 3
    {
        System.out.println("These Hospitals were full and removed from list");
        for(int i=0;i<NoOfPatient;i++)
        {
            if(h[i]!=null)
            {
                if(!h[i].AcceptingApp)
                {
                    System.out.println(h[i].name);
                    h[i]=null;
                }
            }
        }
    }

    int NoHAdmmiting(HCInstitute h[])       //query 5
    {
        int c=0;
        for(int i=0;i<h.length;i++)
        {
            if(h[i]!=null)
            {
                if(h[i].AcceptingApp)
                    c+=1;
            }
        }
        return c;
    }

    void DisplayHDetails(String name,HCInstitute h[])       //query 6
    {
        for(int i=0;i<h.length;i++)
        {
            if(h[i]!=null)
            {
                if(h[i].name.equals(name))
                {
                    System.out.println("Institute Name\t"+name);
                    System.out.println("Temperature criteria\t"+h[i].tempcriteria+"\nOxygen level criteria\t"+h[i].oxycriteria);
                    System.out.println("Number of available beds = "+h[i].nobavailable);
                    if(h[i].AcceptingApp)
                        System.out.println("Admission Status : Accepting");
                    else
                        System.out.println("Admission Status : Not Accepting");
                    break;
                }
            }
        }

    }

    void DisplayPatientDetails(int idn, Patient p[])    //query 7
    {
        for(int i=0;i<p.length;i++)
        {
            if(p[i]!=null)
            {
                if(p[i].unid==idn)
                {
                    System.out.println("ID number : "+p[i].unid);
                    System.out.println("Temperature : "+p[i].temp);
                    System.out.println("Oxygen levels : "+p[i].oxlevel);
                    if(p[i].IsAdmitted())
                    {
                        System.out.println("The patient is admitted in "+p[i].HCName);
                    }
                    else
                        System.out.println("The patient is not admitted yet");
                }
            }
        }

    }

    void DisplayAllPatient(Patient p[])     //query 8
    {
        for(int i=0;i<NoOfPatient;i++)
        {
            if(p[i]!=null)
            {
                System.out.println(p[i].name+" With ID "+p[i].unid);
            }
        }
    }

    void DisplayNameOfPatientInH(Patient p[],String name)       //query 9
    {
        for(int i=0;i<NoOfPatient;i++)
        {
            if(p[i]!=null)
                if(p[i].IsAdmitted())
                {
                    if (p[i].HCName.equals(name))
                        System.out.println(p[i].name + " will recover in " + p[i].RecoveryTime + " days");
                }
        }
    }

}

class Patient       //this is patient class, it will store all our patient data
{
    static int un=1;
    String name;
    int age,unid,oxlevel;
    int RecoveryTime;
    float temp;
    Boolean admitted;
    String HCName;
    Patient(String n, float temperature, int o, int a)    //constructor of our class
    {
        temp=temperature;
        name=n;
        oxlevel=o;
        age=a;
        this.unid=un;
        un++;
        admitted=false;
    }

    Boolean IsAdmitted()
    {
        return admitted;
    }

}

class HCInstitute       //this is hospital class, it will store all our hospital data
{
    String name;
    boolean AcceptingApp;
    float tempcriteria;
    int nobavailable,oxycriteria;
    HCInstitute(String n, float te, int oxl, int nob)
    {
        name=n;
        nobavailable=nob;
        oxycriteria=oxl;
        tempcriteria=te;
        AcceptingApp=true;
    }
    int onboard(Patient p[])        //this function solves query one
    {
        int r[]=new int[p.length];
        Scanner in= new Scanner(System.in);
        //int TotalNoP = p.length;
        int c=0;        //this will store the number of admitted patient
        for(int i = 0; i < p.length; i++)
        {
            if(nobavailable>0 && p[i]!=null)
            {
                if(p[i].oxlevel>=oxycriteria && !p[i].admitted)     //here we check for oxygen level
                {
                    System.out.println("Enter Recovery time of "+p[i].name);
                    p[i].RecoveryTime=in.nextInt();
                    p[i].admitted=true;
                    p[i].HCName=name;
                    nobavailable--;
                    r[i]=1;
                    c=c+1;
                }
            }
        }

        for(int i = 0; i < p.length; i++)
        {
            if(nobavailable>0 && p[i]!=null)
            {
                if(p[i].temp<=tempcriteria && !p[i].admitted)       //here we check for temperature creteria
                {
                    System.out.println("Enter Recovery time of "+p[i].name);
                    p[i].RecoveryTime=in.nextInt();
                    p[i].admitted=true;
                    p[i].HCName=name;
                    nobavailable--;
                    r[i]=1;
                    c=c+1;
                }
            }
        }

        if(nobavailable<1)
            AcceptingApp=false;
        /*Output - Display details of the institute(Recovery days for admitted patients)*/
        System.out.println("Institute Name\t"+name);
        System.out.println("Temperature criteria\t"+tempcriteria+"\nOxygen level criteria\t"+oxycriteria);
        System.out.println("Number of available beds = "+nobavailable);
        if(AcceptingApp)
            System.out.println("Admission Status : Accepting");
        else
            System.out.println("Admission Status : Not Accepting");
        for(int i=0;i<p.length;i++)
        {
            if(r[i]==1)
            {
                System.out.println(p[i].name+" Will Recover in "+p[i].RecoveryTime);
            }
        }

        return c;
    }

    Boolean IsAcceptingApp()
    {
        return AcceptingApp;
    }
}



public class pro0 {

    public static void main(String[] args)
    {
        Scanner in=new Scanner(System.in);
        System.out.println("Enter number of sample case:");
        int N=in.nextInt();
        Patient[] p=new Patient[N];
        HCInstitute[] h= new HCInstitute[N];
        Working w=new Working(N);
        for(int i=0;i<N;i++)
        {
            String name=in.next();
            float temp=in.nextFloat();
            int oxy=in.nextInt();
            int ag=in.nextInt();
            p[i]=new Patient(name,temp,oxy,ag);     //storing data in patient class
        }


        int i=0;        //this will store number of hospitals-1
        int ad=0,left=N;

        while(left>0)       //loop will work till there are no patient left
        {
            System.out.println("Enter query number : ");
            int q=in.nextInt();
            switch (q)
            {

                case 1:
                    System.out.println("Enter name of Hospital:");
                    String n=in.next();
                    System.out.println("Enter Temperature Criteria");
                    float t=in.nextFloat();
                    System.out.println("Enter Oxygen Levels Criteria");
                    int o=in.nextInt();
                    System.out.println("Enter Number of Available beds");
                    int nob=in.nextInt();
                    h[i]=new HCInstitute(n,t,o,nob);
                    ad =h[i].onboard(p);
                    i++;
                    left=left-ad;
                    break;
                case 2:
                    w.RmAccPatient(p);
                    break;
                case 3:
                    w.RmHospitals(h);
                    break;
                case 4:
                    System.out.println("Number of patient left in camp : "+left);
                    break;
                case 5:
                    System.out.println("The number of hospitals currently admitting = "+w.NoHAdmmiting(h));;
                    break;
                case 6:
                    String inn=in.next();
                    w.DisplayHDetails(inn,h);
                    break;
                case 7:
                    int inid=in.nextInt();
                    w.DisplayPatientDetails(inid,p);
                    break;
                case 8:
                    w.DisplayAllPatient(p);
                    break;
                case 9:
                    String hcn=in.next();
                    w.DisplayNameOfPatientInH(p,hcn);
                    break;
                default:
                    System.out.println("Please select correct query number");
            }
        }


    }
}       //this contains our main class
