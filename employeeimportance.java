// Time Complexity :o(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no
class Solution {
    private int result = 0;

    public int getImportance(List<Employee> employees, int id) {
        HashMap<Integer, Employee> map = new HashMap<>();
        for (Employee e : employees) {
            map.put(e.id, e);
        }
        dfs(map, id);
        return result;
    }

    private void dfs(HashMap<Integer, Employee> map, int eid) {
        Employee e = map.get(eid);
        result += e.importance;
        for (int subId : e.subordinates) {
            dfs(map, subId);
        }
    }
}