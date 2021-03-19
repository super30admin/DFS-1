'''
TC: O(n)
SC: O(n) Recursion Stack
'''
class Solution:
    def floodFill(self, image: List[List[int]], sr: int, sc: int, newColor: int) -> List[List[int]]:
        color = image[sr][sc]
        def dfs(sr, sc):
            if sr < 0 or sr>=len(image):
                return
            if sc <0 or sc >=len(image[0]):
                return
            elif image[sr][sc] != color:
                return
            elif image[sr][sc] == newColor:
                return
            image[sr][sc] = newColor
            dfs(sr,sc+1)
            dfs(sr,sc-1)
            dfs(sr+1,sc)
            dfs(sr-1,sc)
        dfs(sr,sc)
        return image