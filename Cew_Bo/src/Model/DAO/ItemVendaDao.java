/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.DAO;

import ClassesBeans.ItemVenda;
import java.util.List;

/**
 *
 * @author Murilo
 */
public interface ItemVendaDao {

    public void salvar(ItemVenda dto);

    public void deletar(ItemVenda dto);

    public void atualizar(ItemVenda dto);

    public List listar();
}
