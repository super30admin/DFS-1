#Time Complexity : O(mn) where m is is number of columns and n is number of rows
#Space Complexity :  O(mn) where m is is number of columns and n is number of rows

#Did this code successfully run on Leetcode : Yes
#Three line explanation of solution in plain english: Find the color of the initial element we want to start from, then calling DFS from that element, we check out of the bounds condition and that the color of the element is already not equal to the newColor as the bas case, if any of these are false, then we return. Else we check whether the element is equal to the initial color and if it is, we change the color of the current element to the newColor and perform DFS in all 4 directions.

class Solution:
    def floodFill(self, image: List[List[int]], sr: int, sc: int, newColor: int) -> List[List[int]]:
        color = image[sr][sc]

        def dfs(image, sr, sc):
            if sr < 0 or sr >= len(image) or sc < 0 or sc >= len(image[0]) or image[sr][sc] == newColor:
                return
            if image[sr][sc] == color:
                image[sr][sc] = newColor
                dfs(image, sr+1, sc)
                dfs(image, sr-1, sc)
                dfs(image, sr, sc+1)
                dfs(image, sr, sc-1)

        dfs(image, sr, sc)
        return image
