class Solution:
    ###dfs solution below
    """
    TC: O(n)
    SC:o(n)
    """

    def floodFill(self, image: List[List[int]], sr: int, sc: int, newColor: int) -> List[List[int]]:
        if image[sr][sc] == newColor:
            return image
        self.m = len(image)
        self.n = len(image[0])
        self.color = image[sr][sc]
        self.dirs = [[0, 1], [0, -1], [1, 0], [-1, 0]]
        self.dfs(image, sr, sc, newColor)
        return image

        return image

    def dfs(self, image, sr, sc, newColor):
        ###base
        if sr < 0 or sc < 0 or sc >= self.n or sr >= self.m or image[sr][sc] != self.color:
            return
            ###logic
        image[sr][sc] = newColor
        for direction in self.dirs:
            row = sr + direction[0]
            col = sc + direction[1]
            ###boldly call the dfs on the neighbouring cells
            self.dfs(image, row, col, newColor)

    ###python bfs below Tc: O(n) where n is the number of pixels in the image; or we can say m*n
    ####sc: O(n)
#         if image[sr][sc]==newColor:
#             return image
#         m=len(image)
#         n=len(image[0])
#         rowq=collections.deque()
#         colq=collections.deque()
#         colororg=image[sr][sc]
#         image[sr][sc]=newColor
#         rowq.append(sr)
#         colq.append(sc)
#         dirs=[[0,1], [0,-1], [1,0], [-1,0]]
#         while rowq:###we can take column too
#             currowind=rowq.popleft()
#             currcolind=colq.popleft()
#             for direction in dirs:
#                 neighbourrow=currowind+direction[0]
#                 neighbourcol=currcolind+direction[1]
#                 ###check if it is old color
#                 ###also check neighbour row and col remain within bounds
#                 if (neighbourrow>=0 and neighbourcol>=0 and neighbourrow<m and neighbourcol<n and image[neighbourrow][neighbourcol]==colororg):
#                     image[neighbourrow][neighbourcol]=newColor
#                     #### now add in the queue the neighbours
#                     rowq.append(neighbourrow)
#                     colq.append(neighbourcol)
#         return image


