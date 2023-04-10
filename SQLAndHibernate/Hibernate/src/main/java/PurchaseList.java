import lombok.*;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
@Entity
@Getter
@Setter
@Table(name = "PurchaseList")
public class PurchaseList {

    @EmbeddedId
    private PurchaseListKey id;

    @Column(name = "student_name",insertable = false, updatable = false)
    private String studentName;

    @Column(name = "course_name",insertable = false, updatable = false)
    private String courseName;

    private int price;

    @Column(name = "subscription_date")
    private Date subscriptionDate;
}
@Embeddable
@EqualsAndHashCode
@Getter
@Setter
class PurchaseListKey implements Serializable {

    @Column(name = "student_name",columnDefinition = "varchar(100)")
    private String studentName;

    @Column(name = "course_name",columnDefinition = "varchar(100)")
    private String courseName;
}
