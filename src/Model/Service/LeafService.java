package Model.Service;

import Model.FamilyTree.LeafFamilyTree;
import Model.Human.Gender;

import java.io.Serializable;

//public class LeafService<E extends LeafFamilyTree<E>> extends MainService{
public class LeafService<E extends LeafFamilyTree<E>> implements Serializable {
    public boolean setWedding(E human1, E human2) {
        if (human1.getSpouse() == null && human2.getSpouse() == null) {
            human1.setSpouse(human2);
            human2.setSpouse(human1);
            return true;
        }
        else return false;
    }
    public boolean setDivorce(E human){
        if (human.getSpouse() != null && human.getSpouse().equals(human)){
            human.getSpouse().setSpouse(null);
            human.setSpouse(null);
            return true;
        }
        return false;
    }
    public boolean setBond(E parent, E child){
        if (parent.getAge() < child.getAge()){
            E temp = child;
            child = parent;
            parent = temp;
        }
        if (parent.getGender().equals(Gender.male) && child.getFather() == null){
            child.setFather(parent);
            if (!parent.getChildren().contains(child)){
                parent.setChildren(child);
                return true;
            }
        } else if (parent.getGender().equals(Gender.female) && child.getMother() == null){
            child.setMother(parent);
            if (!parent.getChildren().contains(child)) {
                parent.setChildren(child);
                return true;
            }
        }
        return false;
    }
    public String getChildrenInfo(E human){
        StringBuilder stringBuilder = new StringBuilder();
        if (human.getChildren().isEmpty())  stringBuilder.append("N/D");
        else {
            stringBuilder.append(human.getChildren().get(0).getFirstName());
            for (int i = 1; i < human.getChildren().size(); i++){
                stringBuilder.append(", ");
                stringBuilder.append(human.getChildren().get(i).getFirstName());
            }
        }
        return stringBuilder.toString();
    }
    public String getInfoLeaf(E leaf){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("ID: ");
        stringBuilder.append(leaf.getId());
        stringBuilder.append(", Name: ");
        stringBuilder.append(leaf.getFirstName());
        stringBuilder.append(", Last Name: ");
        stringBuilder.append(leaf.getLastName());
        stringBuilder.append(", Age: ");
        stringBuilder.append(leaf.getAge());
        stringBuilder.append(", Father: ");
        if (leaf.getFather() != null) stringBuilder.append(leaf.getFather().getFirstName());
        else stringBuilder.append("N/D");
        stringBuilder.append(", Mother: ");
        if (leaf.getMother() != null) stringBuilder.append(leaf.getMother().getFirstName());
        else stringBuilder.append("N/D");
        stringBuilder.append(", Spouse: ");
        if (leaf.getSpouse() != null) stringBuilder.append(leaf.getSpouse().getFirstName());
        else stringBuilder.append("N/D");
        stringBuilder.append(", Children: ");
        stringBuilder.append(this.getChildrenInfo(leaf));
        stringBuilder.append(", Status: ");
        stringBuilder.append(leaf.getStatus());

        return stringBuilder.toString();
    }
}
