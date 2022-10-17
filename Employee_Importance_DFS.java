/*
// Definition for Employee.
class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};
*/

// TC : O(n)
// SC : O(n)
// DFS
class Solution {
    HashMap<Integer, Employee> map;
    private int dfs(List<Employee> employees, Employee e, int result) {
        
        
        for(Integer id : e.subordinates) {
            Employee k = map.get(id);
            result = dfs(employees, k, result+k.importance);
        }
        return result;
    }
    public int getImportance(List<Employee> employees, int id) {
        
        if(employees == null || employees.size() == 0) return 0;
        
        map = new HashMap<>();
        Employee temp = null;
        
        for(Employee e : employees) {
            map.put(e.id, e);
            if(e.id == id)
                temp = e;
        }
        return dfs(employees, temp, temp.importance);
    }
}
