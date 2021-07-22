package hackerrank; /**
 * Created by stan on 18/12/2020.
 */

import java.io.*;
        import java.math.*;
        import java.text.*;
        import java.util.*;
        import java.util.regex.*;

public class TimeConversion {

    /*
     * Complete the timeConversion function below.
     */
    static String timeConversion(String s) {
        //07:05:45PM  -> 19:05:45

        String [] time = s.split("[:AMPM]");
        int unFormattedHour = Integer.parseInt(time[0]) % 12;
        int hour = unFormattedHour;
        if(s.endsWith("PM")) {
            hour = unFormattedHour + 12;
        }

        StringJoiner joiner = new StringJoiner(":");
        joiner.add(String.format("%02d", hour))
                .add(time[1])
                .add(time[2]);

        return joiner.toString();

    }

//    private static final Scanner scan = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
//        BufferedWriter bw = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
//
//        String s = scan.nextLine();

        String result = timeConversion("07:05:45PM");


        System.out.println( timeConversion("12:00:00AM"));
        System.out.println( timeConversion("12:00:00PM"));
//        bw.write(result);
//        bw.newLine();
//
//        bw.close();
    }
}

