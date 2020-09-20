class A
{
    void p()
    {
        System.out.println("In A");
    }
}

class B extends A
{
    void p()
    {
        System.out.println("In B");
    }
}
public class tyring {
    public static void main(String[] args) {
        A aa=new B();
        //B bb=new B();
        aa=(B)aa;
        aa.p();
       // bb.p();

    }



}
