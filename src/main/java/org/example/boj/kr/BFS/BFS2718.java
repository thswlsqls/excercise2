package org.example.boj.kr.BFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BFS2718 {

    static int N;
    static int M;
    static int[][] board;
    static boolean[][] visited;
    static int[] dr = new int[] {0, 0, -1, 1};
    static int[] dc = new int[] {1, -1, 0, 0};

    public static void main(String[] args) {

        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer sta = new StringTokenizer(br.readLine());
            N = Integer.parseInt(sta.nextToken());
            M = Integer.parseInt(sta.nextToken());
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
        Queue<int[]> q = new LinkedList();
        q.add(new int[] {0, 0, 1});

        while (!q.isEmpty()) {
            int now[] = q.poll();
            if (now[0] == N-1 && now[1] == M-1) {
                return now[2];
            }
            for (int i=0; i<4; i++){
                int nr = now[0] + dr[i];
                int nc = now[1] + dc[i];
                if (0<=nr && nr<N && 0<=nc && nc<M) {
                    if (board[nr][nc] == 1 && !visited[nr][nc]){
                        visited[nr][nc] = true;
                        q.add(new int[] {nr, nc, now[2]+1});
                    }
                }
            }
        }

        return 0;
    }

}
