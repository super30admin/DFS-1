class Solution:
    def floodFill(self, image: List[List[int]], sr: int, sc: int, color: int) -> List[List[int]]:
        
        if image[sr][sc] == color:
            return image
        
        dir = [[0,1],[1,0],[-1,0],[0,-1]]     
        
        def dfs(image, sr,sc,color,old,m,n):
            # base case
            if sr > m-1 or sr < 0 or sc < 0 or sc > n-1 or image[sr][sc] != old:
                # print(sr,sc)
                return
            image[sr][sc] = color
            #logic
            for x, y in dir:
                row = sr + x
                col = sc + y
                dfs(image, row, col, color, old, m, n)
                
        
        dfs(image, sr, sc, color, image[sr][sc],len(image), len(image[0]))
        return image
                
                
            
            