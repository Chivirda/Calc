import java.util.regex.Matcher;
import java.util.regex.Pattern;

class ArabCalc {
    static void arabCalc(String inputString) {
        int a = 0;
        int b = 0;
        int result = 0;
        Pattern numPattern = Pattern.compile("[\\d?]+[^\\s]");
        Matcher numMatcher = numPattern.matcher(inputString);
        Pattern arithmeticPattern = Pattern.compile("[+\\-*/]");
        Matcher arithmeticMatcher = arithmeticPattern.matcher(inputString);

        while (numMatcher.find()) {
            System.out.println(inputString.substring(numMatcher.start(), numMatcher.end()));
            System.out.println(inputString.substring(numMatcher.start(), numMatcher.end()));
        }
        
        if (!arithmeticMatcher.find()) throw new ArithmeticException();

        Pattern multiplyPattern = Pattern.compile("\\+");
        Matcher multiplyMatcher = multiplyPattern.matcher(inputString);

        if (multiplyMatcher.find()) {
            result = a + b;
        }

        System.out.println(result);
    }
}
