import java.util.HashMap;
import java.util.Scanner;

class User
{
    private String name,address;
    private float rewardpoints;

    void setdata(String s1, String s2)
    {
        this.name=s1;
        this.address=s2;
        rewardpoints=0;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public float getRewardpoints() {
        return rewardpoints;
    }

    public void setRewardpoints(float rewardpoints)
    {
        this.rewardpoints = rewardpoints;
    }

}


class Customer extends User
{
    private float wallet;
    private lastorder[] li =new lastorder[10];
    private Food[] cart=new Food[10];
    private int[] quantity= new int[10];
    private int cartindex,numberoforder,numberofitemincart;

    void setnameadd(String s1, String s2)
    {
        super.setdata(s1,s2);
        numberoforder=0;
        cartindex=0;
        wallet=1000;
        super.setRewardpoints(0);
    }


    public void setNumberoforder() {
        this.numberoforder++;
    }

    public int getdeliverycharges()
    {
        return 40;
    }
    public Food[] getCart() {
        return cart;
    }

    public void setCart(Food[] cart) {
        this.cart = cart;
    }

    public float getWallet() {
        return wallet;
    }

    public void setWallet(float wallet) {
        this.wallet = wallet;
    }

    public int[] getQuantity() {
        return quantity;
    }

    public void setQuantity(int[] quantity) {
        this.quantity = quantity;
    }


    public int getCartindex() {
        return cartindex;
    }

    public void setCartindex(int cartindex) {
        this.cartindex = cartindex;
    }

    void setcartandquantity(Food f, int qua, int index)
    {
        cart[index]=f;
        quantity[index]=qua;
    }

    float DiscC(float a)
    {
        return (0);
    }

    public lastorder[] getLi() {
        return li;
    }

}

class NormalC extends Customer{
    NormalC(String name, String add)
    {
        super.setnameadd(name,add);
    }

    @Override
    public int getdeliverycharges()
    {
        return 40;
    }
    @Override
    float DiscC(float a)
    {
        return (float) 0.0;
    }
    @Override
    public String toString() {
        return(this.getName());
    }

}
class EliteC extends Customer{
    EliteC(String name, String add)
    {
        super.setnameadd(name,add);
    }

    @Override
    public int getdeliverycharges()
    {
        return 0;
    }
    @Override
    float DiscC(float a)
    {
        if(a>200)
            return (float) 50.0;
        else
            return (float) 0.0;
    }

    @Override
    public String toString() {
        return(this.getName()+" (Elite)");
    }

}
class SpecialC extends Customer{
    SpecialC(String name, String add)
    {
        super.setnameadd(name,add);
    }

    @Override
    public int getdeliverycharges()
    {
        return 20;
    }
    @Override
    float DiscC(float a)
    {
        if(a>200)
            return (float) 25.0;
        else
            return (float) 0.0;
    }

    @Override
    public String toString() {
        return(this.getName()+" (Special)");
    }

}









class restaurant extends User
{
    Scanner in=new Scanner(System.in);
    HashMap<Integer,Food> fooditem= new HashMap<>();
    //private float rewardPoints,Bill;
    private float Bill;
    private int discount; //keep it 0 or set according to query 4

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    void setnameadd(String s1, String s2, int r)
    {
        super.setdata(s1,s2);
        this.discount=r;
        super.setRewardpoints(0);
        Bill=0;
    }


    public float getBill() {
        return Bill;
    }

    public void setBill(float bill) {
        Bill = bill;
    }

    void addfood()
    {
        System.out.println("Enter name of food : ");
        String s=in.next();
        System.out.println("Its price : ");
        int p=in.nextInt();
        System.out.println("Its quantity : ");
        int q=in.nextInt();
        System.out.println("Its category:\n1 for Starter\n2 for Main Course\n3 for Dessert\n4 for Beverage: ");
        int c=in.nextInt();
        System.out.println("offer(enter 0 if none) : ");
        int o=in.nextInt();
        Food f1= new Food(s,p,q,c,o);
        fooditem.put(f1.getUniqueID(),f1);
        System.out.println(f1);

    }

    void editfood()
    {
        for (int f : fooditem.keySet())
        {
            System.out.println(f+" " +fooditem.get(f));
        }
        System.out.println("Enter unique id you want to edit");
        int id=in.nextInt();
        if(fooditem.containsKey(id))
        {
            Food f=fooditem.get(id);
            f.editing();
            System.out.println(f);
        }
        else
            System.out.println("Invalid key selected");
    }

