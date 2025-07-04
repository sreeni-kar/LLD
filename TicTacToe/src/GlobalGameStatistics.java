import java.util.HashMap;
import java.util.PriorityQueue;

//Making this a singleton class as it must never be reinstantiated!!!
public class GlobalGameStatistics {
    private static final GlobalGameStatistics instance = new GlobalGameStatistics();
    private final HashMap<Integer, PlayerStats> playerStatsHashMap;

    private GlobalGameStatistics() {
        playerStatsHashMap = new HashMap<>();
    }

    public static GlobalGameStatistics getInstance() {
        return instance;
    }

    public void updateWin(PlayerProfile playerProfile) {
        int id = playerProfile.getId();
        if (!playerStatsHashMap.containsKey(id)) {
            playerStatsHashMap.put(id, new PlayerStats(playerProfile.getName(), 1, 0, 0));
        } else {
            int wins = playerStatsHashMap.get(id).getWins();
            playerStatsHashMap.get(id).setWins(wins + 1);
        }
    }

    public void updateLoss(PlayerProfile playerProfile) {
        int id = playerProfile.getId();
        if (!playerStatsHashMap.containsKey(id)) {
            playerStatsHashMap.put(id, new PlayerStats(playerProfile.getName(), 0, 1, 0));
        } else {
            int losses = playerStatsHashMap.get(id).getLosses();
            playerStatsHashMap.get(id).setLosses(losses + 1);
        }
    }

    public void upDateDraw(PlayerProfile playerProfile) {
        int id = playerProfile.getId();
        if (!playerStatsHashMap.containsKey(id)) {
            playerStatsHashMap.put(id, new PlayerStats(playerProfile.getName(), 0, 0, 1));
        } else {
            int draws = playerStatsHashMap.get(id).getDraws();
            playerStatsHashMap.get(id).setDraws(draws + 1);
        }
    }

    public void getPlayerRankings() {
        PriorityQueue<PlayerStats> playerStats = new PriorityQueue<>((a, b) -> {
            double winPercentageA = (double) a.wins / (double) (a.wins + a.losses + a.draws);
            double winPercentageB = (double) b.wins / (double) (b.wins + b.losses + b.draws);

            return Double.compare(winPercentageB, winPercentageA);
        });

        for (int id : playerStatsHashMap.keySet()) {
            playerStats.add(playerStatsHashMap.get(id));
        }

        int rank = 1;
        System.out.println("Player Rankings :");
        while (!playerStats.isEmpty()) {
            PlayerStats stats = playerStats.poll();
            System.out.println("Rank " + rank + " : " + stats.getName());
            System.out.println("WINS : " + stats.getWins());
            System.out.println("LOSSES : " + stats.getLosses());
            System.out.println("DRAWS : " + stats.getDraws());
            System.out.println("Win Percentage : " + (stats.getWins() / (double)(stats.getWins() + stats.getLosses() + stats.getDraws())) * 100 + "%");
            System.out.println();
            rank++;
        }
    }
}
