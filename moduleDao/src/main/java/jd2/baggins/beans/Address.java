package jd2.baggins.beans;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "t_addresses")
public class Address implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="c_ID")
    private int id;

    @Column(name = "c_country")
    private String countryName;

    @Column(name = "c_city")
    private String cityName;

    @Column(name = "c_building", length = 4)
    private String buildingNum;

    @Column(name = "c_street_name")
    private String streetName;

    @Column(name = "c_block", length = 3)
    private String buildingBlock;

    @Column(name = "c_flat", length = 5)
    private String flatNum;

    @Column(name = "c_zip_code", length = 10)
    private String zipCode;

    @Column(name = "c_city_phone", length = 5)
    private String cityPhone;

    @Column(name = "c_fk_street_type")
    private int streetTypeId;

//    @OneToMany(mappedBy = "registryAddress")
//    @PrimaryKeyJoinColumn
//    private Set<Passport> passports;

//    @OneToMany(mappedBy = "currentAddress")
//    @PrimaryKeyJoinColumn
//    private Set<Teammate> teammates;

    public Address() {
    }

    public int getStreetTypeId() {
        return streetTypeId;
    }

    public void setStreetTypeId(int streetTypeId) {
        this.streetTypeId = streetTypeId;
    }

    public String getCityPhone() {
        return cityPhone;
    }

    public void setCityPhone(String cityPhone) {
        this.cityPhone = cityPhone;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getFlatNum() {
        return flatNum;
    }

    public void setFlatNum(String flatNum) {
        this.flatNum = flatNum;
    }

    public String getBuildingBlock() {
        return buildingBlock;
    }

    public void setBuildingBlock(String buildingBlock) {
        this.buildingBlock = buildingBlock;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public String getBuildingNum() {
        return buildingNum;
    }

    public void setBuildingNum(String buildingNum) {
        this.buildingNum = buildingNum;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getCountryName() {
        return countryName;
    }

//    public void setCountryName(String countryName) {
//        this.countryName = countryName;
//    }
//
//    public Set<Passport> getPassports() {
//        return passports;
//    }
//
//    public void setPassports(Set<Passport> passports) {
//        this.passports = passports;
//    }
//
//    public Set<Teammate> getTeammates() {
//        return teammates;
//    }
//
//    public void setTeammates(Set<Teammate> teammates) {
//        this.teammates = teammates;
//    }

    @Override
    public String toString() {
        return "Address{" +
                "streetTypeId=" + streetTypeId +
                ", cityPhone='" + cityPhone + '\'' +
                ", zipCode='" + zipCode + '\'' +
                ", flatNum='" + flatNum + '\'' +
                ", buildingBlock='" + buildingBlock + '\'' +
                ", streetName='" + streetName + '\'' +
                ", buildingNum='" + buildingNum + '\'' +
                ", cityName='" + cityName + '\'' +
                ", countryName='" + countryName + '\'' +
                ", id=" + id +
                '}';
    }
}
