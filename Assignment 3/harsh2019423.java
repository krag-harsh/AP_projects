import java.util.Scanner;

interface Comparable<T>{
    public boolean compareTo(T other, double other2);
}

abstract class player implements Comparable<player>
{
    private static int countofunid=0;
    private int uniqueID;
    private boolean isalive;
    private double HP;
    private int voted;

    @Override
    public boolean compareTo(player other, double other2)
    {
        return (other.getHP()<other2);

    }


    public int getVoted() {
        return voted;
    }

    public void setVoted(int voted) {
        this.voted = voted;
    }

    public static int getCountofunid() {
        return countofunid;
    }

    public static void setCountofunid(int countofunid) {
        player.countofunid = countofunid;
    }

    public int getUniqueID() {
        return uniqueID;
    }

    public void setUniqueID(int uniqueID) {
        this.uniqueID = uniqueID;
    }

    public boolean isIsalive() {
        return isalive;
    }

    public void setIsalive(boolean isalive) {
        this.isalive = isalive;
    }

    public double getHP() {
        return HP;
    }

    public void setHP(double HP) {
        this.HP = HP;
    }

    @Override
    public boolean equals(Object obj) {
        return (obj!=null && getClass()==obj.getClass());
    }

}



public class harsh2019423 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N;
        do {
            System.out.println("Enter number of players : ");
            N=in.nextInt();
        }while (N<6);
        player[] p =new player[N];
        game g=new game(N,p);
        g.rounds();

    }
}
