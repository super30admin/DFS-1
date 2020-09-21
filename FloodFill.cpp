// Time Complexity : O(n*m) as we are travellig throught all the elements in the given matrix.
// Space Complexity : O(1) if we do not consider recursive stack. o(n*m) with recursive stack
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : no issues as of now.. Learning



class Solution {
public:
    
    vector<vector<int>> directions = {{0,1},{0,-1},{1,0},{-1,0}};
    vector<vector<int>> floodFill(vector<vector<int>>& image, int sr, int sc, int newColor) {
        if(image.size()==0 || image[0].size()==0 || image[sr][sc] == newColor) return image;  // checking size of matrix given and also if the pixel already has the new color noc ahnges to be done
        
        recurr(image,sr,sc,image[sr][sc], newColor); // recursion
        
        return image;
    }
    
        void recurr(vector<vector<int>>& image, int i, int j,int oldColor, int newColor){
            
            image[i][j] = newColor; // updating the pixel with new color
            
            
            for (auto dir:directions){
                int r = i + dir[0];
                int c = j + dir[1]; // travelling through all the possible direction for the updated pixel to search for more pixels with old color
                
                if(r>=0 && r < image.size() && c >=0 && c <image[0].size() && image[r][c] == oldColor) // checking bounds and also the pixel color
                    recurr(image,r,c,oldColor,newColor); // recursion
            }
        }
};