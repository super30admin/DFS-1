# ## Problem1 (https://leetcode.com/problems/flood-fill/)

# BFS Approach
# // Time Complexity :O(m*n)
# // Space Complexity :O(m*n)
# // Did this code successfully run on Leetcode :Yes
# // Any problem you faced while coding this : DFS code wrong, not sure why


# // Your code here along with comments explaining your approach
# from collections import deque


# class Solution:
#     def floodFill(self, image: List[List[int]], sr: int, sc: int, color: int) -> List[List[int]]:
#         # if image not present return
#         if not image:
#             return image
#         # if already new colour in position --> retrun
#         if image[sr][sc] == color:
#             return image
#         # variables for no(rows) and no(cols)
#         self.m = len(image)
#         self.n = len(image[0])
#         # directions list for going over each direction
#         self.directions = [(0, 0), (0, 1), (1, 0), (0, -1), (-1, 0)]
#         # Variable for keeping original colour
#         original_colour = image[sr][sc]

#         self.dfs(image, sr, sc, color, original_colour)
#         return image

#     def dfs(self, image, cr, cc, color, original_colour):
#         # base case
#         if cr < 0 or cr >= self.m or cc < 0 or cc >= self.n or image[cr][cc] != original_colour:
#             return
#         # logic
#         for direction in self.directions:
#             nr = sr + direction[0]
#             nc = sc + direction[1]
#             self.dfs(image, nr, nc, color, original_colour)


BFS Approach
// Time Complexity :O(m*n)
// Space Complexity :O(m*n)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach


class Solution:
    def floodFill(self, image, sr, sc, color):
        # if image not present return
        if not image:
            return image
        # if already new colour in position --> retrun
        if image[sr][sc] == color:
            return image
        # variables for no(rows) and no(cols)
        m = len(image)
        n = len(image[0])
        # directions list for going over each direction
        directions = [(0, 0), (0, 1), (1, 0), (0, -1), (-1, 0)]
        # Variable for keeping original colour
        original_colour = image[sr][sc]
        # queue for getting pixel coordinates
        q = deque([sr, sc])
        # till q is empty
        while q:
            cr = q.popleft()
            cc = q.popleft()
            # going over all 4 directions
            for direction in directions:
                nr = cr + direction[0]
                nc = cc + direction[1]
                # checking nr and nc bounds
                # checking if pixel == original colour
                if 0 <= nr < m and 0 <= nc < n and image[nr][nc] == original_colour:
                    # adding it to q
                    q.append(nr)
                    q.append(nc)
                    # changing to new colour
                    image[nr][nc] = color
        return image
sol = Solution()
image = [[1, 1, 1], [1, 1, 0], [1, 0, 1]]
sr = 1
sc = 1
color = 2
print(sol.floodFill(image, sr, sc, color))
