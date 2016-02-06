package jd2.baggins.beans;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;
import java.util.jar.Attributes;

@Entity
@Table(name = "t_sexes")
public class Sex implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "c_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "c_sex_name")
    private String sexName;

    @OneToMany(mappedBy = "sex")
    @PrimaryKeyJoinColumn
    private Set<Teammate> teammates;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSexName() {
        return sexName;
    }

    public void setSexName(String sexName) {
        this.sexName = sexName;
    }

    public Set<Teammate> getTeammates() {
        return teammates;
    }

    public void setTeammates(Set<Teammate> teammates) {
        this.teammates = teammates;
    }

    @Override
    public String toString() {
        return "Sex{" +
                "id=" + id +
                ", sexName='" + sexName + '\'' +
                '}';
    }
}
