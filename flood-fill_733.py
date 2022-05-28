#BFS: appending row and column index of source place and checking for all the direction if they have old colour then changing it to new
#Time Complexity O(MN) M= rows, N=columns of image
#Space Complexity O(MN)
#It successfully runs on leetcode
from collections import deque
class Solution:
    def floodFill(self, image: List[List[int]], sr: int, sc: int, newColor: int) -> List[List[int]]:
        q=deque()
        if not image: return image
        if image[sr][sc]==newColor: return image
        old= image[sr][sc]
        r= len(image)
        c = len(image[0])
        
        direction = {(0,1),(0,-1),(1,0),(-1,0)}
        image[sr][sc]=newColor
        q.append((sr,sc))
        
        while q:
            pr,pc = q.popleft()
            for x,y in direction:
                nr,nc= pr+x, pc+y
                if nr >= 0 and nr<r and nc >=0 and nc < c and image[nr][nc]==old:
                    image[nr][nc] = newColor 
                    q.append((nr,nc))       
        return image


#DFS: appending row and column index of source place and checking for all the direction if they have old colour then changing it to new
#Time Complexity O(MN) M= rows, N=columns of image
#Space Complexity O(MN)
#It successfully runs on leetcode
from collections import deque
class Solution:
    def floodFill(self, image: List[List[int]], sr: int, sc: int, newColor: int) -> List[List[int]]:
        q=deque()
        if not image: return image
        if image[sr][sc]==newColor: return image
        old= image[sr][sc]
        r= len(image)
        c = len(image[0])
        direction = {(0,1),(0,-1),(1,0),(-1,0)}
        self.dfs(image,sr,sc,direction,old,newColor,r,c)
        return image
        
    def dfs(self,image, pr,pc,direction,old,newColor,r,c):
        if pr < 0 or pr==r or pc <0 or pc==c: return
        if image[pr][pc]!=old: return
        else: 
            image[pr][pc]=newColor
            for x,y in direction:
                nr= pr+x
                nc= pc+y
                self.dfs(image,nr,nc,direction,old,newColor,r,c)

#Inside declaration
from collections import deque
class Solution:
    def floodFill(self, image: List[List[int]], sr: int, sc: int, newColor: int) -> List[List[int]]:
        q=deque()
        if not image: return image
        if image[sr][sc]==newColor: return image
        old= image[sr][sc]
        r= len(image)
        c = len(image[0])
        direction = {(0,1),(0,-1),(1,0),(-1,0)}
        
        def dfs(image, pr,pc,old,newColor):
            if pr < 0 or pr==r or pc <0 or pc==c: return
            if image[pr][pc]!=old: return
            else:
                image[pr][pc]=newColor
                for x,y in direction:
                    nr= pr+x
                    nc= pc+y
                    dfs(image,nr,nc,old,newColor)
                    
        dfs(image,sr,sc,old,newColor)
        return image
        