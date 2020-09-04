import java.util.Scanner;

class Working
{
    int NoOfPatient=0;
    Working(int n)
    {
        NoOfPatient=n;
    }

    void RmAccPatient(Patient p[])      //query 2
    {
        System.out.println("Patients with these ID were admitted");
        for(int i=0;i<NoOfPatient;i++)
        {
            if(p[i].IsAdmitted() && p[i]!=null)
            {
                System.out.println(p[i].unid);
                p[i]=null;
            }
        }
    }

    void RmHospitals(HCInstitute h[])       //query 3
    {
        System.out.println("These Hospitals were full and removed from list");
        for(int i=0;i<NoOfPatient;i++)
        {
            if(!h[i].AcceptingApp && h[i]!=null)
            {
                System.out.println(h[i].name);
                h[i]=null;
            }
        }
    }



}

class Patient
{
    static int un=1000;
    String name;
    int age,unid,oxlevel;
    int RecoveryTime;
    float temp;
    Boolean admitted;
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

class HCInstitute
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
    void onboard(Patient p[],int NoOfPat)
    {

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
//        for(int i=0;i<N;i++)
//        {
//            String name=in.next();
//            float temp=in.nextFloat();
//            int oxy=in.nextInt();
//            int ag=in.nextInt();
//            p[i]=new Patient(name,temp,oxy,ag);
//        }
//        for(int i=0;i<N;i++)
//        {
//            System.out.println(p[i].name + p[i].unid);
//        }
//        System.out.println(p[2].name);

        int i=0;
//        System.out.println("keep on enter query");
        int q=in.nextInt();
        switch (q)
        {
            case 1:
                System.out.println("Enter name");
                String n=in.next();
                System.out.println("Enter Temperature Criteria");
                float t=in.nextFloat();
                System.out.println("Enter Oxygen Levels Criteria");
                int o=in.nextInt();
                System.out.println("Enter Number of Available beds");
                int nob=in.nextInt();
                h[i]=new HCInstitute(n,t,o,nob);
                h[i].onboard(p,N);
                break;
            case 2:
                System.out.println("2");
                break;
            default:
                System.out.println("Default");
        }


    }
}
