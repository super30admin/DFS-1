//Time complexity: O(n)
//Space complexity:O(n)
//Executed on leetcode.
/*
// Definition for Employee.
class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};
*/

class Solution {
    int importance = 0;// employees.get(id-1).importance;\
    List<Integer> subordinates = new ArrayList<>();   
    Queue<Integer> queue = new LinkedList<>();
    HashMap<Integer, Employee> map = new HashMap<>();
    public int getImportance(List<Employee> employees, int id) {
        for(Employee emp: employees)
        {
            if(emp.id==id)
            {
                importance += emp.importance;
                subordinates = emp.subordinates;
                queue.addAll(subordinates); //Taken a hashmap to store employee details with emp id.
            }
            map.put(emp.id, emp);   //When searching for the given employee id add all the employees to hashmap. 
        }
        
        BFS();          //when given id is found add the subordinate list to queue.
       
        return importance;       
    }
    void BFS()        //then get the importance of each element in queue and return sum. and repeate.
    {
        if(!queue.isEmpty())
        {
            int id = queue.poll();
            
            importance+=map.get(id).importance;
            queue.addAll(map.get(id).subordinates);
        }
        if(!queue.isEmpty())
            BFS();
    }
}