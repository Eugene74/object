package collectionGenerics.task3;

import java.util.Comparator;

public class MyComparator implements Comparator<AlphabetCharContainer> {
    @Override
    public int compare(AlphabetCharContainer o1, AlphabetCharContainer o2) {
        int i=0;
        long tmp = o1.getRepeatabilityCharacter() - (o2.getRepeatabilityCharacter());
        if (tmp > 0) {
            i =-1;
        }
        if (tmp < 0) {
            i = 1;
        }
        return i;
    }
}
