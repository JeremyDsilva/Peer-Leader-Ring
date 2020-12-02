package response;

public class Response<R> {

    R response;
    Exception exception;

    public static Response<Void> Ok() {
        return new Response<Void>();
    }

    public static <R> Response<R> of(R response) {
        return new Response<R>(response);
    }

    public static <R> Response<R> of(Exception exception) {
        return new Response<R>(exception);
    }

    protected Response() {
    }

    private Response(R response) {
        this.response = response;
        exception = null;
    }

    private Response(Exception exception) {
        this.exception = exception;
    }

    public R getResponse() {
        return response;
    }

    public Exception getException() {
        return exception;
    }

    public boolean success() {
        return !hasException();
    }

    public boolean hasException() {
        return exception != null;
    }

}