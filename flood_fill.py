# Time Complexity: O(mn) where m and n is the size of the matrix
# Space Complexity:  O(mn)
#  Did this code successfully run on Leetcode : Yes
#  Any problem you faced while coding this : No

class Solution:
    def floodFill(self, image: List[List[int]], sr: int, sc: int, color: int) -> List[List[int]]:
        dirs = [[0,1],[0,-1],[1,0],[-1,0]]
        q = deque()
        originalColor = image[sr][sc]
        if originalColor == color:
            return image
        q.append([sr, sc])
        while q:
            cell = q.popleft()
            image[cell[0]][cell[1]] = color
            for i,j in dirs:
                r = i + cell[0]
                c = j + cell[1]
                if r >=0 and r < len(image) and c >=0 and c < len(image[0]) and image[r][c] == originalColor:
                    print(r,c)
                    q.append([r,c])
        return image

########################################

class Solution:
    def floodFill(self, image: List[List[int]], sr: int, sc: int, color: int) -> List[List[int]]:
        self.dirs = [[0,1],[0,-1],[1,0],[-1,0]]
        if image[sr][sc] == color:
            return image
        def dfs(image,sr,sc,color, originalColor):
            if sr < 0 or sr >= len(image) or sc < 0 or sc >= len(image[0]) or image[sr][sc] != originalColor:
                return
            image[sr][sc] = color
            for i,j in self.dirs:
                r = sr + i
                c = sc + j
                dfs(image,r,c,color, originalColor)
        originalColor = image[sr][sc]
        dfs(image,sr,sc,color, originalColor)
        return image
