package org.example.programmers.level1;
import java.util.*;
public class 가장_많이_받은_선물 {

    class Solution {
        public int solution(String[] friends, String[] gifts) {
            int answer = 0;

            int fLength = friends.length;
            int gLength = gifts.length;
            Map<String, Integer> map = new HashMap<>();
            for (int i=0; i<fLength; i++) {
                map.put(friends[i], i);
            }

            int[] giftDegree = new int[fLength];
            int[][] giveCnt = new int[fLength][fLength];

            for (String gift : gifts) {
                String[] tokens = gift.split(" ");
                giftDegree[map.get(tokens[0])]++;
                giftDegree[map.get(tokens[1])]--;
                giveCnt[map.get(tokens[0])][map.get(tokens[1])]++;
            }

            answer = Integer.MIN_VALUE;
            for (int i=0; i<fLength; i++) {
                int cnt = 0;
                for (int j=0; j<fLength; j++) {
                    if (i == j) {continue;}
                    if (giveCnt[i][j] > giveCnt[j][i]
                            || (giveCnt[i][j] == giveCnt[j][i] && giftDegree[i] > giftDegree[j])){
                        cnt++;
                    }
                }
                answer = Math.max(answer, cnt);
            }

            return answer;
        }
    }
}
