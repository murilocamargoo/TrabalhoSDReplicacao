/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.DaoFactory;

import Model.DAO.ClienteDao;
import Model.DAO.FormaPagamentoDao;
import Model.DAO.ItemVendaDao;
import Model.DAO.ProdutoDao;
import Model.DAO.VendaDao;
import Model.DaoImpl.Hibernate.HibernateClienteDaoImpl;
import Model.DaoImpl.Hibernate.HibernateFormaPagamentoDaoImpl;
import Model.DaoImpl.Hibernate.HibernateItemVendaDaoImpl;
import Model.DaoImpl.Hibernate.HibernateProdutoDaoImpl;
import Model.DaoImpl.Hibernate.HibernateVendaDaoImpl;

/**
 *
 * @author Murilo
 */
public class DaoFactoryHibernate extends DaoFactory{

    @Override
    public ClienteDao getClienteDao() {
        return new HibernateClienteDaoImpl();
    }

    @Override
    public FormaPagamentoDao getFormaPagamentoDao() {
        return new HibernateFormaPagamentoDaoImpl();
    }

    @Override
    public ItemVendaDao getItemVendaDao() {
        return new HibernateItemVendaDaoImpl();
    }

    @Override
    public ProdutoDao getProdutoDao() {
        return new HibernateProdutoDaoImpl();
    }

    @Override
    public VendaDao getVendaDao() {
        return new HibernateVendaDaoImpl();
    }
    
}
