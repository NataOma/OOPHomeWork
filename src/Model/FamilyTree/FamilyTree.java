package Model.FamilyTree;
import Model.Service.LeafService;

import java.util.Iterator;
import java.util.LinkedList;
import java.io.Serializable;

public class FamilyTree<E extends LeafFamilyTree<E>> implements Iterable<E>, Serializable{
    LeafService<E> leafService = new LeafService<>();
//    private long idLeaf;
    private final LinkedList<E> familyTree;
    public FamilyTree(){
//        this.idLeaf = 0;
        this.familyTree = new LinkedList<E>();
    }
    public int count(){
        return this.familyTree.size();
    }

    public void addHuman(E human){
            this.familyTree.add(human);
    }
    public LinkedList<E> getFamilyTree(){
        return familyTree;
    }
    @Override
    public String toString(){
        StringBuilder stringBuilder = new StringBuilder();
        for (E human : familyTree){
            stringBuilder.append(leafService.getInfoLeaf(human));
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }
    public E getHuman(long id){
            return this.getFamilyTree().
                    stream().filter(i -> i.getId() == id).
                    findFirst().orElse(null);
    }
    public Iterator<E> iterator(){return new FamilyTreeIterator(familyTree);}

    public void sortByAge(){familyTree.sort(new LeafComparatorByAge<E>());}

    public void sortByName(){familyTree.sort(new LeafComparatorByName<E>());}

    public void sortByNameRevers(){familyTree.sort(new LeafComparatorByName<E>().reversed());}

    public void sortByAgeRevers(){familyTree.sort(new LeafComparatorByAge<E>().reversed());}
}