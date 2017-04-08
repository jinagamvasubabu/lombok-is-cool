package src.runner;

import src.com.vasubabu.lombok.cool.Branch;
import src.com.vasubabu.lombok.cool.College;
import src.com.vasubabu.lombok.cool.Student;
import lombok.Cleanup;
import lombok.SneakyThrows;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

import static java.util.Arrays.asList;

/**
 * Created by mac on 08/04/17.
 */
public class CoolRunner {
    public static void main(String[] args) {
        // Not Cool :(
        Student s1 = Student.builder().studentId(1).firstName("vasu").lastName("babu").build();
        Student s2 = Student.builder().studentId(2).firstName("Hari").lastName("panu").build();
        Student s3 = Student.builder().studentId(3).firstName("John").lastName("Noble").build();
        Student s4 = Student.builder().studentId(4).firstName("James").lastName("bond").build();

        Branch b1 = Branch.builder().branchId(101).branchName("CSE").students(asList(s1, s2)).build();
        Branch b2 = Branch.builder().branchId(102).branchName("MECH").students(asList(s3, s4)).build();

        College gitam = College.builder().collegeId(111).collegeName("GITAM").branches(asList(b1, b2)).build();

        //write this reponse to a file
        writeResponseToFile(gitam.getStudentsOfABranch(101));
        System.out.print("Operation Completed!!!!");
    }

    @SneakyThrows(IOException.class)
    private static void writeResponseToFile(List<Student> students) {
        if (!students.isEmpty()) {
            File f = new File("response1.txt");
            @Cleanup
            FileWriter writer = null;
            if (!f.exists()) {
                f.createNewFile();
                writer = new FileWriter(f);
                for (Student s : students) {
                    writer.write(s.getStudentId() + ": " + s.getFirstName() + "," + s.getLastName());
                }
            }
        }
    }
}
