/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package MyExceptions;

/**
 *
 * @author Murilo
 */
public class ExceptionProdutoInvalido extends Exception{
    String CodigoErrado;

    public ExceptionProdutoInvalido(String CodigoErrado) {
        this.CodigoErrado = CodigoErrado;
    }

    public String getCodigoErrado() {
        return CodigoErrado;
    }

    public void setCodigoErrado(String CodigoErrado) {
        this.CodigoErrado = CodigoErrado;
    }
    
}
