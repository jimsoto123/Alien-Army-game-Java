
// BattleStrategy interface defines the contract for battle strategies.
interface BattleStrategy {
    void executeStrategy();
}

// Concrete strategy for aggressive behavior.
class AggressiveBattleStrategy implements BattleStrategy {
    @Override
    public void executeStrategy() {
        System.out.println("Charging forward with full force and unleashing powerful attacks!");
    }
}

// Concrete strategy for defensive behavior.
class DefensiveBattleStrategy implements BattleStrategy {
    @Override
    public void executeStrategy() {
        System.out.println("Taking a defensive stance, blocking attacks, and waiting for the perfect counter opportunity.");
    }
}

// BattleContext class that holds a reference to a BattleStrategy.
class BattleContext {
    private BattleStrategy battleStrategy;

    // Constructor to set the initial battle strategy.
    public BattleContext(BattleStrategy battleStrategy) {
        this.battleStrategy = battleStrategy;
    }

    // Allows changing the battle strategy at runtime.
    public void setBattleStrategy(BattleStrategy battleStrategy) {
        this.battleStrategy = battleStrategy;
    }

    // Executes the current battle strategy.
    public void executeBattleStrategy() {
        battleStrategy.executeStrategy();
    }
}

//// Demo class to illustrate the Strategy pattern with battle strategies.
//public class BattleStrategyDemo {
//    public static void main(String[] args) {
//        // Create a battle context with an aggressive strategy.
//        BattleContext battleContext = new BattleContext(new AggressiveBattleStrategy());
//        System.out.println("Current Strategy:");
//        battleContext.executeBattleStrategy();
//
//        // Switch to a defensive strategy during the battle.
//        System.out.println("\nSwitching Strategy:");
//        battleContext.setBattleStrategy(new DefensiveBattleStrategy());
//        battleContext.executeBattleStrategy();
//    }
//}
