"""
complexity: O(m*n) where m and n are the dimensions of the matrix
space complexity: O(m*n) in the worst case when all the cells are 1 and we have to change them all
BFS approach: we start from all the cells that are 0 and add them to the queue. 
Then we keep popping from the queue and for each cell, we check its 4 neighbors. 
If they are 1, we change them to the distance of the current cell + 1
"""
from typing import List
from collections import deque
import copy
class Solution:
    def updateMatrix(self, mat: List[List[int]]) -> List[List[int]]:
        dirns = [[-1,0],[1,0],[0,1],[0,-1]]
        result = copy.deepcopy(mat)
        q = deque()
        for i in range(len(mat)):
            for j in range(len(mat[0])):
                if mat[i][j]==0:
                    q.append((i,j))
        visited = set()
        while q:
            i,j = q.popleft()
            for dirn in dirns:
                x = i+dirn[0]
                y = j+dirn[1]
                if -1<x<len(mat) and -1<y<len(mat[0]) and mat[x][y]==1 and (x,y) not in visited:
                    result[x][y] = result[i][j]+1
                    visited.add((x,y))
                    q.append((x,y))
        return result




        