package collectionGenerics.task3;

/*
3) Считайте из файла текст на английском языке, вычислите
относительную частоту повторения каждой буквы и выведите на
экран результат в порядке убывания относительной частоты
повторения.
*/

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws IOException {
        File file = new File("texttask3.txt");
        char[] chars = readFile(file);
        ArrayList<AlphabetCharContainer> alphabetCharList = getAlphabetChars(chars);
        alphabetCharList.sort(new MyComparator());
        for (AlphabetCharContainer a : alphabetCharList) {
            System.out.println(a.getCharacter() + " -> count:  " + a.getRepeatabilityCharacter());
        }
    }

    private static ArrayList<AlphabetCharContainer> getAlphabetChars(char[] chars) {
        Set<AlphabetCharContainer> set = new HashSet<>();
        for (char aChar : chars) {
            if (Character.isLetter(aChar)) {
                AlphabetCharContainer charClass = new AlphabetCharContainer();
                charClass.setCharacter(aChar);
                set.add(charClass);
            }
        }
        ArrayList<AlphabetCharContainer> arrayList = new ArrayList<>(set);
        for (Character aChar : chars) {
            if (Character.isLetter(aChar)) {
                // currentChar = Character.toLowerCase(currentChar);
                for (AlphabetCharContainer a : arrayList) {
                    if (a.getCharacter() == aChar) {
                        a.setRepeatabilityCharacter(1);
                    }
                }
            }
        }
        return arrayList;
    }

    public static char[] readFile(File file) throws IOException {
        try (FileReader fr = new FileReader(file)) {
            char[] chars = new char[(int) file.length()];

            int offset = 0;
            while (offset < chars.length) {
                int result = fr.read(chars, offset, chars.length - offset);
                if (result == -1) {
                    break;
                }
                offset += result;
            }
            return chars;
        }
    }
}
