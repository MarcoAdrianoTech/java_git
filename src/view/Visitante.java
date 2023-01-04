/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import dao.VisitanteDao;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import model.Utilitarios;
import model.VisitanteModel;

/**
 *
 * @author mmgti
 */
public class Visitante extends javax.swing.JFrame {

    /**
     * Creates new form Visitante
     */
    public Visitante() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtmensalidade = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        ButtonEditar = new javax.swing.JButton();
        ButtonNovo = new javax.swing.JButton();
        ButtonSalvar = new javax.swing.JButton();
        PanelVisitante = new javax.swing.JPanel();
        LabelNome = new javax.swing.JLabel();
        txtnomevisitante = new javax.swing.JTextField();
        ButtonBuscar = new javax.swing.JButton();
        LabelCpf1 = new javax.swing.JLabel();
        txtvalorentrada = new javax.swing.JTextField();
        txtcpf = new javax.swing.JFormattedTextField();
        LabelCpf = new javax.swing.JLabel();
        LabelCpf2 = new javax.swing.JLabel();
        txtcodigo = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaVisitante = new javax.swing.JTable();

        txtmensalidade.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastro de Visitante");

        jPanel1.setBackground(new java.awt.Color(51, 0, 102));

        jLabel1.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Visitante ");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel1)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        jButton4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/excluir.png"))); // NOI18N
        jButton4.setText("Excluir");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        ButtonEditar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        ButtonEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/editar.png"))); // NOI18N
        ButtonEditar.setText("Editar");
        ButtonEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonEditarActionPerformed(evt);
            }
        });

        ButtonNovo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        ButtonNovo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/novo.png"))); // NOI18N
        ButtonNovo.setText("Novo");
        ButtonNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonNovoActionPerformed(evt);
            }
        });

        ButtonSalvar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        ButtonSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/salvar.png"))); // NOI18N
        ButtonSalvar.setText("Salvar");
        ButtonSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonSalvarActionPerformed(evt);
            }
        });
        ButtonSalvar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                ButtonSalvarKeyPressed(evt);
            }
        });

        LabelNome.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        LabelNome.setText("Nome");

        txtnomevisitante.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        ButtonBuscar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        ButtonBuscar.setText("Busca");
        ButtonBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonBuscarActionPerformed(evt);
            }
        });

        LabelCpf1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        LabelCpf1.setText("Valor da Entrada");

        txtvalorentrada.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        try {
            txtcpf.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtcpf.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtcpf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtcpfActionPerformed(evt);
            }
        });
        txtcpf.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtcpfKeyPressed(evt);
            }
        });

        LabelCpf.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        LabelCpf.setText("CPF");

        LabelCpf2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        LabelCpf2.setText("Codigo");

        txtcodigo.setEditable(false);
        txtcodigo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        tabelaVisitante.setBackground(new java.awt.Color(204, 255, 255));
        tabelaVisitante.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo", "CPF", "Valor ", "Nome"
            }
        ));
        tabelaVisitante.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaVisitanteMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabelaVisitante);

        javax.swing.GroupLayout PanelVisitanteLayout = new javax.swing.GroupLayout(PanelVisitante);
        PanelVisitante.setLayout(PanelVisitanteLayout);
        PanelVisitanteLayout.setHorizontalGroup(
            PanelVisitanteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelVisitanteLayout.createSequentialGroup()
                .addGroup(PanelVisitanteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(PanelVisitanteLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 631, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, PanelVisitanteLayout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(PanelVisitanteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(LabelCpf)
                            .addComponent(LabelNome))
                        .addGap(26, 26, 26)
                        .addGroup(PanelVisitanteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(PanelVisitanteLayout.createSequentialGroup()
                                .addComponent(txtnomevisitante, javax.swing.GroupLayout.PREFERRED_SIZE, 471, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(ButtonBuscar))
                            .addGroup(PanelVisitanteLayout.createSequentialGroup()
                                .addComponent(txtcpf, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(LabelCpf1)
                                .addGap(18, 18, 18)
                                .addComponent(txtvalorentrada, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(LabelCpf2, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtcodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        PanelVisitanteLayout.setVerticalGroup(
            PanelVisitanteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelVisitanteLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelVisitanteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LabelNome)
                    .addComponent(txtnomevisitante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ButtonBuscar))
                .addGap(18, 18, 18)
                .addGroup(PanelVisitanteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LabelCpf)
                    .addComponent(txtcpf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LabelCpf1)
                    .addComponent(txtvalorentrada, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LabelCpf2)
                    .addComponent(txtcodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(PanelVisitante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(158, 158, 158)
                        .addComponent(ButtonNovo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ButtonSalvar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ButtonEditar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton4)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(PanelVisitante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ButtonSalvar)
                    .addComponent(ButtonEditar)
                    .addComponent(jButton4)
                    .addComponent(ButtonNovo))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtcpfKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtcpfKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtcpfKeyPressed

    private void txtcpfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtcpfActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtcpfActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // Botao Excluir

        VisitanteModel obj = new VisitanteModel();

        obj.setId(Integer.parseInt(txtcodigo.getText()));
        VisitanteDao dao = new VisitanteDao();
        dao.excluirVisitante(obj);
        new Utilitarios().LimpaTela(PanelVisitante);

    }//GEN-LAST:event_jButton4ActionPerformed

    private void ButtonEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonEditarActionPerformed
        // botao editar
   
        VisitanteModel obj = new VisitanteModel();
        obj.setNome(txtnomevisitante.getText());
        obj.setCpf(txtcpf.getText());     
        obj.setValor(Double.parseDouble(txtvalorentrada.getText()));
        obj.setId(Integer.parseInt(txtcodigo.getText()));

        VisitanteDao dao = new VisitanteDao();
        dao.alterarVisitante(obj);

        new Utilitarios().LimpaTela(PanelVisitante);


    }//GEN-LAST:event_ButtonEditarActionPerformed

    private void ButtonNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonNovoActionPerformed
                // Botao novo
 
          new Utilitarios().LimpaTela(PanelVisitante); 

    }//GEN-LAST:event_ButtonNovoActionPerformed

    private void ButtonSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonSalvarActionPerformed
        // botao salvar visitante 

        VisitanteModel obj = new VisitanteModel();

        obj.setNome(txtnomevisitante.getText());
        obj.setCpf(txtcpf.getText());
        obj.setValor(Double.parseDouble(txtvalorentrada.getText()));

        VisitanteDao dao = new VisitanteDao();
        dao.cadastrar(obj);


    }//GEN-LAST:event_ButtonSalvarActionPerformed

    private void ButtonSalvarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ButtonSalvarKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_ButtonSalvarKeyPressed

    private void ButtonBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonBuscarActionPerformed

        // pesquisa por nome
        String nome = "%" + txtcodigo.getText() + "%";//sintaxe do sql % caracter qualquer coisa antes e depois
        VisitanteDao dao = new VisitanteDao();
        List<VisitanteModel> lista = dao.buscaVisitantePorNome(nome);
        DefaultTableModel dados = (DefaultTableModel) tabelaVisitante.getModel();
        dados.setNumRows(0);
        for (VisitanteModel c : lista) {
            dados.addRow(new Object[]{
                c.getId(),
                c.getCpf(),
                c.getValor(),
                c.getNome()

            });
        }
    }//GEN-LAST:event_ButtonBuscarActionPerformed

    private void tabelaVisitanteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaVisitanteMouseClicked
        // pega dados da tabela no click do mouse

        txtcodigo.setText(tabelaVisitante.getValueAt(tabelaVisitante.getSelectedRow(), 0).toString());
        txtcpf.setText(tabelaVisitante.getValueAt(tabelaVisitante.getSelectedRow(), 1).toString());
        txtvalorentrada.setText(tabelaVisitante.getValueAt(tabelaVisitante.getSelectedRow(), 2).toString());

        txtnomevisitante.setText(tabelaVisitante.getValueAt(tabelaVisitante.getSelectedRow(), 3).toString());


    }//GEN-LAST:event_tabelaVisitanteMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Visitante.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Visitante.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Visitante.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Visitante.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Visitante().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ButtonBuscar;
    private javax.swing.JButton ButtonEditar;
    private javax.swing.JButton ButtonNovo;
    private javax.swing.JButton ButtonSalvar;
    private javax.swing.JLabel LabelCpf;
    private javax.swing.JLabel LabelCpf1;
    private javax.swing.JLabel LabelCpf2;
    private javax.swing.JLabel LabelNome;
    private javax.swing.JPanel PanelVisitante;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabelaVisitante;
    private javax.swing.JTextField txtcodigo;
    private javax.swing.JFormattedTextField txtcpf;
    private javax.swing.JTextField txtmensalidade;
    private javax.swing.JTextField txtnomevisitante;
    private javax.swing.JTextField txtvalorentrada;
    // End of variables declaration//GEN-END:variables
}