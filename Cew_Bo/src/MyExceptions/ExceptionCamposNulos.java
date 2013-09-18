/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package MyExceptions;

/**
 *
 * @author Murilo
 */
public class ExceptionCamposNulos extends Exception{
    String Campo;
    
    public ExceptionCamposNulos(String Campo){
        this.Campo = Campo;
    }

    public String getCampo() {
        return Campo;
    }

    public void setCampo(String Campo) {
        this.Campo = Campo;
    }
    
}
