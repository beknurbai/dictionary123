package com.company;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Map<String, String[]> dictionary = new HashMap<>();
        Map<String, String[]> dictionaryBig = new HashMap<>();

        dictionary.put("красный", new String[]{"лиловый", "бордовый",
                "красивый", "румяный", "срочный"});
        dictionary.put("большой", new String[]{"огромный", "громадный",
                "колоссальный", "великий"});
        dictionary.put("дом", new String[]{"жилище", "хата", "кров"});
        dictionary.put("человек", new String[]{"персона", "индивидуум",
                "лицо", "личность"});

        Set<String> keys = dictionary.keySet();
        Iterator iter = keys.iterator();
        while (iter.hasNext()) {
            String key = iter.next().toString();
            String[] values = dictionary.get(key);
            dictionaryBig.put(key, values);
            for (int i =0; i<values.length;i++) {
                String budushiyKlyuch = values[i];
                ArrayList<String> strArr = new ArrayList<>(values.length);
                strArr.addAll(Arrays.asList(values));
                strArr.remove(budushiyKlyuch);
                strArr.add(key);
                String[] newVals = new String[strArr.size()];
                newVals = strArr.toArray(newVals);
                dictionaryBig.put(budushiyKlyuch, newVals);
            }
        }

        System.out.println("Введите слово: ");
        Scanner sc = new Scanner(System.in);
        String sentences = sc.nextLine();
        String[] words = sentences.split(" ");
        for (String word : words) {
            String[] rephrases = dictionaryBig.get(word);
            Random r = new Random();
            if (rephrases != null) {
                System.out.printf(" " + rephrases[r.nextInt(rephrases.length - 1)]);
            } else {
                System.out.printf(" ТАКОГО СЛОВА НЕТ");
            }
        }
    }
}

