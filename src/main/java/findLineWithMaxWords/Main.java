package findLineWithMaxWords;

import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) {
      String fileName = "input.txt";
      String userDirectory = Paths.get("")
              .toAbsolutePath()
              .toString();
      System.out.println(userDirectory+"/"+fileName);

      try {
          TextWorker findLineWithMaxWords = new TextWorker();
          String res = findLineWithMaxWords.findLineWithMaxWords(userDirectory, fileName);

          System.out.println(res);
      } catch (Exception e) {
          throw new RuntimeException(e.getMessage());
      }
    }
}
