/**
 * Created by yashasvi on 12/31/14.
 */
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Timestamp;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
public class Main {
    public static void main(String[] args) {

      Analyze analyze= new Analyze();

        JSONParser parser = new JSONParser();

        try {

            Object obj = parser.parse(new FileReader("/home/yashasvi/IdeaProjects/domain_config_dateage/test1.json"));

            JSONObject jsonObject = (JSONObject) obj;

             //For Column1
            JSONObject column1= (JSONObject) jsonObject.get("column1");

            String lower_range = (String) column1.get("lower_range");
            String upper_range = (String) column1.get("upper_range");

            long rangebegin = Timestamp.valueOf(lower_range).getTime();
            long rangeend = Timestamp.valueOf(upper_range).getTime();
            long diff = rangeend - rangebegin + 1;
            System.out.print("DOB                                  Age\n");
            for(int i=0;i<10;i++) {
                Timestamp rand = new Timestamp(rangebegin + (long) (Math.random() * diff));

                System.out.println(rand);

                //For Column2
                JSONObject column2= (JSONObject) jsonObject.get("column2");
                String value= (String)column2.get("value");






              if(value.substring(0,11).equals("dob_age_ref")) {

                  analyze.calculateage(rand.toString().substring(0, 4), rand.toString().substring(5, 7), rand.toString().substring(8, 10), value);

              }







            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }

//Parse the JSON String to date


}

