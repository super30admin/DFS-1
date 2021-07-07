//Time Complexity-O(m*n) - number of pixels
//Space Complexity-O(m*n)- recursive stack Space
//Did the code run on Leetcode? yes

class Solution {
public:
    vector<vector<int>>directions={{0,1},{1,0},{0,-1},{-1,0}};
    vector<vector<int>> floodFill(vector<vector<int>>& image, int sr, int sc, int newColor) {
        int tempcolor=image[sr][sc];
        if(newColor==tempcolor)
        {
            return image;
        }
        flood(image,sr,sc,newColor,tempcolor);
        return image;
    }
    void flood(vector<vector<int>>& image, int sr,int sc,int newColor,int temp)
    {
        if(image[sr][sc]!=temp)
        {
            return;
        }
        image[sr][sc]=newColor;
        for(int i=0;i<directions.size();i++)
        {
            vector<int>k=directions[i];
            int row=k[0]+sr;
            int col=k[1]+sc;
            if(row>=0 && row<image.size() && col>=0 &&col<image[0].size())
            {
                  flood(image,row,col,newColor,temp);
            }
        }
    }
};