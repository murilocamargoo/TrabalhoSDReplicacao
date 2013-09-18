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

/**
 *
 * @author Murilo
 */
public abstract class DaoFactory {

    public abstract ClienteDao getClienteDao();

    public abstract FormaPagamentoDao getFormaPagamentoDao();

    public abstract ItemVendaDao getItemVendaDao();

    public abstract ProdutoDao getProdutoDao();

    public abstract VendaDao getVendaDao();
}
