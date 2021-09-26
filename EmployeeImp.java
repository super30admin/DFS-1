
/**
 * Time complexity is O(Employees)
 * Space complexity is O(Employees)
 */

import java.util.*;

public class EmployeeImp {
    public int getImportance(List<Employee> employees, int id) {

        if (employees == null || employees.size() == 0 || id < 0 || id > 2000)
            return 0;

        int imp = 0;
        Queue<Integer> qu = new LinkedList<>();
        qu.add(id);
        HashMap<Integer, Employee> hs = new HashMap<>();
        for (Employee emp : employees) {
            hs.put(emp.id, emp);
        }

        while (!qu.isEmpty()) {
            int emp_id = qu.poll();
            Employee temp = hs.get(emp_id);
            imp += temp.importance;
            for (int el : temp.subordinates)
                qu.add(el);
        }
        return imp;
    }
}
