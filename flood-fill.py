# Time Complexity: O(n)
# Space Complexity: O(1)
class Solution(object):
    def floodFill(self, image, sr, sc, newColor):
        """
        :type image: List[List[int]]
        :type sr: int
        :type sc: int
        :type newColor: int
        :rtype: List[List[int]]
        """
        # DFS
        def dfs(image, i, j, newColor, oldColor):
            if (i<0 or j<0 or i>=len(image) or j>=len(image[0]) or image[i][j] != oldColor or image[i][j] == newColor):
                return
            image[i][j]=newColor;
            dfs(image, i+1, j, newColor, oldColor)
            dfs(image, i, j-1, newColor, oldColor)
            dfs(image, i-1, j, newColor, oldColor)
            dfs(image, i, j+1, newColor, oldColor)

        if image[sr][sc]!=newColor:
            dfs(image,sr,sc,newColor,image[sr][sc])
        return image;
        # BFS
#         q = deque()
#         result = set()
#         rows, cols = len(image), len(image[0])
#         q.append([sr,sc])
#         result.add((sr,sc))
            
#         dirs = [[0,1], [0,-1], [1,0], [-1,0]]
#         while q:
#             size = len(q)
#             print(q)
#             for i in range(size):
#                 r, c = q.popleft()
#                 for dr, dc in dirs:
#                     row, col = dr + r, dc + c
#                     if (row < 0 or row == len(image) or col < 0 or col == len(image[0]) or image[row][col] != image[sr][sc] or (row, col) in result):
#                         continue
#                     q.append([row, col])
#                     result.add((row, col))

#         for x in result:
#             image[x[0]][x[1]] = newColor
#         return image