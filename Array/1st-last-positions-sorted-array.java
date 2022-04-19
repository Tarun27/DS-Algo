//https://www.geeksforgeeks.org/find-first-and-last-positions-of-an-element-in-a-sorted-array/

public class MyClass {
    public static void findPositions(int arr[], int val){
  
  int first=-1;
  int last=-1;
  first = findFirst(arr,val,0,arr.length-1);
  last=findLast(arr,val,0,arr.length-1);  
  
  System.out.println("First Occurrence = "+first+"\nLast Occurrence = "+last);
}

  public static int findFirst(int arr[],int x,int low, int high){

    if(high>=low){ 
     int mid= low+(high-low)/2;
    if((mid==0||arr[mid-1]<x)&&x==arr[mid]){return mid;}
    if(arr[mid]<x){return findFirst(arr,x,mid+1,high);}
    else{return findFirst(arr,x,mid-1,high);}
    }
      return -1;
   
  }
  
    public static int findLast(int arr[],int x,int low, int high){
    int n=arr.length;
    if(high>=low){ 
     int mid= low+(high-low)/2;
    if((mid==n-1||arr[mid+1]>x)&&x==arr[mid]){return mid;}
    if(arr[mid]>x){return findLast(arr,x,mid-1,high);}
    else{return findLast(arr,x,mid+1,high);}
    }
      return -1;
   
  }
  
   public static void main(String[] args)
    {
 
        int arr[] = { 1, 2, 2, 2, 2, 3, 4, 7, 8, 8 };
        int n = arr.length;
        int x = 8;
      findPositions(arr,x);
    }
}
