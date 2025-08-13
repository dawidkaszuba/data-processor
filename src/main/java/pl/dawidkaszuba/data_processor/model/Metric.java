package pl.dawidkaszuba.data_processor.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Metric {
    private double value;
    private String unit;
}
