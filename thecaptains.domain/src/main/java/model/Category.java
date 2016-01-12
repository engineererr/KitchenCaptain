    package model;

    import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

    import static javax.persistence.GenerationType.IDENTITY;

    /**
 * Created by User on 27.10.2015.
 */
@Entity
public class Category {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private long id;

    private String name;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private int type;

    @Basic
    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