    void setthediscount()
    {
        System.out.println("Sorry the restaurant do not provide discount on final bill");
        //int i=in.nextInt();
//        setDiscount(i);
    }

    float DiscR(float a)
    {
      return (float) (a+0.0);
    }

    public float getreward(float a)
    {
        return(a/20);
    }

//    public void setRewardPoints(float rewardPoints) {
//        this.rewardPoints = rewardPoints;
//    }
//
//    public float getRewardPoints() {
//        return rewardPoints;
//    }
}

class FastFoodR extends restaurant{
    Scanner in=new Scanner(System.in);

    @Override
    public float getreward(float a) {
        return a/15;
    }

    @Override
    void setthediscount()
    {
        System.out.println("Enter discount on bill value - ");
        int i=in.nextInt();
        setDiscount(i);
    }

    @Override
    float DiscR(float a)
    {
        int d=getDiscount();
        float v = (float) ((float)(100 - d) / 100) * a;
        return v;

    }
    FastFoodR(String name, String add, int r)
    {
        super.setnameadd(name,add,r);
    }
    @Override
    public String toString() {
        return(this.getName()+" (Fast Food)");
    }
}

class AuthenticR extends restaurant{
    Scanner in=new Scanner(System.in);

    AuthenticR(String name, String add, int r)
    {
        super.setnameadd(name,add,0);
    }

    @Override
    public float getreward(float a) {
        return a/8;
    }

    @Override
    void setthediscount()
    {
        System.out.println("Enter discount on bill value - ");
        int i=in.nextInt();
        setDiscount(i);
    }
    @Override
    float DiscR(float a)
    {
        int d=getDiscount();
        float c= (float)((float)(100-d)/100)*a;
        if(c>100)
            return (float) (c-50.0);
        else
            return c;
    }

    @Override
    public String toString() {
        return(this.getName()+" ( Authentic Restaurant)");
    }

}

class NormalR extends restaurant{
    //Scanner in=new Scanner(System.in);
    @Override
    public float getreward(float a) {
        return a/20;
    }

    @Override
    void setthediscount()
    {
        System.out.println("Sorry the restaurant do not provide discount on final bill");
        //int i=in.nextInt();
        //setDiscount(i);
    }
    @Override
    float DiscR(float a)
    {
        return a;
    }

    NormalR(String name, String add, int r)
    {
        super.setnameadd(name,add,0);
    }
    @Override
    public String toString() {
        return(this.getName());
    }

}









public class harsh2019423 {
    public static void main(String[] args)
    {
        Scanner in=new Scanner(System.in);

        //User[] U =new User[10];
        Customer[] C= new Customer[5];
        restaurant[] R=new restaurant[5];
        C[0]=new EliteC("Ram","Delhi");
        C[1]=new EliteC("Sam","Delhi");
        C[2]=new SpecialC("Tim","Delhi");
        C[3]=new NormalC("Kim","Delhi");
        C[4]=new NormalC("Jim","Delhi");

        R[0]=new AuthenticR("Shah","Delhi",3);
        R[1]=new NormalR("Ravi's","Delhi",0);
        R[2]=new AuthenticR("The Chinese","Delhi",3);
        R[3]=new FastFoodR("Wang's","Delhi",4);
        R[4]=new NormalR("Paradise","Delhi",0);

        WorkingR wr=new WorkingR(R);
        working wo =new working(C,R);
        WorkingC wc=new WorkingC(C,R,wo);
        int q;
        do {
            System.out.println("Welcome to Zotato:\n" +
                    "\t1) Enter as Restaurant Owner\n" +
                    "\t2) Enter as Customer\n" +
                    "\t3) Check User Details\n" +
                    "\t4) Company Account details\n" +
                    "\t5) Exit\n");
            q=in.nextInt();

            switch (q)
            {
                case 1:
                    wr.Rmenu();
                    break;
                case 2:
                    wc.Cmenu();
                    break;
                case 3:
                    wo.userdetails();
                    break;
                case 4:
                    wo.accountdetails();
                    break;
                case 5:
                    System.out.println("----------Thanks for using the application----------");
                    break;
                default:
                    System.out.println("please enter different value");
            }

        }while (q>0 && q<5);

    }
}
