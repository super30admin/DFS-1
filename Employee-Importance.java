/*
// Definition for Employee.
class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};

Time Complexity : O(n)
Space Complexity : O(n)
*/

class Solution {
    HashMap<Integer, Employee> map = new HashMap<>();
    int total = 0;
    public int getImportance(List<Employee> employees, int id) {
        if(employees == null || employees.size() == 0) return 0;
        
        for(Employee e : employees){
            map.put(e.id, e);
        }
        dfs(id);
        return total;
    }
    
    private void dfs(int id){
        Employee employee = map.get(id);
        total = total + employee.importance;
        for(Integer subid : employee.subordinates){
            dfs(subid);
        } 
    }
}