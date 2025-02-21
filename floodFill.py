"""
BFS Approach -
TC - O(m * n)
SC - O(m * n)
"""
class Solution:
    def floodFill(self, image: List[List[int]], sr: int, sc: int, color: int) -> List[List[int]]:
        if image is None or len(image) == 0 or image[sr][sc] == color: return image

        m = len(image)
        n = len(image[0])

        original_color = image[sr][sc]

        # update original image color with new color
        image[sr][sc] = color

        q = deque([])

        q.append([sr,sc])

        dirs = [[1, 0], [-1, 0], [0, 1], [0, -1]]

        while q:
            qsize = len(q)
            for i in range(qsize):
                curr = q.popleft()
                for directions in dirs:
                    new_row = curr[0] + directions[0]
                    new_col = curr[1] + directions[1]

                    if new_row >= 0 and new_col >= 0 and new_row < m and new_col < n and image[new_row][new_col] == original_color:
                        image[new_row][new_col] = color
                        q.append([new_row, new_col])
        return image

