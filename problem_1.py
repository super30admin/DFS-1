# Time O(M*N)
# Space O(M*N)
class Solution:
    def floodFill(self, image: List[List[int]], sr: int, sc: int, color: int) -> List[List[int]]:
        if not image or not image[0] or image[sr][sc] == color:
            return image
        m = len(image)
        n = len(image[0])
        ori_color = image[sr][sc]
        def dfs(row, col):
            # base 
            if row < 0 or row >= m or col < 0 or col >= n or image[row][col] != ori_color:
                return   

            # logic 
            image[row][col] = color
            dirr = [[-1,0], [1,0], [0,-1],[0,1]]
            for i, j in dirr:
                dfs(row+i, col+j)

        dfs(sr, sc)
        return image

       