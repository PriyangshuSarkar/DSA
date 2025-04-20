import java.util.*;

class Solution {
    public List<String> fizzBuzz(int n) {

        List<String> result = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            StringBuffer s = new StringBuffer();
            if (i % 3 == 0) {
                s.append("Fizz");
            }
            if (i % 5 == 0) {
                s.append("Buzz");
            }

            result.add(s.isEmpty() ? String.valueOf(i) : s.toString());
        }

        return result;

    }
}