public class AlgoImplemetations{
  
  
  public int BinarySearch(int start, int end,int key,int [] arr){
    
    if(start==end){
      if(arr[start]==key){
        return arr[start];
      }
      return -1;
    }
    
    int mid=start+(end-start)/2;
    if(key<arr[mid]){
    BinarySearch(start,(mid-1),key,arr);
    }
    else if(key>arr[mid]){
    BinarySearch(mid+1,end,key,arr);
    }
    
    return mid;
    
  }
  
  public void main (String args[]){
     AlgoImplemetations imp=new AlgoImplemetations();
     
    int [] arr={1,3,5,7,8,9,10};
    int start=0;
    int end=6;
    int key=5;
    
    int index=imp.BinarySearch(start,end,key,arr);
    
    System.out.println("index = "+index);
  }
  
}