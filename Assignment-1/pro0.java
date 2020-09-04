import java.util.Scanner;

class Patient
{
    String name;
    int age,unid,oxlevel;
    int nod;
    float temp;
    Patient(String n, float temperature, int o, int a)    //constructor of our class
    {
        temp=temperature;
        name=n;
        oxlevel=o;
        age=a;
    }
}

class HCInstitute
{
    String name;
    boolean c;
    int nobavailable;
}



public class pro0 {

    public static void main(String[] args)
    {
        Scanner in=new Scanner(System.in);
        System.out.println("Enter number of sample case:\n");
        int N=in.nextInt();
        Patient[] p=new Patient[N];
        for(int i=0;i<N;i++)
        {
            String name=in.next();
            float temp=in.nextFloat();
            int oxy=in.nextInt();
            int ag=in.nextInt();
            p[i]=new Patient(name,temp,oxy,ag);
        }
        System.out.println(p[2].name);
        System.out.println("keep on enter query");

        int q=in.nextInt();
        switch (q)
        {
            case 0:
                System.out.println("0");
                break;
            case 2:
                System.out.println("2");
                break;
            default:
                System.out.println("Default");
        }

    }
}
