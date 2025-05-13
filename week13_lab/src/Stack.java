import java.util.ArrayList;
import java.util.List;

public class Stack<E> {
    private List<E> list = new ArrayList<>();

    public void push(E e){
        list.add(e);
    }

    public E pop(){
        return  list.remove(list.size() - 1);
    }

    public boolean hasItems(){
        if (list.size() == 0)
        {
            return  false;
        }
        else {
            return true;
        }
    }
}
