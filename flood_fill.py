#     TC==>O(N)
#     SC==>O(1)
    def floodFill(self, image: List[List[int]], sr: int, sc: int, newColor: int) -> List[List[int]]:
        old_color=image[sr][sc]
        if image[sr][sc] == newColor:
            return image
        self.dfs(image,newColor,sr,sc,old_color)
        return image   
    def dfs(self,image,newColor,sr,sc,old_color):

        if sr<0 or sr>=len(image) or sc<0 or sc>=len(image[0]) or image[sr][sc]!=old_color:
            return 
        image[sr][sc]=newColor
        self.dfs(image,newColor,sr,sc+1,old_color)
        self.dfs(image,newColor,sr-1,sc,old_color)
        self.dfs(image,newColor,sr,sc-1,old_color)
        self.dfs(image,newColor,sr+1,sc,old_color)