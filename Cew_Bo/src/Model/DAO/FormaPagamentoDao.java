/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.DAO;

import ClassesBeans.FormaPagamento;
import java.util.List;

/**
 *
 * @author Murilo
 */
public interface FormaPagamentoDao {

    public void salvar(FormaPagamento dto);

    public void deletar(FormaPagamento dto);

    public void atualizar(FormaPagamento dto);

    public List listar();
    
    public FormaPagamento buscarFormaPagamentoNome(String FormaPagamento);
}
