# Time Complexity : O(m * n)
# Space Complexity : O(m * n)
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : no
# Problem Name: Flood Fill

class Solution:
    def floodFill(self, image: List[List[int]], sr: int, sc: int, color: int) -> List[List[int]]:
        m = len(image)
        n = len(image[0])
        oldColor = image[sr][sc]
        
        # If the original color is the same as the new color, no need to do anything
        if oldColor == color:
            return image
        
        # Helper function to perform DFS
        def dfs(r, c):
            # Base case: check if out of bounds or not the same color as the original
            if r < 0 or r >= m or c < 0 or c >= n or image[r][c] != oldColor:
                return
            
            # Change the color of the current cell
            image[r][c] = color
            
            # Explore the 4 possible directions (up, down, left, right)
            dfs(r - 1, c)  # up
            dfs(r + 1, c)  # down
            dfs(r, c - 1)  # left
            dfs(r, c + 1)  # right
        
        # Start DFS from the given start point (sr, sc)
        dfs(sr, sc)
        
        return image

        # m = len(image)
        # n = len(image[0])
        # dirs = [[-1,0],[1,0],[0,1],[0,-1]]
        # oldColor = image[sr][sc]
        # if oldColor == color:
        #     return image

        # q = deque()
        # q.append(sr)
        # q.append(sc)
        # image[sr][sc] = color

        # while q:
        #     currRow = q.popleft()
        #     currCol = q.popleft()
        #     for dr in dirs:
        #         r = currRow + dr[0]
        #         c = currCol + dr[1]
        #         if r >= 0 and c >= 0 and r < m and c < n and image[r][c] == oldColor:
        #             image[r][c] = color
        #             q.append(r)
        #             q.append(c)
        # return image