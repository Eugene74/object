package collectionGenerics.task3;


import java.util.Objects;

public class AlphabetCharContainer implements Comparable<AlphabetCharContainer> {
    private Character character;
    private long repeatabilityCharacter = 0;

    public Character getCharacter() {
        return character;
    }

    public void setCharacter(Character character) {
        this.character = character;
    }

    public long getRepeatabilityCharacter() {
        return repeatabilityCharacter;
    }

    public void setRepeatabilityCharacter(long repeatabilityCharacter) {
        this.repeatabilityCharacter += repeatabilityCharacter;
    }

    @Override
    public int compareTo(AlphabetCharContainer o) {
        return this.getCharacter().compareTo(o.getCharacter());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AlphabetCharContainer that = (AlphabetCharContainer) o;
        return character.equals(that.character);
    }

    @Override
    public int hashCode() {
        return Objects.hash(character);
    }
}
