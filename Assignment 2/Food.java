import java.util.Scanner;

public class Food {
    private static int UnID=1;
    private String name;
    private int price;
    private int quantity;
    private int category;

    private int offer;
    private final int UniqueID;
    String stcat;
    //"Starter", "Main Course", "Dessert", "Beverage"
    public Food(String name, int price, int quantity, int category,int offer) {
        this.UniqueID=UnID;
        UnID++;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.category = category;
        this.offer=offer;
        if(category==1)
            stcat="Starter";
        else if(category==2)
            stcat="Main Course";
        else if(category==3)
            stcat="Dessert";
        else if(category==4)
            stcat="Beverage";
    }

    public int getUniqueID() {
        return UniqueID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setCategory(int category) {
        this.category = category;
        if(category==1)
            stcat="Starter";
        else if(category==2)
            stcat="Main Course";
        else if(category==3)
            stcat="Dessert";
        else if(category==4)
            stcat="Beverage";
    }

    public int getOffer() {
        return offer;
    }

    public void setOffer(int offer) {
        this.offer = offer;
    }

    @Override
    public String toString() {

        return(getUniqueID()+" "+name+" "+getPrice()+" "+ getQuantity()+" "+offer+"% off "+ stcat);
    }

    public void editing()
    {
        Scanner in=new Scanner(System.in);
        System.out.println("Choose an attribute to edit:\n" +
                "1) Name\n" +
                "2) Price\n" +
                "3) Quantity\n" +
                "4) Category\n" +
                "5) Offer");
        int i=in.nextInt();
        if(i==1)
        {
            System.out.println("Enter new Name:");
            String ne=in.next();
            setName(ne);
        }
        else if(i==2)
        {
            System.out.println("Enter new Price:");
            int inn=in.nextInt();
            setPrice(inn);
        }
        else if(i==3)
        {
            System.out.println("Enter new Quantity");
            int inn=in.nextInt();
            setQuantity(inn);
        }

        else if(i==4)
        {
            System.out.println("Enter new Category(in number):");
            int inn=in.nextInt();
            setCategory(inn);
        }

        else if(i==5)
        {
            System.out.println("Enter new offer:");
            int inn=in.nextInt();
            setOffer(inn);
        }

    }
}
