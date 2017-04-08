package src.com.vasubabu.lombok.cool;

import lombok.Builder;
import lombok.Data;

import java.util.List;

/**
 * Created by mac on 08/04/17.
 */
@Data
@Builder
public class College {
    private int collegeId;
    private String collegeName;
    private List<Branch> branches;

    public List<Student> getStudentsOfABranch(final int branchId) {
        return branches.stream()
                .filter(b -> b.getBranchId() == branchId)
                .map(Branch::getStudents)
                .findAny()
                .orElse(null);
    }
}
