package src.com.vasubabu.lombok.notcool;

import java.util.List;

/**
 * Created by mac on 08/04/17.
 */
public class College {
    private int collegeId;
    private String collegeName;
    private List<Branch> branches;

    public College(int collegeId, String collegeName, List<Branch> branches) {
        this.collegeId = collegeId;
        this.collegeName = collegeName;
        this.branches = branches;
    }

    public int getCollegeId() {
        return collegeId;
    }

    public void setCollegeId(int collegeId) {
        this.collegeId = collegeId;
    }

    public String getCollegeName() {
        return collegeName;
    }

    public void setCollegeName(String collegeName) {
        this.collegeName = collegeName;
    }

    public List<Branch> getBranches() {
        return branches;
    }

    public void setBranches(List<Branch> branches) {
        this.branches = branches;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof College)) return false;

        College college = (College) o;

        if (getCollegeId() != college.getCollegeId()) return false;
        if (!getCollegeName().equals(college.getCollegeName())) return false;
        return getBranches().equals(college.getBranches());
    }

    @Override
    public int hashCode() {
        int result = getCollegeId();
        result = 31 * result + getCollegeName().hashCode();
        result = 31 * result + getBranches().hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "College{" +
                "collegeId=" + collegeId +
                ", collegeName='" + collegeName + '\'' +
                ", branches=" + branches +
                '}';
    }

    public List<Student> getStudentsOfABranch(final int branchId) {
        return branches.stream()
                .filter(b -> b.getBranchId() == branchId)
                .map(Branch::getStudents)
                .findAny()
                .orElse(null);
    }
}
