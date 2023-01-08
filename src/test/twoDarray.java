package test;

import java.util.Random;

public class twoDarray {
    public static void main(String[] args) {
        int[] testarr = {0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};
        Random r = new Random();
        for (int i = 0; i < testarr.length; i++) {
            int index = r.nextInt(testarr.length);
            int temp = testarr[i];
            testarr[i] = testarr[index];
            testarr[index] = temp;
        }

        for (int i = 0; i < testarr.length; i++) {
            System.out.print(testarr[i]+" ");
        }

        int[][] data = new int[4][4];

        for (int i = 0; i < testarr.length; i++) {
            data[i/4][i%4] = testarr[i];
        }

        //System.out.println(data.length + " " + data[1].length);
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[i].length; j++) {
                System.out.print(data[i][j] + " ");
            }
            System.out.println();
        }

    }
    
    
}
