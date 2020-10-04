import java.util.Scanner;
import java.lang.Math;
import java.util.Random;

public class game {
    final int N;
    player[] p;
    mafia[] m;
    detective[] d;
    commoner[] c;
    healer[] h;
    int choice;
    int nom,nod,noh,nocommon;
    public game(int N, player[] p)
    {
        this.N=N;
        this.p=p;
        System.out.println("Choose a Character\n" +
                "\t1) Mafia\n" +
                "\t2) Detective\n" +
                "\t3) Healer\n" +
                "\t4) Commoner\n" +
                "\t5) Assign Randomly");
        Scanner in = new Scanner(System.in);
        Random rand=new Random();
        try {
            choice = in.nextInt();
        }
        catch (Exception e) {
            choice=5;
            System.out.println("You have entered wrong value hence you have been assigned character randomly");
        }
        if(choice<1 || choice>5)
            choice=5;
        if(choice==5) {
            choice=rand.nextInt(4)+1;
        }

        nod=N/5;
        nom=N/5;
        noh= Math.max(N/10,1);
        nocommon=N-(nod+nom+noh);
        m=new mafia[nom];
        d= new detective[nod];
        h=new healer[noh];
        c= new commoner[nocommon];
        int i=0;
        for(i=0;i<nom;i++)
        {
            p[i]=new mafia();
            m[i]=(mafia)p[i];
        }
        for(i=0;i<nod;i++)
        {
            p[i+nom]=new detective();
            d[i]=(detective)p[i+nom];
        }
        for(i=0;i<noh;i++)
        {
            p[i+nom+nod]=new healer();
            h[i]=(healer) p[i+nom];
        }
        for(i=0;i<nocommon;i++)
        {
            p[i+nom+nod+noh]=new commoner();
            c[i]=(commoner) p[i+nom];
        }




    }

    public void play()
    {

    }
}
