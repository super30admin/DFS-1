"""
# Definition for Employee.
class Employee:
    def __init__(self, id: int, importance: int, subordinates: List[int]):
        self.id = id
        self.importance = importance
        self.subordinates = subordinates
"""
# // Time Complexity : O(N)
# // Space Complexity : O(N)

class Solution:
    def getImportance(self, employees: List['Employee'], id: int) -> int:
        employeeMap = collections.defaultdict()
        for e in employees:
            employeeMap[e.id] = e
        return self.dfs(employeeMap, id)

    def dfs(self, employeeMap, id):
        result = employeeMap[id].importance
        for e in employeeMap[id].subordinates:
            result += self.dfs(employeeMap, e)
        return result