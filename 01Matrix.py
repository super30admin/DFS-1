# Time Complexity : O(m*n)
# Space Complexity : O(m*n) for using the queue data structure
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# The approach followed here is BFS approach using a queue data structure.
# Reversing the logic a bit, trying to find the nearest 1 from 0s and updating the distance
# Rather than finding the distance from 1 to the nearest 0. Hence, adding all the 0s to the queue first and doing a level order traversal

class Solution:
    def updateMatrix(self, mat: List[List[int]]) -> List[List[int]]:
        m = len(mat)
        n = len(mat[0])
        queue = deque()
        directions = [[0, 1], [1, 0], [-1, 0], [0, -1]]

        for r in range(m):
            for c in range(n):
                if mat[r][c] == 0:
                    queue.append((r, c))
                elif mat[r][c] == 1:
                    mat[r][c] = -1
        level = 0
        while queue:
            size = len(queue)
            level += 1
            for i in range(size):
                r, c = queue.popleft()
                for x, y in directions:
                    nr = x + r
                    nc = y + c
                    if nr >= 0 and nc >= 0 and nr < m and nc < n and mat[nr][nc] == -1:
                        mat[nr][nc] = level
                        queue.append((nr, nc))
        return mat