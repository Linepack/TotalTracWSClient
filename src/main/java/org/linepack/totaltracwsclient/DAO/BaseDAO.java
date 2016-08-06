/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.linepack.totaltracwsclient.DAO;

import java.io.IOException;
import java.util.Arrays;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import org.linepack.totaltracwsclient.util.EntityManagerUtil;
import org.linepack.totaltracwsclient.util.Log;

/**
 *
 * @author Leandro
 * @param <T>
 */
public class BaseDAO<T> {

    protected EntityManager entityManager;

    public BaseDAO() {
        this.entityManager = new EntityManagerUtil().getEntityManager();
    }

    public String insert(T object) throws IOException {
        try {
            if (object != null) {
                entityManager.persist(object);
                entityManager.getTransaction().commit();
                entityManager.close();
                return null;
            }
            String erro = "Erro ao inserir, objeto Nulo!";
            Log.write(erro);
            return erro;
        } catch (Exception e) {
            String erro = "Erro ao tentar inserir: " + e.toString();
            Log.write(erro);
            return erro;
        }
    }

    public T getByNamedQuery(String namedQueryName) throws IOException {
        try {
            Query query = entityManager.createNamedQuery(namedQueryName);
            Object object = new Object();
            object = query.getSingleResult();
            return (T) object;            
        } catch (Exception e) {
            Log.write("Erro buscando NamedQuery: " + namedQueryName + ". Erro:" + Arrays.toString(e.getStackTrace()));
        }
        return null;
    }

}
