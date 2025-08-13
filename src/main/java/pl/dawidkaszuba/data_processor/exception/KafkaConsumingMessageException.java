package pl.dawidkaszuba.data_processor.exception;

public class KafkaConsumingMessageException extends RuntimeException {
    public KafkaConsumingMessageException(String message, Throwable cause) {
        super(message, cause);
    }
}
