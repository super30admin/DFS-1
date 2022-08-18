class Solution:
    def floodFill(self, image: List[List[int]], sr: int, sc: int, newColor: int) -> List[List[int]]:
        
        ###### BFS Approach Time : O(n) and space O(n) ##########
        
#         m = len(image)
#         n = len(image[0])
        
#         if image[sr][sc] == newColor:
#             return image
        
#         q = collections.deque()
#         q.appendleft((sr,sc))
#         prevColor = image[sr][sc]
#         image[sr][sc] = newColor
        
#         dirs = [(-1,0),(0,-1),(1,0),(0,1)]
        
#         while(q):
#             size = len(q)
            
#             for i in range(size):
#                 curr = q.pop()

#                 for d in dirs:
#                     r = curr[0] + d[0]
#                     c = curr[1] + d[1]

#                     if r>=0 and r<m and c>=0 and c<n and image[r][c] == prevColor: 
#                         # If r & c are in bounds and the pixel ar r and c is the same as the original color before flooding
#                         image[r][c] = newColor
#                         q.appendleft((r,c))
#         return image
        
        ############ DFS Approach  Time: O(n) and Space: O(n) ################
        
         
        m = len(image)
        n = len(image[0])
        
        if image[sr][sc] == newColor:
            return image
        
        prevColor = image[sr][sc]
        dirs = [(-1,0),(0,-1),(1,0),(0,1)]
        
        def dfs(r,c):
            if r<0 or r>=m or c<0 or c>=n or image[r][c] != prevColor:
                return
            
            image[r][c] = newColor
            
            for d in dirs:
                dfs(r+d[0],c+d[1])
            return
        
        dfs(sr,sc)
        return image
        