//Time Complexity - O(M*N)
//Space Complexity - O(M*N)
class Solution {
public:
    void dfs(vector<vector<int>>& image, int sr, int sc, int newColor, int orgColor){
        image[sr][sc]=newColor;
        if(sr>0&&image[sr-1][sc]==orgColor){
            dfs(image,sr-1,sc,newColor,orgColor);
        }
        if(sc>0&&image[sr][sc-1]==orgColor){
            dfs(image,sr,sc-1,newColor,orgColor);
        }
        if(sr<image.size()-1&&image[sr+1][sc]==orgColor){
            dfs(image,sr+1,sc,newColor,orgColor);
        }
        if(sc<image[sr].size()-1&&image[sr][sc+1]==orgColor){
            dfs(image,sr,sc+1,newColor,orgColor);
        }
    }
    vector<vector<int>> floodFill(vector<vector<int>>& image, int sr, int sc, int newColor) {
        if(image[sr][sc]==newColor)
            return image;
        dfs(image,sr,sc,newColor,image[sr][sc]);
        return image;
    }
};