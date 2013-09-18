/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.DaoImpl.Hibernate;

import ClassesBeans.Venda;
import Util.GerenciadorHibernate;
import Model.DAO.VendaDao;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Murilo
 */
public class HibernateVendaDaoImpl implements VendaDao {

    @Override
    public void salvar(Venda dto) {
        try {
            Session Gerenciador = GerenciadorHibernate.getSessionFactory().openSession();
            Gerenciador.beginTransaction();
            Gerenciador.save(dto);
            Gerenciador.getTransaction().commit();
            Gerenciador.clear();
            Gerenciador.close();
        } catch (HibernateException ex) {
            System.err.println("Exceção BD salvar Venda.");
        }
    }

    @Override
    public void deletar(Venda dto) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void atualizar(Venda dto) {
        try {
            Session Gerenciador = GerenciadorHibernate.getSessionFactory().openSession();
            Gerenciador.beginTransaction();
            Gerenciador.update(dto);
            Gerenciador.getTransaction().commit();
            Gerenciador.clear();
            Gerenciador.close();
        } catch (HibernateException ex) {
            System.err.println("Exceção BD atualizar Venda.");
        }
    }

    @Override
    public List listar() {
        List objects = null;
        try {
            Session Gerenciador = GerenciadorHibernate.getSessionFactory().openSession();
            Gerenciador.beginTransaction();
            Query query = Gerenciador.createQuery("from " + Venda.class.getName());
            objects = query.list();
            Gerenciador.getTransaction().commit();
        } catch (HibernateException ex) {
            System.err.println("Exceção BD Listar Venda.");
        }
        return objects;
    }
}
