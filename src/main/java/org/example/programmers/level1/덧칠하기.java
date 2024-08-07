package org.example.programmers.level1;

import java.util.HashMap;
import java.util.Map;

public class 덧칠하기 {

    public static void main(String[] args) {
        int n = 4;
        int m = 1;
        int[] section = {1, 2, 3, 4};

        System.out.println(solution(n, m, section));
    }

    public static int solution(int n, int m, int[] section) {
        int answer = 0;

        int cur = 1;
        for (int i = 0; i < section.length; i++) {
            if (cur <= section[i]) {
                answer += 1;
                cur = section[i] + m;
            }
        }

        return answer;
    }

}
