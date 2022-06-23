
// Time Complexity : O( m*n )
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :
None

// Your code here along with comments explaining your approach


class Solution {
    int startcolor;
    vector<pair<int,int>>dir = {{-1,0}, {0,1}, {1, 0}, {0,-1}};
public:
    
    void floodFillRecur( vector<vector<int>>& image, int sr, int sc, int color, int rows, int cols ) {
        
        image[sr][sc]=color;
        for( int i=0; i<dir.size(); i++){
            int newsr = sr+dir[i].first;
            int newsc = sc+dir[i].second;
            
            if( newsr < 0 || newsr >= rows || newsc < 0 || newsc >= cols || 
                image[newsr][newsc] != startcolor ) {
                continue;
            }
            floodFillRecur( image, newsr, newsc, color, rows, cols );
        }
    }
    
    
    vector<vector<int>> floodFill(vector<vector<int>>& image, int sr, int sc, int color) {
        int rows = image.size();
        int cols = image[0].size();
        startcolor = image[sr][sc];
        if ( startcolor == color ) {
            return image;
        }
        floodFillRecur( image, sr, sc, color, rows, cols );
        return image;
    }
};
