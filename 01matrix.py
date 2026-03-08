from typing import List
from collections import deque

class BFSSolution1:
# Time Complexity : O(m2*n2) where m is the number of rows and n is the number of columns in the matrix
# Space Complexity : O(m*n) where m is the number of rows and n is the number of columns in the matrix
# Did this code successfully run on Leetcode : No,. it gives TLE
# Any problem you faced while coding this : Yes, confusion with handling the distance and the queue

    # BFS
    def updateMatrix(self, mat: List[List[int]]) -> List[List[int]]:

        m = len(mat)
        n = len(mat[0])
        result = [[2] * n for _ in range(m)]
        neighbors = [[-1, 0], [0, -1], [0, 1], [1, 0]]

        for i in range(m):
            for j in range(n):
                if mat[i][j] == 0:
                    result[i][j] = 0
                else:  # it is 1
                    q = deque()
                    q.append((i, j))
                    distance = 0
                    while len(q):
                        distance += 1
                        size = len(q)
                        for _ in range(size):
                            curr = q.popleft()
                            for neighbor in neighbors:
                                r = curr[0] + neighbor[0]
                                c = curr[1] + neighbor[1]
                                if r >= 0 and c >= 0 and r < m and c < n:
                                    if mat[r][c] == 1:
                                        q.append((r, c))
                                    else:
                                        result[i][j] = min(result[i][j], distance)
                                        break

        return result
    
class BFSSolution2:
# Time Complexity : O(m*n) where m is the number of rows and n is the number of columns in the matrix
# Space Complexity : O(m*n) where m is the number of rows and n is the number of columns in the matrix
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
    # BFS
    def updateMatrix(self, mat: List[List[int]]) -> List[List[int]]:
        from collections import deque

        m = len(mat)
        n = len(mat[0])
        q = deque()
        neighbors = [[-1, 0], [0, -1], [0, 1], [1, 0]]

        for i in range(m):
            for j in range(n):
                if mat[i][j] == 0:
                    q.append((i,j))
                else:
                    mat[i][j] = -1
        
        dist = 0

        while len(q):
            dist += 1
            size = len(q)
            for _ in range(size):
                curr = q.popleft()
                for neighbor in neighbors:
                    r = curr[0] + neighbor[0]
                    c = curr[1] + neighbor[1]
                    if r >= 0 and c >= 0 and r < m and c < n and mat[r][c] == -1:
                        mat[r][c] = dist
                        q.append((r,c))
                
        return mat

class DFSSolution:
# Time Complexity : Ok(m*n) where m is the number of rows and n is the number of columns in the matrix
# Space Complexity : O(m*n) where m is the number of rows and n is the number of columns in the matrix
# Did this code successfully run on Leetcode : TLE
# Any problem you faced while coding this : No

    # DFS
    def updateMatrix(self, mat: List[List[int]]) -> List[List[int]]:

        self.m = len(mat)
        self.n = len(mat[0])
        self.result = [[9999]*self.n for _ in range(self.m)]
        self.neighbors = [[-1, 0], [0, -1], [0, 1], [1, 0]]

        for i in range(self.m):
            for j in range(self.n):
                if mat[i][j] == 0:
                    self.result[i][j] = 0
                    self.dfs(mat, i, j, 1)
                     
        return self.result

    def dfs(self, mat: List[List[int]], i: int, j: int, depth: int)-> None:

        for neighbor in self.neighbors:
            r = i + neighbor[0]
            c = j + neighbor[1]
            if r >= 0 and c >= 0 and r < self.m and c < self.n and mat[r][c] == 1 and self.result[r][c] > depth:
                self.result[r][c] = depth
                self.dfs(mat, r, c, depth+1)