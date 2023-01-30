package basic.exception;

public class TestException extends RuntimeException {
    public TestException(Throwable throwable) {
        super(throwable);
    }
}
