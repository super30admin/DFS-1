# Time Complexity : O(mn) for matrix mXn
# Space Complexity : O(mn)

# Did this code successfully run on Leetcode : 
# YEs

# Any problem you faced while coding this : 

# Your code here along with comments explaining your approach

class Solution:
    import collections
    def updateMatrix(self, matrix: List[List[int]]) -> List[List[int]]:
        def is_valid(index, thresh):
            return index >= 0 and index < thresh
            
        n = len(matrix)
        m = len(matrix[0])
        dp = []
        bfs = collections.deque()
        visited = set()
        
        for i, row in enumerate(matrix):
            r = []
            for j, x in enumerate(row):
                r.append(math.inf)
                if x == 0:
                    bfs.append((i, j, 0))
                    visited.add((i, j))
            dp.append(r)
        
        dirs = [[-1, 0], [1, 0], [0, -1], [0, 1]]
        while(bfs):
            i, j, dist = bfs.popleft()
            dp[i][j] = dist
            
            for dir_i, dir_j in dirs:
                new_i = i + dir_i
                new_j = j + dir_j
                if is_valid(new_i, n) and is_valid(new_j, m) and (new_i, new_j) not in visited:
                    bfs.append((new_i, new_j, dist + 1))
                    visited.add((new_i, new_j))
        
        return dp