import java.util.Arrays;

public class TicTacToe {
    char[][] board;
    int[][] rowTracker;
    int[][] columnTracker;
    int[][] mainDiagonalTracker;
    int[][] antiDiagonalTracker;
    int numCrosses;
    int numCircles;
    boolean isFinished;

    PlayerProfile player1;
    PlayerProfile player2;
    GlobalGameStatistics globalGameStatistics;

    TicTacToe(int n, PlayerProfile player1, PlayerProfile player2) {
        this.player1 = player1;
        this.player2 = player2;
        globalGameStatistics = GlobalGameStatistics.getInstance();
        isFinished = false;


        board = new char[n][n];
        for (char[] row : board) {
            Arrays.fill(row, '.');
        }

        rowTracker = new int[n][2];
        columnTracker = new int[n][2];
        mainDiagonalTracker = new int[1][2];
        antiDiagonalTracker = new int[1][2];
        this.numCircles = 0;
        this.numCrosses = 0;
    }

    public void printBoard() {
        for (char[] row : board) {
            for (char c : row) {
                System.out.print(c + " ");
            }
            System.out.println();
        }
    }

    public void playMove(PlayerProfile player, int i, int j) {
        if (isFinished) {
            return;
        }


        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length) {
            System.out.println("INVALID MOVE : OUT OF BOUNDS!!!");
            return;
        }

        if (board[i][j] != '.') {
            System.out.println("INVALID MOVE : SQUARE ALREADY USED");
            return;
        }

        //First player always puts 'X' and second player always puts 'O'
        char ch = player.getId() == player1.getId() ? 'X' : 'O';

        if (ch == 'X' && numCrosses > numCircles) {
            System.out.println("NOT YOUR TURN, LET PLAYER 2 PLAY THEIR TURN!!!!");
            return;
        }

        if (ch == 'O' && numCircles == numCrosses) {
            System.out.println("NOT YOUR TURN, LET PLAYER 1 PLAY THEIR TURN!!!!");
            return;
        }

        if (ch == 'X') {
            numCrosses++;
        } else {
            numCircles++;
        }

        board[i][j] = ch;

        updateTrackers(i, j, ch);

        if (isGameComplete(i, j, board.length)) {
            isFinished = true;

            System.out.println("GAME HAS BEEN COMPLETED!!!");
            PlayerProfile winner = ch == 'X' ? player1 : player2;
            PlayerProfile loser = ch == 'X' ? player2 : player1;
            System.out.println("WINNER IS " + winner.getName());

            globalGameStatistics.updateWin(winner);
            globalGameStatistics.updateLoss(loser);
            return;
        }

        if (numCircles + numCrosses == board.length * board.length) {
            isFinished = true;
            System.out.println("GAME IS A DRAW !!!");

            globalGameStatistics.upDateDraw(player1);
            globalGameStatistics.upDateDraw(player2);
        }

    }

    private void updateTrackers(int i, int j, char ch) {
        rowTracker[i][ch == 'X' ? 0 : 1]++;
        columnTracker[j][ch == 'X' ? 0 : 1]++;
        if (i == j) {
            mainDiagonalTracker[0][ch == 'X' ? 0 : 1]++;
        }
        if (i + j == board.length - 1) {
            antiDiagonalTracker[0][ch == 'X' ? 0 : 1]++;
        }
    }

    private boolean isGameComplete(int i, int j, int n) {
        return rowTracker[i][0] == n || rowTracker[i][1] == n || columnTracker[j][0] == n || columnTracker[j][1] == n || mainDiagonalTracker[0][0] == n || mainDiagonalTracker[0][1] == n || antiDiagonalTracker[0][0] == n || antiDiagonalTracker[0][1] == n;
    }

}
