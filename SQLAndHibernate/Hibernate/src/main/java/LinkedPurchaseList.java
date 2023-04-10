import lombok.*;
import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@Entity
@Table(name = "LinkedPurchaseList")
public class LinkedPurchaseList {

    @EmbeddedId
    private LinkedPurchaseListKey id;

    @Column(name = "student_id", insertable = false, updatable = false)
    private int studentId;

    @Column(name = "course_id", insertable = false, updatable = false)
    private int courseId;

}
@Embeddable
@EqualsAndHashCode
@Getter
@Setter
@AllArgsConstructor
class LinkedPurchaseListKey implements Serializable {

    @Column(name = "student_id")
    private int studentId;

    @Column(name = "course_id")
    private int courseId;
}
