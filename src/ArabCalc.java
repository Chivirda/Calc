import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class ArabCalc {
    static void arabCalc(String inputString) {
        int result = 0;
        ArrayList<Integer> numbers = new ArrayList<>();
        for (String part : inputString.split("\\s\\+\\s|\\s\\*\\s|\\s/\\s|\\s-\\s")) {
            numbers.add(Integer.parseInt(part));
        }

        Pattern arithmeticPattern = Pattern.compile("[+\\-*/]");
        Matcher arithmeticMatcher = arithmeticPattern.matcher(inputString);

        if (!arithmeticMatcher.find()) throw new ArithmeticException();

        Pattern addPattern = Pattern.compile("\\+");
        Pattern multiplyPattern = Pattern.compile("\\*");
        Pattern dividePattern = Pattern.compile("/");
        Pattern subtractPattern = Pattern.compile("-");
        Matcher addMatcher = addPattern.matcher(inputString);
        Matcher multiplyMatcher = multiplyPattern.matcher(inputString);
        Matcher divideMatcher = dividePattern.matcher(inputString);
        Matcher subtractMatcher = subtractPattern.matcher(inputString);

        if (addMatcher.find()) {
            result = numbers.get(0) + numbers.get(1);
        } else if (multiplyMatcher.find()) {
            result = numbers.get(0) * numbers.get(1);
        } else if (divideMatcher.find()) {
            result = numbers.get(0) / numbers.get(1);
        } else if (subtractMatcher.find()) {
            result = numbers.get(0) - numbers.get(1);
        }

        System.out.println(result);
    }
}
