spring:
  application:
    name: data-processor
  kafka:
    bootstrap-servers: 10.0.0.110:9092
    admin:
      properties:
        bootstrap.servers: 10.0.0.110:9092

data-processor:
  kafka:
    raw-data-topic:
      name: raw-data
      groupId: data-processor-group