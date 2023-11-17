package findLineWithMaxWords;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

// Напишіть програму, яка отримає рядок з максимальною кількістю слів із заданого файлу.
public class TextWorker {
    public String findLineWithMaxWords(String userDirectory, String fileName) throws IOException {
        List<String> lines = readLines(userDirectory, fileName);

        String res = "";
        int maxN = 0;
        for(String l: lines) {
            int currentN = countWordsInALine(l);
            if(currentN > maxN) {
                maxN = currentN;
                res = l;
            }
        }
        System.out.println("Number of words in a line: " + maxN);
        return res;
    }

    public String[] lineToArrOfWords(String line) {
        Pattern pattern = Pattern.compile("[ ,!;.]+");
        String[] s = pattern.split(line);
        return s;
    }

    public int countWordsInALine(String line) {
        return lineToArrOfWords(line).length;
    }

    public List<String> readLines(String userDirectory, String fileName) throws IOException {
        BufferedReader reader;

        List<String> lines = new ArrayList<>();
        reader = new BufferedReader(new FileReader(userDirectory+"/"+ fileName));
        String line = reader.readLine();
        while (line != null) {
            lines.add(line);
            line = reader.readLine();
        }
        reader.close();

        return lines;
    }
}
