import java.util.Random;
import java.util.Scanner;

public class healer extends player {
    public healer()
    {
        setUniqueID(getCountofunid());
        setCountofunid(getCountofunid()+1);
        setIsalive(true);
        setHP(800);
        setVoted(0);
    }

    @Override
    public boolean equals(Object obj) {
        return (obj!=null && getClass()==obj.getClass());
    }

    public int choose(healer[] h, player[] p,int indexofuser)
    {
        Scanner in = new Scanner(System.in);
        Random rand=new Random();
        int inp;
        if(p[indexofuser].equals(h[0])  && p[indexofuser].isIsalive())
        {
            while (true)
            {
                System.out.println("Choose player to heal :");
                inp=in.nextInt();
                inp--;
                if(!p[inp].isIsalive())
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
                if(p[inp].isIsalive())
                    break;
            }
        }
        return inp;

    }
}
