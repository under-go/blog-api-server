package link.wafflebox.api.global.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@Getter
public class ApiResponse {
    private String code;
    private String message;
    private Object data;

    public static ApiResponse ok(Object data) {
        return new ApiResponse(
                String.valueOf(200),
                HttpStatus.OK.getReasonPhrase(),
                data
        );
    }

    public static ApiResponse fromError(Error error) {
        return new ApiResponse(
                String.valueOf(error.getHttpStatusCode().value()),
                error.getHttpStatusCode().getReasonPhrase(),
                error.toString());
    }
}
