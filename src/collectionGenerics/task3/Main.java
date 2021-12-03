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

import static java.util.Collections.sort;


public class Main {
    public static void main(String[] args) throws IOException {
        File file = new File("texttask3.txt");
        char[] chars = readFile(file);
        ArrayList<AlphabetCharClass> alphabetCharList = getAlphabetChars(chars);
        //   sort(alphabetCharList, new MyComparator<AlphabetCharClass>());
        for (AlphabetCharClass a : alphabetCharList) {
            System.out.println(a.getCharacter() + " -> count:  " + a.getRepeatabilityCharacter());
        }
    }

    private static ArrayList<AlphabetCharClass> getAlphabetChars(char[] chars) {
        Set<AlphabetCharClass> set = new HashSet<>();
        for (char aChar : chars) {
            if (Character.isLetter(aChar)) {
                AlphabetCharClass charClass = new AlphabetCharClass();
                charClass.setCharacter(aChar);
                set.add(charClass);
            }
        }
        ArrayList<AlphabetCharClass> arrayList = new ArrayList<>(set);
        for (Character aChar : chars) {
            if (Character.isLetter(aChar)) {
                // currentChar = Character.toLowerCase(currentChar);
                for (AlphabetCharClass a : arrayList) {
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