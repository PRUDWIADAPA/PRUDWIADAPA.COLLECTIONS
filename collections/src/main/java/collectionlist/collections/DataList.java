package collectionlist.collections;
import java.util.Arrays;
public class DataList<E> 
{
    
    private int list_size_of_list = 0;
  
    private static final int DEFAULT_CAPACITY = 10;
     
    private Object list_elements[];
 
    public DataList() {
        list_elements = new Object[DEFAULT_CAPACITY];
    }
 
    public void addition(E e) {
        if (list_size_of_list == list_elements.length) {
            ensure_Capacity();
        }
        list_elements[list_size_of_list++] = e;
    }
     
    @SuppressWarnings("unchecked")
    public E get(int p) {
        if (p >= list_size_of_list || p < 0) {
            throw new IndexOutOfBoundsException("Index: " + p + ", size_of_list " + p);
        }
        return (E) list_elements[p];
    }
     
    @SuppressWarnings("unchecked")
    public E remove(int i) {
        if (i >= list_size_of_list || i < 0) {
            throw new IndexOutOfBoundsException("Index: " + i + ", size_of_list " + i);
        }
        Object item = list_elements[i];
        int numElts = list_elements.length - ( i + 1 ) ;
        System.arraycopy( list_elements, i + 1, list_elements, i, numElts ) ;
        list_size_of_list--;
        return (E) item;
    }
     
    
    public int size_of_list() {
        return list_size_of_list;
    }
     
    //Print method
    @Override
    public String toString() 
    {
         StringBuilder sb = new StringBuilder();
         sb.append('[');
         for(int i = 0; i < list_size_of_list ;i++) {
             sb.append(list_elements[i].toString());
             if(i<list_size_of_list-1){
                 sb.append(",");
             }
         }
         sb.append(']');
         return sb.toString();
    }
     
    private void ensure_Capacity() {
        int latest_size_of_list = list_elements.length * 2;
        list_elements = Arrays.copyOf(list_elements, latest_size_of_list);
    }
}