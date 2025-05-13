import java.util.ArrayList;
import java.util.List;

public class Queue<E> {
    private List<E> list = new ArrayList<>();
    public void enqueue(E e){
        list.add(e);
    }

    public E dequeue(){
        if(hasItems()){
            E e = list.get(0);
            list.remove(0);
            return e;
        }
        return null;
    }

    public boolean hasItems(){
        return !(list.isEmpty());
    }
}
