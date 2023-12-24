package link.wafflebox.api.global.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class Error {
    private final HttpStatus httpStatusCode;
    private final ErrorCode errorCode;
    private final String message;

    public Error(HttpStatus httpStatusCode, String message, ErrorCode errorCode) {
        this.httpStatusCode = httpStatusCode;
        this.errorCode = errorCode;
        this.message = message;
    }

    public Error(HttpStatus httpStatusCode, String message) {
        this.httpStatusCode = httpStatusCode;
        this.errorCode = ErrorCode.NOT_DEFINED;
        this.message = message;
    }

    @Override
    public String toString() {
        return String.format("%s:%s:%s", errorCode.getCode(), errorCode.toString(), message);
    }
}
