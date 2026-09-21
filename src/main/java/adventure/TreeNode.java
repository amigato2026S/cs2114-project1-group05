package adventure;

import java.util.ArrayList;
import java.util.List;

/**
 * A general tree data structure with nodes and an arbitrary number of child
 * nodes, tailored to hold chapter
 * 
 * @author Ami Sato (amigato)
 * @version 2026.09.17
 */
public class TreeNode<T>
{

    private T data;
    private List<TreeNode<T>> children;
    private TreeNode<T> parent;
    private int variant;

    /**
     * Constructor for TreeNode
     * 
     * @param input
     *            Data that the node will hold
     * @param v
     *            Variant number of chapter
     */

    public TreeNode(T input, int v)
    {
        data = input;
        children = new ArrayList<>();
        parent = null;
        variant = v;
    }


    // ----------------------------------------------------------
    /**
     * Returns data of node
     * 
     * @return data
     */

    public T getData()
    {
        return data;
    }


    // ----------------------------------------------------------
    /**
     * Replaces data of node with new data
     * 
     * @param input
     */

    public void setData(T input)
    {
        this.data = input;
    }


    // ----------------------------------------------------------
    /**
     * Returns children of parent node
     * 
     * @return children
     */
    public List<TreeNode<T>> getChildren()
    {
        return children;
    }


    // ----------------------------------------------------------
    /**
     * Adds a child node to the parent node and sets the child's parent
     * accordingly
     * 
     * @param child
     */
    public void addChild(TreeNode<T> child)
    {
        child.parent = this;
        children.add(child);
    }


    // ----------------------------------------------------------
    /**
     * Returns parent node of child
     * 
     * @return parent
     */
    public TreeNode<T> getParent()
    {
        return parent;
    }


    // ----------------------------------------------------------
    /**
     * Returns variant of node
     * 
     * @return variant
     */
    public int getVariant()
    {
        return variant;
    }


    // ----------------------------------------------------------
    /**
     * Determines whether node is the root of the tree by checking that it has
     * no parent
     * 
     * @return true if node has no parent; false otherwise
     */
    public boolean isRoot()
    {
        if (parent == null)
        {
            return true;
        }
        return false;
    }


    // ----------------------------------------------------------
    /**
     * Determines whether node is a leaf by checking that it has no children
     * 
     * @return true if node has no children; false otherwise
     */
    public boolean isLeaf()
    {
        return children.isEmpty();
    }

}
