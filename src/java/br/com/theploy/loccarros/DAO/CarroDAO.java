package br.com.theploy.loccarros.DAO;

import br.com.theploy.loccarros.entidade.Carro;
import br.com.theploy.loccarros.util.FabricaConexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CarroDAO {

    public void salvar(Carro carro) {
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

    public List<Carro> buscar() {
        try {
            Connection conexao = FabricaConexao.getConexao();
            PreparedStatement ps = conexao.prepareStatement("SELECT * FROM `carros`");
            ResultSet rs = ps.executeQuery();
            List<Carro> carros = new ArrayList<Carro>();

            while (rs.next()) {
                Carro carro = new Carro();
                carro.setId(rs.getInt("id"));
                carro.setModelo(rs.getString("modelo"));
                carro.setMarca(rs.getString("marca"));
                carro.setCor(rs.getString("cor"));

                carros.add(carro);

            }
            return carros;

        } catch (SQLException ex) {
            Logger.getLogger(CarroDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }

    }
}
