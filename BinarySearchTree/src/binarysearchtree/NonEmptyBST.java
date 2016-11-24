/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package binarysearchtree;

/**
 *
 * @author davidreyespucheta
 */
class NonEmptyBST<D extends Comparable> implements Tree<D> {
    D data;
    Tree<D> left;
    Tree<D> right;
    
    public NonEmptyBST(D el){
        data = el;
        left = new EmptyBST<>();
        right = new EmptyBST<>();
    }
    
     public NonEmptyBST(D el, Tree<D> leftTree, Tree<D> rightTree){
        data = el;
        left = leftTree;
        right = rightTree;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public int cardinality() {
       return  1 + left.cardinality() + right.cardinality();
    }

    @Override
    public boolean member(D el) {
        if (data == el){
            return true;
        } else {
            if (el.compareTo(data) < 0){
                return left.member(el);
            } else {
                return right.member(el);
            }
        }
    }

    @Override
    public binarysearchtree.NonEmptyBST<D> add(D el) {
        if(data == el){
            return this;
        } else{
            if(el.compareTo(data) < 0 ){
                return new NonEmptyBST(data, left.add(el), right);
            } else {
                return new NonEmptyBST(data, left, right.add(el));
            }            
        }
    }
}
