package heap;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Comparator;
import java.util.NoSuchElementException;

/**
 * A Heap is a binary tree with h levels, which is fully loaded on the levels
 * 0,1...h-2; every child on the last level h-1 is set from left to right. The
 * elements are either ordered by a {@link Comparator} or by their
 * natural ordering, given by their implementation of
 * {@link java.lang.Comparable}. In order to avoid a
 * <code>ClassCastException</code>, the user must only insert
 * {@link java.lang.Comparable} elements or define a
 * {@link Comparator}. Given this order, every element in a parent
 * node is smaller than the elements in both child nodes.
 * <p>
 * The first element of a Heap is always the smallest element. It can be deleted
 * by {@link #deleteFirst()} or received by {@link #getFirst()}. A new element
 * can be inserted by {@link #insert(E)}.
 * <p>
 * A Heap is unbound and will automatically grow when inserting new elements.
 *
 * @author Mathias Menninghaus (mathias.menninghaus@uos.de)
 *
 * @param <E>
 */
public class Heap<E> implements Serializable {

   private static final long serialVersionUID = 1L;

   private static final int DEFAULT_INITIAL_CAPACITY = 11;

   
   /*
    * The heap as Object[], it is not possible to instantiate a generic array.
    */
   private transient Object[] heap;

   private int size = 0;

   private final Comparator<? super E> comparator;

   /**
    * Creates a new empty heap. <code>E</code> must implement
    * {@link java.lang.Comparable} in order to avoid a
    * <code>ClassCastException</code>.
    */
   public Heap() {
      this(null);
   }

   /**
    * Creates a new empty Heap. The elements inserted will be compared using the
    * given {@link Comparator}. If <code>comparator</code> is
    * <code>null</code>, <code>E</code> must implement
    * {@link java.lang.Comparable} in order to avoid a
    * <code>ClassCastException</code>.
    *
    * @param comparator
    *           a Comparator to compare the inserted elements
    */
   public Heap(Comparator<? super E> comparator) {
      this.heap = new Object[DEFAULT_INITIAL_CAPACITY];
      this.comparator = comparator;
   }

   /**
    * Increases the capacity of the array.
    *
    * @param minCapacity
    *           the desired minimum capacity
    */
   private void grow(int minCapacity) {
      if (minCapacity < 0) // overflow
         throw new OutOfMemoryError();
      int oldCapacity = heap.length;
      // Double size if small; else grow by 50%
      int newCapacity = ((oldCapacity < 64) ? ((oldCapacity + 1) * 2)
              : ((oldCapacity / 2) * 3));
      if (newCapacity < 0) // overflow
         newCapacity = Integer.MAX_VALUE;
      if (newCapacity < minCapacity)
         newCapacity = minCapacity;
      heap = Arrays.copyOf(heap, newCapacity);
   }

   /**
    * Inserts <code>e</code> into this Heap. May throw a
    * <code>ClassCastException</code> if this Heap has been initialized with an
    * incompatible <code>Comparator</code> or if <code>e</code> is not
    * comparable to the other elements in this Heap.
    *
    * @param e
    *           element to insert
    */
   public void insert(E e) {
      if (size >= heap.length) {
         grow(size + 1);
      }
      if (size == 0) {
         heap[0] = e;
      } else {
         siftUp(size, e);
      }
      size++;
   }

   /**
    * Retrieves and removes the smallest element of this Heap.
    *
    * @return the smallest element of this Heap.
    * @throws NoSuchElementException
    *            if this Heap is empty
    */
   @SuppressWarnings("unchecked")
   public E deleteFirst() {
      if (size == 0) {
         throw new NoSuchElementException();
      }
      int s = --size;
      E result = (E) heap[0];
      E x = (E) heap[s];
      heap[s] = null;
      if (s != 0) {
         siftDown(0, x);
      }
      return result;
   }

   /**
    * Returns the smallest element of this Heap without removing it.
    *
    * @return the smallest element of this Heap
    * @throws NoSuchElementException
    *            if this Heap is empty
    */
   @SuppressWarnings("unchecked")
   public E getFirst() {
      if (size == 0) {
         throw new NoSuchElementException();
      }
      return (E) heap[0];
   }

   /**
    * Returns the number of elements in this Heap.
    *
    * @return the number of elements in this Heap
    */
   public int size() {
      return size;
   }

   /**
    * Checks if this Heap is empty.
    *
    * @return <code>true</code> if this Heap is empty, else <code>false</code>
    */
   public boolean empty() {
      return size == 0;
   }

   /**
    * Inserts <code>x</code> at position <code>i</code> and sifts it up until
    * it is smaller than or equal to all elements at positions <code>j</code>
    * where <code>j &gt; (i-1)/2</code>.
    *
    * @param i
    *           index where <code>x</code> is inserted
    * @param x
    *           element to insert
    */
   private void siftUp(int i, E x) {
      if (comparator != null) {
         siftUpUsingComparator(i, x);
      } else {
         siftUpComparable(i, x);
      }
   }

