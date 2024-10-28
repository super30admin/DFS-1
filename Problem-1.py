#Approach
# start with the index 0,0 and explore all the adjacents if the source color is not equal to color
# update the color in th image array it self


#Complexities
#Time: 0(N*M)
#Space : O(N)

from typing import List



class Solution:
    def floodFill(self, image: List[List[int]], sr: int, sc: int, color: int) -> List[List[int]]:
        source_color = image[sr][sc]
        if source_color == color:
            return image
        queue = []
        queue.append((sr, sc))
        image[sr][sc] = color
        directions = [[-1, 0], [1, 0], [0, -1], [0, 1]]
        rows = len(image)
        columns = len(image[0])
        while queue:
            (i, j) = queue.pop(0)
            for [dr, dc] in directions:
                nr, nc = i + dr, j + dc
                if 0 <= nr < rows and 0 <= nc < columns and image[nr][nc] == source_color:
                    queue.append((nr, nc))
                    image[nr][nc] = color
        return image
