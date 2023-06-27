// https://leetcode.com/problems/word-search/description/

public class S5 {
    public boolean exist(char[][] board, String word) {

        return helper(0, 0, board, "", word);
    }

    public boolean iSS(String s, String word) {

        for (int i = 0; i < s.length(); i++) {

            if (s.charAt(i) != word.charAt(i)) {
                return false;
            }

        }

        return true;
    }

    public boolean helper(int r, int c, char[][] board, String s, String word) {

        // if (!iSS(s, word)) {
        // return false;
        // }

        int nlr = board.length;
        int nlc = board[0].length;

        int nr = 0;
        int nc = 0;

        if (r < 0 || c < 0 || r >= nlr || c >= nlc || board[r][c] == '*') {
            return false;
        }

        if (c != nlc - 1) {
            nr = r;
            nc = c + 1;
        } else {
            nr = r + 1;
            nc = 0;
        }

        if (s.length() == word.length()) {
            if (s.equals(word)) {
                return true;
            } else {
                return false;
            }
        }

        s += board[r][c];
        board[r][c] = '*';

        if (helper(r + 1, c, board, s, word)) {
            return true;
        } // Down

        if (helper(r, c - 1, board, s, word)) {
            return true;
        } // Left

        if (helper(r, c + 1, board, s, word)) {
            return true;
        } // Right

        if (helper(r - 1, c, board, s, word)) {
            return true;
        } // Up

        board[r][c] = s.charAt(s.length() - 1);

        // System.out.println(s);

        if (s.equals(word)) {
            return true;
        }

        if (s.length() == 1) {
            if (s.equals(word)) {
                return true;
            }
            s = "";
            return helper(nr, nc, board, s, word);
        }

        return false;
    }
}
