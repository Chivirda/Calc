import java.io.IOException;
import java.util.ArrayList;

class ArabCalc {
    static void arabCalc(String inputString) throws IOException {
        ArrayList<Integer> numbers = new ArrayList<>();
        for (String part : inputString.split("\\s\\+\\s|\\s\\*\\s|\\s/\\s|\\s-\\s")) {
            int number = Integer.parseInt(part);
            if (number > 10 || number < 0)
                throw new IOException();
            numbers.add(number);
        }

        int result = Helper.checkMath(inputString, numbers);

        System.out.println(result);
    }
}
