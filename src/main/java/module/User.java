package module;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User extends BaseModel {
    private String name;
    private String username;
    private String password;
    private String attachment;


}
