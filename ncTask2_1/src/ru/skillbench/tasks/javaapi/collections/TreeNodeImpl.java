package ru.skillbench.tasks.javaapi.collections;

import java.util.*;

public class TreeNodeImpl implements TreeNode {
    private TreeNode parent = null;
    private HashSet<TreeNode> children = null;
    private boolean expanded;
    private Object data = null;

//    TreeNodeImpl() {};
//    TreeNodeImpl(Object data) {
//        this.data = data;
//    }
    
    @Override
    public TreeNode getParent() {
        return parent;
    }

//    public void plainSetParent(TreeNode parent) {
//        this.parent = parent;
//    }

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
        return (children == null || children.isEmpty());
    }

    @Override
    public int getChildCount() {
        return children.size();
    }

    @Override
    public Iterator<TreeNode> getChildrenIterator() {
//        Iterator<TreeNode> iterator = children.iterator();
        return children.iterator();
    }

    @Override
    public void addChild(TreeNode child) {
        if (children == null) {
            children = new HashSet<>();
        }
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
        TreeNode tmp = this;
//        if (getParent() != null) {
//             tmp = getParent();
//        } else {
//            tmp = null;
//        }

        while (tmp.getParent() != null) {
            nodes.add(tmp);
            tmp = tmp.getParent();
        }
        nodes.add(tmp);
        //TODO: в nodes реверсировать список, вызов data последовательно
        Collections.reverse(nodes);
        String s = "";
        for (int i = 0; i < nodes.size(); i++) {
            if (nodes.get(i).getData() != null) {
                s = s.concat(nodes.get(i).getData().toString());
            } else {
                s = s.concat("empty");
            }
            if (nodes.size() - i > 1) {
                s = s.concat("->");
            }
        }
        return s;
    }

    @Override
    public TreeNode findParent(Object data) {
//        if (getParent().getData().equals(data)) {
//            getParent().findParent(data);
//        } else {
//            return getParent();
//        }
//        return null;


//        //TODO: if first from root needed
//        TreeNode tmp = this;
//        TreeNode saved = null;
//        while (tmp != null) {
//            System.out.println("+");        //TODO: infinite???
//            if (tmp.getData().equals(data)) {
//                saved = tmp;
//            }
//            tmp = tmp.getParent();
//        }
//        return saved;

        //TODO: if first from child needed
        TreeNode tmp = this;
        while (tmp != null) {
            if (tmp.getData().equals(data)) {
                return tmp;
            } else {
                tmp = tmp.getParent();
            }
        }
        return null;

    }

    @Override
    public TreeNode findChild(Object data) {
//        for (TreeNode tn : children) {
//            if (data == null) {
//                if (tn.getData() == null) {
//                    return this;
//                } else {
//                    tn.findChild(data);
//                }
//            } else {
//                if (tn.getData() != null && tn.getData().equals(data)) {
//                    return this;
//                } else {
//                    tn.findChild(data);
//                }
//            }
//        }
//        return null;

//        //TODO: end of recursion (bottom) is not identified
//        if (children != null) {
//            for (TreeNode tn : children) {
//                System.out.println(tn.getData());
//                if (tn.getData().equals(data)) {
//                    return tn;
//                } else {
//                    return tn.findChild(data);
//                }
//            }
//        } else {
//            if (data == )
//        }
//        return null;


        TreeNode saver = null;
//        System.out.println(saver);

        if (data == null) {
            if (this.data == null) {
//                saver = this;
                return this;
            } else {
                if (children != null) {
                    for (TreeNode tn : children) {
                        tn.findChild(null);
                    }
                }
            }
        } else {
//            System.out.println(this.getData());
            System.out.println(data + " " + getData() + " " + data.equals(this.getData()));
            if (data.equals(this.getData())) {
                return this;
            } else {
                if (children != null) {
                    for (TreeNode tn : children) {
//                        saver = tn.findChild(data);
                        return tn.findChild(data);
                    }
                }
            }
        }
//        System.out.println(saver.getData());


//        if (children != null) {
//            for (TreeNode tn : children) {
//                return tn.findChild(data);
//            }
//        }

        return null;
    }


    public void printAllChildren() {
        for (TreeNode tn : children) {
            System.out.print(tn.getData() + " ");
        }
        System.out.println();
    }

    public void printTree() {
        System.out.println(getData());
        if (children != null) {
            for (TreeNode tn : children) {
                tn.printTree();
            }
        }
    }
}
