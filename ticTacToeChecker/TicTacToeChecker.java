package CodeWarriors.ticTacToeChecker;

public class TicTacToeChecker {
    public static void main(String[] args) {

    }

    public static int isSolved(int[][] board) throws IllegalArgumentException{
        //check for legal argument
        if (board == null || board.length != 3 || board[0].length != 3) throw new IllegalArgumentException();

        for (int i = 0; i < 3; i++) {
            //verticals
            if (board[i][0] != 0 && board[i][1] == board[i][0] && board[i][2] == board[i][0]){
                return board[i][0];
            }
            //horizontals
            if (board[0][i] != 0 && board[1][i] == board[0][i] && board[2][i] == board[0][i]){
                return board[0][i];
            }
        }
        //diagonals
        if (board[0][0] != 0 && board[1][1] == board[0][0] && board[2][2] == board[0][0]){
            return board[1][1];
        }
        if (board[2][0] != 0 && board[1][1] == board[2][0] && board[0][2] == board[2][0]){
            return board[1][1];
        }
        //isAnyEmptySpace?
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == 0) return -1;
            }
        }
        //it means a draw
        return 0;
    }

}
