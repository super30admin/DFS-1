# DFS-1

## Problem1 (https://leetcode.com/problems/flood-fill/)

# Time Complexity= O(n)
# Space Complexity= O(n)

class Solution:
    def floodFill(self, image: List[List[int]], sr: int, sc: int, newColor: int) -> List[List[int]]:
        q=deque()
        c=image[sr][sc]
        q.append([sr,sc])
        d=[[0,1],[0,-1],[1,0],[-1,0]]
        if c==newColor:
            return image
        while q:
            ele=q.popleft()
            image[ele[0]][ele[1]]=newColor
            for j in d:
                x=ele[0]+j[0]
                y=ele[1]+j[1]
                if x>=0 and x<len(image) and y>=0 and y<len(image[0]):
                    if image[x][y]==c:
                        q.append([x,y])

        return image
                
## Problem2 (https://leetcode.com/problems/01-matrix/)

# Time Complexity= O(rc)
# Space Complexity= O(1)

class Solution:
    def updateMatrix(self, matrix: List[List[int]]) -> List[List[int]]:
        m, n = len(matrix), len(matrix[0])
        for i, row in enumerate(matrix):
            for j, cell in enumerate(row):
                if cell:
                    top = matrix[i-1][j] if i else float('inf')
                    left = matrix[i][j-1] if j else float('inf')
                    matrix[i][j] = min(top, left) + 1
        for i in reversed(range(m)):
            for j in reversed(range(n)):
                if cell := matrix[i][j]:
                    bottom = matrix[i+1][j] if i < m - 1 else float('inf')
                    right = matrix[i][j+1] if j < n - 1 else float('inf')
                    matrix[i][j] = min(cell, bottom + 1, right + 1)
        return matrix
