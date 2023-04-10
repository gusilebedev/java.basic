import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
@Entity
@Getter
@Setter
@Table(name = "Subscriptions")
public class Subscription {

    @EmbeddedId
    private SubscriptionKey id;

    @ManyToOne
    @JoinColumn(insertable = false,updatable = false)
    private Student student;

    @ManyToOne
    @JoinColumn(insertable = false,updatable = false)
    private Course course;

    @Column(name = "subscription_date")
    private Date subscriptionDate;
}
@Getter
@Setter
@Embeddable
@EqualsAndHashCode
class SubscriptionKey implements Serializable {

    @Column(name = "student_id")
    private  int student;

    @Column(name = "course_id")
    private int course;
}
