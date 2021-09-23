# Time Complexity : O(M*N) as we go through entire matrix
# Space Complexity : O(M*N) similar to rotting oranges, 
# in worst case all element points in queue
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
# Your code here along with comments explaining your approach

# using dfs color all cells, whose current color is the previous color, to newColor


from collections import deque

class Solution:
    def floodFill(self, image, sr, sc, newColor):

        if image is None or len(image) == 0 or image[sr][sc] == newColor:
            return image
        m, n = len(image), len(image[0])
        prevColor = image[sr][sc]
        image[sr][sc] = newColor
        q = deque()
        q.append([sr,sc])
        dirs = [[0, 1], [0, -1], [-1, 0], [1, 0]]

        while len(q) != 0:
            curr = q.popleft()
            for d in dirs:
                nr = curr[0] + d[0]
                nc = curr[1] + d[1]
                if nr >= 0 and nr < m and nc >= 0 and nc < n and image[nr][nc] == prevColor:
                    image[nr][nc] = newColor
                    q.append([nr, nc])
        return image
