package org.example.boj.kr.bruteforce;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B14889_1 {

    static int N;
    static int minDiff = Integer.MAX_VALUE;
    static int[][] board;
    static boolean[] visited;

    public static void main(String[] args) {
        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            N = Integer.parseInt(br.readLine());
            board = new int[N][N];
            for (int r=0; r<N; r++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int c=0; c<N; c++) {
                    board[r][c] = Integer.parseInt(st.nextToken());
                }
            }
            visited = new boolean[N];
            combination(0, 0);
            System.out.println(minDiff);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void combination(int start, int count) {
        if (count==N/2){
            setMinDiff();
            return;
        }
        for (int i=start; i<N; i++) {
            if (!visited[i]){
                visited[i] = true;
                combination(i+1, count+1);
                visited[i] = false;
            }
        }
    }

    public static void setMinDiff() {
        int start = 0;
        int link = 0;
        for (int r=0; r<N; r++){
            for (int c=r+1; c<N; c++){
                if (r==c) continue;
                if(visited[r] && visited[c]){
                    start += board[r][c];
                    start += board[c][r];
                }
                if(!visited[r] && !visited[c]){
                    link += board[r][c];
                    link += board[c][r];
                }
            }
        }
        minDiff = Math.min(minDiff, Math.abs(start-link));
        if (minDiff == 0){
            System.out.println(0);
            System.exit(0);
        }
    }
}
