package jd2.baggins.beans;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table( name = "t_passports", uniqueConstraints = {@UniqueConstraint(columnNames = "c_personal_num")} )
public class Passport implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="c_ID")
    int id;

    @Column(name = "c_personal_num")
    String personalNum;

    @Column(name = "c_f_name_lat")
    String firstNameLatin;

    @Column(name="c_l_name_lat")
    String lastNameLatin;

    @Column(name = "c_series", length = 2)
    String series;

    @Column(name = "c_number", length = 7)
    int number;

    @Column(name = "c_issue_date")
    Date issueDate;

    @Column(name = "c_expiry_date")
    Date experyDate;

    @Column(name = "c_issuing_org")
    String issuingOrganization;

    @Column(name = "c_issuing_org_inner")
    String issuingOrganizationInner;

    //    Address registrAddress;
    @Column(name = "c_registration_address")
    String registryAddress;

    @Column(name = "c_fingers")
    boolean fingersTaken;

    @Column(name = "c_citizenship")
    String citizenship;

    @OneToOne
    @PrimaryKeyJoinColumn
    private Teammate teammate;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPersonalNum() {
        return personalNum;
    }

    public void setPersonalNum(String personalNum) {
        this.personalNum = personalNum;
    }

    public String getFirstNameLatin() {
        return firstNameLatin;
    }

    public void setFirstNameLatin(String firstNameLatin) {
        this.firstNameLatin = firstNameLatin;
    }

    public String getLastNameLatin() {
        return lastNameLatin;
    }

    public void setLastNameLatin(String lastNameLatin) {
        this.lastNameLatin = lastNameLatin;
    }

    public String getSeries() {
        return series;
    }

    public void setSeries(String series) {
        this.series = series;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Date getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(Date issueDate) {
        this.issueDate = issueDate;
    }

    public Date getExperyDate() {
        return experyDate;
    }

    public void setExperyDate(Date experyDate) {
        this.experyDate = experyDate;
    }

    public String getIssuingOrganization() {
        return issuingOrganization;
    }

    public void setIssuingOrganization(String issuingOrganization) {
        this.issuingOrganization = issuingOrganization;
    }

    public String getIssuingOrganizationInner() {
        return issuingOrganizationInner;
    }

    public void setIssuingOrganizationInner(String issuingOrganizationInner) {
        this.issuingOrganizationInner = issuingOrganizationInner;
    }

    public String getRegistryAddress() {
        return registryAddress;
    }

    public void setRegistryAddress(String registryAddress) {
        this.registryAddress = registryAddress;
    }

    public boolean isFingersTaken() {
        return fingersTaken;
    }

    public void setFingersTaken(boolean fingersTaken) {
        this.fingersTaken = fingersTaken;
    }

    public String getCitizenship() {
        return citizenship;
    }

    public void setCitizenship(String citizenship) {
        this.citizenship = citizenship;
    }

    public Teammate getTeammate() {
        return teammate;
    }

    public void setTeammate(Teammate teammate) {
        this.teammate = teammate;
    }

    @Override
    public String toString() {
        return "Passport{" +
                "id=" + id +
                ", personalNum='" + personalNum + '\'' +
                ", firstNameLatin='" + firstNameLatin + '\'' +
                ", lastNameLatin='" + lastNameLatin + '\'' +
                ", series='" + series + '\'' +
                ", number=" + number +
                ", issueDate=" + issueDate +
                ", experyDate=" + experyDate +
                ", issuingOrganization='" + issuingOrganization + '\'' +
                ", issuingOrganizationInner='" + issuingOrganizationInner + '\'' +
                ", registryAddress='" + registryAddress + '\'' +
                ", fingersTaken=" + fingersTaken +
                ", citizenship='" + citizenship + '\'' +
                '}';
    }
}
