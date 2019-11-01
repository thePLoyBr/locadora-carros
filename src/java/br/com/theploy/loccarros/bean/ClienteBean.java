/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.theploy.loccarros.bean;

import br.com.theploy.loccarros.DAO.ClienteDAO;
import br.com.theploy.loccarros.entidade.Carro;
import br.com.theploy.loccarros.entidade.Cliente;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author felipe
 */
@ManagedBean(name="controllerCliente")
@SessionScoped
public class ClienteBean implements Serializable{
    private Cliente cliente = new Cliente();
    ClienteDAO clienteDAO = new ClienteDAO();
    private List<Cliente> clientes = new ArrayList<>();

    public void adicionar(){
        clienteDAO.salvar(cliente);
        clientes = clienteDAO.buscar();
        cliente = new Cliente();
        
    }
    
    public void listar(){
        clientes = clienteDAO.buscar(); 
    }
    
    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(List<Cliente> clientes) {
        this.clientes = clientes;
    }
    
    
}
