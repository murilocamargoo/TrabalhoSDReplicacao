/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.DAO;

import ClassesBeans.Produto;
import java.util.List;

/**
 *
 * @author Murilo
 */
public interface ProdutoDao {

    public void salvar(Produto dto);

    public void deletar(Produto dto);

    public void atualizar(Produto dto);

    public List listar();
    
    public Produto buscarProduto(int Codigo);
}
