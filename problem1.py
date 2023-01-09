#time complexity: O(m*n)
#space complexity: O(m*n)
#ran on leetcode: Yes
#initialize a queue. push src coordinates into the queue . In each iteration of the graph traversal, change the color of the coordinate to color and look for neighbors who have the same color as image[sr][sc]. Continue the trversal until no elements are in queue.
class Solution:
    def floodFill(self, image: List[List[int]], sr: int, sc: int, color: int) -> List[List[int]]:
        visited=set()
        Q=[(sr,sc)]
        dirs=[(0,-1),(0,+1),(-1,0),(1,0)]
        visited.add((sr,sc))
        start_color=image[sr][sc]
        image[sr][sc]=color
        
        while(Q):
            i=Q[0][0]
            j=Q[0][1]
            del(Q[0])
            #level=ans[i][j]
            for dir in dirs:
                I=i+dir[0]
                J=j+dir[1]
                if(I<len(image) and I>= 0 and J<len(image[0]) and J>=0):
                    if((I,J)not in visited and image[I][J]==start_color):
                        image[I][J]=color
                        visited.add((I,J))
                        Q.append((I,J))
        return image
