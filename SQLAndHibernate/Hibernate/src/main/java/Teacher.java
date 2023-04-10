import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
@Entity
@Table(name = "Teachers")
public class Teacher {

    @Id
    @Getter
    @Setter
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Getter
    @Setter
    @Column(columnDefinition = "varchar(45)")
    private String name;

    @Getter
    @Setter
    private int salary;

    @Getter
    @Setter
    private int age;
}
