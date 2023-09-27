package Conn.OneToMany;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity(name = "orders")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class OrderFastFood {
    @Id
    private int id;
    private float price;
    private String name;
    private Date orderDate;

    @ManyToOne
    private Client client;

}
