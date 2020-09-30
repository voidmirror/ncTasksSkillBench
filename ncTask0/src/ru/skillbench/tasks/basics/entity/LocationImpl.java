package ru.skillbench.tasks.basics.entity;

public class LocationImpl implements Location {

    private Type type;
    private Location parent;
    private String name;


    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public Type getType() {
        return type;
    }

    @Override
    public void setType(Type type) {
        this.type = type;
    }

    @Override
    public void setParent(Location parent) {
        this.parent = parent;
    }

    @Override
    public String getParentName() {
        if (parent != null) {
            return parent.getName();
        }
        return "--";
    }

    @Override
    public Location getTopLocation() {
        if (parent != null) {
            return parent.getTopLocation();
        } else {
            return this;
        }
    }

    @Override
    public boolean isCorrect() {
        if (type.compareTo(parent.getType()) > 0) {
            if (this.getType() == parent.getType()) {
                return false; //TODO: ожет не быть верно, перепроверить
            } else {
                return parent.isCorrect();
            }

        }
//        if (getParentName().equals("--")) {
//            return true;
//        }
//        return false;
        return getParentName().equals("--");
    }

    @Override
    public String getAddress() {
        return null;
    }

    @Override
    public String toString() {
        return name + " (" + type.toString() + ")";
    }
}
