package cork_vaccine_application;

import javax.swing.*;
import java.util.*;
import java.time.LocalDate;
import cork_vaccine_application.Cork_Vaccine_Application;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class add_client extends JInternalFrame {

    /**
     * Creates new form add_client
     */
    private LocalDate startdate=null;
    private LocalDate nextdose=null;
    private int efficacy[];
    private int dosequantity[];
    private int weeks[];
    private int count=0;
    private List<Vaccination> vac;
    public add_client() 
    {
        //LOAD INFORMATION
        initComponents();
        startdate=LocalDate.now();
        txtdate.setText(startdate.toString());
        vac=Cork_Vaccine_Application.objClientCollection.load_data_vaccine();
        efficacy=new int[vac.size()];
        dosequantity=new int[vac.size()];
        weeks= new int[vac.size()];
        
        for(Vaccination vaccineinfo:vac)
        {
            cbovaccine.addItem(vaccineinfo.get_name());
            efficacy[count]=vaccineinfo.get_efficacy();
            dosequantity[count]=vaccineinfo.get_dosequantity();
            count++;
        }
           
       
        this.setSize(200, 200);
    }

  
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new JButton();
        jPanel1 = new JPanel();
        txtdate = new JTextField();
        btnadd = new JButton();
        jLabel1 = new JLabel();
        cbovaccine = new JComboBox<>();
        txtfirstname = new JTextField();
        jLabel5 = new JLabel();
        jLabel2 = new JLabel();
        btnclose = new JButton();
        txtlastname = new JTextField();
        jLabel7 = new JLabel();
        txtid = new JTextField();
        txtfinal = new JTextField();
        jLabel3 = new JLabel();
        jLabel8 = new JLabel();
        jLabel4 = new JLabel();
        txtefficacy = new JTextField();
        txtphone = new JTextField();
        jLabel9 = new JLabel();
        jLabel6 = new JLabel();
        txtdoses = new JTextField();

        jButton1.setText("jButton1");

        setClosable(true);
        setTitle("Add new client info");
        setMaximumSize(new java.awt.Dimension(88, 34));
        setName(""); // NOI18N
        setPreferredSize(new java.awt.Dimension(200, 200));

        btnadd.setText("Add client");
        btnadd.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                btnaddActionPerformed(evt);
            }
        });

        jLabel1.setText("Firstname:");
        jLabel1.setToolTipText("");

        cbovaccine.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                cbovaccineActionPerformed(evt);
            }
        });

        txtfirstname.setName("txt_firstname"); // NOI18N

        jLabel5.setText("Vaccine selected:");

        jLabel2.setText("Lastname:");

        btnclose.setText("Close");
        btnclose.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                btncloseActionPerformed(evt);
            }
        });

        jLabel7.setText("Final dose date:");

        jLabel3.setText("Identification Nº:");

        jLabel8.setText("Efficacy (in %):");

        jLabel4.setText("Phone:");

        jLabel9.setText("Doses:");

        jLabel6.setText("Start dose date:");

        GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, 74, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtfirstname, GroupLayout.PREFERRED_SIZE, 112, GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32)
                        .addComponent(jLabel2)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtlastname, GroupLayout.PREFERRED_SIZE, 106, GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtid, GroupLayout.PREFERRED_SIZE, 302, GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtphone, GroupLayout.PREFERRED_SIZE, 184, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel5)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbovaccine, GroupLayout.PREFERRED_SIZE, 199, GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addGap(7, 7, 7)
                                .addComponent(txtdoses, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txtdate, GroupLayout.PREFERRED_SIZE, 67, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel7)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtfinal, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtefficacy, GroupLayout.PREFERRED_SIZE, 182, GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(btnclose, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 79, GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnadd, GroupLayout.Alignment.TRAILING))))
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(txtfirstname, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtlastname, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtid, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtphone, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(cbovaccine, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtdate, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(txtfinal, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnadd))
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txtdoses, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(txtefficacy, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnclose))
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(147, Short.MAX_VALUE)
                .addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnaddActionPerformed(ActionEvent evt) {//GEN-FIRST:event_btnaddActionPerformed
        // ADD NEW DATA
        try
        {
            Vaccination objvaccine=new Vaccination(cbovaccine.getSelectedIndex()+1,cbovaccine.getSelectedItem().toString(),Integer.parseInt(txtefficacy.getText()),Integer.parseInt(txtdoses.getText()),startdate,nextdose);
            Name objname=new Name(txtfirstname.getText(),txtlastname.getText());
            Client objClient=new Client(txtid.getText(),txtphone.getText(), objname, objvaccine);
            Cork_Vaccine_Application.objClientCollection.add_client(objClient);
            JOptionPane.showMessageDialog(null,"New client was added");
        }
        catch (Exception ex) 
        {
            JOptionPane.showMessageDialog(null, "Error adding the client.");
            ex.printStackTrace();
        }
    cleartext();
       
    }//GEN-LAST:event_btnaddActionPerformed

    private void btncloseActionPerformed(ActionEvent evt) {//GEN-FIRST:event_btncloseActionPerformed
        this.dispose();       //CLOSE THE FORM
      
    }//GEN-LAST:event_btncloseActionPerformed

    private void cbovaccineActionPerformed(ActionEvent evt) {//GEN-FIRST:event_cbovaccineActionPerformed
        // SET THE INFORMATION BY OPTIONSELECTED
        switch(cbovaccine.getSelectedIndex())
        {
            case 0:
                nextdose=startdate.plusWeeks(4);
                txtfinal.setText(nextdose.toString());
                txtdoses.setText(String.valueOf(dosequantity[0]));
                txtefficacy.setText(String.valueOf(efficacy[0]));
                break;
            case 1:
                nextdose=startdate.plusWeeks(8);
                txtfinal.setText(nextdose.toString());
                txtdoses.setText(String.valueOf(dosequantity[1]));
                txtefficacy.setText(String.valueOf(efficacy[1]));
                break;
            case 2:
               nextdose=startdate.plusWeeks(4);
               txtfinal.setText(nextdose.toString());
               txtdoses.setText(String.valueOf(dosequantity[2]));
               txtefficacy.setText(String.valueOf(efficacy[2]));
               break;
            case 3:
               txtfinal.setText("0");
               txtdoses.setText(String.valueOf(dosequantity[3]));
               txtefficacy.setText(String.valueOf(efficacy[3]));
               break;     
        }   
    }//GEN-LAST:event_cbovaccineActionPerformed
 
    //CLEAR THE JTEXTBOX
    private void cleartext()
    {
        txtfirstname.setText("");
        txtlastname.setText("");
        txtid.setText("");
        txtphone.setText("");
        txtdate.setText("");
        txtfinal.setText("");
        txtdoses.setText("");
        txtefficacy.setText("");
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private JButton btnadd;
    private JButton btnclose;
    private JComboBox<String> cbovaccine;
    private JButton jButton1;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JLabel jLabel3;
    private JLabel jLabel4;
    private JLabel jLabel5;
    private JLabel jLabel6;
    private JLabel jLabel7;
    private JLabel jLabel8;
    private JLabel jLabel9;
    private JPanel jPanel1;
    private JTextField txtdate;
    private JTextField txtdoses;
    private JTextField txtefficacy;
    private JTextField txtfinal;
    private JTextField txtfirstname;
    private JTextField txtid;
    private JTextField txtlastname;
    private JTextField txtphone;
    // End of variables declaration//GEN-END:variables
}
