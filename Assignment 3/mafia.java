import java.util.Random;
import java.util.Scanner;

public class mafia extends player {
    public void mafia()
    {
        setUniqueID(getCountofunid());
        setCountofunid(getCountofunid()+1);
        setIsalive(true);
        setHP(2500);
    }

    public int choose(mafia[] m, player[] p,int indexofuser)
    {
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
                inp=rand.nextInt(p.length);
                if(p[inp].equals(m[0]))
                    continue;
                else if(!p[inp].isIsalive())
                    continue;
                else
                    //return inp;
                    break;
            }
        }

        return inp;
    }



}
