public class Main {
    public static void main(String[] args) {
        PlayerProfile player1 = new PlayerProfile(1, "Karthik");
        PlayerProfile player2 = new PlayerProfile(2, "John");

        System.out.println("--- Starting Multiple Games ---\n");

        // GAME 1: Karthik wins (diagonal)
        System.out.println(">>> GAME 1");
        TicTacToe game1 = new TicTacToe(3, player1, player2);
        playGame(game1, new int[][]{
                {0, 0}, // Karthik
                {0, 1}, // John
                {1, 1}, // Karthik
                {0, 2}, // John
                {2, 2}  // Karthik wins
        }, player1, player2);

        // GAME 2: Draw
        System.out.println("\n>>> GAME 2");
        TicTacToe game2 = new TicTacToe(3, player1, player2);
        playGame(game2, new int[][]{
                {0, 0}, // Karthik
                {0, 1}, // John
                {0, 2}, // Karthik
                {1, 1}, // John
                {1, 0}, // Karthik
                {1, 2}, // John
                {2, 1}, // Karthik
                {2, 0}, // John
                {2, 2}  // Karthik
        }, player1, player2);

        // GAME 3: John wins (row)
        System.out.println("\n>>> GAME 3");
        TicTacToe game3 = new TicTacToe(3, player1, player2);
        playGame(game3, new int[][]{
                {0, 0}, // Karthik
                {1, 0}, // John
                {0, 1}, // Karthik
                {1, 1}, // John
                {2, 2}, // Karthik
                {1, 2}  // John wins
        }, player1, player2);

        // Final Rankings
        System.out.println("\n=== Final Player Rankings ===");
        GlobalGameStatistics.getInstance().getPlayerRankings();
    }

    // Utility to simulate a game from a sequence of moves
    private static void playGame(TicTacToe game, int[][] moves, PlayerProfile player1, PlayerProfile player2) {
        for (int moveIndex = 0; moveIndex < moves.length; moveIndex++) {
            PlayerProfile currentPlayer = (moveIndex % 2 == 0) ? player1 : player2;
            int row = moves[moveIndex][0];
            int col = moves[moveIndex][1];
            System.out.println("\n" + currentPlayer.getName() + " played at (" + row + ", " + col + ")");
            game.playMove(currentPlayer, row, col);
            System.out.println();
            game.printBoard();

            if (game.isFinished) break;
        }
    }
}
