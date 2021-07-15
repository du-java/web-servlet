package by.du.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Car {
    private String brand;
    private String model;
    private int price;
}
