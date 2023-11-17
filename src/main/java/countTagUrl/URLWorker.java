package countTagUrl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class URLWorker {
    public static Map<String, Integer> countTags(String str) throws IOException {
        URL url = new URL(str);
        Map<String, Integer> Tags = new HashMap<>();

        URLConnection connection = url.openConnection();
        BufferedReader in = new BufferedReader(new InputStreamReader(
                connection.getInputStream()));


        Pattern tagPattern = Pattern.compile("<(\\w+)(\\s|>)");
        String input;
        while ((input = in.readLine()) != null) {

            Matcher matcher = tagPattern.matcher(input);

            while (matcher.find()) {
                String tagName = matcher.group(1);
                Tags.put(tagName, Tags.getOrDefault(tagName, 0) + 1);
            }

        }

        in.close();
        return Tags;

    }

    static public Map<String, Integer> sortByAlphabet(Map<String, Integer> tags) {
        return new TreeMap<>(tags);
    }

    static public Map<String, Integer> sortByFrequency(Map<String, Integer> tags) {
        return tags.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue())
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (oldValue, newValue) -> oldValue, LinkedHashMap::new));
    }
}
