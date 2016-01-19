package beans;

public class Teammate {
    int id;
    String nickName;
    String firstNameCyr;
    String midNameCyr;
    String lastNameCyr;
    String birthDate; // don't see no need for using Date now. May be later
    String sex;
    String vkProfile;
    String contactPhone;
//    int passportId;
//    int occupationId;
//    int currentAddressId;

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

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
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
