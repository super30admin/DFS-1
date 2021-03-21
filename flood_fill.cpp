//TC: O(n) where n is number of pixels in the image.
//SC: O(n) since the recursive stack may potentially store all the elements


class Solution {
public:
    

    
    void dfs(vector<vector<int>>& image, int sr, int sc, int newColor, int oldColor){     
        
        vector<pair<int, int>> dirs;
        dirs.push_back({0, 1});
        dirs.push_back({0, -1});
        dirs.push_back({1, 0});
        dirs.push_back({-1, 0});
        
        //not the old color
        if(sr<0 || sr>=image.size() || sc <0 || sc>=image[0].size() || image[sr][sc] != oldColor){
            return;
        }
        
        //if this is already the newColor
        if(image[sr][sc] == newColor)
            return;
        
        image[sr][sc] = newColor;
        
        for(int i=0; i<dirs.size(); i++){
            dfs(image, sr+dirs[i].first, sc+dirs[i].second, newColor, oldColor);            
        }
        
        
    }
    
    vector<vector<int>> floodFill(vector<vector<int>>& image, int sr, int sc, int newColor) {
        
        //can be solved using dfs. We store the values of the connected nodes in a queue and then check the 4-directions of the point.
        int oldColor = image[sr][sc];
        dfs(image, sr, sc, newColor, oldColor);
        
        return image;
    }
};