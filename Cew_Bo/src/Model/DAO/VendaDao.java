/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.DAO;

import ClassesBeans.Venda;
import java.util.List;

/**
 *
 * @author Murilo
 */
public interface VendaDao {

    public void salvar(Venda dto);

    public void deletar(Venda dto);

    public void atualizar(Venda dto);

    public List listar();
}
