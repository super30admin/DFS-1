# BFS Approach
# Time Complexity => O(N)
# Space Complexity => O(N)
from pip import List


class Solution:
    def floodFill(self, image: List[List[int]], sr: int, sc: int, color: int) -> List[List[int]]:
        if(len(image)==0 or image[sr][sc]==color):
            return image
        m = len(image)
        n = len(image[0])
        dirs = [[-1,0],[0,-1],[1,0],[0,1]]
        queue = []
        oldcolor = image[sr][sc]
        image[sr][sc] = color
        queue.append([sr,sc])
        while(len(queue)!=0):
            curr = queue.pop(0)
            for d in dirs:
                nr = d[0]+curr[0]
                nc = d[1]+curr[1]
                if(nr>=0 and nr<m and nc>=0 and nc<n and image[nr][nc]==oldcolor):
                    image[nr][nc] = color
                    queue.append([nr,nc])
        return image

# DFS Approach
# Time Complexity => O(N)
# Space Complexity => O(1) or O(H) w.r.t height of the tree.
class Solution:
    def floodFill(self, image: List[List[int]], sr: int, sc: int, color: int) -> List[List[int]]:
        if(len(image)==0 or image[sr][sc]==color):
            return image
        m = len(image)
        n = len(image[0])
        dirs = [[-1,0],[0,-1],[1,0],[0,1]]
        oldcolor = image[sr][sc]
        def traverse(image, sr, sc, oldcolor, color):
            if(sr<0 or sr>=m or sc<0 or sc>=n or image[sr][sc]!=oldcolor):
                return
            image[sr][sc]= color
            for d in dirs:
                traverse(image, sr+d[0], sc+d[1], oldcolor, color)
        traverse(image, sr, sc, oldcolor, color)
        return image
                
            
        