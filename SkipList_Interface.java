package SKPLIST_A4;

/*
Interface: The skiplist will provide this collection of operations:

insert:
  in: a douoble (the element to be stored into the skiplist)
  return: boolean, return true if insert is successful, false otherwise
  effect: if the double is already in the skiplist, then there is no change to
          the skiplist state, and return false
          if the double is not already in the skiplist, then a new skiplist node
            is created, the double put into it as data, the new node is linked
            into the skiplist at the proper place; size is incremented by 1,
            and return a true
remove:
  in: a double (the element to be taken out of the skiplist)
  return: boolean, return true if the remove is successful, false otherwise
          this means return false if the skiplist size is 0
  effect: if the element being looked for is in the skiplist, unlink the node containing
          it and return true (success); size decreases by one
          if the element being looked for is not in the skiplist, return false and
          make no change to the skiplist state
contains:
  in: a double (the element to be seaarched for)
  return: boolean, return true if the double being looked for is in the skiplist;
          return false otherwise
          this means return false if skiplist size is 0
  effect: no change to the state of the skiplist

findMin:
  in: none
  return: double, the element value from the skiplist that is smallest
  effect: no skiplist state change
  error: is skiplist size is 0, return Double.NaN

findMax:
  in: none
  return: double, the element value from the skiplist that is largest
  effect: no skiplist state change
  error: is skiplist size is 0, return Double.NaN

size:
  in: nothing
  return: number of elements stored in the skiplist
  effect: no change to skiplist state

empty:
  in: nothing
  return: boolean, true if the skiplist has no elements in it, true if size is 0
          return false otherwise
  effect: no change to skiplist state

clear:
  in: none
  return: void
  effect: all elements in the skip list are unhooked so that no elements are in the list
          size is set to 0
          sentinel node remains
          the effect is to create a skip list state that exists when it is first 
          produced by the constructor

level:
  in: none
  return: integer, the level of the highest node in the skiplist
  effect: no change in skiplist state
  error: return -1 if skiplist is empty (size is 0, only sentinel node is there)

max: 
  in: none
  return: integer, the value of MAXHEIGHT that is set in the list constructor
  effect: no change in skip list state

getRoot:
  in: none
  return: a skiplist node, the one that is the starter of the entire skiplist
          the skiplist starts with a sentinel, made in the list constructor.
          so getRoot returns the sentinel always, even if the skiplist is empty.
          If the list is empty, then level 0 of the senetinel link array would be null.
  effect: no change to skiplist state

 */

//ADT operations

public interface SkipList_Interface {
	public void setSeed(long seed);
	public void setProbability(double probability);
	public SkipList_Node getRoot();
	public boolean insert(double value);
	public boolean remove(double value);
	public boolean contains(double value);
	public double findMin();
	public double findMax();
	public boolean empty();
	public void clear();
	public int size();
	public int level();
	public int max();
}