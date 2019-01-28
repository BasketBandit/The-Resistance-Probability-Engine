import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.concurrent.atomic.AtomicInteger;

class Console {

    private static Resistance instance;
    private boolean display;

    Console(int players, int simulationCount, boolean display) {
        this.display = display;
        instance = new Resistance(players);

        double totalSpyWins = 0.0;
        double totalResistanceWins = 0.0;

        for(int i = 0; i < simulationCount; i++) {
            if(display) {
                printSettings();
            }
            if(simulate()) {
                totalResistanceWins++;
            } else {
                totalSpyWins++;
            }
            instance = new Resistance(players);
            if(display) {
                System.out.println();
            }
        }

        System.out.println("##########################################");
        System.out.println("R: " + totalResistanceWins + " - " + (totalResistanceWins / simulationCount) * 100 + "%");
        System.out.println("S: " + totalSpyWins + " - " + (totalSpyWins / simulationCount) * 100 + "%");
        System.out.println("##########################################");
    }

    private boolean simulate() {
        Integer[] players;

        for(int i = 0; i < instance.getRounds().size(); i++) {
            if(display) {
                System.out.println("Round: " + (i + 1) + ", Players on mission: " + instance.getRounds().get(i));
                System.out.println("------------------------------------------");
            }
            players = Engine.choosePlayers(instance.getPlayers(), instance.getRounds().get(i));
            if(display) {
                printChosenPlayers(players);
            }
            if(printRoundOutcome(Engine.simulateRound(instance, players, i + 1))) {
                return false;
            }
            if(instance.getPassCount() == 3) {
                break;
            }
        }
        return true;
    }

    private void printSettings() {
        AtomicInteger spies = new AtomicInteger();
        instance.getPlayers().forEach(player -> {
            if(player.isSpy()) {
                spies.getAndIncrement();
            }
        });

        System.out.println("##########################################");
        System.out.println("Players: " + instance.getPlayers().size());
        System.out.println("Spies: " + spies);
        System.out.println("Round Composition: " + instance.getRounds().toString());
        System.out.println("##########################################");
    }

    private void printChosenPlayers(Integer[] playerIds) {
        instance.getPlayers().forEach(player -> {
            if(Arrays.asList(playerIds).contains(player.getPlayerId())) {
                System.out.println("Player: " + player.getPlayerId() + ", " + "Spy? " + player.isSpy() + ", " + "Trust Factor: " + player.getTrustFactor());
            }
        });
    }

    private boolean printRoundOutcome(ArrayList<Boolean> decisions) {
        Collections.reverse(decisions);

        if(display) {
            System.out.println("------------------------------------------");
            System.out.println(decisions.toString());
        }
        if(instance.getFailCount() == 3) {
            if(display) {
                System.out.println("                 Spies WIN                ");
                System.out.println("------------------------------------------");
            }
            return true;
        } else if(instance.getPassCount() == 3) {
            if(display) {
                System.out.println("              Resistance WIN              ");
                System.out.println("------------------------------------------");
            }
            return false;
        } else {
            if(display) {
                System.out.println("------------------------------------------");
                System.out.println();
                System.out.println();
            }
            return false;
        }

    }
}
