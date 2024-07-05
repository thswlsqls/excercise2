package org.example.programmers.level1;

public class 붕대_감기 {

    class Solution {
        public int solution(int[] bandage, int health, int[][] attacks) {
            int maxH = health;
            int current = 0;
            for (int[] atack : attacks) {
                double 추가회복 = (Math.floor((atack[0] - current - 1)/bandage[0])) * bandage[2];
                int 초당회복합 = bandage[1] * (atack[0] - current - 1);
                health +=  추가회복 + 초당회복합;
                if (health > maxH) { health = maxH;}

                current = atack[0];
                health -= atack[1];
                if (health<=0) { return -1; }
            }
            return health;
        }
    }

}

