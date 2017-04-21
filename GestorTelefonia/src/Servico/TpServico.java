/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servico;

/**
 *
 * @author fernando.reis
 */
public class TpServico {
    private String razaoSocial;
    private String cnpj;
    private String inscrEstadual;
    private Integer codContrato;
    private Integer natureza;

    public TpServico(String razaoSocial, String cnpj, String inscrEstadual, Integer codContrato, Integer natureza) {
        this.razaoSocial = razaoSocial;
        this.cnpj = cnpj;
        this.inscrEstadual = inscrEstadual;
        this.codContrato = codContrato;
        this.natureza = natureza;
    }

    /*** Métodos Set
     * @param razaoSocial 
     **/    
    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    /*** Métodos Set
     * @param cnpj 
     **/
    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    /*** Métodos Set
     * @param inscrEstadual 
     **/
    public void setInscrEstadual(String inscrEstadual) {
        this.inscrEstadual = inscrEstadual;
    }

    /*** Métodos Set
     * @param codContrato 
     **/
    public void setCodContrato(Integer codContrato) {
        this.codContrato = codContrato;
    }

    /*** Métodos Set
     * @param natureza 
     **/
    public void setNatureza(Integer natureza) {
        this.natureza = natureza;
    }

    /*** Get
     * @return razaoSocial  
     **/    
    public String getRazaoSocial() {
        return razaoSocial;
    }

    /*** Get
     * @return cnj  
     **/
    public String getCnpj() {
        return cnpj;
    }

    /*** Get
     * @return inscrEstadual
     **/
    public String getInscrEstadual() {
        return inscrEstadual;
    }

    /*** Get
     * @return codContrato  
     **/
    public Integer getCodContrato() {
        return codContrato;
    }

    /*** Get
     * @return natureza  
     **/
    public Integer getNatureza() {
        return natureza;
    }
    
    
}
