import java.io.IOException;
import java.util.Scanner;

public class MakeStars {

    public static void main(String[] args) {
        /*
        try {
            int num;
            while ((num = System.in.read()) != -1) {
                char c = (char)num;
                System.out.print(Character.isWhitespace(c) ? c : '*');
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        */
        Scanner inputScan = new Scanner(System.in);
        while (inputScan.hasNextLine()) {
            String line = inputScan.nextLine();
            Scanner lineScan = new Scanner(line);
            while (lineScan.hasNext()) {
                String word = lineScan.next();
                for (int i = 0; i < word.length(); i++) {
                    System.out.print('*');
                }
                if (lineScan.hasNext()) System.out.print(' ');
            }
            if (inputScan.hasNextLine()) System.out.println();
        }
    }

}
