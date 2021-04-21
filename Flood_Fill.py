class Solution:
    
    #dfs approach
    def floodFill_D(self, image: List[List[int]], sr: int, sc: int, newColor: int) -> List[List[int]]:
        
        if not image:
            return
        m,n = len(image),len(image[0])
        color = image[sr][sc]
        self.dfs(image,sr,sc,m,n,newColor,color)
        return image
    
    def dfs(self,image,sr,sc,m,n,newColor,oldcolor):
        
        #base
        if (sr < 0 or sc < 0 or sr==m or sc==n or image[sr][sc] != oldcolor ):
            return
        
        #Logic
        image[sr][sc] = newColor
        dir_array = [(0,1), (1,0), (-1,0),(0,-1)]
        for i in dir_array:
            row = sr + i[0]
            column = sc +i[1] 
            self.dfs(image,row,column,m,n,newColor,oldcolor)
            
            
    def floodFill(self, image: List[List[int]], sr: int, sc: int, newColor: int) -> List[List[int]]:
        
        if not image or image[sr][sc] == newColor:
            return image
        
        queue = deque()
        m,n = len(image),len(image[0])
        queue.append((sr,sc))
        color = image[sr][sc]
        image[sr][sc] = newColor
        dir_array = [(0,1), (1,0), (-1,0),(0,-1)]
        while queue:
            element = queue.popleft()
            row,column =  element[0],element[1]
            for i in dir_array:
                r = row + i[0]
                c = column + i[1] 
                if (0 <=r<m and 0<=c<n and image[r][c] == color ):
                    image[r][c]= newColor
                    queue.append((r,c))
        
        return image                 
                
        
        
