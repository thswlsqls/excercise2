package org.example.codingTest.C002;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Q2 {

    public static void main(String[] args) {
        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            List<Integer> tList = new ArrayList<>();
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i=0; i<5; i++) {
                int t = Integer.parseInt(st.nextToken());
                tList.add(t);
            }
            Collections.sort(tList);
            int t0 = tList.get(0);
            int t1 = tList.get(1);
            int t4 = tList.get(4);
            System.out.println(t4 + (t1 - (t4-t0)));
        } catch (Exception e) {

        }
    }
}
