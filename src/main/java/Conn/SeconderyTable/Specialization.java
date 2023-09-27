package Conn.SeconderyTable;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Generated;
import lombok.NoArgsConstructor;
@Entity
@Table(name = "specialization")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Specialization {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String type;

}
