import java.util.HashMap;
import java.util.Scanner;

class User
{
    private String name,address;
    void setdata(String s1, String s2)
    {
        this.name=s1;
        this.address=s2;
    }

    public String getName() {
        return name;
    }
}





class Customer extends User
{
    private float wallet,rewardPoints,bill;
    void setnameadd(String s1, String s2)
    {
        super.setdata(s1,s2);
    }

}

class NormalC extends Customer{
    @Override
    public String toString() {
        return(this.getName());
    }

}
class EliteC extends Customer{
    @Override
    public String toString() {
        return(this.getName()+" (Elite)");
    }

}
class SpecialC extends Customer{
    @Override
    public String toString() {
        return(this.getName()+" (Special)");
    }

}









class restaurant extends User
{
    Scanner in=new Scanner(System.in);
    HashMap<Integer,Food> fooditem= new HashMap<Integer, Food>();
    float rewardPoints,Bill;
    int discount; //keep it 0 or set according to query 4

    void setnameadd(String s1, String s2)
    {
        super.setdata(s1,s2);
    }

    void addfood()
    {
        System.out.println("Enter name of food : ");
        String s=in.next();
        System.out.println("Its price : ");
        int p=in.nextInt();
        System.out.println("Its quantity : ");
        int q=in.nextInt();
        System.out.println("Its category:\n1 for Starter\n2 for Main Course\n3 for Dessert\n 4 for Beverage: ");
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
            System.out.println(fooditem.get(f));
        }
        System.out.println("Enter unique id you want to edit");
        int id=in.nextInt();
        Food f=fooditem.get(id);
        f.editing();
        System.out.println(f);

    }

    void preward()
    {
        System.out.println("Reward points claimed by customers till now: "+rewardPoints);
    }

    void setthediscount()
    {
        System.out.println("Enter the percentage discount your restaurant give on final bill");
    }


}

class FastFoodR extends restaurant{
    @Override
    public String toString() {
        return(this.getName()+" (Fast Food)");
    }
}

class AuthenticR extends restaurant{
    @Override
    public String toString() {
        return(this.getName()+" ( Authentic Restaurant)");
    }

}

class NormalR extends restaurant{
    @Override
    public String toString() {
        return(this.getName());
    }

}









public class harsh2019423 {
    public static void main(String[] args)
    {
        Scanner in=new Scanner(System.in);
        System.out.println("First line");
        Food f=new Food("Idli",12,32,1,5);
        System.out.println(f);

        
    }
}
