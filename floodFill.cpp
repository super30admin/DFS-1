class Solution {
public:
    
    void dfs(vector<vector<int>>&image,int sr,int sc,int newColor,int orignal)
    {
       
        if(sr<0 || sc<0 || sr>=image.size() || sc>=image[0].size() || image[sr][sc]!=orignal)
        {
            return ;
        }
        
        image[sr][sc]=newColor;
        
        dfs(image,sr+1,sc,newColor,orignal);
        dfs(image,sr-1,sc,newColor,orignal);
        dfs(image,sr,sc+1,newColor,orignal);
        dfs(image,sr,sc-1,newColor,orignal);
    
        return;
    }
    
    vector<vector<int>> floodFill(vector<vector<int>>& image, int sr, int sc, int newColor) 
    {
        if(image[sr][sc]==newColor)
            return image;
        
        int orignal=image[sr][sc];
        dfs(image,sr,sc,newColor,orignal);
     return image;   
    }
};