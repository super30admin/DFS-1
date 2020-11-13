# Non Optimal BFS Solution
# Time Complexity: O(mn^2)
# Approach: Start a BFS on every node with value 1 and return distance when a 0 is found.
# This is not optimal because we are doing a BFS for every '1' in the matrix
import copy
class Solution(object):
    def updateMatrix(self, matrix):
        """
        :type matrix: List[List[int]]
        :rtype: List[List[int]]
        """
                    
        def bfs(sr,sc):
            q = collections.deque([(sr,sc,0)])
            while q:
                i,j,d = q.popleft()
                if (i < 0 or i >= n or j < 0 or j >= m):
                    continue
                if matrix[i][j] == 0:
                    return d
                q.append((i, j+1, d+1))
                q.append((i+1, j, d+1))
                q.append((i, j-1, d+1))
                q.append((i-1, j, d+1))
            return -1
                        
        distances = copy.deepcopy(matrix)     
        visited = set()
        q = collections.deque()
        n = len(matrix)
        m = len(matrix[0])
        for r,row in enumerate(matrix):
            for c,val in enumerate(row):
                if matrix[r][c] == 1:
                    distances[r][c] = bfs(r,c)
        return distances