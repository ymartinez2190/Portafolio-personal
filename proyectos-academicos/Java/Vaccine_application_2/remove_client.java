package cork_vaccine_application;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class remove_client extends JInternalFrame {

    /**
     * Creates new form remove_client
     */
    private List<Client> clientlist;
    public remove_client() 
    {
        //LOAD DATA TO FORM
        initComponents();
        try
        {
            clientlist=new ArrayList();
            clientlist=Cork_Vaccine_Application.objClientCollection.load_data();
            DefaultTableModel model = (DefaultTableModel) jtbremove.getModel();
            for(Client client:clientlist)
            {
                model.addRow(new Object[]{client.get_idClient(),client.get_name(),client.get_phoneClient(),client.get_vac().get_name(),client.get_vac().get_efficacy(),client.get_vac().get_startDoseDate()});
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }         
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new JScrollPane();
        jtbremove = new JTable();
        jLabel1 = new JLabel();
        btndelete = new JButton();
        btnclose = new JButton();

        setTitle("Delete client");

        jtbremove.setModel(new DefaultTableModel(
            new Object [][] {
               
            },
            new String [] {
               "Identification", "Complete name", "Phone number", "Vaccine name","Efficacy","First dose date","Second dose name"
            }
        ));
        jScrollPane1.setViewportView(jtbremove);

        jLabel1.setText("Select the record you want to delete: ");

        btndelete.setText("Delete record");
        btndelete.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                btndeleteActionPerformed(evt);
            }
        });

        btnclose.setText("Close");
        btnclose.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                btncloseActionPerformed(evt);
            }
        });

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(475, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnclose)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btndelete))
                    .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 627, GroupLayout.PREFERRED_SIZE))
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 126, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(btndelete)
                    .addComponent(btnclose))
                .addContainerGap(76, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btndeleteActionPerformed(ActionEvent evt) {//GEN-FIRST:event_btndeleteActionPerformed
        // DELETE THE DATA
    
        
        if(JOptionPane.showConfirmDialog(null,"You are about to delete a record. Do you wish to continue?","Information",JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION)
        {
            Cork_Vaccine_Application.objClientCollection.remove_client(String.valueOf(jtbremove.getValueAt(jtbremove.getSelectedRow(),jtbremove.getSelectedColumn())));
            if(jtbremove.getValueAt(jtbremove.getSelectedRow(),jtbremove.getSelectedColumn())!=null && (jtbremove.getColumnName(jtbremove.getSelectedColumn())=="Identification"))
            {
                DefaultTableModel model = (DefaultTableModel) jtbremove.getModel();

                model.removeRow(jtbremove.getSelectedRow());
                JOptionPane.showMessageDialog(null,"Deleted information");
            }
        }
        
    }//GEN-LAST:event_btndeleteActionPerformed

    private void btncloseActionPerformed(ActionEvent evt) {//GEN-FIRST:event_btncloseActionPerformed
        // CLOSE THE FORM
        this.dispose();
    }//GEN-LAST:event_btncloseActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private JButton btnclose;
    private JButton btndelete;
    private JLabel jLabel1;
    private JScrollPane jScrollPane1;
    private JTable jtbremove;
    // End of variables declaration//GEN-END:variables
}
