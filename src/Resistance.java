import java.util.ArrayList;

public class Resistance {

    private ArrayList<Player> players = new ArrayList<>();
    private ArrayList<Integer> rounds = new ArrayList<>();
    private int passCount = 0;
    private int failCount = 0;

    public Resistance(int playerCount) {
        int spies = 0;
        switch(playerCount) {
            case 5:
            case 6:
                spies = 2;
                break;
            case 7:
            case 8:
            case 9:
                spies = 3;
                break;
            case 10:
                spies = 4;
        }

        // Setup Players
        for(int i = 0; i < playerCount; i++) {
            if(spies > 0) {
                players.add(new Player(i, true));
                spies--;
            } else {
                players.add(new Player(i, false));
            }
        }

        // Setup Rounds
        switch(playerCount) {
            case 5:
                rounds.add(2);
                rounds.add(3);
                rounds.add(2);
                rounds.add(3);
                rounds.add(3);
                break;
            case 6:
                rounds.add(2);
                rounds.add(3);
                rounds.add(4);
                rounds.add(3);
                rounds.add(4);
                break;
            case 7:
                rounds.add(2);
                rounds.add(3);
                rounds.add(3);
                rounds.add(4);
                rounds.add(4);
                break;
            case 8:
            case 9:
            case 10:
                rounds.add(3);
                rounds.add(4);
                rounds.add(4);
                rounds.add(5);
                rounds.add(5);
        }
    }

    ArrayList<Player> getPlayers() {
        return players;
    }

    ArrayList<Integer> getRounds() {
        return rounds;
    }

    int getFailCount() {
        return failCount;
    }

    int getPassCount() {
        return passCount;
    }

    void setFailCount(int failCount) {
        this.failCount = failCount;
    }

    void setPassCount(int passCount) {
        this.passCount = passCount;
    }
}
