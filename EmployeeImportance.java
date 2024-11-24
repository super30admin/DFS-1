/*
// Definition for Employee.
class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};
*/
// Approach : BFS 
// Time : O(n)
// Space : O(n) + O(n) = O(n)
class Solution {
    public int getImportance(List<Employee> employees, int id) {
        HashMap<Integer,Employee> map = new HashMap<>();
        for(Employee emp: employees ){
            map.put(emp.id,emp);
        }

        int result=0;
        Queue<Integer> q = new LinkedList<>();
        q.add(id);
        // Process the queue
        while(!q.isEmpty()){
            int currId = q.poll();
            Employee currEmployee = map.get(currId);
            result += currEmployee.importance;

            for (int subOrdId: currEmployee.subordinates){
                q.add(subOrdId);
            }
        }
        return result;
    }
}

/*
// Definition for Employee.
class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};
*/
// Approach : DFS - Recursion 
// Time : O(n)
// Space : O(n) + O(n) = O(n)
class Solution {
    int result;
    HashMap<Integer,Employee> map;
    public int getImportance(List<Employee> employees, int id) {
        this.result =0;
        this.map = new HashMap<>();
        for(Employee emp: employees ){
            map.put(emp.id,emp);
        }

        dfs(id);
        return result; 
    }

    public void dfs(int id){
        Employee currEmployee = map.get(id);
        result+=currEmployee.importance;
        for(int subOrdId : currEmployee.subordinates){
            dfs(subOrdId);
        }
    }
}