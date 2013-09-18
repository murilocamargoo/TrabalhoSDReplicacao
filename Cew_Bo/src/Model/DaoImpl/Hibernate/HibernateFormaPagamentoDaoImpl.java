/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.DaoImpl.Hibernate;

import ClassesBeans.FormaPagamento;
import Util.GerenciadorHibernate;
import Model.DAO.FormaPagamentoDao;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Murilo
 */
public class HibernateFormaPagamentoDaoImpl implements FormaPagamentoDao {

    @Override
    public void salvar(FormaPagamento dto) {
        try {
            Session Gerenciador = GerenciadorHibernate.getSessionFactory().openSession();
            Gerenciador.beginTransaction();
            Gerenciador.save(dto);
            Gerenciador.getTransaction().commit();
            Gerenciador.clear();
            Gerenciador.close();
        } catch (HibernateException ex) {
            System.err.println("Exceção BD salvar FormaPagamento.");
        }
    }

    @Override
    public void deletar(FormaPagamento dto) {
        try {
            Session Gerenciador = GerenciadorHibernate.getSessionFactory().openSession();
            Gerenciador.beginTransaction();
            Gerenciador.delete(dto);
            Gerenciador.getTransaction().commit();
            Gerenciador.clear();
            Gerenciador.close();
        } catch (HibernateException ex) {
            System.err.println("Exceção BD deletar FormaPagamento.");
        }
    }

    @Override
    public void atualizar(FormaPagamento dto) {
        try {
            Session Gerenciador = GerenciadorHibernate.getSessionFactory().openSession();
            Gerenciador.beginTransaction();
            Gerenciador.update(dto);
            Gerenciador.getTransaction().commit();
            Gerenciador.clear();
            Gerenciador.close();
        } catch (HibernateException ex) {
            System.err.println("Exceção BD atualizar FormaPagamento.");
        }
    }

    @Override
    public List listar() {
        List objects = null;
        try {
            Session Gerenciador = GerenciadorHibernate.getSessionFactory().openSession();
            Gerenciador.beginTransaction();
            Query query = Gerenciador.createQuery("from " + FormaPagamento.class.getName());
            objects = query.list();
            Gerenciador.getTransaction().commit();
        } catch (HibernateException ex) {
            System.err.println("Exceção BD Listar FormaPagamento.");
        }
        return objects;
    }

    @Override
    public FormaPagamento buscarFormaPagamentoNome(String sFormaPagamento) {
        FormaPagamento fp = new FormaPagamento();
        try{
            Session Gerenciador = GerenciadorHibernate.getSessionFactory().openSession();
            fp = (FormaPagamento) Gerenciador.createCriteria(FormaPagamento.class)
                    .add(Restrictions.eq("descricao", sFormaPagamento)).uniqueResult();
            Gerenciador.clear();
            Gerenciador.close();
        }catch(HibernateException ex){
            System.err.println("Exceção BD Buscar FormaPagamento.");
        }
        return fp;
    }
}
