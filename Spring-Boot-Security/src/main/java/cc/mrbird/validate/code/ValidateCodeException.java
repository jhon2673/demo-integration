package cc.mrbird.validate.code;

import org.springframework.security.core.AuthenticationException;

/**
 * @Description TODO
 * @Author panzhh
 * @Date 2020/6/16 18:38
 * @Version 1.0
 */
public class ValidateCodeException extends AuthenticationException {
    private static final long serialVersionUID = 7866717174253459826L;

    public ValidateCodeException(String message) {
        super(message);
    }
}
