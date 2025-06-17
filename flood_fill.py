# Time complexity: O(mn)
# Space complexity: O(mn)

class Solution:
    def floodFill(self, image: List[List[int]], sr: int, sc: int, newColor: int) -> List[List[int]]:
        if image[sr][sc] == newColor:
            return image
        
        directions = [(0, 1), (0, -1), (1, 0), (-1, 0)]
        old_color = image[sr][sc]
        
        def fill(sr, sc):
            if 0 <= sr < len(image) and 0 <= sc < len(image[0]) and image[sr][sc] == old_color:
                image[sr][sc] = newColor
                for dx, dy in directions:
                    fill(sr + dx, sc + dy)
        
        fill(sr, sc)
        return image
