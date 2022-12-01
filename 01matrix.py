'''
Time Complexity --> O(m*n)

Space Complexity --> O(m*n) for the queue
'''
class Solution:
    def updateMatrix(self, mat: List[List[int]]) -> List[List[int]]:
        m = len(mat)
        n = len(mat[0])
        if m==1 and n==1:
            return mat
        #Use BFS and store all independent variables in a queue
        #Mark all 1's as -1
        
        directions = [[-1,0],[1,0],[0,-1],[0,1]]     #up, down , left, right
        q = []
        for i in range(m):
            for j in range(n):
                if mat[i][j]==0:
                    q.append((i,j))
                else:
                    mat[i][j]=-1
        level = 1
        while q:
            l = len(q)
            for i in range(l):
                s = q.pop(0)
                for d in directions:
                    new_row = s[0] + d[0]
                    new_col = s[1] + d[1]
                    if new_row>=0 and new_row<m and new_col>=0 and new_col<n and mat[new_row][new_col]==-1:
                        mat[new_row][new_col] = level
                        q.append((new_row,new_col))
            level+=1
        
        return mat
                        
        
        
        