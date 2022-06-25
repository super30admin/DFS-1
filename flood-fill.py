# Time Complexity: O(m*n)
# Space Complexity: O(m*n)
# BFS
class Solution:
    def floodFill(self, image: List[List[int]], sr: int, sc: int, color: int) -> List[List[int]]:
        if image==None or color==image[sr][sc]: return image
        from collections import deque
        q=deque()
        directions=[[1,0],[-1,0],[0,1],[0,-1]]
        q.append((sr,sc))
        oldcolor=image[sr][sc]
        image[sr][sc]=color
        while len(q)!=0:
            cur=q.popleft()
            for d in directions:
                r=d[0]+cur[0]
                c=d[1]+cur[1]
                if r>=0 and c>=0 and r<len(image) and c<len(image[0]) and image[r][c]==oldcolor:
                    # print(r,c)
                    q.append((r,c))
                    image[r][c]=color
        return image
# DFS
# Time Complexity: O(m*n)
# Space Complexity: O(m*n)
#     def floodFill(self, image: List[List[int]], sr: int, sc: int, color: int) -> List[List[int]]:
#         self.clr=color
#         self.img=image
#         self.visted=[[False for j in range(len(image[0]))] for i in range(len(image))]
#         if self.img==None or self.clr==self.img[sr][sc]: return self.img
#         self.directions=[[1,0],[-1,0],[0,1],[0,-1]]
#         self.oldcolor=self.img[sr][sc]
#         self.dfs(sr,sc)
#         return self.img

#     def dfs(self,sr: int, sc: int):
#         if sr<0 or sc<0 or sr>=len(self.img) or sc>=len(self.img[0]) or self.img[sr][sc]!=self.oldcolor or self.visted[sr][sc]==True: return
#         self.img[sr][sc]=self.clr
#         self.visted[sr][sc]=True
#         for d in self.directions:
#             r=d[0]+sr
#             c=d[1]+sc
#             self.dfs(r,c)
        
