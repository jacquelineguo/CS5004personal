package finalExam.p3;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StringProcessor2 {

  public StringProcessor2() {
  }

  public static List<ReplacementInfo> replaceAndRepeatLetters(char sourceChar, char destChar,
      int numRepetitions, List<String> stringList){

    //YOUR CODE HERE
    return stringList.stream()
        .map(s -> new ReplacementInfo(s, replaceString(s, sourceChar, destChar, numRepetitions).
            equals(s) ? null : replaceString(s, sourceChar, destChar, numRepetitions),
            s.chars().filter(c -> c == sourceChar).count()))
        .collect(Collectors.toList());
  }


  public static String replaceString(String string, char sourceChar,
      char destChar, int numRepetitions) {
    return string.chars()
        .mapToObj(c -> (char) c)
        .map(c -> c == sourceChar ? repeatLetter(destChar, numRepetitions) :
            c.toString())
        .collect(Collectors.joining());
  }

  private static String repeatLetter(char chr, int numRepetitions) {
    String newChr = "";
    for (int i = 0; i < numRepetitions; i++){
      newChr += chr;
    }
    return newChr;
  }
}
