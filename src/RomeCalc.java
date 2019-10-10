import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

enum Roman {
    I(1), II(2), III(3), IV(4), V(5), VI(6), VII(7), VIII(8), IX(9), X(10), XI(11), XII(12), XIII(13),
    XIV(14), XV(15), XVI(16), XVII(17), XVIII(18), XIX(19), XX(20), XXI(21), XXIV(24), XXV(25), XXVII(27), XXX(30),
    XXXII(32), XXXV(35), XXXVI(36), XL(40), XLII(42), XLV(45), XLVIII(48), XLIX(49), L(50), LIV(54), LVI(56), LX(60),
    LXIII(63), LXIV(64), LXX(70), LXXII(72), LXXX(80), LXXXI(81), XC(90), C(100);
    private final int value;

    private Roman(int value) {
        this.value = value;
    }

    int toInt() {
        return value;
    }
}

class RomeCalc {
    static void romeCalc(String inputString) throws IOException {
        int result = 0;
        ArrayList<Integer> numbers = new ArrayList<>();
        for (String part : inputString.split("\\s\\+\\s|\\s\\*\\s|\\s/\\s|\\s-\\s")) {
            int number = Roman.valueOf(part).toInt();
            if (number > 10 || number < 0)
                throw new IOException();
            numbers.add(number);
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
