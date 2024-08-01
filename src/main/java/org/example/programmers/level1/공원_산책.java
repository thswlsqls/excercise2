package org.example.programmers.level1;
import java.util.*;
public class 공원_산책 {


    class Solution {
        public int[] solution(String[] park, String[] routes) {
            int[] answer = {};

            /** 시작점 찾기 */
            int startY = 0;
            int startX = 0;
            for(int y=0; y<park.length; y++) {
                for (int x=0; x<park[y].length(); x++){
                    if (park[y].charAt(x) == 'X') {
                        startY = y;
                        startX = x;
                    };
                }
            }
            int curY = startY;
            int curX = startX;

            /** 방향거리 이동값 [y, x]  */
            Map<Character, int[]> dMap = new HashMap<>();
            dMap.put('N', new int[]{-1, 0});
            dMap.put('S', new int[]{1, 0});
            dMap.put('W', new int[]{0, -1});
            dMap.put('E', new int[]{0, 1});

            /** 방향으로 1칸씩 검사하며 이동 - 장애물, 공원이탈 */
            for (String route : routes) {
                String[] sArr = route.split(" ");
                char c = sArr[0].charAt(0);
                int[] dir = dMap.get(c);
                int cnt = Integer.parseInt(sArr[1]);
                int curY_ = curY;
                int curX_ = curX;
                boolean isValidRoute = true;
                for (int i=0; i<cnt; i++) {
                    int nxtY = curY + dir[0];
                    int nxtX = curX + dir[1];
                    if (nxtY >= park.length || nxtX >= park[0].length() || park[nxtY].charAt(nxtX) == 'X') {
                        isValidRoute = false;
                        break;
                    }else{
                        curY = nxtY;
                        curX = nxtX;
                    }
                }
                if (!isValidRoute) {
                    curY = curY_;
                    curX = curX_;
                };
            }
            answer = new int[]{curY, curX};

            return answer;
        }
    }
}
