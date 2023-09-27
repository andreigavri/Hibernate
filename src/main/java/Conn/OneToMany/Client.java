package Conn.OneToMany;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity(name = "clients")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Client {
    @Id
    private int id;
    private String firstName;
    private String lastName;

    @OneToMany(mappedBy = "client")
    private List<OrderFastFood> orderFastFoods;


}
