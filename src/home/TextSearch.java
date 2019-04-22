package home;

import java.util.ArrayList;
import java.util.List;

public class TextSearch {

    /**
     * Поиск слова/части слова в тексте
     *
     * @param text - текст, в котором необходимо выполнить поиск
     * @param wrd -  слово / часть слова / буква для поиска
     *
     * */

    public static String search (String text, String wrd) {
        if (text.length()>0 && wrd.length()>0) {
            String[] arr = text.toLowerCase().split(" ");
            String word = wrd.toLowerCase();
            StringBuilder global = new StringBuilder();
            StringBuilder oneGet;
            int count = 0;

            for (int i = 0; i < arr.length; i++) {
                if (arr[i].trim().contains(word.trim())) {
                    count++;
                    oneGet = new StringBuilder();
                    String[] txtWord = arr[i].split("");
                    String[] wordArr = word.split("");
                    List<String> check = new ArrayList<>();

                    for (int j = 0; j < txtWord.length; j++) {
                        for (String w : wordArr) {
                            if (!check.contains(w)) {
                                if (w.equals(txtWord[j])) {
                                    oneGet.append(w.toUpperCase());
                                    check.add(w.toUpperCase());
                                    break;
                                }
                            }
                        }
                        if (!(check.contains(txtWord[j]) || check.contains(txtWord[j].toUpperCase()))) {
                            oneGet.append(txtWord[j]);
                            check.add(txtWord[j]);
                        }
                    }
                    global.append(oneGet.toString() + " ");
                } else {
                    global.append(arr[i] + " ");
                }
            }
            System.out.println("совпадений: " + count);
            return global.toString();
        } else {
            return "текст для поиска, а так же искомое слово/буква не могут быть пустыми";
        }
    }
}
