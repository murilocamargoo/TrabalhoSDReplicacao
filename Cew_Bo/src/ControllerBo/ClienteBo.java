/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ControllerBo;

import ClassesBeans.Cliente;
import Model.DAO.ClienteDao;
import Model.DaoFactory.DaoFactory;

/**
 *
 * @author Murilo
 */

public class ClienteBo {

    ClienteDao ClienteDAO;

    public ClienteBo(DaoFactory Factory) {
        ClienteDAO = Factory.getClienteDao();
    }

    public ClienteBo() {
    }
    
    public void cadastrarCliente(String Nome, String Endereco){
        Cliente cliente = new Cliente();
        cliente.setNome(Nome);
        cliente.setEndereco(Endereco);
        ClienteDAO.salvar(cliente);
    }
    
}
