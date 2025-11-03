# Time Complexity : It is O(n) since we are iterating with the list.
# Space Complexity : It is O(n) we can insert all elements in the queue if value is 1.
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this :

from typing import List
from collections import deque
import copy

class Solution:
    def updateMatrix(self, mat: List[List[int]]) -> List[List[int]]:
        rowLen = len(mat)
        colLen = len(mat[0])
        output = copy.deepcopy(mat)
        neighbour = [[-1,0],[1,0],[0,-1],[0,1]]

        queueRow = deque()
        queueCol = deque()
        for i in range(rowLen):
            for j in range(colLen):
                if mat[i][j]==0:
                    queueRow.append(i)
                    queueCol.append(j)
                    output[i][j] = 2
        
        Level =0
        while queueRow:       
            Level +=1         
            queueLen = len(queueRow)
            for i in range(queueLen):
                row=queueRow.popleft()
                col=queueCol.popleft()
                for neigh in  neighbour:
                    neighRow = row + neigh[0]
                    neighCol = col + neigh[1]
                    if neighRow < rowLen and neighCol < colLen and neighRow>=0 and neighCol >=0 and output[neighRow][neighCol] != 2:
                        queueRow.append(neighRow)
                        queueCol.append(neighCol)
                        output[neighRow][neighCol] = 2                        
                        mat[neighRow][neighCol] = Level
        
        return mat
    
obj = Solution()
print(obj.updateMatrix([[0,0,0],[0,1,0],[1,1,1]]))
#print(obj.updateMatrix([[0,0,0],[0,1,0],[0,0,0]]))
