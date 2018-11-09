// orderedArray.java
// demonstrates ordered array class
// to run this program: C>java OrderedApp
////////////////////////////////////////////////////////////////
class OrdArray
   {
      private long[] a;                 // ref to array a
      private int nElems;               // number of data items
      private boolean isFind;
   //-----------------------------------------------------------
   public OrdArray(int max)          // constructor
      {
      a = new long[max];             // create array
      nElems = 0;
      }

   //-----------------------------------------------------------
   public int size()
      { return nElems; }
   //-----------------------------------------------------------


   public long[] getArray() {
       return a;
   }

   public boolean isFind(long searchKey) {
       find(searchKey);
       return isFind;
   }

   public OrdArray merge(OrdArray firstArr, OrdArray secArr) {
       for (long i: firstArr.getArray()) {
           if (!secArr.isFind(i)) {
               secArr.insert(i);
           }
       }
       return secArr;
   }

   public int find(long searchKey)
      {
      int lowerBound = 0;
      int upperBound = nElems-1;
      int curIn;
      isFind = true;

      while(true)
         {
            curIn = (lowerBound + upperBound ) / 2;
            if(a[curIn]==searchKey)
               return curIn;              // found it
            else
               if(lowerBound > upperBound) {
                  isFind = false;
                  return lowerBound;             // can't find it
               }
            else                          // divide range
               {
               if(a[curIn] < searchKey)
                  lowerBound = curIn + 1; // it's in upper half
               else
                  upperBound = curIn - 1; // it's in lower half
               }  // end else divide range
         }  // end while
      }  // end find()
   //-----------------------------------------------------------
   public void insert(long value)    // put element into array
      {
         int j = find(value);
         for(int k=nElems; k>j; k--)    // move bigger ones up
            a[k] = a[k-1];
         a[j] = value;                  // insert it
         nElems++;                      // increment size
      }  // end insert()
   //-----------------------------------------------------------
   public boolean delete(long value)
      {
      int j = find(value);
      if(!isFind)                  // can't find it
         return false;
      else                           // found it
         {
         for(int k=j; k<nElems; k++) // move bigger ones down
            a[k] = a[k+1];
         nElems--;                   //  decrement size
         return true;
         }
      }  // end delete()
   //-----------------------------------------------------------
   public void display()             // displays array contents
      {
      for(int j=0; j<nElems; j++)       // for each element,
         System.out.print(a[j] + " ");  // display it
      System.out.println("");
      }
   //-----------------------------------------------------------
   }  // end class OrdArray

////////////////////////////////////////////////////////////////
class OrderedApp
   {
   public static void main(String[] args)
      {
      int maxSize = 100;             // array size
      OrdArray arr, arr2;                  // reference to array
      arr = new OrdArray(maxSize);   // create the array

      arr.insert(77);                // insert 10 items
      arr.insert(99);
      arr.insert(44);
      arr.insert(55);
      arr.insert(22);
      arr.insert(88);
      arr.insert(11);
      arr.insert(00);
      arr.insert(66);
      arr.insert(33);

      arr2 = new OrdArray(maxSize);   // create the array
          arr2.insert(123);
          arr2.insert(12);
          arr2.insert(52);
          arr2.insert(43);


      int searchKey = 55;            // search for item
      if( arr.find(searchKey) != arr.size() )
         System.out.println("Found " + searchKey);
      else
         System.out.println("Can't find " + searchKey);

      arr.display();                 // display items

      arr.delete(00);                // delete 3 items
      arr.delete(55);
      arr.delete(99);

      arr.display();                 // display items again


      arr.insert(45);
      arr.display();
      arr.insert(10);
      arr.display();
      arr.delete(80);
      arr.display();

      //check mergearray
      OrdArray arr3 = arr.merge(arr, arr2);
      arr3.display();

      }  // end main()
   }  // end class OrderedApp
