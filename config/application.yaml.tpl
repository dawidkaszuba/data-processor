spring:
  application:
    name: data-processor
  kafka:
    bootstrap-servers: ${KAFKA_BOOTSTRAP_SERVERS}
    admin:
      properties:
        bootstrap.servers: ${KAFKA_BOOTSTRAP_SERVERS}

data-ingest:
  kafka:
    raw-data-topic:
      name: ${RAW_DATA_TOPIC_NAME}
      partitions: ${RAW_DATA_TOPIC_PARTITIONS}
      replicas: ${RAW_DATA_TOPIC_REPLICAS}

mqtt:
  user: ${MQTT_USER}
  password: ${MQTT_PASSWORD}
  broker-url: ${MQTT_BROKER_URL}
  client-id: data-ingest-client
  topics: ${MQTT_TOPICS}