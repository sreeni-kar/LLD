import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class Main{
    public static void main(String[] args){
        int boardSize = 50;

        HashMap<Integer,Integer> snakes = new HashMap<>();
        snakes.put(35,22);
        snakes.put(47,17);
        snakes.put(26,7);

        HashMap<Integer,Integer> ladders = new HashMap<>();
        ladders.put(10,30);
        ladders.put(27,44);

        int numberOfDice = 1;

        List<Player> playerList = new ArrayList<>();
        playerList.add(new Player(1,"Jon",0));
        playerList.add(new Player(2,"Mark", 0));
        playerList.add(new Player(3, "Daniel", 0));

        Board board = new Board(boardSize,snakes,ladders,numberOfDice,playerList);

        board.startGame();
    }
}