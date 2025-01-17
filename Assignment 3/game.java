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
    int leftm,leftd,lefth,leftcom,aliveplayers;

    public game(int totalnumber, player[] passed)
    {
        this.N=totalnumber;
        aliveplayers=N;
        this.p=passed;
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
            //System.out.println(p[i].isIsalive());
            m[i]=(mafia)p[i];
            if(choice==1)
                System.out.println("Player "+(i+1)+" is a mafia");
        }
        for(i=0;i<nod;i++)
        {
            p[i+nom]=new detective();
            d[i]=(detective)p[i+nom];
            if(choice==2)
                System.out.println("Player "+(i+1+nom)+" is a detective");
        }
        for(i=0;i<noh;i++)
        {
            p[i+nom+nod]=new healer();
            h[i]=(healer) p[i+nom+nod];
            if(choice==3)
                System.out.println("Player "+(i+1+nom+nod)+" is a healer");
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
//        if(totalhpofmafia>hpofmafiatarget)
        if(p[0].compareTo(p[indexmafia],totalhpofmafia))
        {
            double reduceforeachmafia=0;
            if(leftm>0)
            reduceforeachmafia=hpofmafiatarget/leftm;
            int count=leftm;
            p[indexmafia].setHP(0);
            while(hpofmafiatarget>1)
            {
                    count=leftm;
                    if(leftm>0)
                        reduceforeachmafia=hpofmafiatarget/leftm;
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

    public void takevoting()
    {
        Scanner in = new Scanner(System.in);
        Random rand=new Random();
        for(int i=0;i<N;i++)
        {
            if(p[i].isIsalive())
            {
                if(i==indexofuser)
                {
                    while (true)
                    {
                        System.out.println("Choose player to you want to vote out :");
                        int inp=in.nextInt();
                        if(inp>p.length || inp<1)
                        {
                            System.out.println("Enter valid player");
                            continue;
                        }
                        inp--;
                        if(!p[inp].isIsalive())
                            System.out.println("The person you voted for is dead vote again");
                        else
                        {
                            p[inp].setVoted(p[inp].getVoted()+1);
                            break;
                        }

                    }

                }
                else {
                    while (true)
                    {
                        int inp=rand.nextInt(N);
                        if(p[inp].isIsalive())
                        {
                            p[inp].setVoted(p[inp].getVoted()+1);
                            break;
                        }
                    }
                }
            }
        }
    }

    public int indexofmaxvote()
    {
        int ind=0;
        int maxvote=0;
        for(int i=0;i<N;i++)
        {
            if(p[i].isIsalive())
            {
                if(p[i].getVoted()>maxvote)
                {
                    ind=i;
                    maxvote=p[i].getVoted();
                }
            }
        }

        for(int i=0;i<N;i++)
        {
            if(p[i].getVoted()==maxvote && i!=ind && p[i].isIsalive())
            {  //we have to revote till we get the max vote
//                clearvoting();
//                takevoting();
                return -1;

            }
        }
        return ind;
    }

    public int checkvoting()
    {
        int ind;
        ind=indexofmaxvote();
        while(ind==-1)
        {
            clearvoting();
            takevoting();
            ind=indexofmaxvote();
        }
        return ind;
    }

    public void clearvoting()
    {
        for(int i=0;i<N;i++)
        {
            p[i].setVoted(0);
        }
    }

    public void play()
    {
        //System.out.println("Inside play function");
        int indmafia,inddetective,indhealer;
        if(leftm>0)
            indmafia=m[0].choose(m,p,indexofuser);
        else
            indmafia=N-1;

        if(leftd>0)
            inddetective=d[0].choose(d,p,indexofuser);
        else
            inddetective=N-1;

        if(lefth>0)
            indhealer=h[0].choose(h,p,indexofuser);
        else
            indhealer=nom+nod;

        int che=killedbymafia(indmafia,inddetective,indhealer);

        System.out.println("--End of actions--");
        if(p[indmafia].getHP()<1)   //killed by mafia
        {
            System.out.println("Player "+(indmafia+1)+" was killed");
            p[indmafia].setIsalive(false);
            p[indmafia].setHP(0);
            //see category and reduce from it
            if(p[indmafia].equals(d[0]))
                leftd--;
            else if(p[indmafia].equals(h[0]))
                lefth--;
            else if(p[indmafia].equals(c[0]))
                leftcom--;
            aliveplayers--;
        }
        else        //either saved by doctor or mafia was unable to kill
        {
            System.out.println("Nobody was killed");
        }

        if(che==-1)  //caught mafia therefore no voting will happen
        {
            System.out.println("Mafia was caught by detective this time hence no voting");
            System.out.println("Mafia was player "+(inddetective+1));
            if(p[indexofuser].equals(d[0]))
            {
                System.out.println("You choose correct person");
            }
            p[inddetective].setIsalive(false);
            leftm--;
            aliveplayers--;
            //print according to user

        }
        else {
            takevoting();       //voting will occur
            int indexr=checkvoting();
            System.out.println("Player "+(indexr+1)+" was voted out");
            p[indexr].setIsalive(false);
            p[indexr].setHP(0);
            //see category and reduce from it
            if(p[indexr].equals(d[0]))
                leftd--;
            else if(p[indexr].equals(h[0]))
                lefth--;
            else if(p[indexr].equals(c[0]))
                leftcom--;
            else if(p[indexr].equals(m[0]))
                leftm--;

            aliveplayers--;
            clearvoting();
        }

    }


    public void rounds()
    {
        int r=1;
        while(true)
        {
            if(leftm>=(leftcom+leftd+lefth))
            {
                System.out.println("\n------Mafia's won------");
                break;
            }
            else if(leftm==0)
            {
                System.out.println("Mafia's lost");
                break;
            }
            else {
                System.out.println("\n\n--------Round "+r+" Starts--------");
                play();
                System.out.println("End of Round "+r);
                r++;
                //printing alive players after each round
                System.out.println("Number of Alive players "+(leftm+leftd+lefth+leftcom));
                for(int i=0;i<N;i++)
                {
                    if(p[i].isIsalive())
                        System.out.print("   Player "+(i+1));
                }
                if(leftm>=(leftcom+leftd+lefth))
                {
                    System.out.println("\n------Mafia's won------");
                    break;
                }
                else if(leftm==0)
                {
                    System.out.println("\n--------Mafia's lost--------");
                    break;
                }
            }
        }

    }


}
