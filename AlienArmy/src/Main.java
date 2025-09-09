import java.util.InputMismatchException;
import java.util.Scanner;

import static java.lang.Math.ceil;
import static java.lang.Math.floor;

public class Main {
    public static void main(String[] args) {

        // create class instances
        Telescope telescope = new Telescope();
        Satellite satellite = new Satellite();
        AI_Warrior warrior = new AI_Warrior();
        // add observers
        telescope.addObserver(warrior);
        satellite.addObserver(warrior);

        System.out.println("\nWelcome to my Alien Invasion game.\n");
        // initial character values
        int warriorHP = 100;
        int totalAlienCount = 60;
        int visibility = 10;
        Double currentAlienCount;
        Scanner scanner = new Scanner(System.in);

        // game loop start
        // set replay to 1 once
        Integer replay = 1;

        while (replay == 1) {
            System.out.println("The game has started\n");
            BattleContext battleContext = new BattleContext(new AggressiveBattleStrategy());

            while (warriorHP > 0 && totalAlienCount > 0) {

                System.out.println("Choose your attack type\n\nPlease input '1' for Full attack or '2' for Partial attack.\n");
                try {
                    int attackType = scanner.nextInt();
                    if (attackType == 1) {
                        battleContext.setBattleStrategy(new AggressiveBattleStrategy());
                        battleContext.executeBattleStrategy();
                        currentAlienCount = ceil(totalAlienCount * 0.8);
                        warriorHP = warriorHP - (visibility + currentAlienCount.intValue());
                        telescope.setAliensObserved(currentAlienCount.intValue());
                        warrior.update(telescope.getAliensObserved());
                    }
                    if (attackType == 2) {
                        battleContext.setBattleStrategy(new DefensiveBattleStrategy());
                        battleContext.executeBattleStrategy();

                        // input aliens to attack with
                        System.out.println("Please choose the amount of Aliens you want to attack with.\nCurrent Alien army strength: " + totalAlienCount);
                        Integer parAttCount = scanner.nextInt();
                        if (parAttCount <= totalAlienCount) {
                            warriorHP = warriorHP - (visibility + parAttCount);
                            Double aliensObserved = floor(parAttCount.doubleValue() / 2);
                            satellite.setAliensObserved(aliensObserved.intValue());
                            warrior.update(satellite.getAliensObserved());
                        } else {
                            System.out.println("Not enough aliens to attack with, restart the game.");

                        }
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Please restart the game and input a number");
                }
                // make sure visibility is atleast 1 after the warrior attacks
                if (visibility >= 2) {
                    visibility -= 2;
                }
                System.out.println("Current Warrior HP: " + warriorHP + "\n");
                System.out.println("Warrior has lost 2 visibility but now attacks all visible aliens being: " + warrior.getAliensObserved() + "\n");

                totalAlienCount = totalAlienCount - (warrior.getAliensObserved() + visibility);
                System.out.println("Current Alien Army strength with visibility considered: " + totalAlienCount + "\n");
                System.out.println("Warrior has gained 1 visibility after attacking!\n\n");
                visibility += 1;
                if (totalAlienCount <= 0) System.out.println("You Lose!!");
                else if (warriorHP <= 0) System.out.println("You Win!!");
                replay = 0;
            }
            System.out.println("Do you wish to restart?\n\nInput '1' for restart and '0' for finish");
            replay = scanner.nextInt();
            if (replay == 1) {

                warriorHP = 100;
                totalAlienCount = 100;
            } else {
                System.out.println("Thank you for playing!!");
            }


        }
    }
}




