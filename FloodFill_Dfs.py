#Time: O(mxn)
#space: O(mxn)
#leetcode: yes


class Solution:
    def floodFill(self, image: List[List[int]], sr: int, sc: int, newColor: int) -> List[List[int]]:
        if (image==[] or len(image)==0 or image[sr][sc]==newColor):
            return image
        row=len(image)
        column=len(image[0])
        color=image[sr][sc]
        direct=[[0,1],[1,0],[-1,0],[0,-1]]
        def dfs(image,sr,sc):
            if (sr>=0 and sr<row and sc>=0 and sc<column and image[sr][sc]==color):
                image[sr][sc]=newColor
            else:
                return
            for d in direct:
                i=sr+d[0]
                j=sc+d[1]
                dfs(image,i,j)

        dfs(image,sr,sc)
        return image