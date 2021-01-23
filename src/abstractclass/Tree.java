package abstractclass;

import java.util.UUID;

public class Tree {
    private UUID treeID;
    private Integer treeAge;
    private String treeType;
    private Boolean treeInGoodHealth;
    private CreateTrees createTrees;

    public Tree(Integer treeAge, String treeType, Boolean treeInGoodHealth) {
        this.treeID = setSingleTreeID();
        this.treeAge = treeAge;
        this.treeType = treeType;
        this.treeType = treeType;
        this.treeInGoodHealth = treeInGoodHealth;
        this.createTrees = new Forest();
    }

    public String returnAllTreeInfo() { //Method should accept an ID number and return the resulting information.
        return String.format("Tree ID: " + treeID + "\nType: " + getTreeType() + "\nAge: " + getTreeAge() + "\nIn Good Health: " + getTreeInGoodHealth() + "\n");
    }

    public static UUID setSingleTreeID() {
        UUID newKey = UUID.randomUUID();
        return newKey;
    }

    public UUID getTreeID() {
        return treeID;
    }

    public Integer getTreeAge() {
        return treeAge;
    }

    public Boolean getTreeInGoodHealth() {
        return treeInGoodHealth;
    }

    public String getTreeType() {
        return treeType;
    }

    public CreateTrees getTreeActions() {
        return createTrees;
    }
}