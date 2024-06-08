package org.example.codingTest.C001;
import java.util.*;

public class Q2 {

    class Solution {
        public int[] solution(String[] record) {
            int length = record.length;
            int[] answer = {};
            answer = new int[2];

            Queue<Integer> q = new LinkedList<>();
            Stack<Integer> st = new Stack<>();
            int qTotal = 0;
            int sTotal = 0;

            for (int r=0; r<length; r++) {
                String[] s = record[r].split(" ");
                int price = Integer.parseInt(s[1]);
                int amount = Integer.parseInt(s[2]);

                if (s[0].equals("P")) {
                    for (int i=0; i<amount; i++) {
                        q.add(price);
                        st.push(price);
                    }
                } else {
                    for (int i=0; i<amount; i++) {
                        qTotal += q.poll();
                        sTotal += st.pop();
                    }
                }

            }

            answer[0] = qTotal;
            answer[1] = sTotal;
            return answer;
        }
    }

}
