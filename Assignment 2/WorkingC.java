import java.util.Scanner;

public class WorkingC {
    restaurant r[];
    Customer c[];
    restaurant selectedres;
    working w;
    int i,j,totalquantity=0;  //index of customer and restaurant selected
    WorkingC(Customer[] c,restaurant[] r, working w)
    {
        this.r=r;
        this.c=c;
        this.w=w;
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
        //c[i].setNumberofitemincart(c[i].getNumberofitemincart()+1);
        index=(index+1)%10;
        c[i].setCartindex(index);


    }

    float billwithoutdiscounts(Food[] f,int[] qua,int numberofitem)
    {
        float value=0;
        for(int t=0;t<numberofitem;t++)
        {
            System.out.println(f[t]);
            float indvalue=(f[t].getPrice()*qua[t])*(100-f[t].getOffer())/100;
            totalquantity+=qua[t];
            value+=indvalue;
        }
        return value;
    }
    void deleteitemsfromlist(Food[] f, int[] qua, int numberofitem)
    {
        Scanner in=new Scanner(System.in);
        for(int t=0;t<numberofitem;t++)
        {
            System.out.println((t+1)+" "+f[t]);
        }
        System.out.println("Enter the index to delete");
        int c=in.nextInt();
        c--;
        qua[c]=0;
    }
    void updateafterpayment(float paytoapp,Customer indc,restaurant indr,float rewardcollectedinthisorder,float backupbill,int deliverycharges)
    {
        indc.setRewardpoints( indc.getRewardpoints()+rewardcollectedinthisorder);
        indr.setRewardpoints(indr.getRewardpoints()+rewardcollectedinthisorder);
        lastorder l=new lastorder(indr.getName(),totalquantity,backupbill,deliverycharges);
        totalquantity=0;

        w.setDeliverychargecollected(w.getDeliverychargecollected()+deliverycharges);
        w.setTotalbalance(w.getTotalbalance()+paytoapp);
    }

    void checkoutcart(Customer indc, restaurant indr)
    {
        Scanner in=new Scanner(System.in);
        float bill=0,rewardcollectedinthisorder;
        bill=this.billwithoutdiscounts(indc.getCart(),indc.getQuantity(),indc.getCartindex());
        bill=indr.DiscR(bill);
        bill-=indc.DiscC(bill);
        float paytoapp=bill/100;
        int deliverycharges=indc.getdeliverycharges();
        rewardcollectedinthisorder=indr.getreward(bill);


        System.out.println("Delivery charges - "+deliverycharges);
        System.out.println("Total order value : "+bill);
        System.out.println("Enter 1 to checkout : ");
        int choice=in.nextInt();
        float backupbill=0;
        if(choice==1)
        {
            //System.out.println("You earned : "+rewardcollectedinthisorder+" reward points");

            if(indc.getRewardpoints()+indc.getWallet()+rewardcollectedinthisorder>=bill+deliverycharges)
            {
                System.out.println("Items successfully bought for INR : "+bill+deliverycharges);
                backupbill=bill;
                bill=bill+deliverycharges;
                bill=bill-indc.getRewardpoints()-rewardcollectedinthisorder;
                indc.setRewardpoints(0);
                indc.setWallet(indc.getWallet()-bill);


                updateafterpayment(paytoapp,indc,indr,rewardcollectedinthisorder,backupbill,deliverycharges);

//                indc.setRewardpoints( indc.getRewardpoints()+rewardcollectedinthisorder);
//                indr.setRewardpoints(indr.getRewardpoints()+rewardcollectedinthisorder);
//                lastorder l=new lastorder(indr.getName(),totalquantity,backupbill,deliverycharges);

            }
            else
            {
                totalquantity=0;
                System.out.println("You have insufficient balance please delete some item and check again for items");
                deleteitemsfromlist(indc.getCart(),indc.getQuantity(),indc.getCartindex());
                checkoutcart(indc,indr);
            }
        }
        else
            System.out.println("Going back");


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
