import java.util.ArrayList;
import java.util.List;

public class Telescope {
    private int aliensObserved;
    private List<Warrior> warriors = new ArrayList<>();

    public void addObserver(Warrior warrior) {
        this.warriors.add(warrior);
    }

    public void setAliensObserved(int aliensObserved) {
        this.aliensObserved = aliensObserved;
        for (Warrior warrior  : this.warriors) {
            warrior.update(this.aliensObserved);
        }
    }
    public int getAliensObserved() {
        this.aliensObserved = aliensObserved;
        return aliensObserved;
    }
}