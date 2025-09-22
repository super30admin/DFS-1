# Time Complexity : O(m*n)
# Space Complexity : O(m*n) using the queue data structure
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# The approach followed here is BFS approach using a queue data structure. Iterate through all the neighbors and update the cell
# to given color if it matches the original color

# BFS approach
class Solution:
    def floodFillBFS(self, image: List[List[int]], sr: int, sc: int, color: int) -> List[List[int]]:
        queue = deque()
        queue.append((sr, sc))
        origColor = image[sr][sc]

        if origColor == color:
            return image

        image[sr][sc] = color
        directions = [[0, 1], [1, 0], [-1, 0], [0, -1]]
        m, n = len(image), len(image[0])

        while queue:
            r, c = queue.popleft()
            for x, y in directions:
                nr = x + r
                nc = y + c
                if nr < 0 or nc < 0 or nr == m or nc == n or image[nr][nc] != origColor:
                    continue
                if image[nr][nc] == origColor:
                    image[nr][nc] = color
                queue.append((nr, nc))

        return image


# Time Complexity : O(m*n)
# Space Complexity : O(m*n) for recursive stack
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Here the approach is to do a DFS starting from the source row(sr) and source column(sc) and then update the image cell with color
# if it's not equal to the orig color. And then repeat the same in all the directions
#DFS approach:
class Solution:
    def floodFillDFS(self, image: List[List[int]], sr: int, sc: int, color: int) -> List[List[int]]:
        origColor = image[sr][sc]
        m, n = len(image), len(image[0])
        directions = [[0, 1], [1, 0], [-1, 0], [0, -1]]

        if origColor == color:
            return image

        def dfs(r, c):
            nonlocal origColor, directions, m, n
            if r < 0 or c < 0 or r == m or c == n or image[r][c] != origColor:
                return None

            image[r][c] = color

            for x, y in directions:
                nr = x + r
                nc = y + c
                dfs(nr, nc)

        dfs(sr, sc)

        return image
