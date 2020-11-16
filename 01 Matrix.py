# Time Complexity:-O(m*n)
# Space Complexity:- O(m*n)
# Approach:- BFS on the matrix and find when we find the first 0 and store that in the result array.
import collections
from typing import List
class Solution:
    def updateMatrix(self, matrix: List[List[int]]) -> List[List[int]]:
        dirs=[[0,1],[1,0],[-1,0],[0,-1]]
        def bfs(matrix,i,j):
            q=collections.deque([])
            q.append([i,j])
            res=1
            while(q):
                size=len(q)
                for _ in range(size):
                    element=q.popleft()
                    for i,j in dirs:
                        k=element[0]+i
                        l=element[1]+j
                        if 0<=k<len(matrix) and 0<=l<len(matrix[0]):
                            if matrix[k][l]==0:
                                return res
                            q.append([k,l])
                res+=1
                
        for i in range(len(matrix)):
            for j in range(len(matrix[0])):
                if matrix[i][j]==1:
                    res = bfs(matrix,i,j)
                    matrix[i][j]=res
        return matrix