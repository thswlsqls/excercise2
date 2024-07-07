package org.example.programmers.level1;
import java.util.*;

public class 데이터_분석 {

    class Solution {
        public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
            int[][] answer = {};

            Map<String, Integer> map = new HashMap<>();
            map.put("code", 0);
            map.put("date", 1);
            map.put("maximum", 2);
            map.put("remain", 3);
            int sort_by_i = map.get(sort_by);
            int ext_i = map.get(ext);

            List<int[]> filteredList = new ArrayList<int[]>();
            for (int[] d : data) {
                if (d[ext_i] < val_ext) {
                    filteredList.add(d);
                }
            }
            Collections.sort(filteredList, (o1, o2) -> o1[sort_by_i]-o2[sort_by_i]);

            answer = new int[filteredList.size()][4];
            for (int i=0; i<filteredList.size(); i++) { answer[i] = filteredList.get(i); }

            return answer;
        }
    }
}
