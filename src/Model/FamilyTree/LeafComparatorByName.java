package Model.FamilyTree;

import java.util.Comparator;

public class LeafComparatorByName<E extends LeafFamilyTree<E>> implements Comparator<E> {
    @Override
    public int compare(E o1, E o2) {
        return o1.getFirstName().compareTo(o2.getFirstName());
    }
}
