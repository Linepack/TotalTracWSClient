/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.linepack.DAO;

import java.io.IOException;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import org.linepack.util.EntityManagerUtil;
import org.linepack.util.Log;

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
            return (T) query.getSingleResult();
        } catch (Exception e) {
            Log.write("Erro buscando NamedQuery: " + namedQueryName + ". Erro:" + e.toString());
        }
        return null;
    }

}
