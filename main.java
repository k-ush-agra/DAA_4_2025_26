class Solution {
    public boolean isValid(int[][] grid ,r,c,n,exp){
    if(r<0||c<0||r>=n||c>=n||grid[r][c]!=exp){
    return false;
    }
    if(exp == n*n -1){
    return true;
                                                                                        }
                                                                                                        boolean ans1 = (isValid(int[][] grid , r-1,c+2,n,exp+1));
                                                                                                                        boolean ans2 = (isValid(int[][] grid , r-2,c+1,n,exp+1));
                                                                                                                                        boolean ans3 = (isValid(int[][] grid , r+1,c+2,n,exp+1));
                                                                                                                                                        boolean ans4 = (isValid(int[][] grid , r+2,c+1,n,exp+1));
                                                                                                                                                                        boolean ans5 = (isValid(int[][] grid , r+2,c-1,n,exp+1));
                                                                                                                                                                                        boolean ans6 = (isValid(int[][] grid , r+1,c-2,n,exp+1));
                                                                                                                                                                                                        boolean ans7 = (isValid(int[][] grid , r-1,c-2,n,exp+1));
                                                                                                                                                                                                                        boolean ans8 = (isValid(int[][] grid , r-2,c-1,n,exp+1));
                                                                                                                                                                                                                                        return ans1 || ans2 || ans3 || ans4 || ans5 || ans6 || ans7 || ans8;
                                                                                                                                                                                                                                                    }

    }

    public boolean checkValidGrid(int[][] grid) {
        return isValid(int[][] grid,0,0,grid.length,0);
    }

}
