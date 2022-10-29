# Time complexity: O(m * n)
# Space compleity: O(m + n)

# The code sucessfully ran on Leetcode

class Solution:
    def floodFill(self, image: List[List[int]], sr: int, sc: int, color: int) -> List[List[int]]:
        if image == None or len(image) == 0 or image[sr][sc] == color:    return image
        
        rows = []
        cols = []
        oldColor = image[sr][sc]
        dirs = [[0, 1], [0, -1], [1, 0], [-1, 0]]
        m = len(image)
        n = len(image[0])
        
        rows.append(sr)
        cols.append(sc)
        image[sr][sc] = color
        
        while rows:
            row = rows.pop(0)
            col = cols.pop(0)
            
            for i in dirs:
                nr = row + i[0]
                nc = col + i[1]
                
                if nr >= 0 and nr < m and nc >= 0 and nc < n and image[nr][nc] == oldColor:
                    image[nr][nc] = color
                    rows.append(nr)
                    cols.append(nc)
                     
        return image