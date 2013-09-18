/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.DaoImpl.Hibernate;

import ClassesBeans.ItemVenda;
import Util.GerenciadorHibernate;
import Model.DAO.ItemVendaDao;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Murilo
 */
public class HibernateItemVendaDaoImpl implements ItemVendaDao {

    @Override
    public void salvar(ItemVenda dto) {
        try {
            Session Gerenciador = GerenciadorHibernate.getSessionFactory().openSession();
            Gerenciador.beginTransaction();
            Gerenciador.save(dto);
            Gerenciador.getTransaction().commit();
            Gerenciador.clear();
            Gerenciador.close();
        } catch (HibernateException ex) {
            System.err.println("Exceção BD salvar ItemVenda.");
        }
    }

    @Override
    public void deletar(ItemVenda dto) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void atualizar(ItemVenda dto) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List listar() {
        List objects = null;
        try {
            Session Gerenciador = GerenciadorHibernate.getSessionFactory().openSession();
            Gerenciador.beginTransaction();
            Query query = Gerenciador.createQuery("from " + ItemVenda.class.getName());
            objects = query.list();
            Gerenciador.getTransaction().commit();
        } catch (HibernateException ex) {
            System.err.println("Exceção BD Listar Item de Venda.");
        }
        return objects;
    }
}
