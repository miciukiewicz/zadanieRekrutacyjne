import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class Main {

    private static final String FILENAME = "zadanie.txt";
    private static final String WORD_REGEX = "[^a-zA-ZąćęłńóśżźĄĆĘŁŃÓŚŹŻ0-9]+";

    private static Map<String, LinesCounter> wordsCounterMap = new TreeMap<>();

    public static void main(String[] args) throws IOException {
        findWords(readFile());
        for (String s : wordsCounterMap.keySet()) {
            System.out.println(s + " " + wordsCounterMap.get(s));
        }
    }

    private static BufferedReader readFile() throws FileNotFoundException {
        FileReader file = new FileReader(FILENAME);
        BufferedReader bufferedReader = new BufferedReader(file);
        return bufferedReader;
    }

    private static void findWords(BufferedReader bufferedReader) throws IOException {
        String line;
        Integer lineCounter = 0;
        while ((line = bufferedReader.readLine()) != null) {
            lineCounter += 1;
            processLine(line, lineCounter);
        }
    }

    private static void processLine(String line, Integer lineCounter) {
        String[] words = splitLine(line);
        for (int i = 0; i < words.length; i++) {
            insertWord(words[i], lineCounter);
        }
    }

    private static String[] splitLine(String line) {
        return line.split(WORD_REGEX);
    }

    private static void insertWord(String word, Integer lineCounter) {
        if (word.isEmpty()) {
            return;
        }
        if (wordsCounterMap.containsKey(word)) {
            wordsCounterMap.get(word).addNewValue(lineCounter);
        } else {
            wordsCounterMap.put(word, new LinesCounter(lineCounter));
        }
    }
}