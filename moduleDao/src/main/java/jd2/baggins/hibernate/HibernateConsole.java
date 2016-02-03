package jd2.baggins.hibernate;

import jd2.baggins.beans.Teammate;
import jd2.baggins.dao.TeammateHiberDao;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;

public class HibernateConsole {
    public static void main(String[] args) {
        System.out.println("Choose an option to do:");
        System.out.println("1.Find user by ID;");
        Scanner sc = new Scanner(new InputStreamReader(System.in));
        System.out.println(new TeammateHiberDao().getById(1));
    }
}
