# Time Complexity : O(m x n) time 
# Space Complexity : O(m x n) space
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
# Your code here along with comments explaining your approach
    #1) DFS approach is, set the dirs array to gobal as we nee directions for each cell to navigate 
    #2) set the color of the given cell in input to a new color global scope as we intent to only change the color for cell which has same color with the target cell given in our input
    
class Solution:
    # BFS Approach = Time = O(m x n) | Space = O(m x n) in worst case if all the cells are of the target color 
    # def floodFill(self, image, sr, sc, newColor):
    #     if image[sr][sc] == newColor:
    #         return image 
    #     q = [[sr,sc]] # Add the given cell in the queue and go on checking for the rest of its neighbours and so on. 
    #     m , n = len(image) , len(image[0])
    #     color = image[sr][sc]
    #     image[sr][sc] = newColor
    #     dirs = [[0,1],[0,-1],[1,0],[-1,0]]
    #     while q:
    #         curr = q.pop(0)
    #         for dir in dirs:
    #             r = dir[0] + curr[0]
    #             c = dir[1] + curr[1]
    #             if r >= 0 and r < m and c >= 0 and c < n and image[r][c] == color:
    #                 image[r][c] = newColor
    #                 q.append([r,c])
    #     return image

    # Method 2) DFS Time = O(m x n) | Space = O(m x n) in worst case if all the cells are of the target color.
    color = None 
    dirs = [[0,1],[0,-1],[1,0],[-1,0]]
    def floodFill(self, image, sr, sc, newColor):
        if image[sr][sc] == newColor:
            return image 
        self.color = image[sr][sc]
        self.__dfs(image,sr,sc,newColor)
        return image 
    
    def __dfs(self,image,sr,sc,newColor):
        # Base 
        if sr < 0 or sc < 0 or sr == len(image) or sc == len(image[0]) or image[sr][sc] != self.color:
            return 
        
        # Logic 
        image[sr][sc] = newColor 
        for dir in self.dirs:
            r = dir[0] + sr
            c = dir[1] + sc 
            self.__dfs(image,r,c,newColor)
    
if __name__ == "__main__":
    s = Solution()
    image = [[0,0,0],[0,1,0]]
    sr = 1
    sc = 1
    newColor = 2
    res = s.floodFill(image,sr,sc,newColor)
    for i in range(len(res)):
        print(res[i])