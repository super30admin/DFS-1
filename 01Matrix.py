# Time Complexity : O(m*n)
# Space Complexity : O(m*n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
# Approach : First, add all 0s to a queue and mark all 1s as -1 to show they haven't been processed yet.
# Then, use BFS from the 0s to expand layer by layer and assign the correct distance to each -1.
# This way, every 1 gets the shortest distance to the nearest 0 as BFS explores in waves.

class Solution:
    def updateMatrix(self, mat: List[List[int]]) -> List[List[int]]:
        dirs = [[-1, 0], [1, 0], [0, 1], [0, -1]]
        rows, cols = len(mat), len(mat[0])

        q = deque()

        for i in range(rows):
            for j in range(cols):
                if mat[i][j] == 0:
                    q.append([i,j])
                else:
                    mat[i][j] = -1

        dist = 1

        while q:
            size = len(q)
            for _ in range(size):
                curr = q.popleft()
                for dx, dy in dirs:
                    r = curr[0] + dx
                    c = curr[1] + dy
                
                    if 0 <= r < rows and 0 <= c < cols and mat[r][c] == -1:
                        q.append([r, c])
                        mat[r][c] = dist
            dist += 1

        return mat
