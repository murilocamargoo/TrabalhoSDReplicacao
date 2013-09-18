/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ControllerBo;

import ClassesBeans.Cliente;
import ClassesBeans.FormaPagamento;
import ClassesBeans.ItemVenda;
import ClassesBeans.Produto;
import ClassesBeans.Venda;
import Model.DAO.ClienteDao;
import Model.DAO.FormaPagamentoDao;
import Model.DAO.ItemVendaDao;
import Model.DAO.ProdutoDao;
import Model.DAO.VendaDao;
import Model.DaoFactory.DaoFactoryHibernate;
import MyExceptions.ExceptionCamposNulos;
import MyExceptions.ExceptionEstoqueInsuficiente;
import MyExceptions.ExceptionFormaPagamentoInvalida;
import MyExceptions.ExceptionProdutoInvalido;
import java.util.List;

/**
 *
 * @author Murilo
 */
public class VendaBo {

    VendaDao VendaDAO;
    ProdutoDao ProdutoDAO;
    ClienteDao ClienteDAO;
    FormaPagamentoDao FormaPagamentoDAO;
    ItemVendaDao ItemVendaDAO;

    public VendaBo() {
        DaoFactoryHibernate f = new DaoFactoryHibernate();
        VendaDAO = f.getVendaDao();
        ProdutoDAO = f.getProdutoDao();
        ClienteDAO = f.getClienteDao();
        FormaPagamentoDAO = f.getFormaPagamentoDao();
        ItemVendaDAO = f.getItemVendaDao();
    }

    public void concretizarVenda(String CodigoProduto, String NomeCliente, String sFormaPagamento,
            String NumeroCartao, String Quantidade, String Endereco) throws Exception {
        if (CodigoProduto == null || CodigoProduto.isEmpty()){
            throw new ExceptionProdutoInvalido(CodigoProduto);
        }
        Produto produto = ProdutoDAO.buscarProduto(Integer.valueOf(CodigoProduto));
        if (produto == null) {
            throw new ExceptionProdutoInvalido("Produto Inválido.");
        }
        
        if (NomeCliente == null || NomeCliente.isEmpty()){
            throw new ExceptionCamposNulos("Nome do Cliente");
        }
        
        if (sFormaPagamento == null){
            throw new ExceptionCamposNulos("Forma de Pagamento");
        }
        
        if (NumeroCartao == null || NumeroCartao.isEmpty()){
            throw new ExceptionCamposNulos("Numero do Cartao");
        }
        if (Quantidade == null || Quantidade.isEmpty()){
            throw new ExceptionCamposNulos("Quantidade");
        }
        
        if (Endereco == null || Endereco.isEmpty()){
            throw new ExceptionCamposNulos("Endereco");
        }
        try{
            if (Integer.valueOf(Quantidade) > produto.getEstoque()){
                throw new ExceptionEstoqueInsuficiente(Integer.valueOf(Quantidade));
            }
        }catch(Exception ex){
            throw new ExceptionCamposNulos("Quantidade precisa ser números");
        }
        
        
        Cliente cliente = new Cliente();
        cliente.setNome(NomeCliente);
        cliente.setEndereco(Endereco);
        ClienteDAO.salvar(cliente);

        FormaPagamento fp = FormaPagamentoDAO.buscarFormaPagamentoNome(sFormaPagamento);
        if(fp == null){
            throw new ExceptionFormaPagamentoInvalida(sFormaPagamento);
        }

        Venda venda = new Venda();
        venda.setCliente(cliente);
        venda.setFormaPagamento(fp);
        venda.setNumeroCartao(Integer.valueOf(NumeroCartao));
        VendaDAO.salvar(venda);

        ItemVenda iv = new ItemVenda();
        iv.setProduto(produto);
        iv.setQuantidade(Integer.valueOf(Quantidade));
        iv.setVenda(venda);
        ItemVendaDAO.salvar(iv);

        //atualiza valor da venda
        venda.setValorVenda((Integer.valueOf(Quantidade) * produto.getPrecoUnitario().intValue()));
        VendaDAO.atualizar(venda);

        //atualiza op estoque do produto
        produto.setEstoque(produto.getEstoque() - Integer.valueOf(Quantidade));
        ProdutoDAO.atualizar(produto);
    }
    
    public List listarVendas(){
        return VendaDAO.listar();
    }
}
