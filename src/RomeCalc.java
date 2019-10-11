import java.io.IOException;
import java.util.ArrayList;

class RomeCalc {
    static void romeCalc(String inputString) throws IOException {
        ArrayList<Integer> numbers = new ArrayList<>();
        for (String part : inputString.split("\\s\\+\\s|\\s\\*\\s|\\s/\\s|\\s-\\s")) {
            int number = Roman.valueOf(part).toInt();
            if (number > 10 || number < 0)
                throw new IOException();
            numbers.add(number);
        }

        int result = Helper.checkMath(inputString, numbers);

        for (Roman num : Roman.values()) {
            if (num.toInt() == result) {
                System.out.println(num.name());
            }
        }
    }
}
