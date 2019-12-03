package Day2;

public class Point {
    int noun;
    int verb;
    boolean found = false;

    public Point(int noun, int verb, boolean found) {
        this.noun = noun;
        this.verb = verb;
        this.found = found;
    }
    public boolean isFound(){
        return (boolean) found;
    }

    public int getNoun() {
        return noun;
    }

    public int getVerb() {
        return verb;
    }

    @Override
    public String toString() {
        return "Point{" +
                "verb=" + noun +
                ", neun=" + verb +
                ", found=" + found +
                '}';
    }
}