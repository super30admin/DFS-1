'''
1. We build an adjacency list for all the courses to get prerequisites.
2. We start from a vertex and do a DFS. If we find a cycle then we return False. Else we return True.
3. We say a cycle is found if we find a vertex that is already being visited.
4. We keep track of visited vertices in a state array to perform this check.

TC: O(V+E)
SC: O(V+E)
'''

class Solution:

    def buildAdjacencyList(self, numberOfCourses: int, edgesList: List[List[int]]) -> List[List[int]]:
        adjList = [[] for _ in range(numberOfCourses)]

        for c1,c2 in edgesList:
            adjList[c2].append(c1)
        return adjList

    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:

        if  len(prerequisites) == 0:
            return True

        adjacencyList = self.buildAdjacencyList(numCourses, prerequisites)

        state = [0]*numCourses

        def hasCycle(v):
            # Node has been visited already, so we have a cycle
            if state[v] == 1:
                return False
            
            # Node is being visited, so we have a cycle 
            if state[v] == -1:
                return True
            
            # Mark node as being visited as we have not found a cycle yet
            state[v] = -1

            # For each of the prerequisites of the current course, we check if there is a cycle
            for sub in adjacencyList[v]:
                if hasCycle(sub):
                    return True
            
            # Mark node as visited 
            state[v] = 1
            return False
        
        # Start DFS. For each vertexm, if we find a cycle then we return False
        for v in range(numCourses):
            # For each course, check if a cycle exists. If it does, return False
            if hasCycle(v):
                return False
        
        # No cycle found
        return True