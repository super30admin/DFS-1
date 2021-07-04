from collections import deque
from typing import List


class Solution:
    def updateMatrix(self, mat: List[List[int]]) -> List[List[int]]:
        #null case
        if mat==0 or len(mat)==0:
            return mat

        q=deque()
        m=len(mat)
        n=len(mat[0])
        directions = [(-1, 0), (0, 1), (1, 0), (0, -1)]
        for i in range(len(mat)):
            for j in range(len(mat[0])):
                if mat[i][j]==0:
                    q.append((i,j))
                else:
                    mat[i][j]=-1
                #make the cell value as -1. This will remove the redundancy where we are making node value to be equal to distance, so at level 1 if we mark the node with distance value, it will be 1 and then we won't be able to distinguish bet node value and marked distance value

        #This problem will only happen at level 1. At level 2, distance would be 2, so will be able to distinguish between marked distance value and actual node value( but still we are marking all 1's with neg sign)
        distance=1
        while q:
            size=len(q)
            for i in range(size):
                popped=q.popleft()
                for d in directions:
                    row=popped[0]+d[0]
                    column=popped[1]+d[1]
                    if (row>=0 and column>=0 and row<m and column<n and mat[row][column]==-1):
                        q.append((row,column))
                        mat[row][column]=distance


            distance+=1

        return mat

s=Solution()
print(s.updateMatrix([[0,0,0],[0,1,0],[1,1,1]]))