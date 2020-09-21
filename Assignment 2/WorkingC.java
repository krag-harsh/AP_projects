import java.util.Scanner;

public class WorkingC {
    restaurant r[];
    Customer c[];
    restaurant selectedres;
    int i,j;  //index of customer and restaurant selected
    WorkingC(Customer[] c,restaurant[] r)
    {
        this.r=r;
        this.c=c;
    }

    void selectresanditem()
    {
        Scanner in=new Scanner(System.in);
        int index=c[i].getCartindex();
        System.out.println("Choose Restaurant");
        for(j=0;j<5;j++)
        {
            System.out.println((j+1)+" "+r[j]);
        }
        j=in.nextInt();
        j--;  //this will store the index of restaurant
        selectedres=r[j];
        for (int f : selectedres.fooditem.keySet())
        {
            System.out.println(f+" " +selectedres.fooditem.get(f));
        }
        System.out.println("Choose item by unique code");
        int unc=in.nextInt();
        System.out.println("Enter item quantity");
        int quantity=in.nextInt();
        c[i].setcartandquantity(selectedres.fooditem.get(unc),quantity,index);
        c[i].setNumberofitemincart(c[i].getNumberofitemincart()+1);
        index=(index+1)%10;
        c[i].setCartindex(index);
        //c[i].fooditem.put(unc,selectedres.fooditem.get(unc));

    }

    void checkoutcart(Customer indc, restaurant indr)
    {


    }


    void Cmenu()
    {
        Scanner in=new Scanner(System.in);
        System.out.println("Enter the number to enter to your account");
        for(i=0;i<5;i++)
        {
            System.out.println((i+1)+". "+c[i]);
        }
        i=in.nextInt();
        i--;        //index of customer
        int q;
        do {
            System.out.println("Welcome "+c[i].getName());
            System.out.println("\tCustomer Menu\n" +
                    "\t1) Select Restaurant\n" +
                    "\t2) checkout cart\n" +
                    "\t3) Reward won\n" +
                    "\t4) print the recent orders\n" +
                    "\t5) Exit");
            q= in.nextInt();
            switch (q)
            {
                case 1:
                    this.selectresanditem();
                    break;
                case 2:
                    this.checkoutcart(c[i],selectedres);
                    break;
                case 3:
                    System.out.println("Total rewards - "+c[i].getRewardpoints());
                    break;
                case 4:
                    System.out.println("These are the last 10 orders");
                    lastorder[] li=c[i].getLi();
                    for(int k=0;k<10;k++)
                    {
                        if(li[k]!=null)
                        {
                            System.out.println(li[k]);
                        }
                    }
                    break;
                case 5:
                    System.out.println("Going back to the main menu");
                    break;
            }
        }while (q>0 && q<5);

    }
}
