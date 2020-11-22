/*Time Complexity : O(N)
Space Complexity : O(N)

Did it run on LeetCode : Yes
Problems faced : No

*/

class Solution {
public:
    vector<vector<int>> floodFill(vector<vector<int>>& image, int sr, int sc, int newColor) {
        
        int color= image[sr][sc];
        if(color!=newColor)
        {
            DFS(image,sr,sc,color,newColor);
            
        }
        return image;
        
    }
    
    void DFS(vector<vector<int>>& image, int sr,int sc, int color,int newColor)
    {
        if(image[sr][sc]==color)
        {
            image[sr][sc]=newColor;
            
             //for top direction 
            if(sr+1<image.size())
            {
                DFS(image,sr+1,sc,color,newColor);
            }
            
            // for left direction
            if(sc+1<image[0].size())
            {
                DFS(image,sr,sc+1,color,newColor);
            }
            
            //for bottom direction 
             if(sr>=1)
            {
                DFS(image,sr-1,sc,color,newColor);
            }
            
            //for right direction
             if(sc>=1)
            {
                DFS(image,sr,sc-1,color,newColor);
            }  
    }
    }
};