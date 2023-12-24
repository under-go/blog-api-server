package link.wafflebox.api.global.dto;

import jakarta.annotation.Nonnull;
import jakarta.annotation.Nullable;
import lombok.Data;
import lombok.Getter;

public class Result<T> {
    private final T data;
    private final boolean isSuccessful;
    private final Error error;

    private Result(@Nullable T data, boolean isSuccessful, @Nullable Error error) {
        assert(isSuccessful ? data != null && error == null : data == null && error != null);

        this.data = data;
        this.isSuccessful = isSuccessful;
        this.error = error;
    }

    public static <T> Result<T> success(@Nonnull T data) {
        return new Result<T>(data, true, null);
    }

    public static <T> Result<T> fail(@Nonnull Error error) {
        return new Result<T>(null, false, error);
    }

    public T getData() {
        assert(isSuccessful);
        return this.data;
    }

    public Error getError() {
        assert(!isSuccessful);
        return this.error;
    }

    public boolean isSuccessful() {
        return isSuccessful;
    }

    public boolean isFail() {
        return !isSuccessful;
    }
}
