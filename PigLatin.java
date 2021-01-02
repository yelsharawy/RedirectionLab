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

}
