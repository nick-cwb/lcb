package indi.nick.lcb.exception;

/**
 * @Author nick
 * @Description 自定义业务异常
 */
public class BussinessException extends RuntimeException{

    public BussinessException() {
        super();
    }

    public BussinessException(String message) {
        super(message);
    }

    public BussinessException(String message, Throwable cause) {
        super(message, cause);
    }


    public BussinessException(Throwable cause) {
        super(cause);
    }



}
