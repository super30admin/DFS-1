// Time Complexity : O(n)
// Space Complexity : O(n) 
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : NO


// Your code here along with comments explaining your approach
class Solution {

    public int getImportance(List<Employee> employees, int queryid) {
        
        HashMap<Integer,Employee> map = new HashMap();
        
        // create graph map out of list
        for(Employee e : employees) {
            
            map.put(e.id, e);
            
        }
        
        Queue<Employee> q = new LinkedList();
        q.add(map.get(queryid));
        
        // BFS to visit all employees
        int ans = 0;
        while(!q.isEmpty()) {
            
            Employee e = q.poll();
            ans += e.importance;
            
            for(int i : e.subordinates) {
                if(map.containsKey(i)) {
                    
                    q.add(map.get(i));
                    map.remove(i);
                    
                }
            }
            
        }
        return ans;
    }
}
