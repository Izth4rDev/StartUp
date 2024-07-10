package model.models;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class Address {
    private int id_addresses;
    private String address_name;
    private int address_number;
    private int user_id;
}
