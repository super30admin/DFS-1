# Time Complexity: O(m*n)
# Space Complexity: O(m*n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class Solution:
    #DFS Solution
    def __init__(self):
        self.dirs = [[-1,0],[0,-1],[1,0],[0,1]]
        self.old = None
        self.row_l = None
        self.col_l = None

    def floodFill(self, image: List[List[int]], sr: int, sc: int, color: int) -> List[List[int]]:
        # if the current element is already = to color then no change is needed
        if image[sr][sc] == color:
            return image
        self.row_l = len(image)
        self.col_l = len(image[0])
        # old will store the color we need to change in the matrix
        self.old = image[sr][sc]

        self.dfs(image,sr,sc,color)
        return image

    def dfs(self,image,row,col,color):
        if image[row][col]!=self.old:
            return
        image[row][col] = color

        for dir in self.dirs:
            nr = row + dir[0]
            nc = col + dir[1]
            if (nr>=0 and nr<self.row_l) and (nc>=0 and nc<self.col_l):
                self.dfs(image,nr,nc,color)

    # BFS Solution
    # def floodFill(self, image: List[List[int]], sr: int, sc: int, color: int) -> List[List[int]]:
    #     if image[sr][sc]==color:
    #         return image
    #     row_l = len(image)
    #     col_l = len(image[0])
    #     pixel_color = image[sr][sc]
    #     image[sr][sc] = color
    #     queue = list()
    #     queue.append([sr,sc])
    #     dirs = [[1,0],[-1,0],[0,1],[0,-1]]

    #     while len(queue)!=0:
    #         curr = queue.pop(0)
    #         row = curr[0]
    #         col = curr[1]
    #         # image[row][col] = color
    #         for dir in dirs:
    #             nr = row + dir[0]
    #             nc = col + dir[1]
    #             if nr>=0 and nr<row_l and nc>=0 and nc<col_l:
    #                 if image[nr][nc]==pixel_color: #and image[nr][nc]!=color:
    #                     image[nr][nc] = color
    #                     queue.append([nr,nc])
    #     return image