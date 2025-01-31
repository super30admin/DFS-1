"""
problem 1: flood fill
TC: O(mn)
SC: O(mn)
Approach: BFS
"""
class Solution:
    def floodFill(self, image: List[List[int]], sr: int, sc: int, color: int) -> List[List[int]]:
        if not image or len(image) == 0 or image[sr][sc] == color:
            return image

        m = len(image)
        n = len(image[0])
        old_color = image[sr][sc]
        image[sr][sc] = color
        q = [[sr, sc]]
        dirs = [[-1, 0], [1, 0], [0, -1], [0, 1]]  # U D L R

        while q:
            curr = q.pop(0)
            for dir_ in dirs:
                nr = curr[0] + dir_[0]
                nc = curr[1] + dir_[1]
                if nr >= 0 and nr < m and nc >= 0 and nc < n and image[nr][nc] == old_color:
                    image[nr][nc] = color
                    q.append([nr, nc])

        return image