package com.darknessvenom.data_structure.impl;

import com.darknessvenom.data_structure.SinglyLinkedListNode;
import com.darknessvenom.data_structure.interfaces.Tree;

import java.util.Iterator;

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
public class SinglyLinkedListBinaryTree<T> implements Tree<T> {

    private T[] array;

    private SinglyLinkedListNode<T> root;

    private SinglyLinkedListNode<T> leftChild;

    private SinglyLinkedListNode<T> rightChild;

    private int size;

    @Override
    public T getElement() {
        return null;
    }

    @Override
    public T setElement(T t) {
        return null;
    }

    @Override
    public T getParent() {
        return null;
    }

    @Override
    public T getFirstChild() {
        return null;
    }

    @Override
    public T getNextSibling() {
        return null;
    }

    @Override
    public int getSize() {
        return 0;
    }

    @Override
    public int getHeight() {
        return 0;
    }

    @Override
    public int getDepth() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return root == null ? true : false;
    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }
}
