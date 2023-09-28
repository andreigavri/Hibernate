package Conn.EX1;

import Conn.ManyToMany.Client2;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Movies extends BaseEntity{

    private String title;
    private int yearOfRelease;
    private int genreId;
    @ManyToMany(mappedBy = "movies")
    private List<Actors> actors;

    public Movies(int i, String ghostRider, int i1, int i2, List<Actors> actorsList1) {
        super();
    }
}
