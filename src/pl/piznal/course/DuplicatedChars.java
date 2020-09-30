package pl.piznal.course;

import static java.lang.String.format;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class DuplicatedChars {
  public static void main(String[] args) {
    int attempts = 10;
    long start, finish;

    System.out.println(
        "Starting stream version for Jaskolka, " + notDuplicatedCharacters.apply("Jaskolka"));
    start = System.currentTimeMillis();
    IntStream.range(1, attempts).forEach(i -> notDuplicatedCharacters.apply("Jaskolka"));
    finish = System.currentTimeMillis();
    System.out.println(format("It took %d miliseconds for %d attemps", finish - start, attempts));

    System.out
        .println("Starting algo version for Jaskolka, " + notDuplicatedCharactesAlgo("Jaskolka"));
    start = System.currentTimeMillis();
    IntStream.range(1, attempts).forEach(i -> notDuplicatedCharactesAlgo("Jaskolka"));
    finish = System.currentTimeMillis();
    System.out.println(format("It took %d miliseconds for %d attemps", finish - start, attempts));

    System.out
        .println("Starting stream version for Wilk, " + notDuplicatedCharacters.apply("Wilk"));
    start = System.currentTimeMillis();
    IntStream.range(1, attempts).forEach(i -> notDuplicatedCharacters.apply("Wilk"));
    finish = System.currentTimeMillis();
    System.out.println(format("It took %d miliseconds for %d attemps", finish - start, attempts));


    System.out.println("Starting algo version for Wilk, " + notDuplicatedCharactesAlgo("Wilk"));
    start = System.currentTimeMillis();
    IntStream.range(1, attempts).forEach(i -> notDuplicatedCharactesAlgo("Wilk"));
    finish = System.currentTimeMillis();
    System.out.println(format("It took %d miliseconds for %d attemps", finish - start, attempts));

    // How set works? https://bulldogjob.pl/news/857-ciekawy-przypadek-ciagu-hashcode-w-javie
    List<Integer> integers = Stream.of(1, 1, 2, 3, 4, 5, 6, 7, 8, 9).collect(Collectors.toList());
    System.out.println(integers.size());
    Set<Integer> integersSet = new HashSet<>(integers);
    System.out.println(integersSet.size());
  }


  // streamed version
  //
  // s.chars() - its IntStream, kind of stream without Objects, but stream with simple int types.
  // why we can treat char as int?
  // https://stackoverflow.com/questions/11671908/can-the-char-type-be-categorized-as-an-integer
  // s.chars().boxed() - stream of Integer java objects (almost same as int, but as object)
  // collect(Collectors.toSet()) - we transform stream of Integers into set. Set is a data structure
  // without duplicates.
  // So if in
  static Function<String, Boolean> notDuplicatedCharacters =
      s -> s.chars().boxed().collect(Collectors.toSet()).size() == s.length();


  // algo version
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
