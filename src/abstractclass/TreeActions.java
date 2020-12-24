package abstractclass;

import java.util.ArrayList;

public interface TreeActions {

    default ArrayList<Tree> createSetOfTrees(Integer numberOfTrees, Integer treeAge, String treeType, Boolean inGoodHealth) {
        if (numberOfTrees <= 0) return null;
        ArrayList<Tree> trees = new ArrayList<>();
        for (int i = 0; i < numberOfTrees; i++) {
            Tree tree = new Tree(treeAge, treeType, inGoodHealth);
            trees.add(tree);
        }
        return trees;
    }
}