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
public class EmptyBST<D extends Comparable> implements Tree<D>{
    
    public EmptyBST(){
    }

    @Override
    public boolean isEmpty() {
        return true;
    }

    @Override
    public int cardinality() {
        return 0;
    }

    @Override
    public boolean member(D el) {
        return false;
    }

    @Override
    public NonEmptyBST<D> add(D el) {
        return new NonEmptyBST<D>(el);
    }
    
    
    
}
