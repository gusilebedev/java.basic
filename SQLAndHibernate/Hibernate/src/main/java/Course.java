import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
@Entity
@Getter
@Setter
@Table(name = "Courses")
public class Course {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id;

    @Column(columnDefinition = "varchar(500)")
    private String name;

    private int duration;

    @Column(columnDefinition = "enum('design','programming','marketing','management','business')")
    private String type;

    @Column(columnDefinition = "varchar(500)")
    private String description;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Teacher teacher;

    @Column(name = "students_count")
    private Integer studentsCount;


    private int price;

    @Column(name = "price_per_hour")
    private float pricePerHour;
}
