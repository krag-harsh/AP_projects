class A
{
    int i=0;
    void aa()
    {
        System.out.println("in a");
    }
}

class B extends A
{
    void p()
    {
        super.i=1;
        System.out.println(super.i);
    }

    @Override
    void aa()
    {
        System.out.println("in b");
    }

}
public class tyring {
    public static void main(String[] args) {

        int price=120;
        int qua=2;
        int offer=5;
        float mul=(float)(qua*price);
        float sub=100-offer;
        float a=sub/100;
        float indvalue= a*mul;
        System.out.println(indvalue);


    }

}
