package src.com.vasubabu.lombok.notcool;

import java.util.List;

/**
 * Created by mac on 08/04/17.
 */
public class Branch {
    private int branchId;
    private String branchName;
    private List<Student> students;

    public Branch(int branchId, String branchName, List<Student> students) {
        this.branchId = branchId;
        this.branchName = branchName;
        this.students = students;
    }

    public int getBranchId() {
        return branchId;
    }

    public void setBranchId(int branchId) {
        this.branchId = branchId;
    }

    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Branch)) return false;

        Branch branch = (Branch) o;

        if (getBranchId() != branch.getBranchId()) return false;
        if (!getBranchName().equals(branch.getBranchName())) return false;
        return getStudents().equals(branch.getStudents());
    }

    @Override
    public int hashCode() {
        int result = getBranchId();
        result = 31 * result + getBranchName().hashCode();
        result = 31 * result + getStudents().hashCode();
        return result;
    }
}
