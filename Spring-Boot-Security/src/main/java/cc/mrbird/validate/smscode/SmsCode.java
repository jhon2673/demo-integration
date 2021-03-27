package cc.mrbird.validate.smscode;

import java.time.LocalDateTime;

/**
 * @Description TODO
 * @Author panzhh
 * @Date 2020/6/16 20:15
 * @Version 1.0
 */
public class SmsCode {
    private String code;

    private LocalDateTime expireTime;

    public SmsCode(String code, int expireIn) {
        this.code = code;
        this.expireTime = LocalDateTime.now().plusSeconds(expireIn);
    }

    public SmsCode(String code, LocalDateTime expireTime) {
        this.code = code;
        this.expireTime = expireTime;
    }

    boolean isExpire() {
        return LocalDateTime.now().isAfter(expireTime);
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public LocalDateTime getExpireTime() {
        return expireTime;
    }

    public void setExpireTime(LocalDateTime expireTime) {
        this.expireTime = expireTime;
    }


    @Override
    public String toString() {
        return "SmsCode{" +
                "code='" + code + '\'' +
                ", expireTime=" + expireTime +
                '}';
    }
}
