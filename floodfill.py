#Time complexity: O(n)
#Space complexity: O(h)
class Solution:
    def floodFill(self, image: List[List[int]], sr: int, sc: int, color: int) -> List[List[int]]:
        m=len(image)
        n=len(image[0])
        if image[sr][sc]==color:
            return image
        org_color=image[sr][sc]
        directions=[[0,1],[0,-1],[1,0],[-1,0]]
        self.dfs(image,sr,sc,color,m,n,org_color,directions)
        return image

    def dfs(self,image,sr,sc,color,m,n,org,directions):
        if sr<0 or sr>=m or sc<0 or sc>=n or image[sr][sc]is not org:
            return
        image[sr][sc]=color
        for d in directions:
            i=sr+d[0]
            j=sc+d[1]
            self.dfs(image,i,j,color,m,n,org,directions)