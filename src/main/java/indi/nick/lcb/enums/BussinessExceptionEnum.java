package indi.nick.lcb.enums;

/**
 * @Author nick
 * @Description 业务异常枚举类
 */
public enum BussinessExceptionEnum {

    ILLEGL_DATA("BE001","录入数据不合法"),
    DATA_OUT_OF_RANGE("BE002","数据越界"),
    NULL_MAPPING("BE003","无映射关系");

    private final String code;
    private final String value;


    BussinessExceptionEnum(String code,String value){
        this.code = code;
        this.value = value;
    }

    public String code(){
        return this.code;
    }

    public String value(){
        return this.value;
    }

}
