//https://leetcode.com/problems/find-unique-binary-string

        
class Solution {
    public String findDifferentBinaryString(String[] nums) {
        StringBuilder ans= new StringBuilder();                  
        for(int i=0; i<nums.length; i++)  
            ans.append(nums[i].charAt(i) == '0' ? '1' : '0');             
        return ans.toString();
    }
}
    
/*
2nd soln
class Solution {
    public String findDifferentBinaryString(String[] nums) {

        int arr[]= new int[100000];
        
        for(int i=0;i<nums.length;i++){
            arr[Integer.parseInt(nums[i],2)]=1;
        }
        
        int x=0;
        for(int i=0;i<100000;i++){
            if(arr[i]!=1){
                x=i;            
                break;
            }
        }
  
            return toBinary(x,nums[0].length());
    }
    
        public  String toBinary(int x, int len)
    {
            String str=Integer.toBinaryString(x);
      
       StringBuilder sb= new StringBuilder(str);
            
            if(str.length()==len){
                return str;
            }else{
            sb.reverse();
            while(sb.length()!=len){
                sb.append("0");
            }
            return sb.reverse().toString();
             }
        }
        }

*/
