package org.example.programmers.level1;
import java.util.*;

public class 추억_점수 {

    class Solution {
        public int[] solution(String[] name, int[] yearning, String[][] photo) {
            int[] answer = new int[photo.length];

            Map<String, Integer> pMap = new HashMap<>();
            for (int i=0; i<name.length; i++) {
                pMap.put(name[i], yearning[i]);
            }

            int i = 0;
            for(String[] names : photo){
                int pTot = 0;
                for (String n : names) {
                    pTot += pMap.containsKey(n) ? pMap.get(n) : 0;
                }
                answer[i++] = pTot;
            }

            return answer;
        }
    }

}
