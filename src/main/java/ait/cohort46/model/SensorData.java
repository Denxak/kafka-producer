package ait.cohort46.model;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SensorData {
    private int id;
    private long timestamp;
    private int pulse;
}
