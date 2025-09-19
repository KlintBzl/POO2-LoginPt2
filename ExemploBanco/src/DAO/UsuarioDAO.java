
package DAO;

import DTO.UsuarioDTO;
import VIEW.Login;
import VIEW.TelaPrincipal;
import java.sql.*;
import javax.swing.JOptionPane;

public class UsuarioDAO {
    
    Connection conexao = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    
    public void logar(UsuarioDTO objUsuarioDTO){
        String sql = "Select * from  tb_usuarios where login = ? and senha = ?";
        conexao = ConexaoDAO.conector();
        
        try{
            pst = conexao.prepareStatement(sql);
            pst.setString(1, objUsuarioDTO.getLogin());
            pst.setString(2, objUsuarioDTO.getSenha());
            
            rs = pst.executeQuery();
            
            if(rs.next()){
                TelaPrincipal principal = new TelaPrincipal();
                principal.setVisible(true);
                
                
            }else {
                
                JOptionPane.showMessageDialog(null, "Usuário e/ou senha invalidos");
            }

        } catch(Exception e){
            JOptionPane.showMessageDialog(null, "** tela Login ***" + e);
        }
    }
    
    public void InserirUsuario(UsuarioDTO objUsuarioDTO){
        String sql = "insert into tb_usuarios (id_usuario, usuario, login, senha, perfil)"
                 + " values (?, ?, ?, ?, ?)";
        conexao = new ConexaoDAO().conector();
        
        try{
            pst = conexao.prepareStatement(sql);
            pst.setInt(1, objUsuarioDTO.getID());
            pst.setString(2, objUsuarioDTO.getNome());
            pst.setString(3, objUsuarioDTO.getLogin());
            pst.setString(4, objUsuarioDTO.getSenha());
            pst.setString(5, objUsuarioDTO.getPerfil());
            
            pst.execute();
            pst.close();
        } catch(Exception e){
            JOptionPane.showMessageDialog(null, "UsuárioDAO "+ e);
        }
    }
}
