package SQLRest.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
@Table(name = "test")
public class test {

    @Id
    @Column(name = "test_id")
    private Long id;

    @Column(name = "test_date")
    private LocalDate test_date;

    public test(){}

    public test(Long test_id, LocalDate test_date) {
        this.id = test_id;
        this.test_date = test_date;
    }
}
