package Conn.CRUD;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Car {
    @Id
    private int id;
    private String modelName;
    private String producer;
    private Double engineVolume;

}
