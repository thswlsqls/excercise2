package org.example.boj.kr.bruteforce;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BF1018 {

    public static void main(String[] args)  {

        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            String[] board = new String[N];

            for (int i = 0; i<N; i++){
                board[i] = br.readLine();
            }

            int[][] cntListB = new int[N][M];
            int[][] cntListW = new int[N][M];

            for (int r=0; r<N; r++){
                for (int c=0; c<M; c++) {
                    if (r % 2 == 0){
                        if (c % 2 == 0){
                            if(board[r].charAt(c) == 'W') {
                                cntListB[r][c] = 1;
                            } else {
                                cntListW[r][c] = 1;
                            }
                        } else {
                            if(board[r].charAt(c) == 'B') {
                                cntListB[r][c] = 1;
                            } else {
                                cntListW[r][c] = 1;
                            }
                        }
                    } else {
                        if (c % 2 == 0){
                            if(board[r].charAt(c) == 'B') {
                                cntListB[r][c] = 1;
                            } else {
                                cntListW[r][c] = 1;
                            }
                        } else {
                            if(board[r].charAt(c) == 'W') {
                                cntListB[r][c] = 1;
                            } else {
                                cntListW[r][c] = 1;
                            }
                        }
                    }
                }
            }

            int cntB = 0;
            int cntW = 0;

            int ans = Integer.MAX_VALUE;
            for (int i=0; i<N-7; i++){
                for (int j=0; j<M-7; j++){
                    for (int r=0; r<8; r++){
                        for (int c=0; c<8; c++){
                            cntB += cntListB[i+r][j+c];
                            cntW += cntListW[i+r][j+c];
                        }
                    }
                    ans = Math.min(ans, cntB);
                    ans = Math.min(ans, cntW);
                    cntB = 0;
                    cntW = 0;

                }
            }

            System.out.println(ans);
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
