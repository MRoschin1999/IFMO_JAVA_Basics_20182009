package ru.ifmo.cet.javabasics;

import javax.swing.text.html.parser.Entity;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.FileReader;
import java.util.*;
import java.io.File;
import java.io.FileReader;


public class WarAndPeaceExercise {

    public static String warAndPeace() throws IOException {
        final Path tome12Path = Paths.get("src", "main", "resources", "WAP12.txt");
        final Path tome34Path = Paths.get("src", "main", "resources", "WAP34.txt");

        String strPath12 = tome12Path.toString();
        String content12 = new String(Files.readAllBytes(Paths.get(strPath12)));
        content12 = content12.toLowerCase();

        String strPath34 = tome34Path.toString();
        String content34 = new String(Files.readAllBytes(Paths.get(strPath34)));
        content34 = content34.toLowerCase();

        String[] subStr1;
        subStr1 = content12.split("[^a-zA-Zа-яА-Я]");
        String[] subStr2;
        subStr2 = content34.split("[^a-zA-Zа-яА-Я]");

        ArrayList<String> subStr = new ArrayList<>();

        subStr.addAll(Arrays.asList(subStr1));
        subStr.addAll(Arrays.asList(subStr2));
        Map<String, Integer> words = new HashMap<>();

        for (String aSubStr : subStr) {
            if ((aSubStr.length() > 3)) {
                if (!words.containsKey(aSubStr))
                    words.put(aSubStr, 1);
                else {
                    words.put(aSubStr, words.get(aSubStr) + 1);
                }
            }
        }

        List<Map.Entry<String,Integer>> sortMap = new ArrayList<>(words.entrySet());

        sortMap.sort(new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                if (o1.getValue().equals(o2.getValue()))
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
        // TODO map lowercased words to its amount in text and concatenate its entries.
        // TODO If word "котик" occurred in text 23 times then its entry would be "котик - 23\n".
        // TODO Entries in final String should be also sorted by amount and then in alphabetical order if needed.
        // TODO Also omit any word with lengths less than 4 and frequency less than 10
        //System.out.println(result);
        return result.substring(0, result.length()-1);
        //throw new UnsupportedOperationException(result);
    }

}