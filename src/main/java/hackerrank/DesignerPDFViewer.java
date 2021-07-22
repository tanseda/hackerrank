package hackerrank; /**
 * Created by stan on 28/01/2021.
 * https://www.hackerrank.com/challenges/designer-pdf-viewer/problem?h_r=next-challenge&h_v=zen
 */

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class DesignerPDFViewer {

    private static final Scanner scanner = new Scanner(System.in);

    static int designerPdfViewer(int[] h, String word) {
        int result = 0;
        int maxHeight = 0;
        for(int i = 0; i < word.length(); i++){
            int tmp = word.charAt(i);
            int heightOfChar = h[tmp - 'a'];
            maxHeight = Math.max(heightOfChar, maxHeight);
        }

        result = maxHeight * word.length();
        return result;
    }

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int[] h = new int[26];

        String[] hItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < 26; i++) {
            int hItem = Integer.parseInt(hItems[i]);
            h[i] = hItem;
        }

        String word = scanner.nextLine();

        int result = designerPdfViewer(h, word);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
