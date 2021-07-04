from collections import deque
from typing import List


class Solution:
    def floodFill(self, image: List[List[int]], sr: int, sc: int, newColor: int) -> List[List[int]]:
        if image == None or len(image) == 0 or len(image[0]) == 0 or image[sr][sc] == newColor:
            return image

        color=image[sr][sc] #original color
        m=len(image)
        n=len(image[0])
        q=deque()
        directions = [(-1, 0), (0, 1), (1, 0), (0, -1)]
        q.append((sr,sc))
        image[sr][sc]=newColor #marking visited
        #no need to maintain size variable as we are not treating each level node as distinct
        #as at the end we are replacing all the cell from old color to new color
        while q:
            popped=q.popleft()
            #go over all neighbors
            for dr in directions:
                neighbor_row= popped[0]+dr[0]
                neighbor_column=popped[1]+dr[1]

                if (neighbor_row>=0 and neighbor_column>=0 and neighbor_row<m and neighbor_column<n and image[neighbor_row][neighbor_column]==color): #if neighbor is of original color
                    q.append((neighbor_row,neighbor_column))
                    image[neighbor_row][neighbor_column]=newColor #make it new color


        return image

s=Solution()
print(s.floodFill([[1,1,1],[1,1,0],[1,0,1]],1,1,2))
