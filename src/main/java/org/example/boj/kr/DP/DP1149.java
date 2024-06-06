package org.example.boj.kr.DP;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class DP1149 {
    static int N;
    static int[][] dp;

    public static void main(String[] args) {

        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            N = Integer.parseInt(br.readLine());
            dp = new int[N][3];
            for (int i=0; i<N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j=0; j<3; j++) {
                    dp[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            for (int i=1; i<N; i++) {
                dp[i][0] += Math.min(dp[i-1][1], dp[i-1][2]);
                dp[i][1] += Math.min(dp[i-1][0], dp[i-1][2]);
                dp[i][2] += Math.min(dp[i-1][0], dp[i-1][1]);
            }

            System.out.println(Math.min(Math.min(dp[N-1][0], dp[N-1][1]), dp[N-1][2]));
        } catch (Exception e){
            e.printStackTrace();
        }

    }
}
