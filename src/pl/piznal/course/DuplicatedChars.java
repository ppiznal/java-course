package pl.piznal.course;

import static java.lang.String.format;
import static java.util.stream.Collectors.toSet;
import java.util.function.Predicate;
import java.util.stream.IntStream;

public class DuplicatedChars {
  public static void main(String[] args) {
    int attempts = 10;
    long start, finish;

    System.out.println("Starting stream version for Jaskolka");
    start = System.currentTimeMillis();
    IntStream.range(1, attempts).forEach(i -> notDuplicatedCharacters.test("Jaskolka"));
    finish = System.currentTimeMillis();
    System.out.println(format("It took %d miliseconds for %d attemps", finish - start, attempts));

    System.out.println("Starting algo version for Jaskolka");
    start = System.currentTimeMillis();
    IntStream.range(1, attempts).forEach(i -> notDuplicatedCharactesAlgo("Jaskolka"));
    finish = System.currentTimeMillis();
    System.out.println(format("It took %d miliseconds for %d attemps", finish - start, attempts));

    System.out.println("Starting stream version for Wilk");
    start = System.currentTimeMillis();
    IntStream.range(1, attempts).forEach(i -> notDuplicatedCharacters.test("Wilk"));
    finish = System.currentTimeMillis();
    System.out.println(format("It took %d miliseconds for %d attemps", finish - start, attempts));


    System.out.println("Starting algo version for Wilk");
    start = System.currentTimeMillis();
    IntStream.range(1, attempts).forEach(i -> notDuplicatedCharactesAlgo("Wilk"));
    finish = System.currentTimeMillis();
    System.out.println(format("It took %d miliseconds for %d attemps", finish - start, attempts));
  }


  static Predicate<String> notDuplicatedCharacters =
      s -> s.chars().boxed().collect(toSet()).size() == s.length();

  static boolean notDuplicatedCharactesAlgo(String str) {
    char[] chars = str.toCharArray();
    char[] temp = new char[str.length()];

    for (int i = 0; i < chars.length; i++) {
      for (int j = 0; j < temp.length; j++) {
        if (temp[j] == chars[i]) {
          return false;
        }
      }
      temp[i] = chars[i];
    }

    return true;
  }
}
