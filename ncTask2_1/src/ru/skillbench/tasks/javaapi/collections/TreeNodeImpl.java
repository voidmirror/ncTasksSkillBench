package ru.skillbench.tasks.javaapi.collections;

import java.util.*;

public class TreeNodeImpl implements TreeNode {
    private TreeNode parent = null;
    private ArrayList<TreeNode> children = new ArrayList<>();
    private boolean expanded;
    private Object data = null;

    TreeNodeImpl() {};
    TreeNodeImpl(Object data) {
        this.data = data;
    }
    
    @Override
    public TreeNode getParent() {
        return parent;
    }

    @Override
    public void setParent(TreeNode parent) {
        this.parent = parent;
    }

    @Override
    public TreeNode getRoot() {
        if (parent != null) {
            if (parent.getParent() == null) {
                return parent.getRoot();
            } else {
                return parent.getParent();
            }
        } else {
            return null;
        }
    }

    @Override
    public boolean isLeaf() {
        return children.isEmpty();
    }

    @Override
    public int getChildCount() {
        return children.size();
    }

    @Override
    public Iterator<TreeNode> getChildrenIterator() {
        Iterator<TreeNode> iterator = children.iterator();
        return iterator;
    }

    @Override
    public void addChild(TreeNode child) {
        children.add(child);
        child.setParent(this);
    }

    @Override
    public boolean removeChild(TreeNode child) {
        for (TreeNode tn : children) {
            if (tn.equals(child)) {
                tn.setParent(null);
                children.remove(tn);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean isExpanded() {
        return expanded;
    }

    @Override
    public void setExpanded(boolean expanded) {
        this.expanded = expanded;
        for (TreeNode tn : children) {
            tn.setExpanded(expanded);
        }
    }

    @Override
    public Object getData() {
        return data;
    }

    @Override
    public void setData(Object data) {
        this.data = data;
    }

    @Override
    public String getTreePath() {
        ArrayList<TreeNode> nodes = new ArrayList<>();
        TreeNode tmp;
        if (getParent() != null) {
             tmp = getParent();
        } else {
            tmp = null;
        }

        while (tmp.getParent() != null) {
            nodes.add(tmp);
            tmp = tmp.getParent();
        }
        //TODO: в nodes реверсировать список, вызов data последовательно
        Collections.reverse(nodes);
        String s = "";
        for (int i = 0; i < nodes.size(); i++) {
            if (nodes.get(i).getData() != null) {
                s.concat(nodes.get(i).getData().toString());
            } else {
                s.concat("empty");
            }
            if (nodes.size() - i > 1) {
                s.concat("->");
            }
        }
        return s;
    }

    @Override
    public TreeNode findParent(Object data) {
        if (getParent().getData().equals(data)) {
            getParent().findParent(data);
        } else {
            return getParent();
        }
        return null;
    }

    @Override
    public TreeNode findChild(Object data) {
        for (TreeNode tn : children) {
            if (data == null) {
                if (tn.getData() == null) {
                    return this;
                } else {
                    tn.findChild(data);
                }
            } else {
                if (tn.getData() != null && tn.getData().equals(data)) {
                    return this;
                } else {
                    tn.findChild(data);
                }
            }
        }
        return null;
    }
}
