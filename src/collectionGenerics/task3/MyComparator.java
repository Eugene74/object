package collectionGenerics.task3;

import java.util.Comparator;

public class MyComparator<T> implements Comparator<AlphabetCharClass> {
    @Override
    public int compare(AlphabetCharClass o1, AlphabetCharClass o2) {
        return o1.getCharacter().compareTo(o2.getCharacter());
    }
}
