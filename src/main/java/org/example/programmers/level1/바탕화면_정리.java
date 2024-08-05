package org.example.programmers.level1;

public class 바탕화면_정리 {
    public static void main(String[] args) {
        String[] wallpaper = {".#...", "..#..", "...#."};
        solution(wallpaper);
        System.out.println(wallpaper.length);
        System.out.println(wallpaper[0].length());
    }

    public static int[] solution(String[] wallpaper) {
        int[] answer = {};
        int luy=Integer.MAX_VALUE;
        int lux=Integer.MAX_VALUE;
        int rdy=Integer.MIN_VALUE;
        int rdx=Integer.MIN_VALUE;

        // lux
        // luy
        for (int y=0; y<wallpaper.length; y++) {
            int xLen = wallpaper[y].length();
            for (int x=0; x<xLen; x++) {
                if (wallpaper[y].charAt(x) == '#'){
                    luy = Math.min(luy, y);
                    lux = Math.min(lux, x);;
                    break;
                }
            }
        }

        // rdy
        // rdx
        for (int y=0; y<wallpaper.length; y++) {
            int xLen = wallpaper[y].length();
            for (int x=0; x<xLen; x++) {
                if (wallpaper[y].charAt(x) == '#'){
                    rdy = Math.max(rdy, y);
                    rdx = Math.max(rdx, x);;
                }
            }
        }

        answer = new int[]{lux, luy, rdx, rdy};
        System.out.println(""+ lux + " " + luy + " " + rdx + " " + rdy);
        return answer;
    }
}
