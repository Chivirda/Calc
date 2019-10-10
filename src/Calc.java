import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calc {
    public static void main(String[] args) throws IOException {
        while (true) {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String inputString = reader.readLine();

            checkString(inputString);

        }
    }

    private static void checkString(String inputString) throws IOException {
        Pattern arabPattern = Pattern.compile("\\d");
        Matcher arabMatcher = arabPattern.matcher(inputString);
        Pattern romePattern = Pattern.compile("[IVX]");
        Matcher romeMatcher = romePattern.matcher(inputString);

        if (arabMatcher.find() && romeMatcher.find()) {
            throw new IOException();
        } else if (romeMatcher.find()) {
            System.out.println("Rome Calc");
        } else if (arabMatcher.find()) {
            ArabCalc.arabCalc(inputString);
        } else throw new IOException();

    }
}
