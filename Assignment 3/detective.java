import java.util.Random;
import java.util.Scanner;

public class detective extends player
{
    public void detective()
    {
        setUniqueID(getCountofunid());
        setCountofunid(getCountofunid()+1);
        setIsalive(true);
        setHP(800);
    }


    public int choose(detective[] d, player[] p,int indexofuser)
    {
        Scanner in = new Scanner(System.in);
        Random rand=new Random();
        int inp;
        if(p[indexofuser].equals(d[0])  && p[indexofuser].isIsalive())
        {
            while (true)
            {
                System.out.println("Choose a player to test :");
                inp=in.nextInt();
                inp--;
                if(p[inp].equals(d[0]) )
                {
                    System.out.println("You cannot test a detective try again :");
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
                if(p[inp].equals(d[0]))
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