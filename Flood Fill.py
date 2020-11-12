class Solution:
    def floodFill(self, image: List[List[int]], sr: int, sc: int, newColor: int) -> List[List[int]]:
        def rec(image, row, col, color):
            if row < 0 or row >= len(image) or col < 0 or col >= len(image[0]):
                return
            elif image[row][col] != color: return
            else:
                directions = [(0, 1), (1, 0), (-1, 0), (0, -1)]
                image[row][col] = -1
                for r, c in directions:
                    rec(image, row+r, col+c, color)
                image[row][col] = newColor
                return image
            
        return rec(image, sr, sc, image[sr][sc])

Time : O(M*N)
Space : O(M*N)