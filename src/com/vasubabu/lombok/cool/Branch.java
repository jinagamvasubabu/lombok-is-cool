package src.com.vasubabu.lombok.cool;

import lombok.Builder;
import lombok.Data;
import java.util.List;

/**
 * Created by mac on 08/04/17.
 */
@Data //Getter, Setter, RequiredArgsConstructor, EqualsAndHashCode, ToString
@Builder
public class Branch {
    private int branchId;
    private String branchName;
    private List<Student> students;
}
