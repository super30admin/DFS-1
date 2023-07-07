# Time complexity : O(m*n), we shoould traverse all elements in worst case
# Space complexity : O(m*n)
# The code ran on Leetcode

# Start at the initial index, traverse to all directions and move further if the conditions are satisfied. 

class Solution:
    def floodFill(self, image: List[List[int]], sr: int, sc: int, color: int) -> List[List[int]]:
        start_color = image[sr][sc]
        visited = set()
        visited.add((sr, sc))
        image[sr][sc] = color
        def helper(image, sr, sc, color):
            dirs = [[1, 0], [-1, 0], [0, 1], [0, -1]]
            for dr, dc in dirs:
                r = sr + dr; c = sc + dc

                if 0 <= r < len(image) and 0 <= c < len(image[0]) and image[r][c] == start_color and (r, c) not in visited:
                    image[r][c] = color
                    visited.add((r, c))
                    helper(image, r, c, color)
    
        helper(image, sr, sc, color)
        return image