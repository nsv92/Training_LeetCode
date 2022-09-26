package Roman_to_integer;

import java.util.ArrayList;
import java.util.HashMap;

public class Solution {

    public int romanToInt(String s) {

        if (s.length() < 1 || s.length() > 15) {
            throw new IndexOutOfBoundsException();
        }
        s = s.toUpperCase();

        ArrayList<Integer> integers = new ArrayList<>();

        HashMap<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                integers.add(map.get(c));
            } else throw new IllegalArgumentException();
        }

        int result = 0;
        for (int i = integers.size() - 1; i >= 0; i--) {
            Integer current = integers.get(i);
            Integer previous = 0;
            if (i != integers.size() - 1) {
                previous = integers.get(i + 1);
            }
            if (current == 1 && (previous == 5 || previous == 10)) {
                result -= 1;
            } else if (current == 10 && (previous == 50 || previous == 100)) {
                result -= 10;
            } else if (current == 100 && (previous == 500 || previous == 1000)) {
                result -= 100;
            } else result += current;
        }
        return result;
    }

}
