#Time Complexity:O(m*n)
#Space Complexity: O(m*n)
class Solution:
    def floodFill(self, image: List[List[int]], sr: int, sc: int, color: int) -> List[List[int]]:
        if image==None or image[sr][sc]==color:
            return image
        m=len(image)
        n=len(image[0])
        dirs=[[-1,0],[0,-1],[0,1],[1,0]]
        original_color=image[sr][sc]
        q=deque()
        q.append(sr)
        q.append(sc)
        image[sr][sc]=color
        while q:
            cr=q.popleft()
            cc=q.popleft()
            for dir in dirs:
                nr=cr+dir[0]
                nc=cc+dir[1]
            #Check bounds
                if nr>=0 and nc>=0 and nr<m and nc<n and image[nr][nc]==original_color:
                    q.append(nr)
                    q.append(nc)
                    image[nr][nc]=color
        return image

#dfs
#Time Complexity:O(m*n)
#Space Complexity: O(m*n)
class Solution:
    def floodFill(self, image: List[List[int]], sr: int, sc: int, color: int) -> List[List[int]]:
        if image==None or image[sr][sc]==color:
            return image
        m=len(image)
        n=len(image[0])
        self.dirs=[[-1,0],[0,-1],[0,1],[1,0]]
        self.original_color=image[sr][sc]
        self.dfs(image,sr,sc,color,m,n)
        return image
    def dfs(self,image,sr,sc,color,m,n):
        if sr<0 or sc<0 or sr==m or sc==n or image[sr][sc]!=self.original_color:
            return 
        image[sr][sc]=color
        for dir in self.dirs:
            nr=sr+dir[0]
            nc=sc+dir[1]
            self.dfs(image,nr,nc,color,m,n)
        
            
        