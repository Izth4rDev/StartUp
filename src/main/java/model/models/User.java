package model.models;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString

public class User {
    private int user_id;
    private String mail;
    private Date created_at;
    private String nick;
    private String name;
    private String password;
    private String weight;
    private Date updated_at;
}
