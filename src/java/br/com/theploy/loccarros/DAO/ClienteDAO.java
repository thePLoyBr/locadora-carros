/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.theploy.loccarros.DAO;

import br.com.theploy.loccarros.entidade.Cliente;
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
public class ClienteDAO {
    public void salvar(Cliente cliente){
        try {
            Connection conexao = FabricaConexao.getConexao();
            PreparedStatement ps = conexao.prepareStatement("INSERT INTO `clientes` (`nome`,`idade`) VALUES (?,?)");
            ps.setString(1, cliente.getNome());
            ps.setInt(2, cliente.getIdade());
            ps.execute();
            FabricaConexao.fecharConexao();
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
