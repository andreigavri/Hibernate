package Conn.ManyToMany;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Cascade;

import java.util.Date;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Order2 {

    @Id
    private int id;
    private float price;
    private String name;
    private Date date;
    @ManyToMany(mappedBy = "order2")
    private List<Client2> client2;


}
