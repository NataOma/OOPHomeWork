package Model.FamilyTree;

import java.util.Iterator;
import java.util.List;

public class FamilyTreeIterator<E extends LeafFamilyTree<E>> implements Iterator<E> {
    private List<E> list;
    private int index;
    public FamilyTreeIterator(List<E> list){
        this.list = list;
        index = 0;
    }
    public boolean hasNext() {return index < list.size(); }
    public E next() {return list.get(index++); }
}
