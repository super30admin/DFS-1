from typing import List
from collections import deque
class Solution:
    def updateMatrix(self, mat: List[List[int]]) -> List[List[int]]:
        if mat is None or len(mat[0])==0: return
        levelorder=deque()
        row=len(mat)
        column=len(mat[0])
        for rowindex in range(len(mat)):
            for columnindex in range(len(mat[0])):
                if mat[rowindex][columnindex]==0:
                    levelorder.append([rowindex,columnindex])
                else:
                    mat[rowindex][columnindex]=-1

        dist=1
        direction=[[0,1],[0,-1],[1,0],[-1,0]]
        while levelorder.__len__()>0:
            size=levelorder.__len__()
            for idx in range(size):
                node =levelorder.popleft()
                for index in direction:
                    r=node[0]+index[0]
                    c=node[1]+index[1]
                    if r>= 0 and r<row-1 and c>=0 and c< column-1 and mat[r][c]==-1:
                        mat[r][c]=dist
                        levelorder.append([r,c])
            dist+=1

        return mat

# space O(m*n)
# Time O(m*n)


if __name__ == '__main__':
    print(Solution().updateMatrix([[0,0,0],[0,1,0],[0,0,0]]))
