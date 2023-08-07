package com.example.coupxchange;

public class Website {
    private String name;
    private int icon;
    private boolean selected;

    public Website(String name, int icon) {
        this.name = name;
        this.icon = icon;
        this.selected = false;
    }

    public String getName() {
        return name;
    }

    public int getIcon() {
        return icon;
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }
}


