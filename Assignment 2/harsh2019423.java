import java.util.HashMap;
import java.util.Scanner;

class User
{
    String name,address;
}

class Customer extends User
{
    private float wallet,rewardPoints,bill;
}

class EliteC extends Customer{

}

class SpecialC extends Customer{

}

class restaurants extends User
{
    Scanner in=new Scanner(System.in);
    HashMap<Integer,Food> fooditem= new HashMap<Integer, Food>();
    float rewardPoints,Bill;
    int discount;

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

}






public class harsh2019423 {
    public static void main(String[] args)
    {
        Scanner in=new Scanner(System.in);
        System.out.println("First line");
        Food f=new Food("har",12,32,1,5);
        System.out.println(f);

    }
}
