package jd2.baggins.beans;

import java.io.Serializable;
import java.util.Date;

public class Teammate implements Serializable {
    private static final long serialVersionUID = 1L;

    int id;
    String nickName;
    String firstNameCyr;
    String midNameCyr;
    String lastNameCyr;
    Date birthDate;
    int sex;
    String vkProfile;
    String contactPhone;
    int passportId;
    int occupationId;
    int currentAddressId;

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

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
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

    public int getPassportId() {
        return passportId;
    }

    public void setPassportId(int passportId) {
        this.passportId = passportId;
    }

    public int getOccupationId() {
        return occupationId;
    }

    public void setOccupationId(int occupationId) {
        this.occupationId = occupationId;
    }

    public int getCurrentAddressId() {
        return currentAddressId;
    }

    public void setCurrentAddressId(int currentAddressId) {
        this.currentAddressId = currentAddressId;
    }

    @Override
    public String toString() {
        return "Teammate{" +
                "id=" + id +
                ", nickName='" + nickName + '\'' +
                ", firstNameCyr='" + firstNameCyr + '\'' +
                ", midNameCyr='" + midNameCyr + '\'' +
                ", lastNameCyr='" + lastNameCyr + '\'' +
                ", birthDate='" + birthDate + '\'' +
                ", sex='" + sex + '\'' +
                ", vkProfile='" + vkProfile + '\'' +
                ", contactPhone='" + contactPhone + '\'' +
                '}';
    }
}
