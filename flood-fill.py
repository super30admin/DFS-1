
#---------------Solution 1 : BFS-------------
''' Time Complexity : O(m*n) 
    Space Complexity : O(m*n) 
    Did this code successfully run on Leetcode : Yes
    Any problem you faced while coding this :  No
'''

class Solution:
    def floodFill(self, image: List[List[int]], sr: int, sc: int, color: int) -> List[List[int]]:
        rows,cols = len(image),len(image[0])
        q = deque()
        old_color = image[sr][sc]
        if image[sr][sc] == color:
            return image
        image[sr][sc] = color
        q.append((sr,sc))
        while q:
            i, j  = q.popleft()
            dirs = [(i,j+1),(i,j-1),(i-1,j),(i+1,j)]
            for r,c in dirs:
                if 0<=r<rows and 0<=c<cols and image[r][c] == old_color:
                    image[r][c] = color
                    q.append((r,c))
        
        return image

#---------------Solution 2 : DFS-------------
''' Time Complexity : O(m*n) 
    Space Complexity : O(m*n) 
    Did this code successfully run on Leetcode : Yes
    Any problem you faced while coding this :  No
'''
class Solution:
    def floodFill(self, image: List[List[int]], sr: int, sc: int, color: int) -> List[List[int]]:
        self.rows,self.cols = len(image),len(image[0])
        self.dirs = [(-1,0),(1,0),(0,1),(0,-1)]
        old_color = image[sr][sc]
        if image[sr][sc] == color:
            return image
        
        def dfs(i, j):
            #base
            #logic
            image[i][j] = color
            for dir in self.dirs:
                r = dir[0] + i
                c = dir[1] + j
                if 0<=r<self.rows and 0<=c<self.cols and image[r][c] == old_color:
                    dfs(r,c)
        dfs(sr,sc)
        return image