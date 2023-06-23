"""
Did this code successfully run on Leetcode : yes
Any problem you faced while coding this : no

Problem2 (https://leetcode.com/problems/01-matrix/)
Your code here along with comments explaining your approach
"""

# Approach -1 
from collections import deque
class Solution:
    def updateMatrix(self, mat: List[List[int]]) -> List[List[int]]:
        """
        BFS, running a fresh BFS whenever we encounter a "1"
        Time Complexity : O(M*N)^2
        Space Complexity :O(M*N)
        """
        if len(mat) == 0 or mat ==[]: return mat
        m = len(mat)
        n = len(mat[0])
        q = deque()
        level = 0
        dirs = [(1,0),(0,1),(-1,0),(0,-1)]
        
        # adding all the "1" inside the queue
        for r in range(m):
            for c in range(n):
                if mat[r][c] == 1:
                    q = deque()
                    visited = [[False for i in range(n)]for j in range(m)]
                    q.append((r,c))
                    dist = 0
                    visited[r][c] = True
                    flag = False
                    
                    # iterating over the queue
                    while q and not flag:
                        _size = len(q)
                      
                        for i in range(_size):
                            curr = q.popleft()
                            for d in dirs:
                                nr = curr[0] + d[0]
                                nc = curr[1] + d[1]
                                
                                if (nr >=0 and nr <m and nc >=0 and nc <n and visited[nr][nc]==False):
                                    if mat[nr][nc] == 0:
                                        falg = True
                                        break
                                        
                                    else:
                                        q.append((nr, nc))
                                        visited[nr][nc] = True
                                        
                            if flag: break
                                
                        dist += 1
                        
                    mat[nr][nc] = dist
                    
            return mat
                    


# Approach - 2

from collections import deque
class Solution:
    def updateMatrix(self, mat: List[List[int]]) -> List[List[int]]:
        """
        Time Complexity : O(M*N)
        Space Complexity :O(M*N)
        """
        if len(mat) == 0 or mat ==[]: return mat
        m = len(mat)
        n = len(mat[0])
        q = deque()
        dirs = [(1,0),(0,1),(-1,0),(0,-1)]
        
        # adding all the "1" inside the queue
        for r in range(m):
            for c in range(n):
                # if the value of the cell is 1 convert it to -1 else if it is 0 add it to queue
                if mat[r][c] == 1:
                    mat[r][c] = -1
                else:
                    q.append((r,c))
               
        # q reaaches the total number cell or if there are no zeros in the cell then we will return the matrix
        if (len(q) == m*n) or (len(q) == 0): return mat
        distance = 0
        while q:
            _size = len(q)
            # processing each queue element
            for i in range(_size):
                cur = q.popleft()
                # iterating through all the directions
                for d in dirs:
                    nr = cur[0] + d[0]
                    nc = cur[1] + d[1]
                    
                    # checking the boundary condition
                    if (nr >= 0 and nr < m and nc >= 0 and nc < n and mat[nr][nc] == -1):
                        # if it satisfies the boundary conditios then we will add the elem inside the queue and increment it curr dist value in the matrix by 1
                        
                        q.append((nr, nc))
                        
                        mat[nr][nc] = distance + 1
                        
                        
            distance += 1
           
            
        return mat

            
        
# Approach -3 

from collections import deque
class Solution:
    def updateMatrix(self, mat: List[List[int]]) -> List[List[int]]:
        """
        DFS approach, by going through any cell and applying dfs when we encounter a 0.
        Time Complexity : O(M*N)^2
        Space Complexity: O(M*N)
        """
        if len(mat) == 0 or mat ==[]: return mat
        m = len(mat)
        n = len(mat[0])
        dirs = [(1,0),(0,1),(-1,0),(0,-1)]
        
        
        def dfs_helper(mat, r, c, dist):
            # base condition
            if (r < 0 or r == len(mat)) or (c < 0 or c == len(mat[0])) : return 
            if mat[r][c] != -1 and mat[r][c] < dist: return 
            
            
            # logic
            mat[r][c] = dist
            for d in dirs:
                nr = r + d[0]
                nc = c + d[1]
                dfs_helper(mat, nr, nc, dist + 1)
                    
        
        # adding all the "1" inside the queue
        for r in range(m):
            for c in range(n):
                # if the value of the cell is 1 convert it to -1 
                if mat[r][c] == 1:
                    mat[r][c] = -1
                    
        # If we encounter 0 in the cell we will call the DFS function
        for r in range(m):
            for c in range(n):
                if mat[r][c] == 0:
                    # call dfs
                    dfs_helper(mat, r, c, 0)
                    
        return mat
