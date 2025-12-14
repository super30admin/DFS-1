'''
Docstring for flood-fill
TC: O(m * n)
SC: O(m * n)
'''
class Solution:
    def __init__(self):
        self.dirs = [[1, 0], [0, 1], [-1, 0], [0, -1]]

    def floodFill( self, image, sr, sc, color):
        m = len(image)
        n = len(image[0])
        q = []
        q.append([sr, sc])
        original_color = image[sr][sc]
        # if there is no color change
        if original_color == color:
            return image
        while len(q) > 0:
            curr = q.pop(0)
            # check or each direction
            for dir in self.dirs:
                r = dir[0] + curr[0]
                c = dir[1] + curr[1]
                # Out of Bound check
                if r >= 0 and c >= 0 and r < m and c < n and image[r][c] == original_color:
                    image[r][c] = color
                    q.append([r, c])
        return image


image = [[1,1,1],[1,1,0],[1,0,1]]
sr = 1
sc = 1
color = 2
s = Solution()
print(s.floodFill(image, sr, sc, color))
    
image = [[0,0,0],[0,0,0]]
sr = 0
sc = 0
color = 0
print(s.floodFill(image, sr, sc, color))
