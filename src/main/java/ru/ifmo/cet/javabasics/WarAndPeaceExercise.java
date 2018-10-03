package ru.ifmo.cet.javabasics;
import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import javax.swing.text.html.parser.Entity;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.FileReader;
import java.util.*;
import java.io.File;
import java.io.FileReader;

import static java.nio.file.Files.readAllLines;


public class WarAndPeaceExercise {
    public static Map<String, Integer> words = new HashMap<>();
    public static String warAndPeace() throws IOException {
        final Path tome12Path = Paths.get("src", "main", "resources", "WAP12.txt");
        final Path tome34Path = Paths.get("src", "main", "resources", "WAP34.txt");
        findWord(tome12Path);
        findWord(tome34Path);

        List<Map.Entry<String,Integer>> sortMap = new ArrayList<>(words.entrySet());

        Collections.sort(sortMap, new Comparator<Map.Entry<String,Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                if(o1.getValue().equals(o2.getValue()))
                    return o1.getKey().compareTo(o2.getKey());
                else
                    return o2.getValue().compareTo(o1.getValue());
            }
        });

        String result = "";
        for(Map.Entry entry: sortMap){
            String key = (String) entry.getKey();
            Integer value = (Integer) entry.getValue();
            if (value >= 10) {
                result += key + " - " + value + "\n";
            }
        }
        return result.substring(0,result.length()-1);
        //throw new UnsupportedOperationException(result.substring(0,result.length() - 1));
    }

    private static void findWord(Path path) throws IOException {
        for (String line : readAllLines(path, Charset.forName("windows-1251"))) {
            line = line.replaceAll("[^а-яА-Яa-zA-Z]", " ");
            for (String word : line.split(" ")) {
                if (word.length() > 3) {
                    word = word.toLowerCase();
                    if (words.containsKey(word)) {
                        words.put(word, words.get(word) + 1);
                    } else {
                        words.put(word, 1);
                    }
                }
            }
        }
    }
}