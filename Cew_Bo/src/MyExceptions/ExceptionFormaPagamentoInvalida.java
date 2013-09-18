/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package MyExceptions;

/**
 *
 * @author Murilo
 */
public class ExceptionFormaPagamentoInvalida extends Exception {

    private String nomeFormaPagamento;

    public ExceptionFormaPagamentoInvalida(String string) {
        this.nomeFormaPagamento = string;
    }

    public String getNomeFormaPagamento() {
        return nomeFormaPagamento;
    }

    public void setNomeFormaPagamento(String nomeFormaPagamento) {
        this.nomeFormaPagamento = nomeFormaPagamento;
    }
}
