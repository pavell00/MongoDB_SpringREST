package SQLRest.Model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@NamedStoredProcedureQuery(
        name = "call_sp_foldersJSON",
        resultClasses = test.class,
        procedureName = "sp_foldersJSON",
        parameters = {
                @StoredProcedureParameter(mode = ParameterMode.IN, type = Long.class, name = "rootid"),
                @StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "typefolder"),
        }
)
public class test {

    @Id
    @Column(name = "id")
    private Long Id;

    @Column(name = "JSON_F52E2B61-18A1-11d1-B105-00805F49916B")
    private String result;

    public test(){}

    public test( String result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return  result;
    }
}
