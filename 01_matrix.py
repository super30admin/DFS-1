class Solution:
    def updateMatrix(self, matrix):
        n,m,ans=len(matrix),len(matrix[0]),[]
        def dfs(i,j,visited):
            if 0<=i<n and 0<=j<m and (i,j) not in visited:
                visited[i,j]=True
                tbr=0 if matrix[i][j]==0 else min(dfs(i+1,j,visited)+1,dfs(i,j+1,visited)+1,dfs(i-1,j,visited)+1,dfs(i,j-1,visited)+1)
                del visited[i,j]
                return tbr
            return float("inf")
        for i in range(n):
            temp=[]
            for j in range(m):
                temp.append(dfs(i,j,{}))
            ans.append(temp)
        return ans