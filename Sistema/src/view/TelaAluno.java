/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import static controller.Gerenciador.buscarRequerimentoProtocolo;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.ArrayList;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import model.entity.Aluno;
import model.requerimento.Requerimento;

/**
 *
 * @author labccet
 */
public class TelaAluno extends javax.swing.JFrame {

    /**
     * Creates new form telaAluno
     */
    public TelaAluno() {
        initComponents();

    }
    Aluno aluno;

    public TelaAluno(String cpf, String senha) {
        initComponents();
        preencherCampos();
        centralizarTela(); 
    }

    public TelaAluno(Aluno aluno) {
        initComponents();
        this.aluno = aluno;
        preencherCampos();
        popularRequerimentos();
        centralizarTela();
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        logOutLabel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        logoutLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        lista = new javax.swing.JList<String>();
        painelTelaAluno = new javax.swing.JTabbedPane();
        jScrollPane4 = new javax.swing.JScrollPane();
        tabelaRequerimentoAluno = new javax.swing.JTable();
        verDadosCompletos = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        nomeCompletoAlunoLabel = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        matriculaAlunoLabel = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        emailAlunoLabel = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        telefoneAlunoLabel = new javax.swing.JLabel();
        quadradoAtualizar = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        setinhaAtualizar = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setMaximumSize(new java.awt.Dimension(1000, 600));
        jPanel1.setPreferredSize(new java.awt.Dimension(1000, 800));

        logOutLabel.setBackground(new java.awt.Color(56, 113, 156));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/iBSI.png"))); // NOI18N

        logoutLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        logoutLabel.setForeground(new java.awt.Color(255, 255, 255));
        logoutLabel.setText("Trocar de Usuário");
        logoutLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                logoutLabelMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout logOutLabelLayout = new javax.swing.GroupLayout(logOutLabel);
        logOutLabel.setLayout(logOutLabelLayout);
        logOutLabelLayout.setHorizontalGroup(
            logOutLabelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(logOutLabelLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(logOutLabelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, logOutLabelLayout.createSequentialGroup()
                        .addComponent(logoutLabel)
                        .addGap(26, 26, 26))))
        );
        logOutLabelLayout.setVerticalGroup(
            logOutLabelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(logOutLabelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(logOutLabelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(logOutLabelLayout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, logOutLabelLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel5)
                        .addGap(64, 64, 64)
                        .addComponent(logoutLabel)
                        .addGap(46, 46, 46))))
        );

        lista.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Atualização de cadastro", "Cancelamento de matrícula", "Emissão de certificado ou diploma", "Emissão de histórico escolar", "Emissão do programa de disciplinas", "Isenção ou aproveitamento de disciplina", "Realização de segunda chamada", "Revisão de prova", "Trancamento de Disciplina", "Trancamento de matrícula", "Outros" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        lista.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(lista);

        painelTelaAluno.setBackground(new java.awt.Color(255, 255, 255));

        tabelaRequerimentoAluno.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Protocolo", "Tipo", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabelaRequerimentoAluno.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        tabelaRequerimentoAluno.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tabelaRequerimentoAluno.setUpdateSelectionOnSort(false);
        tabelaRequerimentoAluno.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaRequerimentoAlunoMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(tabelaRequerimentoAluno);
        tabelaRequerimentoAluno.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);

        painelTelaAluno.addTab("Meus Requerimentos", jScrollPane4);

        verDadosCompletos.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        verDadosCompletos.setText("Ver dados cadastrais completos");
        verDadosCompletos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                verDadosCompletosMouseClicked(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel11.setText("Nome:");

        nomeCompletoAlunoLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        nomeCompletoAlunoLabel.setText("Nome Completo do Aluno");

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel13.setText("Matrícula:");

        matriculaAlunoLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        matriculaAlunoLabel.setText("123456789");

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel15.setText("E-mail:");

        emailAlunoLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        emailAlunoLabel.setText("nome.sobrenome@uniriotec.br");

        jLabel17.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel17.setText("Telefone:");

        telefoneAlunoLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        telefoneAlunoLabel.setText("(21) 9-2222-2222");

        quadradoAtualizar.setBackground(new java.awt.Color(255, 255, 255));
        quadradoAtualizar.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(56, 113, 156), 2, true));
        quadradoAtualizar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                quadradoAtualizarMouseClicked(evt);
            }
        });

        jLabel19.setBackground(new java.awt.Color(255, 255, 255));
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));

        jLabel3.setText("Atualizar");

        setinhaAtualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/refresh.png"))); // NOI18N
        setinhaAtualizar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                setinhaAtualizarMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout quadradoAtualizarLayout = new javax.swing.GroupLayout(quadradoAtualizar);
        quadradoAtualizar.setLayout(quadradoAtualizarLayout);
        quadradoAtualizarLayout.setHorizontalGroup(
            quadradoAtualizarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, quadradoAtualizarLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addContainerGap())
            .addGroup(quadradoAtualizarLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(quadradoAtualizarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(setinhaAtualizar)
                    .addComponent(jLabel19))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        quadradoAtualizarLayout.setVerticalGroup(
            quadradoAtualizarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(quadradoAtualizarLayout.createSequentialGroup()
                .addGroup(quadradoAtualizarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(quadradoAtualizarLayout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jLabel19))
                    .addGroup(quadradoAtualizarLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(setinhaAtualizar)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(logOutLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(painelTelaAluno))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(verDadosCompletos)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel11)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(nomeCompletoAlunoLabel)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel13))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel15)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(emailAlunoLabel)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 131, Short.MAX_VALUE)
                                        .addComponent(jLabel17)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(telefoneAlunoLabel)
                                    .addComponent(matriculaAlunoLabel))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 129, Short.MAX_VALUE)
                        .addComponent(quadradoAtualizar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(59, 59, 59))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(logOutLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(nomeCompletoAlunoLabel)
                                    .addComponent(jLabel11)
                                    .addComponent(jLabel13)
                                    .addComponent(matriculaAlunoLabel))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel15)
                                    .addComponent(emailAlunoLabel)
                                    .addComponent(jLabel17)
                                    .addComponent(telefoneAlunoLabel)))
                            .addComponent(quadradoAtualizar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(verDadosCompletos)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 62, Short.MAX_VALUE)
                        .addComponent(painelTelaAluno, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1))
                .addGap(34, 34, 34))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1103, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 606, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private void limparTabela(){
        DefaultTableModel model = (DefaultTableModel) tabelaRequerimentoAluno.getModel();
        model.setRowCount(0);
    }
    private void preencherCampos() {
        try{
        emailAlunoLabel.setText(aluno.getEmail());
        nomeCompletoAlunoLabel.setText(aluno.getNome());
        matriculaAlunoLabel.setText(aluno.getMatricula());
        telefoneAlunoLabel.setText(aluno.getTelefoneCelular());
        }catch(Exception e){
            JOptionPane.showMessageDialog(this, "Erro no Login");
        }
    }

    private void popularRequerimentos() {

        DefaultTableModel model = (DefaultTableModel) tabelaRequerimentoAluno.getModel();
        ArrayList<Requerimento> requerimentos = controller.Gerenciador.buscarRequerimentoCPF(aluno.getCpf());
        Object rowData[] = new Object[3];
        for (int i = 0; i < requerimentos.size(); i++) {
            rowData[0] = requerimentos.get(i).getNumeroRequerimento();
            rowData[1] = requerimentos.get(i).getTipoRequerimento();
            rowData[2] = requerimentos.get(i).getStatus();
            model.addRow(rowData);
        }
    }

    private void centralizarTela() {
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);
    }

    private void listaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listaMouseClicked
        String titulo;
        JList list = (JList) evt.getSource();
        titulo = (String) list.getSelectedValue();
        if (evt.getClickCount() == 2) {
            RequerimentoGeralAnexoAluno janelaRequerimento = new RequerimentoGeralAnexoAluno(aluno, titulo);
            janelaRequerimento.setVisible(true);
            this.setVisible(false);
            this.dispose();
        }


    }//GEN-LAST:event_listaMouseClicked

    private void verDadosCompletosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_verDadosCompletosMouseClicked
        DadosCadastraisCompletos janelaDados = new DadosCadastraisCompletos(aluno);
        janelaDados.setVisible(true);
        this.setVisible(false);
        this.dispose();

     }//GEN-LAST:event_verDadosCompletosMouseClicked

    private void setinhaAtualizarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_setinhaAtualizarMouseClicked
        limparTabela();
        popularRequerimentos();
    }//GEN-LAST:event_setinhaAtualizarMouseClicked

    private void quadradoAtualizarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_quadradoAtualizarMouseClicked
        limparTabela();
        popularRequerimentos();
    }//GEN-LAST:event_quadradoAtualizarMouseClicked

    private void tabelaRequerimentoAlunoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaRequerimentoAlunoMouseClicked
        tabelaRequerimentoAluno = (JTable) evt.getSource();
        
        if (evt.getClickCount() == 2) {
            int numeroLinha = tabelaRequerimentoAluno.getSelectedRow();
            String numeroProtocolo = (String) tabelaRequerimentoAluno.getValueAt(numeroLinha,0);
            String tipoRequerimento =(String) tabelaRequerimentoAluno.getValueAt(numeroLinha,1);
            ArrayList<Requerimento> requerimento = buscarRequerimentoProtocolo(numeroProtocolo);
            RequerimentoGeralAnexoAlunoLeitura requerimentoAlunoLeitura;
            requerimentoAlunoLeitura = new RequerimentoGeralAnexoAlunoLeitura(requerimento.get(0),tipoRequerimento);
            requerimentoAlunoLeitura.setVisible(true);
        }        
        
    }//GEN-LAST:event_tabelaRequerimentoAlunoMouseClicked

    private void logoutLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logoutLabelMouseClicked
        Login telaLogin = new Login();
        telaLogin.setVisible(true);
        this.setVisible(false);
        this.dispose();

    }//GEN-LAST:event_logoutLabelMouseClicked

 

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel emailAlunoLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JList<String> lista;
    private javax.swing.JPanel logOutLabel;
    private javax.swing.JLabel logoutLabel;
    private javax.swing.JLabel matriculaAlunoLabel;
    private javax.swing.JLabel nomeCompletoAlunoLabel;
    private javax.swing.JTabbedPane painelTelaAluno;
    private javax.swing.JPanel quadradoAtualizar;
    private javax.swing.JLabel setinhaAtualizar;
    private javax.swing.JTable tabelaRequerimentoAluno;
    private javax.swing.JLabel telefoneAlunoLabel;
    private javax.swing.JLabel verDadosCompletos;
    // End of variables declaration//GEN-END:variables
}
