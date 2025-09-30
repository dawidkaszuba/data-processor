FROM eclipse-temurin:21-jdk

RUN useradd -r -u 1001 -m -d /home/appuser appuser \
    && mkdir -p /opt/data-processor \
    && chown -R appuser:appuser /opt/data-processor

COPY --chown=appuser:appuser ./target/*.jar /opt/data-processor/data-processor.jar

USER appuser
EXPOSE 8080
WORKDIR /opt/data-processor
ENTRYPOINT ["java", "-jar", "/opt/data-processor/data-processor.jar"]
