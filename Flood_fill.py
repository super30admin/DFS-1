from collections import deque
class Solution:
    """DFS Implementation
    Time complexity-O(m*n)
    Space complexity-O(m*n)"""
    def __init__(self):
        self.dirs=[[1,0],[0,1],[-1,0],[0,-1]]
        self.color=0
    def floodFill(self, image: List[List[int]], sr: int, sc: int, newColor: int) -> List[List[int]]:
        self.color=image[sr][sc]
        if self.color==newColor:
            return image
        return self.dfs(image, sr, sc, newColor)
    
    def dfs(self, image, sr, sc, newColor):
        if sr<0 or sr==len(image) or sc<0 or sc==len(image[0]) or image[sr][sc]!=self.color:
            return
        image[sr][sc]=newColor
        for dir in self.dirs:
            nr=sr+dir[0]
            nc=sc+dir[1]
            self.dfs(image,nr, nc, newColor)
        return image
            
        
        
    """BFS Implementation
    Time complexity-O(m*n)
    Space Complexity-O(m*n)"""
    # def floodFill(self, image: List[List[int]], sr: int, sc: int, newColor: int) -> List[List[int]]:
    #     if image[sr][sc]==newColor or not image:
    #         return image
    #     q=deque()
    #     for i in range(len(image)):
    #         for j in range(len(image[0])):
    #             if i==sr and j==sc:
    #                 color=image[i][j]
    #                 image[i][j]=newColor
    #                 q.append(i)
    #                 q.append(j)
    #     if not q:
    #         return 0
    #     dirs=[[1,0],[0,1],[-1,0],[0,-1]]
    #     while q:
    #         size=len(q)
    #         for i in range(0, size, 2):
    #             r=q.popleft()
    #             c=q.popleft()
    #             for dir in dirs:
    #                 nr=r+dir[0]
    #                 nc=c+dir[1]
    #                 if nr>=0 and nr<len(image) and nc>=0 and nc<len(image[0]) and image[nr][nc]==color:
    #                     image[nr][nc]=newColor
    #                     q.append(nr)
    #                     q.append(nc)
    #     return image
                
                
                
                    
                    
        