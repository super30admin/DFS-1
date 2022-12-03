#Time complexity: O(m*n)
#Space complexity: O(m*n)

#Accepted on Leetcode

#Approach
#BFS based solution -> do a classic BFS, start by entering source into queue 
#For each element popped from queue, check neighbours and if they have the oldColor -> if yes, set oldColor to newColor and add that neighbour to queue
#Repitions will be prevented since when we change a value to newColor, we already know it has been processed


from collections import deque
class Solution:
    def floodFill(self, image: List[List[int]], sr: int, sc: int, color: int) -> List[List[int]]:
        if image[sr][sc] == color:
            return image

        queue = deque()
        n = len(image)
        m = len(image[0])
        dirs = [[-1,0],[1,0],[0,-1],[0,1]]

        oldColor = image[sr][sc]
        image[sr][sc] = color
        queue.append([sr,sc])
        
        while len(queue):
            curNodeArr = queue.popleft()
            row = curNodeArr[0]
            col = curNodeArr[1]
            for dirn in dirs:
                nr = row + dirn[0]
                nc = col + dirn[1]
                if nr >= 0 and nr < n and nc >= 0 and nc < m and image[nr][nc] == oldColor:
                    image[nr][nc] = color
                    queue.append([nr,nc])

        return image
        


            
        