
import collections
#Time complexity: O(m*n)
#Space complexity: O(m*n)
#Works on leetcode: yes
#Approach: We use a queue to perform BFS and start from the source cell. While queue is not empty, we pop from it and see 
#if the neighbouring cells are within bound and of original color, we add those cells to the queue. 
class Solution:
    def floodFillBFS(self, image: List[List[int]], sr: int, sc: int, newColor: int) -> List[List[int]]:
        old, m, n = image[sr][sc], len(image), len(image[0])
        q = collections.deque([(sr,sc)])
        if image[sr][sc]!=newColor:
            while q:
                a,b = q.popleft()
                image[a][b]=newColor
                for i,j in [(a-1,b),(a+1,b),(a,b-1),(a,b+1)]:
                    if 0<=i<m and 0<=j<n and image[i][j]==old:
                        q.append((i,j))
        return image
#Time complexity: O(m*n)
#Space complexity: O(m*n)
#Works on leetcode: yes
#Approach: We perform DFS on the source cell and continue DFS till either next cell is within bounds or the next cell is same
# color as original cell. Edge case is where new color and original are same
class Solution:
    def floodFillDFS(self, image: List[List[int]], sr: int, sc: int, newColor: int) -> List[List[int]]:
        r, c, original = len(image), len(image[0]), image[sr][sc]
        def dfs(row, col):
            if (not (0<=row<r and 0<=col<c)) or image[row][col]!=original:
                return 
            image[row][col] = newColor
            for i,j in [(1,0),(0,1),(-1,0),(0,-1)]:
                dfs(row+i,col+j)
        if newColor!=original:
            dfs(sr,sc)
        return image