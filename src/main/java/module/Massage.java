package module;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Massage extends BaseModel{
    private String text;
    private UUID user;
    private UUID chatId;

}
