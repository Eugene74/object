package collectionGenerics.task3;


import java.util.Objects;

public class AlphabetCharClass implements Comparable<AlphabetCharClass> {
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
    public int compareTo(AlphabetCharClass o) {
        return this.getCharacter().compareTo(o.getCharacter());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AlphabetCharClass that = (AlphabetCharClass) o;
        return character.equals(that.character);
    }

    @Override
    public int hashCode() {
        return Objects.hash(character);
    }
}
