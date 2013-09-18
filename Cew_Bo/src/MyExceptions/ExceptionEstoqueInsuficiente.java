/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package MyExceptions;

/**
 *
 * @author Murilo
 */
public class ExceptionEstoqueInsuficiente extends Exception{
    
    int QuantidadePedida;

    public ExceptionEstoqueInsuficiente(int Qntde) {
        this.QuantidadePedida = Qntde;
    }
    
}
