
package com.jackie.flash.models;

public class SocialNetwork {
    private String name;
    private int icon;
    private boolean checked;

    public SocialNetwork(String name, int icon) {
        this.name = name;
        this.icon = icon;
        this.checked = true;
    }

    @Override
    public String toString() {
        return "SocialNetwork{" +
                "name='" + name + '\'' +
                ", icon=" + icon +
                ", checked=" + checked +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }
}
