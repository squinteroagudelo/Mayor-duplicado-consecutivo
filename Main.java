import java.util.*;

class Main {
  public static void main(String[] args) {
    int[] myArray = { 1, 2, 2, 4, 5, 6, 7, 8, 8, 8, 4, 4, 8, 8, 2, 2, 2, 2 };
    Map<Integer, Integer> integerMap = new HashMap<>();
    for (int n : myArray) {
      int counter = 0, auxCount = 0;
      boolean change = false;
      for (int k : myArray) {
        if (change) {
          auxCount = counter > auxCount ? counter : auxCount;
          counter = 0;
        }
        if (k == n) {
          counter++;
          change = false;
        } else {
          change = true;
        }
      }
      counter = counter > auxCount ? counter : auxCount;
      if (integerMap.containsKey(n)) {
        integerMap.put(n, integerMap.get(n) < counter ? counter : integerMap.get(n));
      } else {
        integerMap.put(n, counter);
      }
    }
    integerMap.forEach((key, value) -> System.out.println(key + ": " + value));
  }
}