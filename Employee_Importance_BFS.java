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
// BFS
class Solution {
    public int getImportance(List<Employee> employees, int id) {
        
        if(employees == null || employees.size() == 0) return 0;
        
        Queue<Employee> q = new LinkedList<Employee>();
        HashMap<Integer, Employee> map = new HashMap<>();
        Employee temp = null;
        
        for(Employee e : employees) {
            map.put(e.id, e);
            if(e.id == id)
                temp = e;
        }
        
        q.add(temp);
        int result = 0;
        while(!q.isEmpty()) {
            temp = q.poll();
            List<Integer> subIds = temp.subordinates;
            result = result + temp.importance;
            for(int i = 0; i < subIds.size(); i++) {
                q.add(map.get(subIds.get(i)));
            }
        }
        return result;
    }
}
