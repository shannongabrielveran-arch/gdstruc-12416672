import java.util.Objects;

public class Player {
    private int playerid;
    private String username;
    private int level;

    public Player(int id, int level, String name) {
        this.playerid = id;
        this.level = level;
        this.username = name;
    }

    public int getPlayerId() {
        return playerid;
    }

    public void setPlayerId(int id) {
        this.playerid = id;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getUserName() {
        return username;
    }

    public void setUsername(String name) {
        this.username = name;
    }

    @Override
    public String toString() {
        return "Player{" +
                "playerid=" + playerid +
                ", username='" + username + '\'' +
                ", level=" + level +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return playerid == player.playerid && level == player.level && Objects.equals(username, player.username);
    }

    @Override
    public int hashCode() {
        return Objects.hash(playerid, username, level);
    }
}