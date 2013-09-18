/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.DaoImpl.Hibernate;

import ClassesBeans.Cliente;
import Util.GerenciadorHibernate;
import Model.DAO.ClienteDao;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Murilo
 */
public class HibernateClienteDaoImpl implements ClienteDao {

    @Override
    public void salvar(Cliente dto) {
        try {
            Session Gerenciador = GerenciadorHibernate.getSessionFactory().openSession();
            Gerenciador.beginTransaction();
            Gerenciador.save(dto);
            Gerenciador.getTransaction().commit();
            Gerenciador.clear();
            Gerenciador.close();
        } catch (HibernateException ex) {
            System.err.println("Exceção BD salvar cliente.");
        }
    }

    @Override
    public void deletar(Cliente dto) {
        try {
            Session Gerenciador = GerenciadorHibernate.getSessionFactory().openSession();
            Gerenciador.beginTransaction();
            Gerenciador.delete(dto);
            Gerenciador.getTransaction().commit();
            Gerenciador.clear();
            Gerenciador.close();
        } catch (HibernateException ex) {
            System.err.println("Exceção BD deletar cliente.");
        }
    }

    @Override
    public void atualizar(Cliente dto) {
        try {
            Session Gerenciador = GerenciadorHibernate.getSessionFactory().openSession();
            Gerenciador.beginTransaction();
            Gerenciador.update(dto);
            Gerenciador.getTransaction().commit();
            Gerenciador.clear();
            Gerenciador.close();
        } catch (HibernateException ex) {
            System.err.println("Exceção BD atualizar cliente.");
        }
    }

    @Override
    public List listar() {
        List objects = null;
        try {
            Session Gerenciador = GerenciadorHibernate.getSessionFactory().openSession();
            Gerenciador.beginTransaction();
            Query query = Gerenciador.createQuery("from " + Cliente.class.getName());
            objects = query.list();
            Gerenciador.getTransaction().commit();
        } catch (HibernateException ex) {
            System.err.println("Exceção BD Listar cliente.");
        }
        return objects;
    }
}
