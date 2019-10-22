/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.theploy.loccarros.bean;

import br.com.theploy.loccarros.DAO.CarroDAO;
import br.com.theploy.loccarros.entidade.Carro;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author felipe
 */
@ManagedBean
@SessionScoped 
public class CarroBean {
    private Carro carro = new Carro();

    public void adicionar(){
        new CarroDAO().salvar(carro);
    }
    
    public Carro getCarro() {
        return carro;
    }

    public void setCarro(Carro carro) {
        this.carro = carro;
    }
    
    
    
    
}
