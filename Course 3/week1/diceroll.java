import java.util.Random;

public class diceroll {
    public void simulate(int rolls)
    {
        Random rand=new Random();
        int[] count=new int[13];
        for(int i=0;i<rolls;i++)
        {
            int d1=rand.nextInt(6)+1;
            int d2=rand.nextInt(6)+1;
            System.out.println("roll is "+d1+"+"+d2+"="+(d1+d2));
            count[d1+d2]+=1;
        }
        for(int k=2;k <= 12;k++)
        {
            System.out.println(k+"'s="+count[k]);
        }
    }

}
