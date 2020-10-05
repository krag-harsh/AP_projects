import java.util.Random;
import java.util.Scanner;

public class mafia extends player {
    public mafia()
    {
        super.setUniqueID(getCountofunid());
        super.setCountofunid(getCountofunid()+1);
        super.setIsalive(true);
        super.setHP(2500);
        super.setVoted(0);
    }

    @Override
    public boolean equals(Object obj) {
        return (obj!=null && getClass()==obj.getClass());
    }

    public int choose(mafia[] m, player[] p,int indexofuser)
    {
        System.out.println("inside mchoose functino");
        Scanner in = new Scanner(System.in);
        Random rand=new Random();
        int inp;
        if(p[indexofuser].equals(m[0])  && p[indexofuser].isIsalive())
        {
            while (true)
            {
                System.out.println("Choose player to kill :");
                inp=in.nextInt();
                inp--;
                if(p[inp].equals(m[0]))
                {
                    System.out.println("You cannot choose another mafia\nTry again :");
                    //System.out.println("Player is also a mafia select other player");
                }
                else if(!p[inp].isIsalive())
                    System.out.println("The person you choose is dead choose again");
                else
                    return inp;
                    break;
            }
        }
        else
        {
            while (true)
            {
                System.out.println("Mafias are selecting target");
                inp=rand.nextInt(p.length);
                System.out.println(inp);
                System.out.println(p[inp].equals(m[0]));
                if(p[inp].equals(m[0]))
                    continue;
                else if(!p[inp].isIsalive())
                {
                    System.out.println(p[inp].isIsalive());
                }
                else
                    return inp;
                    //break;
            }
        }

        return inp;
    }



}
