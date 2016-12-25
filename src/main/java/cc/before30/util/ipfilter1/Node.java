package cc.before30.util.ipfilter1;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * Created by before30 on 24/12/2016.
 */
public class Node {
    private HashMap<Integer, Node> children = new HashMap<Integer, Node>();
    private Node parent;
    private int value;
    private final int depth;

    public static final int STAR_VALUE = -1;

    public Node() {
        this.parent = null;
        this.depth = 0;
    }

    public Node(Node parent, int value, int depth) {
        this.parent = parent;
        this.depth = depth;
        this.value = value;
    }

    public void add(List<Integer> ips) {
        if (ips.size() <= depth) {
            return;
        }

        if (children.containsKey(ips.get(depth))) {
            // get old one
            Node node = children.get(ips.get(depth));
            node.add(ips);
        } else {
            // new one
            Node node = new Node(this, ips.get(depth), depth+1);
            children.put(ips.get(depth), node);
            node.add(ips);
        }
    }

    public boolean contains(List<Integer> ips) {
        if (ips.size() <= depth) {
            return true;
        }

        Node node = children.get(ips.get(depth));
        if (node != null) {
            return node.contains(ips);
        }

        node = children.get(STAR_VALUE);
        if (node != null) {
            return node.contains(ips);
        }

        return false;
    }

    public Node get(int key) {
        return children.get(key);
    }

    public void printAll() {
        if (depth == 4) {
            StringBuffer buffer = new StringBuffer();
            Node node = this;
            for (int i=0; i<4; i++) {
                if (node.get() == STAR_VALUE) {
                    buffer.insert(0, "*.");
                } else {
                    buffer.insert(0, node.get() + ".");
                }
            }
            System.out.println(buffer.toString());
            return;
        }

        Iterator iterator = children.entrySet().iterator();
        while(iterator.hasNext()) {
            Map.Entry<String, Node> entry = (Map.Entry<String, Node>)iterator.next();
            entry.getValue().printAll();
        }
    }

    public int get() {
        return value;
    }
}
