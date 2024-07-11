package model.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString

public class Car {
    private int id_car;
    private String car_name;
    private String url;
    private int user_id;
    private int supplier_id;
}
