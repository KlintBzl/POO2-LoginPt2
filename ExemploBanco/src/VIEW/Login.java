
package VIEW;

import DAO.ConexaoDAO;
import DAO.UsuarioDAO;
import DTO.UsuarioDTO;
import java.awt.*;
import java.sql.*;
import javax.swing.*;

public class Login extends javax.swing.JFrame {

    Connection conexao = null;
    
    public Login() {
         
        initComponents();
        conexao = ConexaoDAO.conector();
        System.out.println(conexao);
        if(conexao == null){
                ImageIcon iconeverde = new ImageIcon(getClass().getResource("/Imagens/errado.png"));
                Image img = iconeverde.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
                lblImagem.setIcon(new ImageIcon(img));
                
            }else{
                ImageIcon iconevermelho = new ImageIcon(getClass().getResource("/Imagens/certo.png"));
                Image img = iconevermelho.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
                lblImagem.setIcon(new ImageIcon(img));
            }
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txtLogin = new javax.swing.JTextField();
        txtSenha = new javax.swing.JPasswordField();
        jLabel3 = new javax.swing.JLabel();
        btnLogin = new javax.swing.JButton();
        lblImagem = new javax.swing.JLabel();
        lblcadastrar = new javax.swing.JLabel();

        jLabel2.setText("jLabel2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Tela Login");
        setResizable(false);

        jLabel1.setText("Usuário:");

        jLabel3.setText("Senha:");

        btnLogin.setText("Login");
        btnLogin.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnLogin.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });

        lblImagem.setMaximumSize(new java.awt.Dimension(50, 50));
        lblImagem.setMinimumSize(new java.awt.Dimension(50, 50));

        lblcadastrar.setText("Cadastre-se...");
        lblcadastrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblcadastrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblcadastrarMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel3))
                        .addGap(54, 54, 54)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblImagem, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(75, 75, 75)
                                .addComponent(btnLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(165, 165, 165)
                                .addComponent(lblcadastrar)))))
                .addContainerGap(37, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnLogin)
                        .addGap(18, 18, 18)
                        .addComponent(lblcadastrar))
                    .addComponent(lblImagem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(68, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginActionPerformed

//        TelaPrincipal rincipal = new TelaPrincipal();;;
//        rincipal.setVisible(true);
        String login = txtLogin.getText();
        String senha = new String(txtSenha.getPassword());
        UsuarioDTO objUsuarioDTO = new UsuarioDTO();
        objUsuarioDTO.setLogin(login);
        objUsuarioDTO.setSenha(senha);
        
        UsuarioDAO objUsuarioDAO = new UsuarioDAO();
        
        objUsuarioDAO.logar(objUsuarioDTO);
       this.dispose();
    }//GEN-LAST:event_btnLoginActionPerformed

    private void lblcadastrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblcadastrarMouseClicked
        PrimeiroCadastro cadastro = new PrimeiroCadastro();
        cadastro.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_lblcadastrarMouseClicked

    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLogin;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel lblImagem;
    private javax.swing.JLabel lblcadastrar;
    private javax.swing.JTextField txtLogin;
    private javax.swing.JPasswordField txtSenha;
    // End of variables declaration//GEN-END:variables
}
