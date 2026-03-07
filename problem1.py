# problem 1 

class Solution:
    def floodFill(self, image: List[List[int]], sr: int, sc: int, color: int) -> List[List[int]]:
        m = len(image)
        n = len(image[0])

        directions = [[-1,0],[0,-1],[1,0],[0,1]]
        old_color = image[sr][sc] # get the current selected color
        if old_color == color:
            return image
        image[sr][sc] = color
        my_queue = deque()
        my_queue.append((sr,sc))
        while(len(my_queue) > 0):
            curr_queue = my_queue.popleft()
            for direction in directions:
                r = direction[0] + curr_queue[0]
                c = direction[1] + curr_queue[1]
                if r>=0 and r<m and c >= 0 and c <n:
                    if image[r][c] == old_color:
                        image[r][c] = color 
                        my_queue.append((r,c))
        return image