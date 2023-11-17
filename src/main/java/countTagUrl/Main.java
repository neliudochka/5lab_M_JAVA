package countTagUrl;

import java.io.IOException;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        String url = "https://docs.oracle.com/javase/tutorial/networking/urls/readingWriting.html";
        Map<String, Integer> Tags;
        try {
            Tags = URLWorker.countTags(url);
            System.out.println(Tags);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        //за алфавітом
        Map<String, Integer> TagsByAlphabet = URLWorker.sortByAlphabet(Tags);
        System.out.println(TagsByAlphabet);

        //за збільшенням частоти
        Map<String, Integer> TagsByFrequency = URLWorker.sortByFrequency(Tags);
        System.out.println(TagsByFrequency);

    }
}
