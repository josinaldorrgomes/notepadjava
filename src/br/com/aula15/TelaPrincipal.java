package br.com.aula15;

import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class TelaPrincipal extends javax.swing.JFrame {

    private String arquivoAberto;

    public TelaPrincipal() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        areaDeTexto = new javax.swing.JTextArea();
        barraDeMenu = new javax.swing.JMenuBar();
        menuArquivo = new javax.swing.JMenu();
        opcaoAbrir = new javax.swing.JMenuItem();
        opcaoSalvar = new javax.swing.JMenuItem();
        separador = new javax.swing.JPopupMenu.Separator();
        opcaoSair = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Notepad em Java");

        areaDeTexto.setColumns(20);
        areaDeTexto.setRows(5);
        jScrollPane1.setViewportView(areaDeTexto);

        menuArquivo.setText("Arquivo");

        opcaoAbrir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/aula15/abrir.png"))); // NOI18N
        opcaoAbrir.setText("Abrir");
        opcaoAbrir.setName("Ctrl+O"); // NOI18N
        opcaoAbrir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                opcaoAbrirActionPerformed(evt);
            }
        });
        menuArquivo.add(opcaoAbrir);

        opcaoSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/aula15/salvar.png"))); // NOI18N
        opcaoSalvar.setText("Salvar");
        opcaoSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                opcaoSalvarActionPerformed(evt);
            }
        });
        menuArquivo.add(opcaoSalvar);
        menuArquivo.add(separador);

        opcaoSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/aula15/sair.png"))); // NOI18N
        opcaoSair.setText("Sair");
        opcaoSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                opcaoSairActionPerformed(evt);
            }
        });
        menuArquivo.add(opcaoSair);

        barraDeMenu.add(menuArquivo);

        setJMenuBar(barraDeMenu);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 800, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 579, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void opcaoAbrirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opcaoAbrirActionPerformed
        JFileChooser chooser = new JFileChooser();
        int result = chooser.showOpenDialog(this);
        if (JFileChooser.OPEN_DIALOG == result) {
            String caminhoDoArquivo = chooser.getSelectedFile().getAbsolutePath();
            tentarAbrirArquivo(caminhoDoArquivo);
        }
    }//GEN-LAST:event_opcaoAbrirActionPerformed

    private void opcaoSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opcaoSalvarActionPerformed
        tentarSalvarArquivo();
        JOptionPane.showMessageDialog(this, "Arquivo atualizado com sucesso!", "Notepad", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_opcaoSalvarActionPerformed

    private void opcaoSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opcaoSairActionPerformed
        dispose();
    }//GEN-LAST:event_opcaoSairActionPerformed

    private void tentarAbrirArquivo(String caminhoDoArquivo) {
        NotepadService service = new NotepadService();
        try {
            String dados = service.abrir(caminhoDoArquivo);
            areaDeTexto.setText(dados);
            arquivoAberto = caminhoDoArquivo;
            opcaoSalvar.setEnabled(true);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Falha ao tentar abrir o arquivo", "Notepad", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void tentarSalvarArquivo() {
        NotepadService service = new NotepadService();
        try {
            service.salvar(arquivoAberto, areaDeTexto.getText());
            JOptionPane.showMessageDialog(this, "Arquivo salvo com sucesso", "Notepad", JOptionPane.INFORMATION_MESSAGE);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Falha ao tentar salvar o arquivo. " + "Verifique se o arquivo já está em uso por outro programa", "Notepad", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea areaDeTexto;
    private javax.swing.JMenuBar barraDeMenu;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JMenu menuArquivo;
    private javax.swing.JMenuItem opcaoAbrir;
    private javax.swing.JMenuItem opcaoSair;
    private javax.swing.JMenuItem opcaoSalvar;
    private javax.swing.JPopupMenu.Separator separador;
    // End of variables declaration//GEN-END:variables
}
