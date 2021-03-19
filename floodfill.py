//Time complexity: o(mXn)
//space complexity: o(1)
import collections
class Solution:
    def floodFill(self, image: List[List[int]], sr: int, sc: int, newColor: int) -> List[List[int]]:
        dirs = [[0,1],[1,0],[-1,0],[0,-1]]
        r = len(image)
        c = len(image[0])
        if image is None or r == 0 or c == 0 or image[0] is None or image[sr][sc] == newColor:
            return image
        directions = [[0,1],[1,0],[-1,0],[0,-1]]
        color = image[sr][sc]
        image[sr][sc] = newColor        
        queue = collections.deque()
        queue.append([sr,sc])        
        while queue:
            start_row, start_column = queue.popleft()
            for i in range(len(directions)):
                r1 = start_row + directions[i][0]
                c1 = start_column + directions[i][1]
                if r1 >= 0 and c1>= 0 and r1 < r and c1 < c and image[r1][c1] == color:
                    image[r1][c1] = newColor
                    queue.append([r1,c1])
        return image
