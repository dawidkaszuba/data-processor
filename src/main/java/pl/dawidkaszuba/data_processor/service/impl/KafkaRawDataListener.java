package pl.dawidkaszuba.data_processor.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;
import pl.dawidkaszuba.data_processor.exception.KafkaConsumingMessageException;
import pl.dawidkaszuba.data_processor.model.RawDataMessage;
import pl.dawidkaszuba.data_processor.service.RawDataListener;

@Slf4j
@Service
public class KafkaRawDataListener implements RawDataListener {

    private final ObjectMapper objectMapper;

    public KafkaRawDataListener(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }


    @KafkaListener(topics = "${data-processor.kafka.raw-data-topic.name}", groupId = "${data-processor.kafka.raw-data-topic.groupId}")
    @Override
    public void handleRawDataMessage(@Payload String message, @Header(KafkaHeaders.RECEIVED_TOPIC) String topic) {
        try {
            RawDataMessage rawDataMessage = objectMapper.readValue(message, RawDataMessage.class);
            log.info(rawDataMessage.toString());
        } catch (Exception e) {
            log.error("[KafkaConsumer] Error consuming message from Kafka topic {} : {}", topic, e.getStackTrace());
            throw new KafkaConsumingMessageException("An error occurred while consuming message from Kafka", e);
        }
    }
}
