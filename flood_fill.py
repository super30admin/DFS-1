# TC : O(MN)
# SC : O(MN) # worse case if queue/stack fills up 
class Solution:
    def floodFill(self, image: List[List[int]], sr: int, sc: int, newColor: int) -> List[List[int]]:
        dirs = [[0,1], [1,0], [-1,0], [0,-1]]
        
        q = [] # nodes processing
        q.append([sr,sc])
        old_color = image[sr][sc]
        if old_color == newColor:
            return image
        rows = len(image)
        cols = len(image[0])
        
        while(q):
            i,j = q.pop(0)
            for d in dirs:
                new_i = i + d[0]
                new_j = j + d[1]
                if new_i>=0 and new_i<rows and new_j>=0 and new_j<cols and image[new_i][new_j] == old_color:
                    q.append([new_i,new_j])
                    image[new_i][new_j] = newColor
        image[sr][sc] = newColor
        return image
                
        