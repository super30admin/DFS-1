# Time Complexity : O(M * N) As it traverse the whole array
#  Space Complexity : O(1) No additional space is introduced
#  Did this code successfully run on Leetcode : Yes
#  Any problem you faced while coding this : N/A

#  Your code here along with comments explaining your approach
class Solution:
    def updateMatrix(self, mat: List[List[int]]) -> List[List[int]]:
        #Base case
        if not mat:
            return mat
        #Declare variable to check bounds of matrix
        m = len(mat)
        n = len (mat[0])
        
        dirs = [[-1,0], [1,0], [0,-1], [0,1]]
        
        q = deque()
        
        #Traverse the matrix and seprate out the 0's
        for i in range(m):
            for j in range(n):
                
                if mat[i][j] == 0:
                    q.append((i,j))
                else:
                    mat[i][j] = -1
        dist = 1 #To maintain the levels
        
        #DFS to traveser the matrix and calculate the distance
        while q:
            for i in range(len(q)):
                r,c = q.popleft()    
                for dr,dc in dirs:
                    nr=r+dr
                    nc=c+dc
                    
                    if 0 <= nr < m and 0<= nc < n and mat[nr][nc] == -1:
                        q.append((nr,nc))
                        mat[nr][nc] = dist
            dist += 1
            
        return mat