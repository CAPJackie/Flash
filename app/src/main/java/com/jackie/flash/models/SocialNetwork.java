
package com.jackie.flash.models;

import androidx.annotation.NonNull;

import java.util.Objects;

public class SocialNetwork {
    private String name;
    private int icon;
    private boolean checked;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SocialNetwork that = (SocialNetwork) o;
        return icon == that.icon &&
                checked == that.checked &&
                Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, icon, checked);
    }

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

    public SocialNetwork clone(){
        return new SocialNetwork(this.name, this.icon);
    }
}
