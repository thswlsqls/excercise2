package org.example.boj.kr.DFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class DFS2667_1 {

    static int N, d, cnt;
    static int[][] board;
    static boolean[][] visited;
    static int[] dr = {1, -1, 0, 0};
    static int[] dc = {0, 0, 1, -1};

    public static int dfs(int r, int c) {

        for (int i=0; i<4; i++){
            int nr = r + dr[i];
            int nc = c + dc[i];
            if (0<=nr && nr<N && 0<=nc && nc<N) {
                if (board[nr][nc] == 1 && !visited[nr][nc]) {
                    visited[nr][nc] = true;
                    dfs(nr, nc);
                    d += 1;
                }
            }
        }
        return d;
    }

    public static void main(String[] args) {

        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            N = Integer.parseInt(br.readLine());
            board = new int[N][N];
            visited = new boolean[N][N];

            for (int r=0; r<N; r++) {
                String row = br.readLine();
                for (int c=0; c<N; c++) {
                    board[r][c] = row.charAt(c) - '0';
                }
            }

            List<Integer> d_list = new ArrayList<>();
            for (int r=0; r<N; r++) {
                for (int c=0; c<N; c++) {
                    if (board[r][c] == 1 && !visited[r][c]) {
                        visited[r][c] = true;
                        d = 1;
                        d_list.add(dfs(r, c));
                        cnt += 1;
                    }
                }
            }

            System.out.println(cnt);
            Collections.sort(d_list);
            for(int d : d_list){
                System.out.println(d);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
