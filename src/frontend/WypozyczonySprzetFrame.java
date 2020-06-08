/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frontend;

import backend.BazaKarta;
import backend.BazaSprzet;
import backend.WypozyczonySprzet;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JComboBox;

/**
 *
 * @author Piotr Buczek
 */
public class WypozyczonySprzetFrame extends javax.swing.JFrame {

    /**
     * Creates new form WypozyczonySprzetFrame
     */
    public WypozyczonySprzetFrame() {
        initComponents();
        
        this.zablokujTekst();
        bd = new BazaSprzet();
        dane = bd.odczyt();
        pf = new PracownikFrame();
        sprzetComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(initializeComboBox(dane)));
        sprzetComboBox.addActionListener(new ActionListener() {
 
        @Override
        public void actionPerformed(ActionEvent event) {
        JComboBox<String> combo = (JComboBox<String>) event.getSource();
        String selectedSprzet = (String) combo.getSelectedItem();
 
        wyswietlSprzet(Integer.parseInt(selectedSprzet));
            }
        });
        
        this.bZapisz.setEnabled(false);
        this.wyswietl(0);
        this.setTitle("Menedżer wypożyczonego sprzętu");
    }
    
    private void wyswietl(int i){
        WypozyczonySprzet w = dane.get(i);
        tNrSeryjny.setText(""+w.getNrSeryjny());
        tNazwaSprzetu.setText(w.getNazwaSprzetu());
        tDataWydania.setText(w.getDataWydania());
        tNrPracownika.setText(""+w.getNrPracownika());
    }
    
    private void wyswietlSprzet(long nrSeryjny){
        for(int i=0;i<dane.size();i++){
            if(((WypozyczonySprzet)dane.get(i)).getNrSeryjny()==nrSeryjny){
                this.i = i;
                wyswietl(i);
            }
        }
    }
    
    private String[] initializeComboBox(ArrayList<WypozyczonySprzet> sprzety){
        String[] numbers = new String[sprzety.size()];
        int i = 0;
        for(WypozyczonySprzet sprzet : sprzety){
            numbers[i] = String.valueOf(sprzet.getNrSeryjny());
            i++;
        }
        return numbers;
    }
    
    private void odblokujTekst(){
        tNrSeryjny.setEnabled(true);
        tNazwaSprzetu.setEnabled(true);
        tDataWydania.setEnabled(true);
        tNrPracownika.setEnabled(true);
    }
    
    private void zablokujTekst(){
        tNrSeryjny.setEnabled(false);
        tNazwaSprzetu.setEnabled(false);
        tDataWydania.setEnabled(false);
        tNrPracownika.setEnabled(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        sprzetComboBox = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        tNrSeryjny = new javax.swing.JTextField();
        tNazwaSprzetu = new javax.swing.JTextField();
        tDataWydania = new javax.swing.JTextField();
        tNrPracownika = new javax.swing.JTextField();
        bNowy = new javax.swing.JButton();
        bZapisz = new javax.swing.JButton();
        bEdytuj = new javax.swing.JButton();
        bUsun = new javax.swing.JButton();
        bWyswietl = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        mNowy = new javax.swing.JMenuItem();
        mZapisz = new javax.swing.JMenuItem();
        mKoniec = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        mEdytuj = new javax.swing.JMenuItem();
        mUsun = new javax.swing.JMenuItem();

        jLabel1.setText("Wybierz numer seryjny sprzętu:");

        sprzetComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel2.setText("Numer seryjny:");

        jLabel3.setText("Nazwa sprzętu:");

        jLabel4.setText("Data wydania:");

        jLabel5.setText("Numer pracownika:");

        tNrSeryjny.setText("jTextField1");
        tNrSeryjny.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tNrSeryjnyActionPerformed(evt);
            }
        });

        tNazwaSprzetu.setText("jTextField2");

        tDataWydania.setText("jTextField3");

        tNrPracownika.setText("jTextField4");

        bNowy.setText("Nowy");
        bNowy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bNowyActionPerformed(evt);
            }
        });

        bZapisz.setText("Zapisz");
        bZapisz.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bZapiszActionPerformed(evt);
            }
        });

        bEdytuj.setText("Edytuj");
        bEdytuj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bEdytujActionPerformed(evt);
            }
        });

        bUsun.setText("Usuń");
        bUsun.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bUsunActionPerformed(evt);
            }
        });

        bWyswietl.setText("Wyświetl informacje o pracowniku");
        bWyswietl.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bWyswietlActionPerformed(evt);
            }
        });

        jMenu1.setText("Plik");

        mNowy.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.CTRL_MASK));
        mNowy.setText("Nowy");
        mNowy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mNowyActionPerformed(evt);
            }
        });
        jMenu1.add(mNowy);

        mZapisz.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        mZapisz.setText("Zapisz");
        mZapisz.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mZapiszActionPerformed(evt);
            }
        });
        jMenu1.add(mZapisz);

        mKoniec.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Q, java.awt.event.InputEvent.CTRL_MASK));
        mKoniec.setText("Koniec");
        mKoniec.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mKoniecActionPerformed(evt);
            }
        });
        jMenu1.add(mKoniec);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edycja");

        mEdytuj.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_E, java.awt.event.InputEvent.CTRL_MASK));
        mEdytuj.setText("Edytuj");
        mEdytuj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mEdytujActionPerformed(evt);
            }
        });
        jMenu2.add(mEdytuj);

        mUsun.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_DELETE, 0));
        mUsun.setText("Usuń");
        mUsun.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mUsunActionPerformed(evt);
            }
        });
        jMenu2.add(mUsun);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(jLabel1)
                        .addGap(32, 32, 32)
                        .addComponent(sprzetComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(bNowy)
                                .addGap(18, 18, 18)
                                .addComponent(bZapisz)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(tNrPracownika, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(bWyswietl)
                                .addGap(22, 22, 22))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tNazwaSprzetu, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(tNrSeryjny, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(tDataWydania, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(bEdytuj)
                                        .addGap(18, 18, 18)
                                        .addComponent(bUsun)))
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(sprzetComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(tNrSeryjny, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(tNazwaSprzetu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(tDataWydania, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(tNrPracownika, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bWyswietl))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bNowy)
                    .addComponent(bZapisz)
                    .addComponent(bEdytuj)
                    .addComponent(bUsun))
                .addGap(34, 34, 34))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tNrSeryjnyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tNrSeryjnyActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tNrSeryjnyActionPerformed

    private void bNowyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bNowyActionPerformed
        // TODO add your handling code here:
        this.odblokujTekst();
        this.bNowy.setEnabled(false);
        this.bZapisz.setEnabled(true);
        this.bEdytuj.setEnabled(false);
        this.bUsun.setEnabled(false);
         this.bWyswietl.setEnabled(false);
         sprzetComboBox.setEnabled(false);

        tNrSeryjny.setText("");       
        tNazwaSprzetu.setText("");
        tDataWydania.setText("");
        tNrPracownika.setText("");
    }//GEN-LAST:event_bNowyActionPerformed

    private void bZapiszActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bZapiszActionPerformed
        // TODO add your handling code here:
        if(tNrSeryjny.isEnabled()){
            bd.zapis(tNrSeryjny.getText(),       
        tNazwaSprzetu.getText(),
        tDataWydania.getText(),
        tNrPracownika.getText());
        } else if(!tNrSeryjny.isEnabled()){
            bd.modyfikuj(tNrSeryjny.getText(),       
        tNazwaSprzetu.getText(),
        tDataWydania.getText(),
        tNrPracownika.getText());
        }
        
        this.zablokujTekst();
        this.bNowy.setEnabled(true);
        this.bZapisz.setEnabled(false);
        this.bEdytuj.setEnabled(true);
        this.bUsun.setEnabled(true);
        this.bWyswietl.setEnabled(true);
        sprzetComboBox.setEnabled(true);
        dane = bd.odczyt();
        sprzetComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(initializeComboBox(dane)));
        sprzetComboBox.setSelectedItem(tNrSeryjny.getText());
    }//GEN-LAST:event_bZapiszActionPerformed

    private void bEdytujActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bEdytujActionPerformed
        // TODO add your handling code here:
        this.odblokujTekst();
        sprzetComboBox.setEnabled(false);
        this.bZapisz.setEnabled(true);
        this.bNowy.setEnabled(false);
        this.bUsun.setEnabled(false);
        this.bEdytuj.setEnabled(false);
        tNrSeryjny.setEnabled(false);
    }//GEN-LAST:event_bEdytujActionPerformed

    private void bUsunActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bUsunActionPerformed
        // TODO add your handling code here:
        bd.usun(tNrSeryjny.getText());
        dane = bd.odczyt();
        sprzetComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(initializeComboBox(dane)));
        sprzetComboBox.setSelectedItem(String.valueOf(dane.get(0).getNrSeryjny()));
    }//GEN-LAST:event_bUsunActionPerformed

    private void bWyswietlActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bWyswietlActionPerformed
        // TODO add your handling code here:
        pf.wyswietlPracownika(Long.parseLong(tNrPracownika.getText()));
        pf.setVisible(true);
    }//GEN-LAST:event_bWyswietlActionPerformed

    private void mNowyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mNowyActionPerformed
        // TODO add your handling code here:
        this.bNowyActionPerformed(evt);
    }//GEN-LAST:event_mNowyActionPerformed

    private void mZapiszActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mZapiszActionPerformed
        // TODO add your handling code here:
        this.bZapiszActionPerformed(evt);
    }//GEN-LAST:event_mZapiszActionPerformed

    private void mKoniecActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mKoniecActionPerformed
        // TODO add your handling code here:
        dispose();
        setVisible(false);
    }//GEN-LAST:event_mKoniecActionPerformed

    private void mEdytujActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mEdytujActionPerformed
        // TODO add your handling code here:
        this.bEdytujActionPerformed(evt);
    }//GEN-LAST:event_mEdytujActionPerformed

    private void mUsunActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mUsunActionPerformed
        // TODO add your handling code here:
        this.bUsunActionPerformed(evt);
    }//GEN-LAST:event_mUsunActionPerformed

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
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(WypozyczonySprzetFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(WypozyczonySprzetFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(WypozyczonySprzetFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(WypozyczonySprzetFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new WypozyczonySprzetFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bEdytuj;
    private javax.swing.JButton bNowy;
    private javax.swing.JButton bUsun;
    private javax.swing.JButton bWyswietl;
    private javax.swing.JButton bZapisz;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem mEdytuj;
    private javax.swing.JMenuItem mKoniec;
    private javax.swing.JMenuItem mNowy;
    private javax.swing.JMenuItem mUsun;
    private javax.swing.JMenuItem mZapisz;
    private javax.swing.JComboBox<String> sprzetComboBox;
    private javax.swing.JTextField tDataWydania;
    private javax.swing.JTextField tNazwaSprzetu;
    private javax.swing.JTextField tNrPracownika;
    private javax.swing.JTextField tNrSeryjny;
    // End of variables declaration//GEN-END:variables
    private BazaSprzet bd;
    private ArrayList<WypozyczonySprzet> dane;
    private int i;
    private PracownikFrame pf;
}
