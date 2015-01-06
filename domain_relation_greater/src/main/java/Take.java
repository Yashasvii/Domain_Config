import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.Random;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * Created by yashasvi on 1/6/15.
 */
public class Take {

    public void jsonread()
    {


        JSONParser parser = new JSONParser();
        Analyze analyze= new Analyze();

        try {

            Object obj = parser.parse(new FileReader("/home/yashasvi/IdeaProjects/domain_relation_greater/test2.json"));

            JSONObject jsonObject = (JSONObject) obj;

            //For Column1
            JSONObject column1= (JSONObject) jsonObject.get("column1");

            String lower_range = (String) column1.get("lower_range");
            String upper_range = (String) column1.get("upper_range");

            System.out.print("Value1                                 Value2\n");
            for(int i=0;i<10;i++) {
                Random random = new Random();
                int rand = random.nextInt(Integer.parseInt(upper_range) - Integer.parseInt(lower_range) + 1) + Integer.parseInt(lower_range);

                System.out.println(rand);


                //For Column2
               JSONObject column2= (JSONObject) jsonObject.get("column2");
                String value= (String)column2.get("value");





                if(value.substring(0,12).equals("greater_than")) {

                    analyze.calculate_greater(rand, Integer.parseInt(upper_range),value);

                }

              else if(value.substring(0,9).equals("less_than")) {

                    analyze.calculate_lesser(rand, Integer.parseInt(lower_range),value);

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

    }

