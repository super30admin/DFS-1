# Approach: BFS
# Time : O(M * N)
# Space: O(M * N)

# Worst case we would have to update all the numbers so visiting the neighbors grows exponentially, hence O( M * N) time and space since we add to queue

from collections import deque
class Solution:
    def floodFill(self, image: List[List[int]], sr: int, sc: int, newColor: int) -> List[List[int]]:
        
        # base case
        if not image or len(image) == 0 or image[sr][sc] == newColor:
            return image

        q = deque()

        rows = len(image)
        cols = len(image[0])

        original_color = image[sr][sc]
        image[sr][sc] = newColor
        q.append((sr, sc))

        dirs = [(-1, 0), (0, -1), (0, 1), (1, 0)]

        while q:

            cr, cc = q.popleft()

            for dir in dirs:
                r = cr + dir[0]
                c = cc + dir[1]

                if r >= 0 and r < rows and c >= 0 and c < cols and image[r][c] == original_color and image[r][c] != newColor:
                    image[r][c] = newColor
                    q.append((r,c))

        return image


# DFS Approach


def floodFill(self, image: List[List[int]], sr: int, sc: int, newColor: int) -> List[List[int]]:

    # base case
    if image == None or len(image) == 0 or image[sr][sc] == newColor:
        return image

    self.rows = len(image)
    self.cols = len(image[0])
    self.original_color = image[sr][sc]

    self.dfs(image, sr, sc, newColor)

    return image

    

def dfs(self, image, sr, sc, newColor):

    # base case
    if sr < 0 or sc < 0 or sr == self.rows or sc == self.cols or image[sr][sc] != self.original_color:
        return 


    # logic
    
    image[sr][sc] = newColor
    dirs = [(-1, 0), (0, -1), (0, 1), (1, 0)]

    for dir in dirs:
        r = sr + dir[0]
        c = sc + dir[1]

        self.dfs(image, r, c, newColor)

        



        

