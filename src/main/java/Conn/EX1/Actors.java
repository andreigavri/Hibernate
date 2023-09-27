package Conn.EX1;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor


public class Actors {

    @Id
    private int id;
    private int yearOfBirth;
    private String firstName;
    private String lastName;


    @ManyToMany
    @Cascade(CascadeType.ALL)
    private List<Movies> movies;

}
