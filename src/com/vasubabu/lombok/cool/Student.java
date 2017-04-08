package src.com.vasubabu.lombok.cool;

import lombok.Builder;
import lombok.Data;

/**
 * Created by mac on 08/04/17.
 */
@Data
@Builder
public class Student {
    private int studentId;
    private String firstName;
    private String lastName;
}
