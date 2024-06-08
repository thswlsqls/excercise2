package org.example.codingTest.C001;
import java.util.*;

public class Q3 {

    class Solution {
        public int solution(int[][] customer) {
            int answer = 0;
            int length = customer.length;

            Arrays.sort(customer, (o1, o2) -> {
                return o1[0] - o2[0];
            });

            answer = customer[0][1];
            int gap = customer[0][0];

            for(int i=1; i<length; i++) {
                int start = customer[i][0];
                int end = customer[i][1];

                if (end > answer) {
                    if (start>answer) {
                        gap += (start-answer);
                    }
                    answer += (end-answer);
                }
            }

            answer -= gap;
            return answer;
        }
    }
}
