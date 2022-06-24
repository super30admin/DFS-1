#Time Complexity: O(m*n)
#space complexity: O(m*n)

class Solution:
    def floodFill(self, image: List[List[int]], sr: int, sc: int, color: int) -> List[List[int]]:
        
        m = len(image)
        n = len(image[0])
        orgColor = image[sr][sc]
        if image[sr][sc] == color:
            return image
        
        q = deque()
        dirs = [[0,1],[1,0],[-1,0],[0,-1]]
        q.append(sr)
        q.append(sc)
        image[sr][sc] = color
        while q:
            cR = q.popleft()
            cC = q.popleft()
            
            for d in dirs:
                nR = cR + d[0]
                nC = cC + d[1]
                if nR >= 0 and nC >=0 and nR < m and nC < n and image[nR][nC] == orgColor:
                    q.append(nR)
                    q.append(nC)
                    image[nR][nC] = color
                    
        return image
                    
