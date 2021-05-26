class Solution:
    def floodFill(self, image: List[List[int]], sr: int, sc: int, newColor: int) -> List[List[int]]:
        
        if not image or image[sr][sc]==newColor:
            return image  
        color = image[sr][sc]
        m = len(image)
        n = len(image[0])
        q = list()
        image[sr][sc] = newColor
        q.append((sr,sc))
        direct = ((0,1),(0,-1),(-1,0),(1,0))
        while q:
            curr = q.pop(0)
            for direction in direct:
                r = curr[0] + direction[0]
                c = curr[1] + direction[1]
                if r>=0 and r<m and c>=0 and c<n and image[r][c] == color:
                    image[r][c] = newColor
                    q.append((r,c))
        return image
        
        
#  BFS solution - time complexity is O(n) and space complexity is O(n)
