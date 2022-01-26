class Solution:
    def floodFill(self, image: List[List[int]], sr: int, sc: int, newColor: int) -> List[List[int]]:
        currentColor = image[sr][sc]
        m = len(image)
        n = len(image[0])
        def dfs(sr, sc):
            if 0 <= sr < m and 0 <= sc  < n and image[sr][sc] == currentColor and image[sr][sc] != newColor:
                image[sr][sc] = newColor
                dfs(sr + 1, sc)
                dfs(sr - 1, sc)
                dfs(sr, sc + 1)
                dfs(sr, sc - 1)
                
        dfs(sr,sc)
        return image

        # T.C=> O(m * n)
        # S.C=> O(H) => since we used stack in back for recurssion
        # Approach => This is recurssion approach. Here we make a call everytime snf collect sll the rows and column pointer that have old color.
        #then we apply dfs and check all its four side and change old color to new color.
