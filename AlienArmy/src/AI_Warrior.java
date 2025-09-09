public class AI_Warrior implements Warrior {
    private int aliensObserved;

    @Override
    public void update(int aliensObserved) {
        this.setAliensObserved(aliensObserved);

    }

    public void setAliensObserved(int aliensObserved) {
        this.aliensObserved = aliensObserved;
    }

    public int getAliensObserved(){

        return aliensObserved;
    }
}
