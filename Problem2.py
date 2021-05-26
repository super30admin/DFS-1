# time: 
#space :0(1)
class Solution(object):
    def bfs(self,mat,x,y,m,n):
        queue = []
        step = 0
        queue.append([x,y,step])
        visited = set()
        while len(queue) != 0:
            x,y,step = queue.pop(0)
            
            if x >=0 and x<m and y>=0 and y <n and (x,y) not in visited:
                visited.add((x,y))
                if mat[x][y] == 0:
                    return step

                queue.append([x+1,y,step+1])
                queue.append([x,y+1,step+1])
                queue.append([x,y-1,step+1])
                queue.append([x-1,y,step+1])
        return mat[x][y]
    
    def updateMatrix(self, mat):
        
        m = len(mat)
        n = len(mat[0])
        
        for i in range(m):
            for j in range(n):
                if mat[i][j] == 1:
                    mat[i][j] = self.bfs(mat,i,j,m,n)
                    
        return mat
        """
        :type mat: List[List[int]]
        :rtype: List[List[int]]
        """
        