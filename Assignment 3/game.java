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
    int indexofuser;
    int leftm,leftd,lefth,leftcom;

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
        leftd=nod;
        nom=N/5;
        leftm=nom;
        noh= Math.max(N/10,1);
        lefth=noh;
        nocommon=N-(nod+nom+noh);
        leftcom=nocommon;
        m=new mafia[nom];
        d= new detective[nod];
        h=new healer[noh];
        c= new commoner[nocommon];
        int i;

        if(choice==1)
        {
            indexofuser=0;
            System.out.println("You are now a mafia");
        }
        else if(choice==2)
        {
            indexofuser=nom;
            System.out.println("You are a detective");
        }
        else if(choice==3)
        {
            indexofuser=nom+nod;
            System.out.println("You are a healer");
        }
        else
        {
            indexofuser=nom+nod+noh;
            System.out.println("You are a commoner");
        }
        System.out.println("You are Player "+(indexofuser+1));


        for(i=0;i<nom;i++)
        {
            p[i]=new mafia();
            m[i]=(mafia)p[i];
            if(choice==1)
                System.out.println("Player "+(i+1)+"is a mafia");
        }
        for(i=0;i<nod;i++)
        {
            p[i+nom]=new detective();
            d[i]=(detective)p[i+nom];
            if(choice==2)
                System.out.println("Player "+(i+1+nom)+"is a detective");
        }
        for(i=0;i<noh;i++)
        {
            p[i+nom+nod]=new healer();
            h[i]=(healer) p[i+nom+nod];
            if(choice==3)
                System.out.println("Player "+(i+1+nom+nod)+"is a healer");
        }
        for(i=0;i<nocommon;i++)
        {
            p[i+nom+nod+noh]=new commoner();
            c[i]=(commoner) p[i+nom+nod+noh];
        }


    }

    public int killedbymafia(int indexmafia, int indexdet, int indexhealer)
    {

        int returnvalue=0;
        double totalhpofmafia=0,hpofmafiatarget;
        for(int i=0;i<nom;i++)
        {
            if(p[indexdet].equals(m[i]))
                returnvalue=-1;

            if(m[i].isIsalive())
                totalhpofmafia+=m[i].getHP();
        }

        hpofmafiatarget=p[indexmafia].getHP();
        if(totalhpofmafia>hpofmafiatarget)
        {
            double reduceforeachmafia=0;
            if(leftm>0)
            reduceforeachmafia=hpofmafiatarget/leftm;
            int count=leftm;
            p[indexmafia].setHP(0);
            for(int i=0;i<nom;i++)
            {
                if(m[i].isIsalive())
                {
                    if(m[i].getHP()>=reduceforeachmafia) {
                        m[i].setHP(m[i].getHP() - reduceforeachmafia);
                        hpofmafiatarget -= reduceforeachmafia;
                        count--;
                    }
                    else
                    {
                        hpofmafiatarget-=m[i].getHP();
                        m[i].setHP(0);
                        count--;
                        if(count!=0)
                        reduceforeachmafia=hpofmafiatarget/count;
                    }

                }
            }
        }
        else {
            for(int i=0;i<nom;i++)
            {
                m[i].setHP(0);
            }
            hpofmafiatarget-=totalhpofmafia;
            p[indexmafia].setHP(hpofmafiatarget);
        }

        p[indexhealer].setHP( p[indexhealer].getHP()+500 );

        return returnvalue;
    }

    public void play()
    {
        int indmafia=m[0].choose(m,p,indexofuser); //check if mafias still playing
        int inddetective=d[0].choose(d,p,indexofuser);
        int indhealer=h[0].choose(h,p,indexofuser);
        int c=killedbymafia(indmafia,inddetective,indhealer);

        if(p[indmafia].getHP()<1)   //killed by mafia
        {

        }
        else        //either saved by doctor or mafia was unable to kill
        {

        }

        if(c==-1)  //caught mafia
        {

        }
        else {

        }

    }


}
