#BFS 
#TC : 0(M X N)
#sc : 0(M x n)
class Solution:
    def floodFill(self, image: List[List[int]], sr: int, sc: int, color: int) -> List[List[int]]:
        if(len(image)==None or image[sr][sc]==color):
            return image
        m = len(image)
        n = len(image[0])
        dirs = [[-1,0],[0,-1],[1,0],[0,1]]
        oldcolor = image[sr][sc]
        q = []
        image[sr][sc] = color
        q.append([sr,sc])
        while(len(q)!=0):
            cur = q.pop(0)
            for d in dirs:
                
                nr = cur[0] + d[0]
                nc = cur[1] + d[1]
                
                if (nr >= 0 and nr < m and nc >= 0 and nc < n and image[nr][nc] == oldcolor):
                    image[nr][nc] = color
                    q.append([nr,nc])
        return image         
        

#DFS
#TC:0(N)
#SC:0(h)

class Solution:
    def floodFill(self, image: List[List[int]], sr: int, sc: int, color: int) -> List[List[int]]:
        if(len(image)==None or image[sr][sc]==color):
            return image
        self.m = len(image)
        self.n = len(image[0])
        self.dirs = [[-1,0],[0,-1],[1,0],[0,1]]
        oldcolor = image[sr][sc]
        self.dfs(image,sr,sc,color,oldcolor)
        return image
    
    def dfs(self,image,row,col,color,oldcolor):
        
        if(row < 0 or col < 0 or row == self.m or col == self.n or image[row][col] != oldcolor):
            return 
        image[row][col]=color
        for d in self.dirs:
            nr = row + d[0]
            nc = col + d[1]
            self.dfs(image,nr,nc,color,oldcolor)
            