package jd2.baggins.beans;

import javax.persistence.*;

@Entity
@Table( name="t_occupations")
public class Occupation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "c_ID")
    private int id;

    @Column(name = "c_position")
    private String position;

    @Column(name = "c_stud_department")
    private String studDepartment;

    @Column(name = "c_stud_group")
    private String studGroup;

    @Column(name = "c_stud_course")
    private String studCourse;

    @ManyToOne
    @JoinColumn(name = "c_fk_employer_id")
    private Employer employer;

    @OneToOne
    @PrimaryKeyJoinColumn
    private Teammate teammate;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getStudDepartment() {
        return studDepartment;
    }

    public void setStudDepartment(String studDepartment) {
        this.studDepartment = studDepartment;
    }

    public String getStudGroup() {
        return studGroup;
    }

    public void setStudGroup(String studGroup) {
        this.studGroup = studGroup;
    }

    public String getStudCourse() {
        return studCourse;
    }

    public void setStudCourse(String studCourse) {
        this.studCourse = studCourse;
    }

    public Employer getEmployer() {
        return employer;
    }

    public void setEmployer(Employer employer) {
        this.employer = employer;
    }

    public Teammate getTeammate() {
        return teammate;
    }

    public void setTeammate(Teammate teammate) {
        this.teammate = teammate;
    }

    @Override
    public String toString() {
        return "Occupation{" +
                "id=" + id +
                ", position='" + position + '\'' +
                ", studDepartment='" + studDepartment + '\'' +
                ", studGroup='" + studGroup + '\'' +
                ", studCourse='" + studCourse + '\'' +
                ", employer=" + employer +
                '}';
    }
}
