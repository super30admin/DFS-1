# // Time Complexity : O(mn)
# // Space Complexity : O(mn)
# // Did this code successfully run on Leetcode :Yes
# // Any problem you faced while coding this : No
# // Your code here along with comments explaining your approach
	# Maintain a visited array
	# Start from the se sc pixel and perform BFS to complte the frame
	
	# I am quite unsure if the way i used the visited array is correct??
	# Can you please let me know if its right?


class Solution:
    def floodFill(self, image: List[List[int]], sr: int, sc: int, newColor: int) -> List[List[int]]:
        if not image:
            return image
        RefColor = image[sr][sc]
        Visited = []
        m = len(image)
        n = len(image[0])
        
        Queue = deque()
        Queue.append([sr,sc])
        image[sr][sc] = newColor
        direction = [[0,-1],[-1,0],[1,0],[0,1]]
        while(len(Queue) != 0):
            CurrPixel = Queue.popleft()
            for dirs in direction:
                r = CurrPixel[0] + dirs[0]
                c = CurrPixel[1] + dirs[1]
                if r < m and c < n and r >= 0 and c >=0 and image[r][c] == RefColor and [r,c] not in Visited:
                    image[r][c] = newColor
                    Visited.append([r,c])
                    Queue.append([r,c])
        return image