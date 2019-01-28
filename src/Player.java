public class Player implements Comparable<Player> {

    private int playerId;
    private int trustFactor;
    private boolean spy;

    Player(int playerId, boolean spy) {
        this.playerId = playerId;
        this.trustFactor = 0;
        this.spy = spy;
    }

    int getPlayerId() {
        return playerId;
    }

    int getTrustFactor() {
        return trustFactor;
    }

    boolean isSpy() {
        return spy;
    }

    void setTrustFactor(int trustFactor) {
        this.trustFactor = trustFactor;
    }

    @Override
    public int compareTo(Player player) {
        return Integer.compare(this.trustFactor, player.getTrustFactor());
    }
}
