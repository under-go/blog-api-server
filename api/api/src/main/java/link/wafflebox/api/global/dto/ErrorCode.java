package link.wafflebox.api.global.dto;

import lombok.Getter;

@Getter
public enum ErrorCode {
    NOT_DEFINED("X-000"),
    DUPLICATED_ID_NICKNAME("A-001");

    private final String code;

    private ErrorCode(String code) {
        this.code = code;
    }
}
