/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ControllerBo;

import Model.DAO.FormaPagamentoDao;
import Model.DaoFactory.DaoFactory;

/**
 *
 * @author Murilo
 */
public class FormaPagamentoBo {

    FormaPagamentoDao FormaPgtDao;

    public FormaPagamentoBo(DaoFactory Factory) {
        FormaPgtDao = Factory.getFormaPagamentoDao();
    }
}
