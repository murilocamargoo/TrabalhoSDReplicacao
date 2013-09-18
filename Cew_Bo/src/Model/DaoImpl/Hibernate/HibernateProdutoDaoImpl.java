/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.DaoImpl.Hibernate;

import ClassesBeans.Produto;
import Util.GerenciadorHibernate;
import Model.DAO.ProdutoDao;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Murilo
 */
public class HibernateProdutoDaoImpl implements ProdutoDao {

    @Override
    public void salvar(Produto dto) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void deletar(Produto dto) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void atualizar(Produto dto) {
        try {
            Session Gerenciador = GerenciadorHibernate.getSessionFactory().openSession();
            Gerenciador.beginTransaction();
            Gerenciador.update(dto);
            Gerenciador.getTransaction().commit();
            Gerenciador.clear();
            Gerenciador.close();
        } catch (HibernateException ex) {
            System.err.println("Exceção BD atualizar Produto.");
        }
    }

    @Override
    public List listar() {
        List objects = null;
        try {
            Session Gerenciador = GerenciadorHibernate.getSessionFactory().openSession();
            Gerenciador.beginTransaction();
            Query query = Gerenciador.createQuery("from " + Produto.class.getName());
            objects = query.list();
            Gerenciador.getTransaction().commit();
        } catch (HibernateException ex) {
            System.err.println("Exceção BD Listar Produto.");
        }
        return objects;
    }

    @Override
    public Produto buscarProduto(int Codigo) {
        Produto produto = new Produto();
        try {
            Session Gerenciador = GerenciadorHibernate.getSessionFactory().openSession();
            Gerenciador.beginTransaction();
            produto = (Produto) Gerenciador.get(Produto.class, Codigo);
            Gerenciador.clear();
            Gerenciador.close();
        } catch (HibernateException ex) {
            System.err.println("Exceção BD Buscar Produto.");
        }
        return produto;
    }
}
