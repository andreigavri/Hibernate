package Conn.SeconderyTable;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="teacher")
@SecondaryTable(name="specialization")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Teacher {
    @EmbeddedId
    private TeacherId teacherId;

    @Embedded
    private Person person;

    @Column(table="specialization")
    private String type;

}
