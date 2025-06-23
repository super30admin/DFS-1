#Time Complexity : 0(N)
# Space Complexity : 0(N)
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : no
# Your code here along with comments explaining your approach: used dfs 

class Solution:
    def floodFill(self, image: List[List[int]], sr: int, sc: int, color: int) -> List[List[int]]:
        self.dirs = [(0,1),(0,-1),(1,0),(-1,0)]
        self.initial = image[sr][sc]
        
        if image[sr][sc] == color:
            return image
        def dfs(i,j):

            if i < 0 or i >= len(image) or j <0 or j >= len(image[0]) or image[i][j] != self.initial:
                return 
            image[i][j] = color

            for r,c in self.dirs:
                newrow = i+ r
                newcol = j + c

                dfs(newrow,newcol)
            
        dfs(sr,sc)
        return image

#Time Complexity :
# Space Complexity :
# Did this code successfully run on Leetcode :
# Any problem you faced while coding this :
# Your code here along with comments explaining your approach


class Solution:
    def updateMatrix(self, mat: List[List[int]]) -> List[List[int]]:

        m = len(mat)
        n = len(mat[0])
        dirs = [(0,1),(0,-1),(1,0),(-1,0)]
        newmat = [[-1] * n for _ in range(m)]
        print(newmat)
        myq = deque()
        for i in range(m):
            for j in range(n):
                if mat[i][j] == 0:
                    newmat[i][j] = 0
                    myq.append([i,j])
        while myq:
            oldr, oldc = myq.popleft()
            for r,c in dirs:
                newr = oldr +r
                newc = oldc + c
                if not (newr < 0 or newr >= m or newc < 0 or newc >=n) and newmat[newr][newc] == -1:
                    newmat[newr][newc] = newmat[oldr][oldc] + 1        
                    myq.append([newr,newc])
        return newmat


        


        


