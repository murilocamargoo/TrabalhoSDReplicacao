/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ControllerBo;

import ClassesBeans.Produto;
import Model.DAO.ProdutoDao;
import Model.DaoFactory.DaoFactory;
import Model.DaoFactory.DaoFactoryHibernate;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Murilo
 */
public class ProdutoBo {

    ProdutoDao ProdutoDAO;

    public ProdutoBo() {
        DaoFactoryHibernate f = new DaoFactoryHibernate();
        ProdutoDAO = f.getProdutoDao();
    }

    public List listarProdutos() {
        ArrayList teste = (ArrayList) ProdutoDAO.listar();
        return ProdutoDAO.listar();
    }

    public void cadastrarProduto(String Descricao, String Unidade, BigDecimal PrecoUn, int QntdEstoque) {
        Produto produto = new Produto();
        produto.setDescricao(Descricao);
        produto.setEstoque(QntdEstoque);
        produto.setPrecoUnitario(PrecoUn);
        produto.setUnidade(Unidade);
        ProdutoDAO.salvar(produto);
    }
}
