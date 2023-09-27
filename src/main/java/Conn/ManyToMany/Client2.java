package Conn.ManyToMany;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Client2 {
    @Id
    private int id;
    private String firstName;
    private String lastName;
    @ManyToMany
    @Cascade(CascadeType.ALL)
    private List<Order2> order2;

}
