package org.example.codingTest.C002;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Q1 {

    public static void main(String[] args) {
        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int N = Integer.parseInt(br.readLine());
            List<Long> resultList = new ArrayList<Long>();
            for (int i=0; i<N; i++) {
                Long inputLong = Long.parseLong(br.readLine());
                Long 나머지 = inputLong%9;
                resultList.add(inputLong+(9-나머지));
            }
            Collections.sort(resultList);
            System.out.println(resultList.get(resultList.size()));
        } catch (Exception e){

        }
    }
}
