/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.theploy.loccarros.DAO;

import br.com.theploy.loccarros.entidade.Carro;
import br.com.theploy.loccarros.util.FabricaConexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author felipe
 */
public class CarroDAO {
    
    public void salvar(Carro carro){
        try {
            Connection conexao = FabricaConexao.getConexao();
            PreparedStatement ps = conexao.prepareStatement("INSERT INTO `carros` (`modelo`,`marca`,`cor`,`km`) VALUES (?,?,?,?)");
            ps.setString(1, carro.getModelo());
            ps.setString(2, carro.getMarca());
            ps.setString(3, carro.getCor());
            ps.setDouble(4, carro.getKm());
            ps.execute();
            FabricaConexao.fecharConexao();
        } catch (SQLException ex) {
            Logger.getLogger(CarroDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
