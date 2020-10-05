// Time Complexity : O(m*N)
// Space Complexity : O(H)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach


def floodFill(self, image: List[List[int]], sr: int, sc: int, newColor: int) -> List[List[int]]:
        
        q = deque()
        q.append([sr,sc])
        
        sameColor = image[sr][sc]
        image[sr][sc] = newColor
        
        dirs = [[-1,0], [1,0], [0,1], [0,-1]]
        
        while q:
            
            for i in range(len(q)):
                temp = q.popleft()
            
                for d in dirs:
                    r = temp[0] + d[0]
                    c = temp[1] + d[1]

                    if (r>=0 and r<len(image) and c>=0 and c<len(image[0]) and image[r][c] == sameColor and image[r][c] != newColor): 
                        image[r][c] = newColor
                        q.append([r,c])
        return image