   /**
    * Inserts <code>x</code> at position <code>i</code> and sifts it up until
    * it is smaller than or equal to all elements at positions <code>j</code>
    * where <code>j &gt; (i-1)/2</code>. This method assumes that all elements
    * in this Heap and <code>x</code> are mutually comparable and that
    * <code>x</code> is not <code>null</code>.
    *
    * @param i
    *           index where <code>x</code> is inserted
    * @param x
    *           element to insert
    */
   @SuppressWarnings("unchecked")
   private void siftUpComparable(int i, E x) {
      Comparable<? super E> key = (Comparable<? super E>) x;
      while (i > 0) {
         int parent = (i - 1) >>> 1;
         Object e = heap[parent];
         if (key.compareTo((E) e) >= 0) {
            break;
         }
         heap[i] = e;
         i = parent;
      }
      heap[i] = key;
   }

   /**
    * Inserts <code>x</code> at position <code>i</code> and sifts it up until
    * it is smaller than or equal to all elements at positions <code>j</code>
    * where <code>j &gt; (i-1)/2</code>. This method assumes that all elements
    * in this Heap and <code>x</code> are mutually non-comparable or that a
    * <code>Comparator</code> has been set.
    *
    * @param i
    *           index where <code>x</code> is inserted
    * @param x
    *           element to insert
    */
   @SuppressWarnings("unchecked")
   private void siftUpUsingComparator(int i, E x) {
      while (i > 0) {
         int parent = (i - 1) >>> 1;
         Object e = heap[parent];
         if (comparator.compare(x, (E) e) >= 0) {
            break;
         }
         heap[i] = e;
         i = parent;
      }
      heap[i] = x;
   }

   /**
    * Inserts <code>x</code> at position <code>i</code> and sifts it down until
    * it is larger than or equal to all elements at positions <code>j</code>
    * where <code>j &gt; i &times; 2</code> and <code>j+1</code>.
    *
    * @param i
    *           index where <code>x</code> is inserted
    * @param x
    *           element to insert
    */
   private void siftDown(int i, E x) {
      if (comparator != null) {
         siftDownUsingComparator(i, x);
      } else {
         siftDownComparable(i, x);
      }
   }

   /**
    * Inserts <code>x</code> at position <code>i</code> and sifts it down until
    * it is larger than or equal to all elements at positions <code>j</code>
    * where <code>j &gt; i &times; 2</code> and <code>j+1</code>. This method
    * assumes that all elements in this Heap and <code>x</code> are mutually
    * comparable and that <code>x</code> is not <code>null</code>.
    *
    * @param i
    *           index where <code>x</code> is inserted
    * @param x
    *           element to insert
    */
   @SuppressWarnings("unchecked")
   private void siftDownComparable(int i, E x) {
      Comparable<? super E> key = (Comparable<? super E>) x;
      int half = size >>> 1; // loop while a non-leaf
      while (i < half) {
         int child = (i << 1) + 1; // assume left child is least
         Object c = heap[child];
         int right = child + 1;
         if (right < size &&
                 ((Comparable<? super E>) c).compareTo((E) heap[right]) > 0) {
            c = heap[child = right];
         }
         if (key.compareTo((E) c) <= 0) {
            break;
         }
         heap[i] = c;
         i = child;
      }
      heap[i] = key;
   }

   /**
    * Inserts <code>x</code> at position <code>i</code> and sifts it down until
    * it is larger than or equal to all elements at positions <code>j</code>
    * where <code>j &gt; i &times; 2</code> and <code>j+1</code>. This method
    * assumes that all elements in this Heap and <code>x</code> are mutually
    * non-comparable or that a <code>Comparator</code> has been set.
    *
    * @param i
    *           index where <code>x</code> is inserted
    * @param x
    *           element to insert
    */
   @SuppressWarnings("unchecked")
   private void siftDownUsingComparator(int i, E x) {
      int half = size >>> 1; // loop while a non-leaf
      while (i < half) {
         int child = (i << 1) + 1; // assume left child is least
         Object c = heap[child];
         int right = child + 1;
         if (right < size && comparator.compare((E) c, (E) heap[right]) > 0) {
            c = heap[child = right];
         }
         if (comparator.compare(x, (E) c) <= 0) {
            break;
         }
         heap[i] = c;
         i = child;
      }
      heap[i] = x;
   }

   private void writeObject(java.io.ObjectOutputStream s)
           throws java.io.IOException {
      // Write out element count, and any hidden stuff
      s.defaultWriteObject();

      // Write out array length
      s.writeInt(heap.length);

      // Write out all elements in the proper order.
      for (int i = 0; i < size; i++) {
         s.writeObject(heap[i]);
      }
   }

   private void readObject(java.io.ObjectInputStream s)
           throws java.io.IOException, ClassNotFoundException {
      // Read in size, and any hidden stuff
      s.defaultReadObject();

      // Read in array length
      int arrayLength = s.readInt();
      heap = new Object[arrayLength];

      // Read in all elements in the proper order.
      for (int i = 0; i < size; i++)
         heap[i] = s.readObject();
   }

   /**
    * Returns a string representation of this Heap.
    *
    * @return a string representation of this Heap
    */
   public String toString() {
      return Arrays.toString(heap);
   }
}

