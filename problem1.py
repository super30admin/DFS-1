#timecomplexity O(m*n)
#space complexity O(m*n)
# desc bfs: adding the starting index in the queue and then checking in the 4 direction whose value is equal to the intial color value add that index inthe queue and update that image value to new color

# dfs
class Solution:
    serval=0
    #dfs implementation
    def floodFill(self, image: List[List[int]], sr: int, sc: int, newColor: int) -> List[List[int]]:
        if image[sr][sc]==newColor: return image
        m=len(image)
        n=len(image[0])
        self.srval=image[sr][sc]# storing the deafult color
        #image[sr][sc]=newColor
        return self.dfs(image,sr,sc,newColor)
    
    
    
    def dfs(self,image,x,y,newColor):
        #base
        if (x>=0 and x<len(image)) and (y>=0 and y<len(image[0])) and image[x][y]==self.srval:
            image[x][y]=newColor
        else:
            return
            
        
        #logic
        _dir=[[0,1],[1,0],[-1,0],[0,-1]]
        for d in _dir:
            r= x + d[0]
            c= y + d[1]
            self.dfs(image,r,c,newColor)
    
        return image
    
    
    
    
    
    
    """BFS
     if image[sr][sc]==newColor: return image
        m=len(image)
        n=len(image[0])
        srval=image[sr][sc]# storing the deafult color
        image[sr][sc]=newColor
       queue=[]
        queue.append([sr,sc])
        
        _dir=[[0,1],[1,0],[-1,0],[0,-1]]
        while queue:
            temp=queue.pop(0)
            for d in _dir:
                x=temp[0]+d[0]
                y=temp[1]+d[1]
                if (x>=0 and x<m) and (y>=0 and y<n) and image[x][y]==srval:
                    queue.append([x,y])
                    image[x][y]=newColor
        return image
        """            
                            
        
        