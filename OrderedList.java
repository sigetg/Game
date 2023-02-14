/*
 * Author: George Sigety - sigetyg@bc.edu
 */

public interface OrderedList<T extends Comparable<T>> extends List<T> {
  public void insert(T item);
  public void print(String format);

}
