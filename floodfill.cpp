// TC:O(m*n)
// SC:O(m*n) recursive stack space
// Here in worst case all cells can be traversed;

// Here the both BFS & DFS approaches works but DFS is more suitable
// Because there is only one starting point at time t=0;
// I followed the DFS 


class Solution {
public:
    vector<vector<int>>dirs={{-1,0},{1,0},{0,-1},{0,1}};
    vector<vector<int>> floodFill(vector<vector<int>>& image, int sr, int sc, int color) {

        if(image[sr][sc]==color)
        return image;

        int col=image[sr][sc];
        // image[sr][sc]=color;

        dfs(image,sr,sc,col,color);

        return image;
    }


    void dfs(vector<vector<int>>& image, int sr, int sc, int col ,int color)
    {
     

        if(image[sr][sc]!=col)
        return;
        
        if(image[sr][sc]==col)
        image[sr][sc]=color;



        for(int i=0;i<dirs.size();i++)
        {
            int nr=sr+dirs[i][0];
            int nc=sc+dirs[i][1];
            if(nr>=0 && nc>=0 && nr<image.size() && nc<image[0].size())
            {
                dfs(image,nr,nc,col,color);
               
            }
        }
    }

};