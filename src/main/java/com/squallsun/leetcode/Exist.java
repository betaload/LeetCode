package com.squallsun.leetcode;

public class Exist {
    public static boolean exist(char[][] board, String word) {
        char[] wordChar = word.toCharArray();
        int m = board.length;
        int n = board[0].length;
        boolean[][] visited = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (dfs(board, wordChar, 0, i, j, visited))
                    return true;
            }
        }
        return false;
    }

    private static boolean dfs(char[][] board, char[] s, int cur, int x, int y,  boolean[][] visited) {

        if(cur == s.length) {
            return true;
        }

        if(x < 0 || y < 0 || x>=(board.length) || y>=(board[0].length)) {
            return false;
        }
        if(visited[x][y] || board[x][y] != s[cur]) {
            return false;
        }
        visited[x][y] = true;
        boolean res = dfs(board, s, cur + 1, x - 1, y, visited)
                || dfs(board, s, cur + 1, x + 1, y, visited)
                || dfs(board, s, cur + 1, x, y + 1, visited)
                || dfs(board, s, cur + 1, x, y - 1, visited);

        visited[x][y] = false;
        return res;
    }

    public static void main(String[] args) {
        char[][] a = {{'a', 'b'}, {'c', 'd'}};
        exist(a, "acbd");
    }
}
