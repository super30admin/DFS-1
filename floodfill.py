from typing import List

class BFSSolution:
# Time Complexity : O(m*n) where m is the number of rows and n is the number of columns in the image
# Space Complexity : O(m*n) in the worst case when all the pixels have the same color and we need to change all of them
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

    # BFS
    def floodFill(self, image: List[List[int]], sr: int, sc: int, color: int) -> List[List[int]]:
        from collections import deque
        q = deque()
        m = len(image)
        n = len(image[0])
        original_color = image[sr][sc]

        if color == original_color:
            return image
            
        q.append((sr,sc))
        image[sr][sc] = color
        neighbors = [[-1,0],[0,-1],[0,1],[1,0]]

        while len(q):
            curr = q.popleft()
            for neighbor in neighbors:
                r = curr[0] + neighbor[0]
                c = curr[1] + neighbor[1]
                if r >= 0 and c >= 0 and r < m and c < n and image[r][c] == original_color:
                    q.append((r,c))
                    image[r][c] = color
                
        return image

class DFSSolution:
# Time Complexity : O(m*n) where m is the number of rows and n is the number of columns in the image
# Space Complexity : O(m*n) in the worst case when all the pixels have the same color and we need to change all of them
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

    # DFS
    def floodFill(self, image: List[List[int]], sr: int, sc: int, color: int) -> List[List[int]]:
        original_color = image[sr][sc]

        if original_color == color:
            return image
        
        self.dfs(image, sr, sc, original_color, color)

        return image
    
    def dfs(self, image: List[List[int]], i: int, j: int, original_color: int, color: int)-> None:
        image[i][j] = color
        m = len(image)
        n = len(image[0])
        neighbors = [[-1,0],[0,-1],[0,1],[1,0]]
        for neighbor in neighbors:
            r = i + neighbor[0]
            c = j + neighbor[1]

            if r >= 0 and c >= 0 and r < m and c < n and image[r][c] == original_color:
                self.dfs(image, r, c, original_color, color)