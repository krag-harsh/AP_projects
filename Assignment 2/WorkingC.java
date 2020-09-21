import java.util.Scanner;

public class WorkingC {
    restaurant r;
    Customer c[];
    WorkingC(Customer[] c)
    {
        this.c=c;
    }

    void Cmenu()
    {
        Scanner in=new Scanner(System.in);
        System.out.println("Enter the number to enter to your account");
        for(int i=0;i<5;i++)
        {
            System.out.println((i+1)+". "+c[i]);
        }
        int i=in.nextInt();
        i--;
        int q;
        do {
            System.out.println("Welcome "+c[i].getName());
            System.out.println("\tCustomer Menu\n" +
                    "\t1) Select Restaurant\n" +
                    "\t2) checkout cart\n" +
                    "\t3) Reward won4) print the recent orders\n" +
                    "\t5) Exit");
            q= in.nextInt();
            switch (q)
            {
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    System.out.println("Going back to the main menu");
                    break;
            }
        }while (q>0 && q<5);
    }
}
