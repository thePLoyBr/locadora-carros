/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.theploy.loccarros.bean;

import br.com.theploy.loccarros.DAO.ClienteDAO;
import br.com.theploy.loccarros.entidade.Cliente;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author felipe
 */
@ManagedBean
@SessionScoped
public class ClienteBean {
    private Cliente cliente = new Cliente();

    public void adicionar(){
        new ClienteDAO().salvar(cliente);
    }
    
    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    
    
}
