# Breadth first search
# Time complexity - O(n*m)
# Space complexity - O(n*m) queue space
# Did this solution run on leetcode? - yes
from collections import deque
class Solution:
    def floodFill(self, image: List[List[int]], sr: int, sc: int, newColor: int) -> List[List[int]]:
        if not image or len(image)==0:
            return
        
        n, m = len(image), len(image[0])
        matchColor = image[sr][sc]
        # edge case
        if matchColor == newColor:
            return image
        
        # directions array - right, up, down, up
        dirs = [(1, 0), (-1, 0), (0, 1), (0, -1)]
        # fill the starting pixel with the new color
        image[sr][sc] = newColor
        
        # Time - O(n*m)
        # begin traversing from the starting index
        q = deque([(sr, sc)])
        while q:
            for _ in range(len(q)):
                r, c = q.popleft()
                for d in dirs:
                    if 0<=r+d[0]<n and 0<=c+d[1]<m and image[r+d[0]][c+d[1]]==matchColor:
                        # add the new color to the new location.
                        image[r+d[0]][c+d[1]] = newColor
                        q.append((r+d[0], c+d[1]))
        
        return image
    
        
# Depth first search
# Time complexity - O(n*m)
# Space complexity - O(n*m)
# Did this solution run on leetcode? - yes
class Solution:
    def floodFill(self, image: List[List[int]], sr: int, sc: int, newColor: int) -> List[List[int]]:
        if not image or len(image)==0:
            return
        
        n, m = len(image), len(image[0])
        # color at starting index of an image.
        matchColor = image[sr][sc]
        # edge case
        if matchColor == newColor:
            return image
        
        # directions array - right, up, down, up
        dirs = [(1, 0), (-1, 0), (0, 1), (0, -1)]
        q = [(sr, sc)]
        image[sr][sc] = newColor    # set color at the starting index.
        while q:
            r, c = q.pop()
            for d in dirs:
                if 0<=r+d[0]<n and 0<=c+d[1]<m and image[r+d[0]][c+d[1]]==matchColor:
                    # add the new color to the new location.
                    image[r+d[0]][c+d[1]] = newColor
                    q.append((r+d[0], c+d[1]))
                    
        return image


# Recursive solution
# Time complexity - O(n*m)
# Space complexity - O(n*m)) # recursive stack 
# Did this solution run on leetcode? - yes
class Solution:
    def floodFill(self, image: List[List[int]], sr: int, sc: int, newColor: int) -> List[List[int]]:
        if not image or len(image)==0:
            return
        
        matchColor = image[sr][sc]
        # edge case
        if matchColor == newColor:
            return image
        
        # depth first search
        def dfs(r, c):
            if image[r][c]==matchColor:
                image[r][c] = newColor
                if r>0: dfs(r-1, c)
                if r<len(image)-1: dfs(r+1, c)
                if c>0: dfs(r, c-1)
                if c<len(image[0])-1: dfs(r, c+1)
            
        dfs(sr, sc)
        return image