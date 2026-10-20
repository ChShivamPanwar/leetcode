class Solution {
    public boolean validPalindrome(String s) {
        int i=0;
        int j=s.length()-1;
        while(i<j){
            char left=s.charAt(i),right=s.charAt(j);
            if(left!=right){
                return checkPalindrome(i+1,j,s) || checkPalindrome(i,j-1,s);
            }else{
                i++;
                j--;
            }
        }
        return true;
    }
    private boolean checkPalindrome(int i,int j,String s){
        while(i<j){
            if(s.charAt(i)!=s.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }   
}