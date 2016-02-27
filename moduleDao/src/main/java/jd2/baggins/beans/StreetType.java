package jd2.baggins.beans;

import javax.persistence.*;

@Entity
@Table(name = "t_street_types" )
public class StreetType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "c_ID")
    private int id;

    @Column(name = "c_type_name")
    private String streetTypeName;

    @Column(name = "c_type_code")
    private String streetTypeCode;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStreetTypeName() {
        return streetTypeName;
    }

    public void setStreetTypeName(String streetTypeName) {
        this.streetTypeName = streetTypeName;
    }

    public String getStreetTypeCode() {
        return streetTypeCode;
    }

    public void setStreetTypeCode(String streetTypeCode) {
        this.streetTypeCode = streetTypeCode;
    }

    @Override
    public String toString() {
        return "StreetType{" +
                "streetTypeCode='" + streetTypeCode + '\'' +
                ", streetTypeName='" + streetTypeName + '\'' +
                '}';
    }
}
