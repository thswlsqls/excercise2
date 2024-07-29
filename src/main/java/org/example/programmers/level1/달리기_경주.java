package org.example.programmers.level1;
import java.util.*;


import org.example.Main;

public class 달리기_경주 {

    class Solution {
        public String[] solution(String[] players, String[] callings) {
            String[] answer = {};

            Map<String, Integer> iMap = new HashMap<>();
            for(int i = 0; i<players.length; i++){
                iMap.put(players[i], i);
            }

            String temp = null;
            for(String name : callings){
                int i = iMap.get(name);
                temp = players[i-1];
                players[i-1] = name;
                players[i] = temp;
                iMap.put(name, i-1);
                iMap.put(temp, i);
            }

            return players;
        }
    }
}
