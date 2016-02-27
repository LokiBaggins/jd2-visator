package jd2.baggins.beans;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "t_teammates")
public class Teammate implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "c_ID")
    private int id;

    @Column(name = "c_nick_name")
    private String nickName;

    @Column(name = "c_f_name_cyr")
    private String firstNameCyr;

    @Column(name = "c_m_name_cyr")
    private String midNameCyr;

    @Column(name = "c_l_name_cyr")
    private String lastNameCyr;

    @Column(name = "c_birth_date")
    private Date birthDate;

    @Column(name = "c_vk_profile")
    private String vkProfile;

    @Column(name = "c_contact_phone")
    private String contactPhone;

    @ManyToOne
    @JoinColumn(name = "c_fk_sexes_id")
    private Sex sex;

    @OneToOne(mappedBy = "teammate", cascade = CascadeType.ALL)
    private Passport passport;

    @OneToOne(mappedBy = "teammate")
    private Occupation occupation;

    @ManyToOne
    @JoinColumn(name = "c_fk_current_address_id")
    private Address currentAddress;

    public Teammate() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getFirstNameCyr() {
        return firstNameCyr;
    }

    public void setFirstNameCyr(String firstNameCyr) {
        this.firstNameCyr = firstNameCyr;
    }

    public String getMidNameCyr() {
        return midNameCyr;
    }

    public void setMidNameCyr(String midNameCyr) {
        this.midNameCyr = midNameCyr;
    }

    public String getLastNameCyr() {
        return lastNameCyr;
    }

    public void setLastNameCyr(String lastNameCyr) {
        this.lastNameCyr = lastNameCyr;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    public String getVkProfile() {
        return vkProfile;
    }

    public void setVkProfile(String vkProfile) {
        this.vkProfile = vkProfile;
    }

    public String getContactPhone() {
        return contactPhone;
    }

    public void setContactPhone(String contactPhone) {
        this.contactPhone = contactPhone;
    }

    public Passport getPassport() {
        return passport;
    }

    public void setPassport(Passport passport) {
        this.passport = passport;
    }


    public Occupation getOccupation() {
        return occupation;
    }

    public void setOccupation(Occupation occupation) {
        this.occupation = occupation;
    }

    public Address getCurrentAddress() {
        return currentAddress;
    }

    public void setCurrentAddress(Address currentAddressId) {
        this.currentAddress = currentAddressId;
    }

    @Override
    public String toString() {
        return "Teammate{" +
                "id=" + id +
                ", nickName='" + nickName + "\'" +
                ", firstNameCyr='" + firstNameCyr + "\'\n" +
                ", midNameCyr='" + midNameCyr + "\'\n" +
                ", lastNameCyr='" + lastNameCyr + "\'\n" +
                ", birthDate='" + birthDate + "\'\n" +
                ", Passoprt='" + ((passport != null) ? passport.getPersonalNum() : "") + "\'\n" +
                ", sex='" + ((sex != null) ? sex.getSexName() : "") + "\'\n" +
//                ", sexN='" + sexId + "\'\n" +
                ", vkProfile='" + vkProfile + "\'\n" +
                ", contactPhone='" + contactPhone + "\'\n" +
                '}';
    }
}
