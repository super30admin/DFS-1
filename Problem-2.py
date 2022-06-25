class Solution:
    def updateMatrix(self, mat: List[List[int]]) -> List[List[int]]:
        m=len(mat)
        n=len(mat[0])
        if not mat or n==0 or m==0:
            return mat
        
        q=deque()
        for i in range(m):
            for j in range(n):
                if mat[i][j]==0:
                    q.append([i,j])
                elif mat[i][j]==1:
                    mat[i][j]=-1
        dirs=[[0,1],[1,0],[-1,0],[0,-1]]  
        level=0
        while q:
            size=len(q)
            for i in range(size):
                q_element=q.popleft()
                mat[q_element[0]][q_element[1]]=level
                for direction in dirs:
                    r=q_element[0]+direction[0]
                    c=q_element[1]+direction[1]
                    
                    if 0<=r<m  and 0<=c<n and mat[r][c] !=0 and mat[r][c]<0:
                        q.append([r,c])
                        mat[r][c]=level
            level+=1
        return mat
                
                
            
            
        