/*
 * Author: George Sigety - sigetyg@bc.edu
 */

public interface List2<T> {
  public int size();
  public boolean isEmpty();
  public T first();
  public T last();
  public void addFirst(T item);
  public void addLast(T item);
  public T removeFirst();
  public T removeLast();
}
