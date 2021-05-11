## Problem2 (https://leetcode.com/problems/01-matrix/)

class Solution:
    def updateMatrix(self, mat: List[List[int]]) -> List[List[int]]:
        if mat == None or len(mat) ==0:
            return mat
        q = []
        m = len(mat)
        n = len(mat[0])
        cnt = 0
        for i in range(m):
            for j in range(n):
                if mat[i][j]==0:
                    q.append([i,j])
                else:
                    cnt = cnt+1
                    mat[i][j]=-1
        if cnt ==0:
            return mat
        level = 1
        while len(q)!=0:
            size = len(q)
            for i in range(size):
                curr = q.pop(0)
                dir = [[0,1],[0,-1],[1,0],[-1,0]]
                for i in dir:
                    r = curr[0]+i[0]
                    c = curr[1]+i[1]
                    if r>=0 and r<m and c>=0 and c<n and mat[r][c]==-1:
                        mat[r][c] = level
                        q.append([r,c])
            level=level+1
        return mat
        #Time Complexity:O(mn)
        #Space Complexity:O(mn)
        #Approach: Traverse through all the matrix elements and add the coordinates of the matrix elements of all zeroes in to the queue and then change the matrix elements other than 0 to -1. start processing queue elements. Change the element according to level of the matrix element.   
        
                
        
        