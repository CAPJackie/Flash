
package com.jackie.flash.models.entities;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.Objects;

@Entity(tableName = SocialNetwork.TABLE_NAME)
public class SocialNetwork {


    @PrimaryKey(autoGenerate = true)
    private int id;

    private String name;
    private int icon;
    private boolean checked;

    public static final String TABLE_NAME = "social_network";


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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
