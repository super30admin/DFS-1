# Time Complexity : O(M*N) 
# Space Complexity :    O(M*N) 
# Did this code successfully run on Leetcode : YES
# Any problem you faced while coding this : NO


#BFS
class Solution:
    def floodFill(self, image: List[List[int]], sr: int, sc: int, newColor: int) -> List[List[int]]:

        
        if image[sr][sc]==newColor:
            return image
        
        color = image[sr][sc]
        dirs = [[1,0],[0,1],[-1,0],[0,-1]]
        m = len(image)
        n = len(image[0])
        
        q = deque()
        #append indices of mx
        q.append(sr)
        q.append(sc)
        image[sr][sc]=newColor
        while(len(q)):
            r = q.popleft()
            c = q.popleft()                        
            for dir in dirs:
                nr = r+dir[0]
                nc = c+dir[1]
                if (nr>=0 and nc>=0 and nr<m and nc<n and image[nr][nc]==color):
                    image[nr][nc]=newColor
                    q.append(nr)
                    q.append(nc)
        return image
                
        
#DFS

class Solution:
    def __init__(self):
        self.dirs = [[1,0],[0,1],[-1,0],[0,-1]]
        
    def floodFill(self, image: List[List[int]], sr: int, sc: int, newColor: int) -> List[List[int]]:

        
        if image[sr][sc]==newColor:
            return image
        
        color = image[sr][sc]
        
        m = len(image)
        n = len(image[0])
        
        #self.dfs(image,r,c,newColor,color)
        self.dfs(image,sr,sc,newColor,color)
        
        return image
    
    
    def dfs(self,image,r,c,newColor,color):
        #base
        if(r<0 or c<0 or r==len(image) or c==len(image[0]) or image[r][c]!=color):
            return
        #logic
        
        image[r][c]=newColor
        for d in self.dirs:
            nr = r+d[0]
            nc = c+d[1]
            self.dfs(image,nr,nc,newColor,color)
    
        
        
        


        