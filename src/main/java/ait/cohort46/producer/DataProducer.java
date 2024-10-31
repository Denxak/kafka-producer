package ait.cohort46.producer;

import ait.cohort46.model.SensorData;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.Random;
import java.util.function.Supplier;

@Component
public class DataProducer {
    private final Random random = new Random();
    private final ObjectMapper objectMapper = new ObjectMapper();

    @Bean
    public Supplier<String> sendData() {
        return () -> {
            SensorData data = new SensorData(
                    random.nextInt(100),
                    System.currentTimeMillis(),
                    random.nextInt(100)
            );
            try {
                return objectMapper.writeValueAsString(data);
            } catch (JsonProcessingException e) {
                throw new RuntimeException();
            }
        };
    }
}
