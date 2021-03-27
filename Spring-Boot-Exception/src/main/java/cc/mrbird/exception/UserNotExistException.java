package cc.mrbird.exception;

/**
 * @Description TODO
 * @Author panzhh
 * @Date 2020/6/5 16:59
 * @Version 1.0
 */
public class UserNotExistException extends RuntimeException {

    private String id;

    public UserNotExistException(String id) {
        super("user not exist!");
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
