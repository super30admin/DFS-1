class Solution {
public:
    int color;
    int n,m;
    vector<vector<int>> dir{{0,-1},{0,1},{-1,0},{1,0}};
    vector<vector<int>> floodFill(vector<vector<int>>& image, int sr, int sc, int newColor) {
        
        if(image.size()  ==0 || image[sr][sc] == newColor)                return image;
        
        m = image.size();
        n = image[0].size();
         color = image[sr][sc];
/
        
        //dfs 
        
        dfs(image,sr,sc,newColor);
        return image; 
    }
    
    void dfs(vector<vector<int>>& image, int sr, int sc, int newColor ) {
        //base 
        
     if(sr<0 || sr==m || sc<0 || sc==n || image[sr][sc] != color ) return;
        
            //logic
            image[sr][sc] = newColor;
          for(auto v : dir) {
                int rn = v[0] + sr;
                int cn = v[1] + sc;
                 dfs(image,rn,cn,newColor) ;
           }
    }
};