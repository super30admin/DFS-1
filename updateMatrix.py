# Time Complexity : O(N) where N is the number of elements
# Space Complexity : O(N)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
class Solution:
    def updateMatrix(self, mat: List[List[int]]) -> List[List[int]]:
        rows = len(mat[0])
        cols = len(mat)
        res = [[-1] * rows for _ in range(cols)]
        q = []
        for row in range(rows):
            for col in range(cols):
                if mat[col][row] == 0:
                    q.append((col, row, 0))
        while q:
            y, x, l = q.pop(0)

            if res[y][x] < 0:
                res[y][x] = l
            else:
                res[y][x] = res[y][x]

            for nx, ny in [(x - 1, y), (x + 1, y), (x, y - 1), (x, y + 1)]:
                if 0 <= nx < rows and 0 <= ny < cols and res[ny][nx] < 0:
                    q.append((ny, nx, l + 1))
        return res
