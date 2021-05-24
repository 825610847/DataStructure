package com.darknessvenom.data_structure;

/**
 * <p>
 * Title:
 * </p>
 * <p>
 * Module:
 * </p>
 *
 * @author: DarknessVenom@gmail.com
 * @date: 4/14/21
 */
public class BinaryTreeNode<T> {

    public T node;

    public BinaryTreeNode<T> leftChildNode;

    public BinaryTreeNode<T> rightChildNode;

    public BinaryTreeNode(T node) {
        this.node = node;
    }
}
