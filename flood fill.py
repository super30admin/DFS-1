# // Time Complexity : O(N)
# // Space Complexity : O(N)
# // Did this code successfully run on Leetcode : YES
# // Any problem you faced while coding this : NO


# // Your code here along with comments explaining your approach
class Solution:
    def floodFill(self, image: List[List[int]], sr: int, sc: int, color: int) -> List[List[int]]:
        rMax, cMax = len(image), len(image[0])
        def dfs(r, c):
            if r < 0 or c < 0 or r >= rMax or c >= cMax:
                return
            if (r,c) in visiting:
                return
            if image[r][c] != priorColor:
                return
            
            image[r][c] = color

            visiting.add((r,c))
            dfs(r+1, c)
            dfs(r-1, c)
            dfs(r, c+1)
            dfs(r, c-1)
            visiting.remove((r,c))

        priorColor = image[sr][sc]
        visiting = set()
        dfs(sr, sc)

        return image