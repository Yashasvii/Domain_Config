import java.util.Random;

/**
 * Created by yashasvi on 1/6/15.
 */
public class Analyze {

    public void calculate_greater(int num, int upper_range, String value)
    {
        Random random = new Random();
        if(value.substring(13,17).equals("id:1")) {
             int rand = random.nextInt((upper_range+1) - (num + 1) + 1) + (num + 1);
             System.out.println("                            "+rand);
        }
    }

    public void calculate_lesser(int num, int lower_range, String value)
    {
        Random random = new Random();
        if(value.substring(10,14).equals("id:1")) {
            int rand = random.nextInt((num-1) - (lower_range-1) + 1) + (lower_range - 1);
            System.out.println("                            "+rand);
        }
    }
}
