package indi.nick.lcb;

import indi.nick.lcb.service.LetterCombinationService;

public class Main {


    /**
     * 1、2问的结果都可以用这个main验证
     * @param args
     */
    public static void main(String[] args){

        int[] array = new int[]{2,3,4};

        LetterCombinationService service = new LetterCombinationService();

        String[] combinateResult = service.combinate(array);

        for (String str : combinateResult){
            System.out.println(str);
        }


    }

}
