package Util;

import java.util.Random;

public final class CodeUtil {
    private CodeUtil(){};
    public static String getCode(){
        Random r = new Random();
        char[] codeArr= new char[62];
        StringBuilder sb = new StringBuilder();
        int codeLen = 4;
        for (int i = 0; i < codeArr.length-26; i++) {
            if(i<=9){
                codeArr[i] = (char)(48+i);
            } else {
                codeArr[i] = (char)(65+i-10);
                codeArr[i+26] = (char)(97+i-10);
            }
        }
        /*for (int i = 0; i < codeArr.length; i++) {
            System.out.print(codeArr[i] + " ");
        }*/
        //System.out.println();
        for (int i = 0; i < codeLen; i++) {
            int index = r.nextInt(codeArr.length);//
            sb.append(codeArr[index]);
        }
        return sb.toString();
    }
}
