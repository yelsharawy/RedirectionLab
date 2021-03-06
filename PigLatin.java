import java.util.Scanner;

public class PigLatin {

    public static String pigLatinSimple(String word) {
        word = word.toLowerCase();
        char firstChar = word.charAt(0);
        switch (firstChar) {
            case 'a': case 'e': case 'i': case 'o': case 'u':
                return word + "hay";
            default:
                return word.substring(1) + firstChar + "ay";
        }
    }

    private static String[] diagraphs = {"bl", "br", "ch", "ck", "cl", "cr", "dr", "fl", "fr", "gh", "gl", "gr", "ng", "ph", "pl", "pr", "qu", "sc", "sh", "sk", "sl", "sm", "sn", "sp", "st", "sw", "th", "tr", "tw", "wh", "wr"};

    private static boolean startsWithDiagraph(String s) {
        if (s.length() < 2) return false;
        String firstTwo = s.substring(0, 2);
        // i considered using another switch statement here
        // but i didn't want a block of ugly code
        // for minimal, at best questionable, speed improvements
        for (String diagraph : diagraphs) {
            if (firstTwo.equals(diagraph)) {
                return true;
            }
        }
        return false;
    }

    public static String pigLatin(String word) {
        word = word.toLowerCase();
        char firstChar = word.charAt(0);

        switch (firstChar) {
            case 'a': case 'e': case 'i': case 'o': case 'u':
                return word + "hay";
        }

        return startsWithDiagraph(word) ?
                word.substring(2) + word.substring(0, 2) + "ay" :
                word.substring(1) + firstChar + "ay";
    }

    public static String pigLatinBest(String word) {
        word = word.toLowerCase();
        char firstChar = word.charAt(0);

        if (firstChar < 'a' || firstChar > 'z') return word;

        int upTo = word.length();
        while (!Character.isLetterOrDigit(word.charAt(upTo-1))) {
            upTo--;
        }

        return pigLatin(word.substring(0, upTo)) + word.substring(upTo);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            Scanner lineScanner = new Scanner(scanner.nextLine());
            while (lineScanner.hasNext()) {
                System.out.print(pigLatinBest(lineScanner.next()));
                if (lineScanner.hasNext()) System.out.print(' ');
            }
            if (scanner.hasNextLine()) System.out.println();
        }
    }

}
