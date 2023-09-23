package eventorganizer;
import java.util.StringTokenizer;

public class Contact {
    private Department department;
    private String email;

    public Contact(Department department, String email) {
        this.department = department;
        this.email = email;
    }

    /**
     *
     * @return
     */
    public boolean isValid () {
//        StringTokenizer st = new StringTokenizer(this.email, "@");
//        while (st.hasMoreTokens()) {
//            st.nextToken();
//            if (!st.nextToken().equals("rutgers.edu"))
//                return false;
//        }
        if (!this.email.endsWith("@rutgers.edu"))
            return false;

        for (Department department: Department.values()) {
            if (this.department.name().equals(department.name()))
                return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return this.department + ", " + this.email;
    }

    public static void main(String[] args) {
        Contact c1 = new Contact(Department.CS, "email@rutgers.edu");
    }
}
