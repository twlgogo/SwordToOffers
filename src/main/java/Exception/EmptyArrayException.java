package Exception;

/**
 * Created with IntelliJ IDEA.
 * User: tanweiliang
 * Date: 2018/8/6
 * Time: 下午10:41
 */
public class EmptyArrayException extends RuntimeException{
    private String retCd;  //异常对应的返回码
    private String msgDes;  //异常对应的描述信息

    public EmptyArrayException() {
        super();
    }

    public EmptyArrayException(String message) {
        super(message);
        msgDes = message;
    }

    public EmptyArrayException(String retCd, String msgDes) {
        super();
        this.retCd = retCd;
        this.msgDes = msgDes;
    }

    public String getRetCd() {
        return retCd;
    }

    public String getMsgDes() {
        return msgDes;
    }
}


