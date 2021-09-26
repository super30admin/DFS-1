
import java.util.*;

public class EmployeeDFS {

    int imp = 0;
    HashMap<Integer, Employee> hs = new HashMap<>();

    public int getImportance(List<Employee> employees, int id) {
        for (Employee emp : employees)
            hs.put(emp.id, emp);
        helper(id);
        return imp;
    }

    public void helper(int id) {

        imp += hs.get(id).importance;
        for (int i : hs.get(id).subordinates)
            helper(i);
    }

}
