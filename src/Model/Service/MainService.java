package Model.Service;

import Model.FamilyTree.FamilyTree;
import Model.FamilyTree.LeafFamilyTree;
import Model.Human.Gender;
import Model.Writer.FileHandler;

public class MainService<E extends LeafFamilyTree<E>> {
    private static int genLeafID;
    public FamilyTree<E> familyTree;

    public MainService() {familyTree = new FamilyTree<E>();}
    public boolean addLeaf(E leaf){
        if (leaf.getId() == -1){
            leaf.setId(genLeafID++);
            familyTree.addHuman(leaf);
            return true;
        }
        else return false;
    }
    public boolean setWedding(E human1, E human2) {
        if (human1.getSpouse() == null && human2.getSpouse() == null) {
            human1.setSpouse(human2);
            human2.setSpouse(human1);
            return true;
        }
        else return false;
    }
    public void saveTree(FamilyTree<E> tree, String filePath) {
        FileHandler handler = new FileHandler();
        handler.save(tree, filePath);
    }
    public FamilyTree read(String filePath){
        FileHandler handler = new FileHandler();
        return (FamilyTree) handler.read(filePath);
    }

}
