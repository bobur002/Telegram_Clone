package module;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Chat extends BaseModel{
    private UUID userTo;
    private UUID userFrom;
}
