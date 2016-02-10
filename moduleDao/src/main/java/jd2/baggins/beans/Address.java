package jd2.baggins.beans;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "t_addresses")
public class Address implements Serializable {
//    `c_ID` int(5) NOT NULL AUTO_INCREMENT,
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="c_ID")
    int id;
//    `c_country` varchar(50) DEFAULT NULL,
    @Column(name = "c_country")
    String countryName;
//    `c_city` varchar(50) DEFAULT NULL,
    @Column(name = "c_city")
    String cityName;
//    `c_building` varchar(4) DEFAULT NULL,
    @Column(name = "c_building", length = 4)
    String buildingNum;
//    `c_street_name` varchar(50) DEFAULT NULL,
    @Column(name = "c_street_name")
    String streetName;
//    `c_block` varchar(3) DEFAULT NULL,
    @Column(name = "c_block", length = 3)
    String buildingBlock;
//    `c_flat` varchar(5) DEFAULT NULL,
    @Column(name = "c_flat", length = 5)
    String flatNum;
//    `c_zip_code` varchar(10) DEFAULT NULL,
    @Column(name = "c_zip_code", length = 10)
    String zipCode;
//    `c_city_phone` varchar(10) DEFAULT NULL,
    @Column(name = "c_city_phone", length = 5)
    String cityPhone;
//    `c_fk_street_type` int(2) DEFAULT NULL,
    @Column(name = "c_fk_street_type", length = 2)
    int streetTypeId;

    @OneToOne
    @PrimaryKeyJoinColumn
    Passport passport;

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

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

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
