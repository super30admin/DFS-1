
# Time: O(m*n)
# Space: O(m*n)

# Approach:
# fill (sr,sc) with new color and look for adjacent pixel with same color
# If we find one, recursively call function for that pixel after coloring it. 

class Solution:
    def floodFill(self, image: List[List[int]], sr: int, sc: int, newColor: int) -> List[List[int]]:
        if image[sr][sc] == newColor: return image
        rows = len(image)
        cols = len(image[0])
        oldColor = image[sr][sc]
        image = self.floodFillHelper(image, sr, sc, oldColor, newColor, rows, cols)
        return image

    def floodFillHelper(self, image, row, col, oldColor, newColor, rows, cols):
        image[row][col] = newColor

        directions = {(0, 1), (0, -1), (1, 0), (-1, 0)}

        for direction in directions:
            new_row = row + direction[0]
            new_col = col + direction[1]

            if 0 <= new_row < rows and 0 <= new_col < cols and image[new_row][new_col] == oldColor:
                image = self.floodFillHelper(image, new_row, new_col, oldColor, newColor, rows, cols)

        return image