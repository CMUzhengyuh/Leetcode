/**
 * Leetcode 79 - Word Search
 */
public class Leetcode79 {

    static boolean[][] visited;

    public boolean exist(char[][] board, String word) {
        visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if ((word.charAt(0) == board[i][j]) && search(board, word, i, j, 0)){
                    return true;
                }
            }
        }
        return false;
    }

    private boolean search(char[][]board, String word, int i, int j, int index){
        if (index == word.length()){
            return true;
        }
        if (i >= board.length || i < 0 || j >= board[i].length || j < 0 || board[i][j] != word.charAt(index) || visited[i][j]){
            return false;
        }
        visited[i][j] = true;
        if (search(board, word, i - 1, j, index + 1) ||
                search(board, word, i + 1, j, index + 1) ||
                search(board, word, i, j - 1, index + 1) ||
                search(board, word, i, j + 1, index + 1)) {
            return true;
        }
        visited[i][j] = false;
        return false;
    }

    public static void main(String[] args) {
        Leetcode79 Solution = new Leetcode79();

        char[][] test1Board = new char[][]{{'A','B','C','E'}, {'S','F','C','S'},{'A','D','E','E'}};
        String test1Word = "ABCCED";
        System.out.println(Solution.exist(test1Board, test1Word));

        char[][] test2Board = new char[][]{{'A','B','C','E'}, {'S','F','C','S'},{'A','D','E','E'}};
        String test2Word = "ABCCES";
        System.out.println(Solution.exist(test2Board, test2Word));

    }
}