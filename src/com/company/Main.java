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
                String futureKey = values[i];
                ArrayList<String> strArr = new ArrayList<>(values.length);
                strArr.addAll(Arrays.asList(values));
                strArr.remove(futureKey);
                strArr.add(key);
                String[] newValues = new String[strArr.size()];
                newValues = strArr.toArray(newValues);
                System.out.println(futureKey
                    + " - " + Arrays.toString(newValues));
                dictionaryBig.put(futureKey, newValues);
            }
        }

        System.out.println("Введите слово: ");
        Scanner sc = new Scanner(System.in);
        String sentences = sc.nextLine();
        String[] words = sentences.split(" ");
        for (String word : words) {
            String[] sinonims = dictionaryBig.get(word);
            Random r = new Random();
            if (sinonims != null) {
                System.out.printf(" " + sinonims[r.nextInt(sinonims.length - 1)]);
            } else {
                System.out.printf(" ТАКОГО СЛОВА НЕТ");
            }
        }
    }
}

