//Time Complexity: O(m*n)
//Space Complexity: O(m*n)

//Did the code run on leetcode: Yes
//Approach - DFS
class Solution(object):
    def floodFill(self, image, sr, sc, newColor):
        R, C = len(image), len(image[0])
        color = image[sr][sc]
        if color == newColor: return image
        dirs = [[0,1],[1,0],[-1,0],[0,-1]]
        def dfs(r, c):
            if image[r][c] == color:
                image[r][c] =newColor

            for dir1 in dirs:
                nr =dir1[0] + r
                nc = dir1[1] + c
                if(nr>=0 and nr<R and nc>=0 and nc<C and image[nr][nc]== color):
                    dfs(nr,nc)
        dfs(sr, sc)
        return image
        
        //Approach - BFS
        class Solution(object):
    def floodFill(self, image, sr, sc, newColor):
        R, C = len(image), len(image[0])
        color = image[sr][sc]
        if color == newColor: return image
        dirs = [[0,1],[1,0],[-1,0],[0,-1]]
        
        q = deque([[sr,sc]])
        
        while q:
            qlen = len(q)
            
            for i in range(qlen):
                curr = q.popleft()
                # print(curr)
                if( image [curr[0]][curr[1]] == color):
                    image [curr[0]][curr[1]] = newColor
                for dir1 in dirs:
                    nr =curr[0] + dir1[0]
                    nc = curr[1] + dir1[1]
                    if(nr>=0 and nr<R and nc>=0 and nc<C and image[nr][nc]== color):
                            q.append([nr,nc])                 
        return image
