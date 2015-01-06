import java.time.LocalDate;
import java.time.Month;
import java.time.Period;

/**
 * Created by yashasvi on 1/3/15.
 */
public class Analyze {

    public void calculateage(String year,String month, String day, String value) {
        LocalDate today = LocalDate.now();

        if(value.substring(12,16).equals("id:1")) {
            LocalDate birthday = LocalDate.of(Integer.parseInt((year)), Integer.parseInt(month), Integer.parseInt(day));

            Period p = Period.between(birthday, today);

//Now access the values as below
            //  System.out.println(p.getDays());
            //  System.out.println(p.getMonths());

            System.out.println("                                                           " + p.getYears());
        }

    }



}
