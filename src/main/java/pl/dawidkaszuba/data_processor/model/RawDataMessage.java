package pl.dawidkaszuba.data_processor.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.OffsetDateTime;
import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
@ToString
public class RawDataMessage {
    private String device;
    private String source;
    private OffsetDateTime received;
    private String schemaVersion;
    private Map<String, Metric> metrics = new HashMap<>();

}
