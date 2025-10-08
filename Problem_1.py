# // Time Complexity : O(m*n)
# // Space Complexity : O(h)
class Solution:
    def floodFill(self, image: List[List[int]], sr: int, sc: int, color: int) -> List[List[int]]: 
        
        n=len(image)
        m=len(image[0])
        start_color = image[sr][sc]
        if(start_color==color):
            return image
        queue = deque() 
        queue.append([sr,sc])

        while(len(queue)>0):
            temp = queue.popleft()
            image[temp[0]][temp[1]] = color
            
            nei = [[temp[0]-1,temp[1]],[temp[0],temp[1]+1],[temp[0]+1,temp[1]],[temp[0],temp[1]-1]]

            for i in nei:
                if(i[0]>=0 and i[0]<n):
                    if(i[1]>=0 and i[1]<m):
                        if(image[i[0]][i[1]] == start_color):
                            queue.append([i[0],i[1]])

            
        return image
