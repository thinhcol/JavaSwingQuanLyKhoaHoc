/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edusys.Dao;

import java.util.List;

/**
 *
 * @author Admin
 */
abstract public class EduSys_DAO<EntityType,KeyValue>  {
    abstract public void insert(EntityType entity);
    abstract public void update(EntityType entity);
    abstract public void delete(KeyValue id);
    abstract public EntityType findById(KeyValue id);
    abstract public List<EntityType> select();
    abstract protected List<EntityType> SelectBySQL(String sql , Object...args);
}
