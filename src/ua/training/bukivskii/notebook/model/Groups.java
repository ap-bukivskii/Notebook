package ua.training.bukivskii.notebook.model;

import javax.print.DocFlavor;

public enum Groups {
    FIRST (1, "First"),
    SECOND (2, "Second"),
    THIRD (3, "Third"),
    FOURTH (4,"Fourth"),
    FIFTH (5, "Fifth");

    public int groupID;
    public String name;

    Groups(int groupID, String name) {
        this.name = name;
        this.groupID = groupID;
    }

    public int getGroupID() {
        return groupID;
    }

    public String getName() {
        return name;
    }
}
