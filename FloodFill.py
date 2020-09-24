// Time Complexity : O(V+E)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// // Any problem you faced while coding this : No

// Your code here along with comments explaining your approach

class Solution:
    def floodFill(self, image: List[List[int]], sr: int, sc: int, newColor: int) -> List[List[int]]:
        
        def recurr(image,sr,sc,oldColor,newColor): #perform DFS for every nearby node in 4 directions


            image[sr][sc]=newColor #update to new color so that node is Not visited again
            for dirs in self.directions:
                r=dirs[0]+sr
                c=dirs[1]+sc

                if r>=0 and r<len(image) and c>=0 and c<len(image[0]) and image[r][c]==oldColor:
                    
                    recurr(image,r,c,oldColor,newColor)

                    
        if image is None or len(image)==0 or len(image[0])==0 or image[sr][sc]==newColor:
            return image
        oldColor=image[sr][sc]
        self.directions=[[-1,0],[0,1],[1,0],[0,-1]]
        recurr(image,sr,sc,oldColor,newColor)
        return image
 