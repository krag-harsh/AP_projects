import java.util.Scanner;

public class WorkingR {
    restaurant[] r;

    WorkingR(restaurant[] r)
    {
        this.r=r;
    }

    void Rmenu()
    {
        Scanner in=new Scanner(System.in);
        System.out.println("Choose Restaurant");
        for(int i=0;i<5;i++)
        {
            System.out.println((i+1)+" "+r[i]);
        }
        int i=in.nextInt();
        i--;
        int q;
        do {
            System.out.println("Welcome "+r[i].getName());
            System.out.println("\t1) Add item\n" +
                    "\t2) Edit item\n" +
                    "\t3) Print Rewards\n" +
                    "\t4) Discount on bill value\n" +
                    "\t5) Exit");
            q= in.nextInt();
            switch (q)
            {
                case 1:r[i].addfood();
                    break;
                case 2:r[i].editfood();
                    break;
                case 3:
                    System.out.println("Reward points - "+r[i].getRewardpoints());
                    break;
                case 4:r[i].setthediscount();
                    break;
                case 5:
                    System.out.println("Going back to the main menu");
                    break;
            }
        }while (q>0 && q<5);
    }


}
