package org.example.programmers.level1;

public class 바탕화면_정리 {
    public static void main(String[] args) {
        String[] wallpaper = {"..........", ".....#....", "......##..", "...##.....", "....#....."}; //= {".#...", "..#..", "...#."};

        for(int i=0; i<wallpaper.length; i++){
            System.out.println(wallpaper[i]);
        }
        System.out.println("y x " + wallpaper.length + " " + wallpaper[0].length());

        solution(wallpaper);
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
                    lux = Math.min(lux, x);
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

        answer = new int[]{luy, lux, rdy+1, rdx+1};
        System.out.println(""+ lux + " " + luy + " " + rdx + " " + rdy);
        return answer;
    }
}
