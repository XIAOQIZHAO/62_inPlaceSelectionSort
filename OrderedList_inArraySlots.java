/**
  OrderedList_inArraySlots, holding Integers

  A list with the invariant the elements are in order by
  increasing value, implemented using a
  ArrayList<Integer>
 */
import java.util.ArrayList;  // shortcut

public class OrderedList_inArraySlots
    implements OrderedList {

    private ArrayList<Integer> list_iAS;
    // private int counter;

    /** 
      construct order from an unordered ArrayList
     */
    public OrderedList_inArraySlots
            ( ArrayList<Integer> unordered) {
	// Integer saveOriginal;
	// Integer saveNew;
	list_iAS = unordered;
	// int champIndex;
	// for (int i = 0; i < list_iAS.size(); i++){
	//     champIndex = champIndex();
	//     System.out.println(champIndex);
	//     saveOriginal = list_iAS.get(i);
	//     saveNew = list_iAS.get(champIndex);
	//     list_iAS.set(champIndex, saveOriginal);
	//     list_iAS.set(i, saveNew);
	//     counter++;

	// Iterate through each slot that is to be populated.
        for( int next = 0
           ; next < list_iAS.size() -1  // last needs no sort
           ; next++) {

            // for development and debugging
            // System.out.println( 
                // "so far: " + list_iAS 
              // + " smallest element is at index " + dweebIndex( next) 
              // + " and has the value " + list_iAS.get( dweebIndex( next)));

              /* Find the next smallest. Swap it into place.
                 Use SET's convenient feature that it returns
                 the value that it replaces.
              */
            list_iAS.set( next   // set the smallest value to the current spot
                        , list_iAS.set( dweebIndex( next)
					, list_iAS.get( next)) // set current value to the spot of the smallest value, return the original smallest at that spot
                        );
            }
       
	
        // System.out.println( 
        //     "current list_iAS" + list_iAS
        //   + System.lineSeparator()
	//     + "after " + (i + 1) + " swaps"
        //   );
	// }
    }

    
/** 
      @return the index of the smallest element of list_iAS
              whose index is >= \startAt,
              using the reigning champ algorithm.
      helper function for constructor
     */
     private int dweebIndex( int startAt) {
        // use the starting element as a first guess
        int dweebAt = startAt;
        Integer dweeb = list_iAS.get( dweebAt);
        
        for( int testAt = startAt +1
           ; testAt < list_iAS.size()
           ; testAt++)
            if( list_iAS.get( testAt).compareTo( dweeb) < 0) {
                // Found a smaller value. Remember it.
                dweebAt = testAt;
                dweeb = list_iAS.get( dweebAt);
            }
        return dweebAt;
     }
    

    // /** 
    //   helper function for constructor
    //   Write good English here, reflecting good thinking.
    //   @return the index of the nth smallest Integer in list_iAS, disregarding the  n-1 Integers before it in list_iAS
    //  */
    //  private int champIndex() {
    // 	 int index = counter; //start from counter, not 0, otherwise
    // 	 // if nothing is smaller after the current, it returns ele 0
    // 	 Integer champ = list_iAS.get(counter);
    // 	 for (int i = counter; i < list_iAS.size(); i++){
    // 	     if (list_iAS.get(i) < champ){
    // 		 champ = list_iAS.get(i);
    // 		 index = i;
    // 	     }
    // 	     // System.out.println(champ);
    // 	 }
    // 	 return index;
    //  }


    // ------ code from previous assignments below here ----

    /**
      @return the index of any occurrence of
              \findMe in this list, or -1 if
              \findMe is absent from this list.
     */
    public int indexOf( Integer findMe) {
        return indexOf_whileStyle( findMe);
        // return indexOf_recursive(
            // findMe, 0, list_iAS.size() -1);
    }


    /**
      @return the indexOf value, calculated while-style
     */
    private int indexOf_whileStyle( Integer findMe) {
        int low = 0;
        int hi  = list_iAS.size() -1;  // inclusive

        while( low <= hi){
            int pageToCheck = (low + hi) / 2;
            int comparison =
              findMe.compareTo( list_iAS.get( pageToCheck));
            if( comparison == 0) return pageToCheck;
            else
                if( comparison < 0)
                    // findMe's spot precedes pageToCheck
                    hi = pageToCheck -1;
                // findMe's spot follows pageToCheck
                else low = pageToCheck +1;
        }
        return -3; // value differs from skeleton, just FYI
    }


    /**
      @return the indexOf value, calculated recursively
      [Holmes's comments temporarily elided, so as
       to avoid spoilers for hw60_16]
     */
    private int indexOf_recursive( Integer findMe
                                 , int low
                                 , int hi // inclusive
                                 ) {
        // System.out.println( "debug low: " + low
                          // + "   hi: " + hi);
        if( low > hi)  // detect base case
            return -2;   // solution to base case
              // value differs from while-style method, just FYI
        else{
            int pageToCheck = (low + hi) / 2;
            int comparison =
              findMe.compareTo( list_iAS.get( pageToCheck));


            if( comparison == 0)    // detect base case
                return pageToCheck; // solution other base case
            // recursive cases
            else
                if( comparison < 0)
                    // findMe's spot precedes pageToCheck
                    return indexOf_recursive( findMe
                                             , low
                                             , pageToCheck -1);
                else
                    // findMe's spot follows pageToCheck
                    return indexOf_recursive( findMe
                                            , pageToCheck +1
                                            , hi);
        }
    }


    public OrderedList_inArraySlots() {
        list_iAS = new java.util.ArrayList<Integer>();
    }

    /**
      @return the number of elements in this list
     */
    public int size(){
        return list_iAS.size();
    }

    /**
      @return a string representation of this Orderedlist_iAS
     */
    public String toString() {
        return list_iAS.toString();
    }


    /**
      Put @value where it belongs in the list.
      @pre: the list is in increasing order
     */
     public boolean add( Integer value) {
         int dest = 0;
         for( ; dest < list_iAS.size() && list_iAS.get( dest) < value
              ; dest++) ;
         // System.out.println( "OL adding " + value
         //                   + " at index " + dest);
         list_iAS.add( dest, value);
         return true;
     }


     /**
      @return element @index from this list
      precondition: @index is within the bounds of the array.
          (Having warned the user about this precondition,
           you should NOT complicate your code to check
           whether the condition was violated.)
     */
    public Integer get( int index ) {
        return list_iAS.get( index);
    }


    /**
      Remove the element at position @index in this list.

      Shift any subsequent elements to the left (that is,
      decrease the index associated with each).

      @return the value that was removed from the list
     */
    public Integer remove( int index) {
        return list_iAS.remove( index);
    }
}
