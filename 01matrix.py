'''
Time Complexity: O(mn)
Space Complexity: O(m+n)
'''
from collections import deque
class Solution(object):
    def updateMatrix(self, mat):
        """
        :type mat: List[List[int]]
        :rtype: List[List[int]]
        """
        rows = len(mat)
        cols = len(mat[0])
        q = deque([])
        direction = [[-1,0],[1,0],[0,-1],[0,1]]
        for i in range(rows):
            for j in range(cols):
                if(mat[i][j] == 1):
                    mat[i][j] = -1
                elif(mat[i][j]==0):
                    q.append([i,j])
        #print(q)
        while(len(q)>0):
            val = q.popleft()
            for i in direction:
                nr = val[0]+i[0]
                nc = val[1]+i[1]
                if(nr>=0 and nr<rows and nc>=0 and nc<cols and mat[nr][nc]==-1):
                    mat[nr][nc] = mat[val[0]][val[1]]+1
                    q.append([nr, nc])
        return mat

        