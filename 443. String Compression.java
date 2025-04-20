// import java.util.*;

class Solution {

    public int compress(char[] chars) {

        int j = 0;
        int count = 1;

        for (int i = 1; i <= chars.length; i++) {

            if (i < chars.length && chars[i - 1] == chars[i]) {
                count++;
            } else {
                chars[j] = chars[i - 1];
                j++;

                if (count > 1) {
                    char[] countArray = String.valueOf(count).toCharArray();
                    for (char c : countArray) {
                        chars[j] = c;
                        j++;
                    }
                }

                count = 1;
            }
        }

        return j;
    }
}
