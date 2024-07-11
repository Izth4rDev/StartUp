package model.models;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString

public class UserCarListDTO {
    private String name;
    private String nick;
    private String mail;
    private String weight;
    private String role_name;
    private String address_name;
    private int  address_number;
    private String car_name;
    private String url;
}
