package indi.nick.lcb.service;

import indi.nick.lcb.enums.BussinessExceptionEnum;
import indi.nick.lcb.exception.BussinessException;
import jdk.nashorn.internal.ir.ReturnNode;

import java.util.LinkedList;
import java.util.List;


/**
 * @Author nick
 * @Description 字母组合逻辑处理
 */
public class LetterCombinationService {

    /**
     * 根据给的数组排映射关系
     * @param array
     * @return
     */
    public String[] combinate(int[] array){

        List<String[]> letterList = new LinkedList<String[]>();


        for (int i:array){
            if (i < 0 || i > 99){
                throw new BussinessException(BussinessExceptionEnum.DATA_OUT_OF_RANGE.value());
            }

            if (i < 10){
                if (this.transformUnitsDigit(i)!=null){
                    letterList.add(this.transformUnitsDigit(i));
                }
            }else {
                letterList.add(this.transformsTensDigit(i));
            }
        }

        return this.combineLetter(letterList);
    }

    /**
     * 0-9返回对应字母
     * @param number
     * @return
     */
    private String[] transformUnitsDigit(int number){

        if (number < 0 || number > 9){
            throw new BussinessException(BussinessExceptionEnum.DATA_OUT_OF_RANGE.value());
        }

        String[] letters ;
        switch (number) {
            case 0:
                letters = null;
                break;
            case 1:
                letters = null;
                break;
            case 2:
                letters = new String[]{"A","B","C"};
                break;
            case 3:
                letters = new String[]{"D","E","F"};
                break;
            case 4:
                letters = new String[]{"G","H","I"};
                break;
            case 5:
                letters = new String[]{"J","K","L"};
                break;
            case 6:
                letters = new String[]{"M","O","N"};
                break;
            case 7:
                letters = new String[]{"P","Q","R","S"};
                break;
            case 8:
                letters = new String[]{"T","U","V"};
                break;
            case 9:
                letters = new String[]{"W","X","Y","Z"};
                break;
            default:
                letters = null;
                break;
        }
        return letters;
    }


    /**
     * 10-99返回对应字母
     * @param number
     * @return
     */
    private String[] transformsTensDigit(int number){

        if (number < 10 || number > 99){
            throw new BussinessException(BussinessExceptionEnum.DATA_OUT_OF_RANGE.value());
        }
        //
        String[] unitsDigit = this.transformUnitsDigit(number % 10);
        String[] tensDigit = this.transformUnitsDigit(number / 10);

        List<String[]> letterList = new LinkedList<String[]>();

        if (tensDigit != null){
            letterList.add(tensDigit);
        }
        if (unitsDigit != null){
            letterList.add(unitsDigit);
        }

        return this.combineLetter(letterList);
    }

    /**
     * 映射数字
     * @param letterList
     * @return
     */
    private String[] combineLetter(List<String[]> letterList){

        if (letterList == null || letterList.size() < 1){
            throw new BussinessException(BussinessExceptionEnum.NULL_MAPPING.value());
        }

        if (letterList.size() == 1){
            return letterList.get(0);
        }
        //映射的总个数
        int totle = 1;

        for (String[] array : letterList){
            totle *= array.length;
        }

        List<String> combineResult = new LinkedList<String>();

        int size = letterList.size();
        //遍历总个数，拼接映射对应的值
        for (int i = 1; i <= totle ; i++){
            StringBuffer s = new StringBuffer();
            for (int j = 0; j < size; j++){
                int index = this.caculateIndex(totle,size,i,j+1,letterList);

                s.append(letterList.get(j)[index-1]);
            }
            combineResult.add(s.toString());
        }


        return combineResult.toArray(new String[combineResult.size()]);
    }

    /**
     * 返回对应数组取值时的下标
     * @param totle
     * @param size
     * @param i
     * @param number
     * @param letterList
     * @return
     */
    private int caculateIndex(int totle,int size,int i,int number,List<String[]> letterList){

        //最后一个数的下标取余
        if (size == number){
            int length = letterList.get(number-1).length;
            //能余尽的取下标最后一个
            if (i % length == 0){
                return length;
            }
            return i % length;
        }

        //非最后一个数的按照间隔数整除想上取整
        int divisor = totle;

        for (int j = 1; j <= number; j++){
            divisor /= letterList.get(j-1).length;
        }


        double a = i;
        double b = divisor;
        int index = 0 ;
        //能余尽的取下标最后一个
        if (a % (b * letterList.get(number-1).length) == 0){
            index = letterList.get(number-1).length;

        }else {

            index = (int) Math.ceil(a % (b * letterList.get(number-1).length)/ b);
        }


        return index;


    }

}
