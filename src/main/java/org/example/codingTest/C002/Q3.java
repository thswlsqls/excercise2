package org.example.codingTest.C002;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Q3 {

    public static void main(String[] args) {
        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String str =  br.readLine();
            char[] charArr = str.toCharArray();
            Stack<Character> st = new Stack();
            String result = "Ture";

            for(char ch : charArr) {
                if (ch == '(' || ch == '{' || ch == '[') {
                    st.push(ch);
                } else if (ch == ')') {
                    if (!st.isEmpty() && st.pop() != '(') {
                        result = "False";
                        break;
                    }
                } else if (ch == '}') {
                    if (!st.isEmpty() && st.pop() != '{') {
                        result = "False";
                        break;
                    }
                } else if (ch == ']') {
                    if (!st.isEmpty() && st.pop() != '[') {
                        result = "False";
                        break;
                    }
                }
            }

            if (!st.isEmpty()) {
                result = "False";
            }
            System.out.println(result);

        } catch (Exception e) {

        }

    }

}
