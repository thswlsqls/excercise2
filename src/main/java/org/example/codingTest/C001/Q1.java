package org.example.codingTest.C001;

public class Q1 {

    class Solution {
        public int[][] solution(int[][] image) {
            int length = image.length;
            int[][] answer = {};
            answer = new int[2*length][2*length];

            // 1
            for(int r=0; r<length; r++) {
                for (int c=0; c<length; c++) {
                    answer[r][c] = image[r][c];
                }
            }

            // 2
            for(int r=0; r<length; r++) {
                for (int c=0; c<length; c++) {
                    answer[r][length+c] = image[r][length-1-c];
                }
            }

            // 3
            for(int r=0; r<length; r++) {
                for (int c=0; c<length; c++) {
                    answer[length+r][c] = image[length-1-r][c];
                }
            }
            // 4
            for(int r=0; r<length; r++) {
                for (int c=0; c<length; c++) {
                    answer[length+r][length+c] = image[length-1-r][length-1-c];
                }
            }

            return answer;
        }
    }
}
