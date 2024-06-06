package org.example.boj.kr.BinarySearch;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BS2343 {

    static int N;
    static int M;
    static int[] lectures;
    static int maxLen;
    static int subLen;
    static int subCnt;
    static int lo;
    static int hi;
    static int mid;
    static int ans;

    public static void main(String[] args) {

        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());

            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            lectures = new int[N];
            lo = 0;
            st = new StringTokenizer(br.readLine());
            for (int i=0; i<N; i++) {
                lectures[i] = Integer.parseInt(st.nextToken());
                maxLen = Math.max(maxLen, lectures[i]);
                hi += lectures[i];
            }
            ans = hi;
            while (lo <= hi) {
                mid = (lo+hi) / 2;
                if (mid < maxLen){
                    lo = mid + 1;
                    continue;
                }
                subLen = 0;
                subCnt = 1;
                for (int i=0; i<N; i++) {
                    if ((subLen + lectures[i]) <= mid) {
                        subLen += lectures[i];
                    } else {
                        subCnt += 1;
                        subLen = lectures[i];
                    }
                }
                if (subCnt <= M) {
                    ans = Math.min(ans, mid);
                    hi = mid-1;
                } else {
                    lo = mid+1;
                }
            }

            System.out.println(ans);
        } catch(Exception e) {
            e.printStackTrace();
        }

    }

}
