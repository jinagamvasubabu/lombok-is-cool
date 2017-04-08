package src.runner;

import src.com.vasubabu.lombok.notcool.Branch;
import src.com.vasubabu.lombok.notcool.College;
import src.com.vasubabu.lombok.notcool.Student;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import static java.util.Arrays.asList;

/**
 * Created by mac on 08/04/17.
 */
public class NotCoolRunner {
    public static void main(String[] args) {
        // Not Cool :(
        Student s1 = new Student(1, "vasu", "babu");
        Student s2 = new Student(2, "Hari", "panu");
        Student s3 = new Student(3, "John", "Noble");
        Student s4 = new Student(4, "James", "bond");

        Branch b1 = new Branch(101, "CSE", asList(s1, s2));
        Branch b2 = new Branch(102, "MECH", asList(s2, s3));


        College gitam = new College(111, "GITAM", asList(b1, b2));

        //write this reponse to a file
        writeResponseToFile(gitam.getStudentsOfABranch(101));
        System.out.print("Operation Completed!!!!");
    }

    public static void writeResponseToFile(List<Student> students) {
        if (!students.isEmpty()) {
            File f = new File("response1.txt");
            FileWriter writer = null;
            if (!f.exists()) {
                try {
                    f.createNewFile();
                    writer = new FileWriter(f);
                    for (Student s : students) {
                        writer.write(s.getStudentId() + ": " + s.getFirstName() + "," + s.getLastName());
                    }
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
