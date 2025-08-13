package pl.dawidkaszuba.data_processor.service;

public interface RawDataListener {
    void handleRawDataMessage(String message, String topic);
}
