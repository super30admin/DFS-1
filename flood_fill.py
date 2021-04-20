# Time Complexity: O(mn)
# Space Complexity: O(mn)
# Ran on Leetcode: Yes

from queue import Queue
class Solution:
    def floodFill(self, image: List[List[int]], sr: int, sc: int, newColor: int) -> List[List[int]]:
        if not len(image):
            return image
        m = len(image)
        n = len(image[0])
        d = [[0, 1], [0, -1], [-1, 0], [1, 0]]
        q = Queue()
        original_color = image[sr][sc]
        q.put([sr, sc])
        while q.qsize():
            i, j = q.get()
            for elem in d:
                r = i + elem[0]
                c = j + elem[1]
                if r >= 0 and r < m and c >= 0 and c < n and image[r][c] != newColor and original_color == image[r][c]:
                    q.put([r, c])
            image[i][j] = newColor
            
        return image
                
        