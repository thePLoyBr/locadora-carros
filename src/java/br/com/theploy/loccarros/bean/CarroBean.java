/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.theploy.loccarros.bean;

import br.com.theploy.loccarros.DAO.CarroDAO;
import br.com.theploy.loccarros.entidade.Carro;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author felipe
 */
@ManagedBean(name="controllerCarro")
@SessionScoped
public class CarroBean implements Serializable{
    private Carro carro = new Carro();
    private CarroDAO  carroDAO = new CarroDAO();
    private List<Carro> carros = new ArrayList<>();

    public void adicionar(){
        carroDAO.salvar(carro);
        carros = carroDAO.buscar();
        carro = new Carro();
    }
    
    public void listar(){
        carros = carroDAO.buscar(); 
    }
    
    public Carro getCarro() {
        return carro;
    }

    public void setCarro(Carro carro) {
        this.carro = carro;
    }

    public CarroDAO getCarroDAO() {
        return carroDAO;
    }

    public void setCarroDAO(CarroDAO carroDAO) {
        this.carroDAO = carroDAO;
    }

    public List<Carro> getCarros() {
        return carros;
    }

    public void setCarros(List<Carro> carros) {
        this.carros = carros;
    }
    
    
    
    
}
