
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.WeightedQuickUnionUF;

   
        /**
         *
         * @author Saqib Islam
         * CSE Undergraduate 
         * BRAC UNIVERSITY
         * 
         */
        public class Percolation{
       
         
         private final WeightedQuickUnionUF wUF; // to store WeightedQuickUnionUF object
         private final int size; //grid size
         private final int noOfComponents; //
         private final int[][] grid; //grid to correspond to component
         private final int topVirtualSite; //top Virtual site index 
         private final int bottomVirtualSite; //bottom virtual site
         private boolean [] openSite;    //array to store site check
         private int noOpenSite; //number of open sites
             
             
             
             
         
         public Percolation(int n){
           if(n <= 0){throw new IllegalArgumentException("Enter Positive Number");
           }
             
           
           noOpenSite = 0;
           grid = new int[n][n];
           int c = 0; //to sequentially fill grid
             for (int i = 0; i < grid[0].length; i++) {
                 for (int j = 0; j < grid.length; j++) {
                     grid[i][j] = c;
                     c++;   
                 }
             }
           
             
           
           size = n;
           noOfComponents =(n*n)+2; // 2 for top and bottom virtual sites
           topVirtualSite = noOfComponents-2; //last two indexes for virtual sites
           bottomVirtualSite = noOfComponents-1;
           openSite = new boolean[noOfComponents]; //Intializing all sites to be false closed
           wUF=new WeightedQuickUnionUF(noOfComponents);// Initiaizing new wUF with n*n+2
          
           
          // Connect Top and bottom Virtual sites to the top and bottom rows
          //          openSite[topVirtualSite]=true;
          //          openSite[bottomVirtualSite]=true;
          for (int i = 0; i < n; i++) {
                 wUF.union(i,topVirtualSite);
             }
          
             for (int i = noOfComponents-(n+2); i < (size*size); i++) {
                 wUF.union(i, bottomVirtualSite);
             }
         }    
         
            // create n-by-n grid, with all sites blocked
        
        
         public void open(int row, int col){
          
           if(isOpen(row,col)){
          return;}
           
           row = row-1;
          col = col-1;
          
          
          int index=validate(row,col); // gets index of 2D array and returns -1 if row or col is out of bounds
          if(index < 0){
            throw new IllegalArgumentException("Enter valid row & col"); 
          }
          
        
          openSite[index] = true;
          noOpenSite += 1;
          int left = validate(row,col-1);
          int right = validate(row,col+1);
          int up = validate(row-1,col);
          int down = validate(row+1,col);
          
         
         
          //checks adjacent sides and connects them if open
 
               if(validateIndex(left)){
                   if(openSite[left]){
                       
                   wUF.union(index, left);
                   }
               }
               
               if(validateIndex(right)){
                   if(openSite[right]){
                      
                       wUF.union(index, right);
                   }
               }
               
               if(validateIndex(up)){
                     if(openSite[up]){
               wUF.union(index, up);
                     }
               }
               
               if(validateIndex(down)){
                     if(openSite[down]){
               wUF.union(index, down);
                     }
               }
          }

      

             // open site (row, col) if it is not open already
           
           public boolean isOpen(int row, int col){
             
               row = row-1;
               col = col-1;
               int index = validate(row,col);
               if( validateIndex(index) ){
               return openSite[index];
               }
               throw new IllegalArgumentException("Enter valid number");
           }  // is site (row, col) open?
           
           public boolean isFull(int row, int col) {
               row = row-1;
               col = col-1;
           int index = validate(row,col);
           if(index<0) throw new IllegalArgumentException("EnterValid row and col");
           if(validateIndex(index)){
               if(openSite[index]){
               return wUF.connected(index, topVirtualSite);
               }
           }
           
           return false;
           }             // is site (row, col) full?
           
           
           public int numberOfOpenSites() {
            
             
             return noOpenSite;
           }      // number of open sites
           
           
           public boolean percolates()       {
            //   System.out.println("Percolates: "+wUF.connected(topVirtualSite, bottomVirtualSite));
            return numberOfOpenSites() > 0 && wUF.connected(topVirtualSite, bottomVirtualSite);
           }       // does the system percolate?

           
          
        private boolean validateIndex(int index) {
         
            if(index>=0 && index<size*size){
         return true;
         }
         return false;
        }          // checks the bounds of the index
        
        
          private int validate(int row, int col) {
            if(row >= 0 && row < size && col >= 0 && col < size){
           return grid[row][col]; 
           }
            return -1;
        }            //validates the row and col and returns 2D index
        
        
        }


