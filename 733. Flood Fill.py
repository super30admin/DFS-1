# time complexity: O(mn)
# space complexity: O(1)

from queue import Queue
class Solution:
    def floodFill(self, image: List[List[int]], sr: int, sc: int, newColor: int) -> List[List[int]]:
        if image==None or len(image)==0 or image[sr][sc]==newColor: return image
        m=len(image)
        n=len(image[0])
        dirs=[[0,1],[0,-1],[1,0],[-1,0]]
        
        rows=Queue()
        cols=Queue()
        
        rows.put(sr)
        cols.put(sc)
        color=image[sr][sc]
        image[sr][sc]=newColor
        
        while(not rows.empty()):
            r=rows.get()
            c=cols.get()
            
            for dir in dirs:
                nr=r+dir[0]
                nc=c+dir[1]
                
                if(nr>=0 and nr<m and nc>=0 and nc<n and image[nr][nc]==color):
                    image[nr][nc]=newColor
                    rows.put(nr)
                    cols.put(nc)
        return image
    
#         def dfs(image, sr, sc, newColor):
#             #base
#             if(sr<0 or sc<0 or sr==m or sc==n or image[sr][sc]!=color):
#                 return
#             #logic
#             image[sr][sc]=newColor
            
#             for dir in dirs:
#                 nr=sr+dir[0]
#                 nc=sc+dir[1]
#                 dfs(image,  nr, nc, newColor)
            

#         dfs(image, sr, sc, newColor)
        # return image