package Conn.MappedSuperclass;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ComputerGame extends BaseEntity{
    private String name;
    private String description;
    private String type;

}
