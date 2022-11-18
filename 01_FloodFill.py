# https://leetcode.com/problems/flood-fill
# // Time Complexity : O(m x n), because we visit each element atleast once if all are of original color
# // Space Complexity : O(m x n) because we create recursive call for each element atleast once if all are of original color
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : No
class Solution:
    def dfs(self, visited, r,c, directions, color, image, original):
        if [r,c] in visited:
            return

        if image[r][c] == original and image[r][c] != color:
            image[r][c] = color
        
        visited.append([r,c])

        for x, y in directions:
            if  0 <= r+x < len(image) and 0 <=c+y < len(image[0]):
                r1= r+x
                c1= c+y
                if image[r1][c1] == original and image[r1][c1] != color:
                    self.dfs(visited, r1, c1, directions, color, image, original)
                    
                    
        return image
                

    def floodFill(self, image: List[List[int]], sr: int, sc: int, color: int) -> List[List[int]]:
        directions = [[1,0], [-1,0], [0,1], [0,-1]]
        return self.dfs([], sr, sc, directions, color, image, image[sr][sc])