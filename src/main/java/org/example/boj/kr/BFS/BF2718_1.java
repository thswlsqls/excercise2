package org.example.boj.kr.BFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BF2718_1 {

    static int N;
    static int M;
    static int[][] board;
    static int[] dr = {0, 0, 1, -1};
    static int[] dc = {1, -1, 0, 0};
    static boolean[][] visited;

    public static void main(String[] args) {

        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            board = new int[N][M];
            visited = new boolean[N][M];
            for (int r=0; r<N; r++){
                String row = br.readLine();
                for (int c=0; c<M; c++){
                    board[r][c] = Integer.parseInt(String.valueOf(row.charAt(c)));
                }
            }
            System.out.println(bfs());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static int bfs() {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {0, 0, 1});
        while(!q.isEmpty()) {
            int[] row = q.poll();
            if (row[0] == N-1 && row[1] == M-1){
                return row[2];
            }

            for (int i=0; i<4; i++) {
                int nr = row[0] + dr[i];
                int nc = row[1] + dc[i];
                if (0<=nr && nr<N && 0<=nc && nc<M){
                    if (board[nr][nc] == 1 && !visited[nr][nc]){
                        visited[nr][nc] = true;
                        q.add(new int[] {nr, nc, row[2]+1});
                    }
                }
            }

        }
        return 0;
    }

}
