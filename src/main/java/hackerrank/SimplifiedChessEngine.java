package hackerrank; /**
 * Created by stan on 11/02/2021.
 */

import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class SimplifiedChessEngine {

    static HashSet<String> passwordSet = new HashSet<>();
    static int passwordLength;
    public static String passwordCracker(List<String> passwords, String loginAttempt) {
        // Write your code here
        passwordSet =  (HashSet<String>)
                passwords.stream()
                        .collect(Collectors.toSet());

        passwordLength = loginAttempt.length();
        /*
            because can do must we what
            wedowhatwemustbecausewecan
        */

        String result =  passwordCracker(loginAttempt);
        if(result.length() < loginAttempt.length()) {
            result =  "WRONG PASSWORD";
        }
        return result;
    }

    public static String passwordCracker(String loginAttempt){
        String subString = "";

        if (loginAttempt.isEmpty())
            return "";

        for(int i= 0; i <= loginAttempt.length(); i++) {
            subString = loginAttempt.substring(0, i);

            if(passwordSet.contains(subString)) {
                String nextString = loginAttempt.substring(i, loginAttempt.length());
                String result = passwordCracker(nextString);
                if(!result.isEmpty()) {
                    return String.join(" ", subString, result);
                }
                if(nextString.isEmpty())
                    return subString;
            }
        }

        return "";
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, t).forEach(tItr -> {
            try {
                int n = Integer.parseInt(bufferedReader.readLine().trim());

                List<String> passwords = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .collect(toList());

                String loginAttempt = bufferedReader.readLine();

                String result = SimplifiedChessEngine.passwordCracker(passwords, loginAttempt);

                bufferedWriter.write(result);
                bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}
