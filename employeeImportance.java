
/*
// Definition for Employee.
class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};
*/

public class employeeImportance {
    // DFS
    // TC: O(V+E) SC: O(V)
    HashMap<Integer, Employee> map;
    int result;

    public int getImportance(List<Employee> employees, int id) {
        map = new HashMap<>();
        for (Employee e : employees) {
            map.put(e.id, e);
        }
        dfs(id);
        return result;

    }

    private void dfs(Integer eid) {
        // logic
        Employee e = map.get(eid);
        result += e.importance;
        for (Integer subId : e.subordinates) {
            dfs(subId);
        }
    }

}

// //BFS
// //TC: O(V+E) SC: O(V)
// public int getImportance(List<Employee> employees, int id) {
// HashMap<Integer, Employee> map = new HashMap<>();
// for(Employee e : employees){
// map.put(e.id, e);
// }
// Queue<Integer> q = new LinkedList<>();
// q.add(id);
// int result = 0;
// while(!q.isEmpty()){
// int eid = q.poll();
// Employee e = map.get(eid);
// result += e.importance;
// for(Integer subId: e.subordinates){
// q.add(subId);
// }
// }

// return result;

// }
