import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class Board {
    private final int boardSize;
    private final HashMap<Integer, Integer> snakes;
    private final HashMap<Integer, Integer> ladders;
    private final Dice dice;
    private final List<Player> players;

    public Board(int boardSize, HashMap<Integer, Integer> snakes, HashMap<Integer, Integer> ladders, int numberOfDice, List<Player> players) {
        this.boardSize = boardSize;
        this.snakes = snakes;
        this.ladders = ladders;
        this.dice = new Dice(numberOfDice);
        this.players = players;
    }

    public void startGame() {
        HashSet<Integer> completed = new HashSet<>();

        while (completed.size() != players.size()) {
            for (Player player : players) {
                if(completed.contains(player.getId())){
                    continue;
                }

                int pos = player.getCurrPos();
                int stepsToMove = dice.roll();
                System.out.println("Player:" + " " + player.getName() + " has rolled " + stepsToMove);

                if (pos + stepsToMove > boardSize - 1) {
                    System.out.println("Player:" + " " + player.getName() + " has rolled more than what is required!");
                } else if (pos + stepsToMove == boardSize - 1) {
                    completed.add(player.getId());
                    System.out.println("Player:" + " " + player.getName() + " has won the game!");
                } else {
                    int newPos = pos + stepsToMove;
                    if(snakes.containsKey(newPos)){
                        System.out.println("Player:" + " " + player.getName() + " has been eaten by snake at position " + newPos + " to " + snakes.get(newPos));
                        newPos = snakes.get(newPos);
                    } else if(ladders.containsKey(newPos)){
                        System.out.println("Player:" + " " + player.getName() + " has climbed ladder at position " + newPos + " to " + ladders.get(newPos));
                        newPos = ladders.get(newPos);
                    }

                    if(newPos == boardSize - 1){
                        completed.add(player.getId());
                        System.out.println("Player:" + " " + player.getName() + " has won the game!");
                        continue;
                    }

                    System.out.println("Player:" + " " + player.getName() + " is at position " + newPos);

                    player.setCurrPos(newPos);
                }
            }
        }
    }
}
