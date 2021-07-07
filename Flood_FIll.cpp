//BFS Solution
//Time Complexity-O(m*n) where m-number of rows,n-number of columns
//space complexity-O(m+n) where m-number of rows,n-number of columns

class Solution {
public:
    vector<vector<int>> floodFill(vector<vector<int>>& image, int sr, int sc, int newColor) {
        vector<vector<int>>directions={{0,1},{1,0},{0,-1},{-1,0}};
        queue<vector<int>>m;
        int tempcolor=image[sr][sc];
        image[sr][sc]=newColor;
        m.push({sr,sc});
        while(!m.empty() && newColor!=tempcolor)
        {
            vector<int>temp=m.front();
            m.pop();
            for(int i=0;i<directions.size();i++)
            {
                vector<int>h=directions[i];
                int row=h[0]+temp[0];
                int col=h[1]+temp[1];
                if(row>=0 && row<image.size() && col >=0 && col<image[0].size() &&   image[row][col]==tempcolor)
                {
                    image[row][col]=newColor;
                    m.push({row,col});
                }
            }
        }
        return image;
    }
};