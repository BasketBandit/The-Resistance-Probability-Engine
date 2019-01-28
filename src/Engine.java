import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class Engine {

    static Integer[] choosePlayers(ArrayList<Player> players, Integer playersNeeded) {
        boolean equalTrust = true;
        int previousPlayerTrust = players.get(0).getTrustFactor();
        for(Player player : players) {
            if(previousPlayerTrust == players.get(0).getTrustFactor()) {
                previousPlayerTrust = player.getTrustFactor();
                continue;
            }
            if(player.getTrustFactor() != previousPlayerTrust) {
                equalTrust = false;
                break;
            }
        }

        if(equalTrust) {
            Collections.shuffle(players);
            return select(playersNeeded, players);
        } else {
            Collections.sort(players);
            Collections.reverse(players);
            return select(playersNeeded, players);
        }
    }

    private static Integer[] select(int playersNeeded, ArrayList<Player> players) {
        switch(playersNeeded) {
            case 2:
                return new Integer[]{players.get(0).getPlayerId(), players.get(1).getPlayerId()};
            case 3:
                return new Integer[]{players.get(0).getPlayerId(), players.get(1).getPlayerId(), players.get(2).getPlayerId()};
            case 4:
                return new Integer[]{players.get(0).getPlayerId(), players.get(1).getPlayerId(), players.get(2).getPlayerId(), players.get(3).getPlayerId()};
            case 5:
                return new Integer[]{players.get(0).getPlayerId(), players.get(1).getPlayerId(), players.get(2).getPlayerId(), players.get(3).getPlayerId(), players.get(4).getPlayerId()};
            default:
                return null;
        }
    }

    static ArrayList<Boolean> simulateRound(Resistance instance, Integer[] players, Integer round) {
        ArrayList<Boolean> actions = new ArrayList<>();
        List<Integer> playerIds = Arrays.asList(players);
        boolean failChosen = false;

        if(round != 1) { // Assuming everyone votes true first round (Set this to force a true vote on a certain round.)
            for(Player playerObj : instance.getPlayers()) {
                if(playerIds.contains(playerObj.getPlayerId())) {
                    if(!playerObj.isSpy()) {
                        actions.add(true);
                        continue;
                    }
                    if(!failChosen) {
                        failChosen = true;
                        actions.add(false);
                    } else {
                        actions.add(true);
                    }
                }
            }
        } else {
            for(Integer player : players) {
                actions.add(true);
            }
        }

        if(failChosen) {
            for(Player playerObj : instance.getPlayers()) {
                if(playerIds.contains(playerObj.getPlayerId())) {
                    playerObj.setTrustFactor(playerObj.getTrustFactor() - 1);
                }
            }
            instance.setFailCount(instance.getFailCount() + 1);
        } else {
            for(Player playerObj : instance.getPlayers()) {
                if(playerIds.contains(playerObj.getPlayerId())) {
                    playerObj.setTrustFactor(playerObj.getTrustFactor() + 1);
                }
            }
            instance.setPassCount(instance.getPassCount() + 1);
        }
        return actions;
    }

}
