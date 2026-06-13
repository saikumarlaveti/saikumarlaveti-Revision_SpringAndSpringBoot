package com.Entity.Runner;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStream;
import java.io.Reader;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.Entity.Person;
import com.Entity.PersonManagement.PersonManagement;

@Component
public class Runner implements CommandLineRunner {

    @Autowired
    private PersonManagement management;

    @Override
    public void run(String... args) throws Exception {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Age: ");
        int age = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter Photo Path: ");
        String photoPath = sc.nextLine();
       // Enter Photo Path: D:\Photos\IMG_20240523_144510718_HDR_AE.jpg
       // Enter Resume Path: D:\new resume\Saikumar_Laveti_Resume.pdf
        System.out.print("Enter Resume Path: ");
        String resumePath = sc.nextLine();

        // Read photo file into byte[]
        InputStream is = new FileInputStream(photoPath);
        byte[] photoContent = is.readAllBytes();

        // Read resume file into char[]
        Reader reader = new FileReader(resumePath);
        File file = new File(resumePath);

        char[] resumeContent = new char[(int) file.length()];
        reader.read(resumeContent);

        // Create Entity object
        Person person = new Person(
                0,
                name,
                age,
                photoContent,
                resumeContent
        );

        try {
            System.out.println(management.registerPerson(person));
        } catch (Exception e) {
            e.printStackTrace();
        }

        is.close();
        reader.close();
        sc.close();
    }
}