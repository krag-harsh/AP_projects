import java.util.Scanner;

public class working {
    restaurant r[];
    Customer c[];
    float totalbalance=0;
    int deliverychargecollected=0;
    working(Customer[] c,restaurant[] r)
    {
        this.r=r;
        this.c=c;
    }

    public float getTotalbalance() {
        return totalbalance;
    }

    public void setTotalbalance(float totalbalance) {
        this.totalbalance = totalbalance;
    }

    public int getDeliverychargecollected() {
        return deliverychargecollected;
    }

    public void setDeliverychargecollected(int deliverychargecollected) {
        this.deliverychargecollected = deliverychargecollected;
    }

    void userdetails()
    {
        Scanner in=new Scanner(System.in);
        System.out.println("\t1) Customer List\n" +
                "\t2) Restaurant List");
        int i=in.nextInt();
        if(i==1)
        {
            //System.out.println("Enter the number to enter to your account");
            for(int j=0;j<5;j++)
            {
                System.out.println((j+1)+". "+c[j]);
            }
            int j=in.nextInt();
            j--;        //index of customer
            System.out.println(c[j]+", "+c[j].getAddress()+", "+c[j].getWallet());
        }
        else
        {
            for(int j=0;j<5;j++)
            {
                System.out.println((j+1)+". "+r[j]);
            }
            int j=in.nextInt();
            j--;        //index of customer
            System.out.println(r[j]+", "+r[j].getAddress()+", "+r[j].getRewardpoints());

        }
    }

    void accountdetails()
    {
        System.out.println("Total Company balance - INR "+totalbalance+"/-\n" +
                "Total Delivery Charges Collected - INR "+deliverychargecollected+"/-");

    }

}
