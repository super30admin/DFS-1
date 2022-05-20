# // Time Complexity : O(m*n)
# // Space Complexity : O(m*n)
#  I used a visited array and queue and changed the input array in place. Please let me know if my
#  Time and Space Complexities are wrong...
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : No
class Solution(object):
    def updateMatrix(self, mat):
        """
        :type mat: List[List[int]]
        :rtype: List[List[int]]
        """
        directions = [[0, 1], [0, -1], [-1, 0], [1, 0]]
        queue = deque([])
        visited = set()
        rows = len(mat)
        cols = len(mat[0])

        for row in range(rows):
            for col in range(cols):
                if mat[row][col] == 0:
                    queue.append((row, col))

        while queue:
            row, col = queue.popleft()
            visited.add((row, col))
            for pos in directions:
                n_row = row + pos[0]
                n_col = col + pos[1]
                if (n_row >= 0 and n_row < rows) and (n_col >= 0 and n_col < cols):
                    if mat[n_row][n_col] != 0:
                        if (n_row, n_col) not in visited:
                            mat[n_row][n_col] = mat[row][col] + 1
                            visited.add((n_row, n_col))
                            queue.append((n_row, n_col))
                        else:
                            mat[n_row][n_col] = min(
                                mat[row][col] + 1, mat[n_row][n_col])

        return mat
