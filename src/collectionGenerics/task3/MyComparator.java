package collectionGenerics.task3;

import java.util.Comparator;

public class MyComparator<T> implements Comparator<AlphabetCharContainer> {
    @Override
    public int compare(AlphabetCharContainer o1, AlphabetCharContainer o2) {
        return o1.getCharacter().compareTo(o2.getCharacter());
    }
}
