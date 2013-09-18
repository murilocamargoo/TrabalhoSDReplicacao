/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.DAO;

import ClassesBeans.Cliente;
import java.util.List;

/**
 *
 * @author Murilo
 */
public interface ClienteDao {

    public void salvar(Cliente dto);

    public void deletar(Cliente dto);

    public void atualizar(Cliente dto);

    public List listar();
}
