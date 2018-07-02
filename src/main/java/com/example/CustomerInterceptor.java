package com.example;

import org.hibernate.CallbackException;
import org.hibernate.EmptyInterceptor;
import org.hibernate.EntityMode;
import org.hibernate.Transaction;
import org.hibernate.type.Type;

import java.io.Serializable;
import java.util.Iterator;

public class CustomerInterceptor extends EmptyInterceptor {
    private int cout = 0;

    @Override
    public void onDelete(
            Object entity,
            Serializable id,
            Object[] state,
            String[] propertyNames,
            Type[] types) {
        System.out.println("onDelete" + ++cout);

    }

    @Override
    public boolean onFlushDirty(
            Object entity,
            Serializable id,
            Object[] currentState,
            Object[] previousState,
            String[] propertyNames,
            Type[] types) {
        System.out.println("onFlushDirty" + ++cout);
        return false;
    }

    @Override
    public boolean onLoad(
            Object entity,
            Serializable id,
            Object[] state,
            String[] propertyNames,
            Type[] types) {
        boolean flag = false;
        int location = 0;
        for (Type type : types) {
            if ("string".equals(type.getName()) && state[location] != null & "".equals(state[location])) {
                state[location] = "_";
                flag = true;
            }
            location++;
        }
        System.out.println("onLoad" + ++cout);
        return flag;
    }

    @Override
    public boolean onSave(
            Object entity,
            Serializable id,
            Object[] state,
            String[] propertyNames,
            Type[] types) {
        boolean flag = false;
        int location = 0;
        for (Type type : types) {
            if ("string".equals(type.getName()) && state[location] != null & "".equals(state[location])) {
                state[location] = "_";
                flag = true;
            }
            location++;
        }
        return flag;
    }

    @Override
    public void postFlush(Iterator entities) {
        System.out.println("postFlush" + ++cout);
    }

    @Override
    public void preFlush(Iterator entities) {
        System.out.println("preFlush" + ++cout);
    }

    @Override
    public Boolean isTransient(Object entity) {
        System.out.println("isTransient" + ++cout);
        return null;
    }

    @Override
    public Object instantiate(String entityName, EntityMode entityMode, Serializable id) {
        System.out.println("instantiate" + ++cout);
        return null;
    }

    @Override
    public int[] findDirty(
            Object entity,
            Serializable id,
            Object[] currentState,
            Object[] previousState,
            String[] propertyNames,
            Type[] types) {
        System.out.println("findDirty" + ++cout);
        return null;
    }

    @Override
    public String getEntityName(Object object) {
        System.out.println("getEntityName" + ++cout);
        return null;
    }

    @Override
    public Object getEntity(String entityName, Serializable id) {
        System.out.println("getEntity" + ++cout);
        return null;
    }

    @Override
    public void afterTransactionBegin(Transaction tx) {
        System.out.println("afterTransactionBegin" + ++cout);
    }

    @Override
    public void afterTransactionCompletion(Transaction tx) {
        System.out.println("afterTransactionCompletion" + ++cout);
    }


    @Override
    public void beforeTransactionCompletion(Transaction tx) {
        System.out.println("beforeTransactionCompletion" + ++cout);
    }

    @Override
    public String onPrepareStatement(String sql) {
        System.out.println("onPrepareStatement" + ++cout);
        return sql;
    }

    @Override
    public void onCollectionRemove(Object collection, Serializable key) throws CallbackException {
        System.out.println(++cout);
    }

    @Override
    public void onCollectionRecreate(Object collection, Serializable key) throws CallbackException {
        System.out.println(++cout);
    }

    @Override
    public void onCollectionUpdate(Object collection, Serializable key) throws CallbackException {
        System.out.println(++cout);
    }
}
