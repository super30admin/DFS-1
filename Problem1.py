## Problem1 (https://leetcode.com/problems/flood-fill/)

# Method1: Using BFS
# M -- No. of Rows
# N -- No. of Cols
# Time Complexity : O(M*N) -- as in worst case we would be going through all the nodes to change the color
# Space Complexity : O(M*N) -- O(m*n / 2) -- as in leaf level at max m*n/2 nodes would be in the queue
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach in three sentences only
# Going level by level to update the color to mentioned color. Since a node in the next level could be added in the queue from multiple nodes
# as it could adjacent to multiple nodes at same level. So to avoid repeats in the queue, we change the color of the neighbor before adding to
# the queue. In this way of another node at the same level has it as its neighbor, we will not add it to the queue as it is already changed
# to the mentioned color.

from collections import deque
class Solution(object):
    def floodFill(self, image, sr, sc, color):
        """
        :type image: List[List[int]]
        :type sr: int
        :type sc: int
        :type color: int
        :rtype: List[List[int]]
        """
        if(image[sr][sc] == color):
            # no changes to be made in the image
            return image
            
        # keep note of the original color
        ogColor = image[sr][sc]
        # change the color to mentioned color
        image[sr][sc] = color
        que = deque()
        que.append((sr, sc))
        direc = [(0,1), (1,0), (0,-1), (-1,0)]

        while(que):
            # we dont need size, as nothing is required to keep level by level
            r,c = que.popleft()
            for i in range(len(direc)):
                nr = r + direc[i][0]
                nc = c + direc[i][1]
                # check bounds
                if((0 <= nr < len(image)) and (0 <= nc < len(image[0])) and image[nr][nc] == ogColor):
                    # change the color to mentioned color
                    image[nr][nc] = color
                    # append to the queue
                    que.append((nr,nc))

        
        return image

sol = Solution()
print("Method1: Using BFS")
print(sol.floodFill([[1,1,1],[1,1,0],[1,0,1]], 1, 1, 2))
print(sol.floodFill([[0,0,0],[0,0,0]], 0, 0, 0))


# Method2: Using DFS
# M -- No. of Rows
# N -- No. of Cols
# Time Complexity : O(M*N) -- as in worst case we would be going through all the nodes to change the color
# Space Complexity : O(M*N) -- as in worst case m*n recursive call can go into the recursive stack
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach in three sentences only



from collections import deque
class Solution(object):
    def floodFill(self, image, sr, sc, color):
        """
        :type image: List[List[int]]
        :type sr: int
        :type sc: int
        :type color: int
        :rtype: List[List[int]]
        """
        if(image[sr][sc] == color):
            # no changes to be made in the image
            return image

        def dfs(ogColor, r, c, image, mentionedColor, direc):
            # base
            # bounds
            if((r < 0) or (c < 0) or (r >= len(image)) or (c >= len(image[0])) or image[r][c] != ogColor):
                return

            # change the color to mentioned color
            image[r][c] = mentionedColor

            for i in range(len(direc)):
                nr = r + direc[i][0]
                nc = c + direc[i][1]
                dfs(ogColor, nr, nc, image, mentionedColor, direc)



            
        # keep note of the original color
        ogColor = image[sr][sc]
        direc = [(0,1), (1,0), (0,-1), (-1,0)]
        dfs(ogColor, sr, sc, image, color, direc)
        return image

sol = Solution()
print("Method2: Using DFS")
print(sol.floodFill([[1,1,1],[1,1,0],[1,0,1]], 1, 1, 2))
print(sol.floodFill([[0,0,0],[0,0,0]], 0, 0, 0))