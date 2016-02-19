package jd2.baggins.utils;

import jd2.baggins.beans.Address;
import jd2.baggins.beans.Passport;
import jd2.baggins.beans.Sex;
import jd2.baggins.beans.Teammate;
import jd2.baggins.dao.GenericDao;
import org.hibernate.annotations.SourceType;

import java.io.InputStreamReader;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;
import java.util.Date;

public class HibernateConsole {
    public static void main(String[] args) {
//        System.out.println("Choose an option to do:");
//        System.out.println("1.Find user by ID;");
        Scanner sc = new Scanner(new InputStreamReader(System.in));
        GenericDao<Teammate> tmDao = new GenericDao<>(Teammate.class);
        GenericDao<Sex> sexDao = new GenericDao<>(Sex.class);
        GenericDao<Passport> passDao = new GenericDao<>(Passport.class);
        GenericDao<Address> addrDao = new GenericDao<>(Address.class);

        Sex sex1 = sexDao.getById(1);
        Passport pass1 = passDao.getById(1);
        Address addr1 = addrDao.getById(1);
        Calendar birthDate = new GregorianCalendar(2011, 1, 1);

        Teammate tm = tmDao.getById(9);
        System.out.println("Teammate from DB" + tm);

        tmDao.delete(tm);
        System.out.println("\nDeleted!\n");

        tm.setNickName("TeamMate_test");
        tm.setFirstNameCyr("Имя_test");
        tm.setMidNameCyr("Отчество_test");
        tm.setLastNameCyr("Фамилия_test");
        tm.setBirthDate(new Date(birthDate.getTimeInMillis()));
        tm.setVkProfile("http://vk.com/loki_baggins_test");
        tm.setContactPhone("+375291234567");
        tm.setSex(sex1);
        tm.setPassport(pass1);
        tm.setCurrentAddress(addr1);
//        tm.setOccupation(occ1);
        tmDao.add(tm);
        System.out.println("\nAdded!\n");


        tm.setNickName(tm.getNickName() + "_updated");
        tmDao.update(tm);
        System.out.println("\nUpdated!\n");
        System.out.println("\nComplete!\n");
    }
}
