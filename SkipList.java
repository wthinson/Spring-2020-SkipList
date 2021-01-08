package SKPLIST_A4;

import java.util.Random;

public class SkipList implements SkipList_Interface {

    private SkipList_Node root;
    private final Random rand;
    private double probability;
    private final int MAXHEIGHT = 30; // the most links that a data cell may contain
    private final double LAMBDA = .0001;
    private int size;
    private int maxHeight;

    public SkipList(int maxHeight) {
        this.maxHeight = maxHeight > MAXHEIGHT ? MAXHEIGHT : maxHeight;
        probability = 0.5;
        rand = new Random();
        root = new SkipList_Node(Double.NaN, this.maxHeight);
        
        clear();
    }

    @Override
    public void setSeed(long seed) {
        rand.setSeed(seed);
    }

    @Override
    public void setProbability(double probability) {
        this.probability = probability;
    }

    private boolean flip() {
        // use this where you "roll the dice"
        // call it repeatedly until you determine the level
        // for a new node
        return rand.nextDouble() < probability;
    }

    @Override
    public SkipList_Node getRoot() {
        return root;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        int levels;
        for (levels = 0; levels < root.getNext().length && root.getNext(levels) != null; levels++);

        StringBuilder[] sbs = new StringBuilder[levels];

        for (int i = 0; i < sbs.length; i++) {
            sbs[i] = new StringBuilder();
            sbs[i].append("level ").append(i).append(":");
        }

        SkipList_Node cur = root;

        while (cur.getNext(0) != null) {
            cur = cur.getNext(0);
            for (int i = levels - 1; i >= cur.getNext().length; i--) {
                sbs[i].append("\t");
            }
            for (int i = cur.getNext().length - 1; i >= 0; i--) {
                if (cur.getNext(i) == null) {
                    levels--;
                }
                sbs[i].append("\t").append(cur.getValue());
            }
        }

        for (int i = sbs.length - 1; i >= 0; i--) {
            sb.append(sbs[i]).append("\n");
        }

        return sb.toString();
    }

    //---------------------------------------------------------
    // student code follows
    // implement the methods of the interface
    //---------------------------------------------------------
    
    private SkipList_Node getLeftNode(int level, double value, SkipList_Node rootNode) {
        SkipList_Node leftNode = rootNode;
        SkipList_Node rightNode = rootNode.getNext(level);
        while (rightNode != null && rightNode.getValue() < value) {
            leftNode = rightNode;
            rightNode = rightNode.getNext(level);
        }
        return leftNode;
    }

    @Override
    public boolean insert(double value) {
        int level = 0;
        while (flip() && level < maxHeight - 1) {
            level++;
        }

        if (insertRecur(level, new SkipList_Node(value, level + 1), root)) {
           this.size++;
            return true;
        } else {
            return false;
        }
    }

    private boolean insertRecur(int level, SkipList_Node newNode, SkipList_Node rootNode) {
        SkipList_Node leftNode = getLeftNode(level, newNode.getValue(), rootNode);
        SkipList_Node rightNode = leftNode.getNext(level);

        if (rightNode != null && Math.abs(rightNode.getValue() - newNode.getValue()) < LAMBDA) {
            return false;
        }

        if (level == 0 || insertRecur(level - 1, newNode, leftNode)) {
            leftNode.setNext(level, newNode);
            newNode.setNext(level, rightNode);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean remove(double value) {
        // TODO Auto-generated method stub
        if (empty()) {
            return false;
        }
        if (removeRecur(level(), value, root)) {
           this.size--;
            return true;
        } else {
            return false;
        }
    }

    private boolean removeRecur(int level, double value, SkipList_Node rootNode) {
        SkipList_Node leftNode = getLeftNode(level, value, rootNode);
        SkipList_Node rightNode = leftNode.getNext(level);

        if (rightNode != null && Math.abs(rightNode.getValue() - value) < LAMBDA) {
            leftNode.setNext(level, rightNode.getNext(level));
            return level == 0 || removeRecur(level - 1, value, leftNode);
        } else if (level == 0) {
            return false;
        } else {
            return removeRecur(level - 1, value, leftNode);
        }
    }

    @Override
    public boolean contains(double value) {
        // TODO Auto-generated method stub
        if (empty()) {
            return false;
        }
        return containsRecur(level(), value, root);
    }

    private boolean containsRecur(int level, double value, SkipList_Node rootNode) {
        SkipList_Node leftNode = getLeftNode(level, value, rootNode);
        SkipList_Node rightNode = leftNode.getNext(level);

        if (rightNode != null && Math.abs(rightNode.getValue() - value) < LAMBDA) {
            return true;
        } else if (level == 0) {
            return false;
        } else {
            return containsRecur(level - 1, value, leftNode);
        }
    }

    @Override
    public double findMin() {
        if (empty()) {
            return Double.NaN;
        }
        return root.getNext(0).getValue();
    }

    @Override
    public double findMax() {
        if (empty()) {
            return Double.NaN;
        }
        SkipList_Node max = root;
        int level = level();

        while (level != 0 || max.getNext(level) != null) {
            if (max.getNext(level) == null) {
                level--;
            } else {
                max = max.getNext(level);
            }
        }
        return max.getValue();
    }

    @Override
    public boolean empty() {
        return this.size == 0;
    }

    @Override
    public void clear() {
        root = new SkipList_Node(Double.NaN, maxHeight);
       this.size = 0;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public int level() {
        if (empty()) {
            return -1;
        }
        for (int i = maxHeight - 1; i >= 0; i--) {
            if (root.getNext(i) != null) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int max() {
        return maxHeight;
    }

}
