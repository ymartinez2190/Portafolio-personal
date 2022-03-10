package cork_vaccine_application;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class principal_form extends JFrame {

    /**
     * Creates new form principal_form
     */
    private LocalDate startdate=null;
    private LocalDate nextdate=null;
    public principal_form() 
    {
        //LOAD THE DATA
        try
        {
            List<Client> clientlist=Cork_Vaccine_Application.objClientCollection.load_data();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            if(!clientlist.isEmpty())
            {
                for(int i = 0; i < clientlist.size(); i++) 
                {
                    startdate=LocalDate.parse(clientlist.get(i).get_vac().get_startDoseDate().toString(), formatter);
                    nextdate=LocalDate.parse(clientlist.get(i).get_vac().get_next_dose_date().toString(), formatter);
                    Vaccination objvaccine=new Vaccination(clientlist.get(i).get_vac().get_idvaccine(),clientlist.get(i).get_vac().get_name(),clientlist.get(i).get_vac().get_efficacy(),clientlist.get(i).get_vac().get_dosequantity(),startdate,nextdate);
                    Name objname=new Name(clientlist.get(i).get_firstName(),clientlist.get(i).get_lastName());
                    Client objClient=new Client(clientlist.get(i).get_idClient(),clientlist.get(i).get_phoneClient(), objname, objvaccine);  
                    Cork_Vaccine_Application.objClientCollection.add_client(objClient);
                }
            }
        }
        catch(Exception ex)
        {
            JOptionPane.showMessageDialog(null, "Error loading the data. The file doesn't exists.");
            ex.printStackTrace();
        }
        initComponents();  
    }

 
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        frmMDI = new javax.swing.JDesktopPane();
        menuBar = new javax.swing.JMenuBar();
        fileMenu = new javax.swing.JMenu();
        saveMenuItem = new javax.swing.JMenuItem();
        exitMenuItem = new javax.swing.JMenuItem();
        clientsMenu = new javax.swing.JMenu();
        addMenuItem = new javax.swing.JMenuItem();
        removeMenuItem = new javax.swing.JMenuItem();
        searchMenuItem = new javax.swing.JMenuItem();
        displayMenu = new javax.swing.JMenu();
        byvaccineMenuItem = new javax.swing.JMenuItem();
        byIdMenuItem = new javax.swing.JMenuItem();
        DummyjMenu = new javax.swing.JMenu();

        jMenu1.setText("jMenu1");

        jMenu2.setText("jMenu2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        fileMenu.setMnemonic('f');
        fileMenu.setText("File");

        saveMenuItem.setText("Save information");
        saveMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveMenuItemActionPerformed(evt);
            }
        });
        fileMenu.add(saveMenuItem);

        exitMenuItem.setMnemonic('x');
        exitMenuItem.setText("Exit");
        exitMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitMenuItemActionPerformed(evt);
            }
        });
        fileMenu.add(exitMenuItem);

        menuBar.add(fileMenu);

        clientsMenu.setMnemonic('e');
        clientsMenu.setText("Clients");

        addMenuItem.setMnemonic('t');
        addMenuItem.setText("Add new client");
        addMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addMenuItemActionPerformed(evt);
            }
        });
        clientsMenu.add(addMenuItem);

        removeMenuItem.setMnemonic('y');
        removeMenuItem.setText("Remove client");
        removeMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeMenuItemActionPerformed(evt);
            }
        });
        clientsMenu.add(removeMenuItem);

        searchMenuItem.setMnemonic('p');
        searchMenuItem.setText("Search client");
        searchMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchMenuItemActionPerformed(evt);
            }
        });
        clientsMenu.add(searchMenuItem);

        menuBar.add(clientsMenu);

        displayMenu.setMnemonic('h');
        displayMenu.setText("Display");

        byvaccineMenuItem.setMnemonic('c');
        byvaccineMenuItem.setText("Display clients by vaccine");
        byvaccineMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                byvaccineMenuItemActionPerformed(evt);
            }
        });
        displayMenu.add(byvaccineMenuItem);

        byIdMenuItem.setMnemonic('a');
        byIdMenuItem.setText("Display clients by ID");
        byIdMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                byIdMenuItemActionPerformed(evt);
            }
        });
        displayMenu.add(byIdMenuItem);

        menuBar.add(displayMenu);

        DummyjMenu.setText("Dummy Clients");
        DummyjMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DummyjMenuActionPerformed(evt);
            }
        });
        menuBar.add(DummyjMenu);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(frmMDI, javax.swing.GroupLayout.PREFERRED_SIZE, 793, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(frmMDI, javax.swing.GroupLayout.PREFERRED_SIZE, 555, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        frmMDI.getAccessibleContext().setAccessibleParent(frmMDI);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void exitMenuItemActionPerformed(ActionEvent evt) {//GEN-FIRST:event_exitMenuItemActionPerformed
        
        System.exit(0); //EXIT THE PROGRAM
    }//GEN-LAST:event_exitMenuItemActionPerformed

    private void addMenuItemActionPerformed(ActionEvent evt) {//GEN-FIRST:event_addMenuItemActionPerformed
        // LOAD FORM
        add_client frmadd=new add_client();
        frmadd.setSize(300, 300);
        this.setContentPane(frmadd);
        frmadd.setVisible(true);
    }//GEN-LAST:event_addMenuItemActionPerformed

    private void removeMenuItemActionPerformed(ActionEvent evt) {//GEN-FIRST:event_removeMenuItemActionPerformed
        // LOAD FORM
        remove_client frmremove=new remove_client();
        this.setContentPane(frmremove);
        frmremove.setVisible(true);
    }//GEN-LAST:event_removeMenuItemActionPerformed

    private void searchMenuItemActionPerformed(ActionEvent evt) {//GEN-FIRST:event_searchMenuItemActionPerformed
     // LOAD FORM
        search_client frmsearch=new search_client();
        this.setContentPane(frmsearch);
        frmsearch.setVisible(true);
    }//GEN-LAST:event_searchMenuItemActionPerformed

    private void byvaccineMenuItemActionPerformed(ActionEvent evt) {//GEN-FIRST:event_byvaccineMenuItemActionPerformed
          // LOAD FORM
        show_client frmshow=new show_client();
        this.setContentPane(frmshow);
        frmshow.setVisible(true);
        
    }//GEN-LAST:event_byvaccineMenuItemActionPerformed

    private void saveMenuItemActionPerformed(ActionEvent evt) {//GEN-FIRST:event_saveMenuItemActionPerformed
        // SAVE THE DATA
        Cork_Vaccine_Application.objClientCollection.save_data();
    }//GEN-LAST:event_saveMenuItemActionPerformed

    private void byIdMenuItemActionPerformed(ActionEvent evt) {//GEN-FIRST:event_byIdMenuItemActionPerformed
        //  // LOAD FORM
         show_client_id frmshow_id=new show_client_id();
        this.setContentPane(frmshow_id);
        frmshow_id.setVisible(true);
    }//GEN-LAST:event_byIdMenuItemActionPerformed

    private void DummyjMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DummyjMenuActionPerformed
        // TODO add your handling code here:
       try
       {
            int dummyid=1;
            LocalDate dummydate=null;
            while(true)
            {
                System.out.println("null");
                Vaccination objvaccine=new Vaccination(dummyid,"vaccine"+String.valueOf(dummyid),dummyid,dummyid,dummydate,dummydate);
                Name objname=new Name("Dummy","Client"+String.valueOf(dummyid));
                Client objClient=new Client("id"+String.valueOf(dummyid),"dummy phone"+String.valueOf(dummyid), objname, objvaccine);
                Cork_Vaccine_Application.objClientCollection.add_client(objClient);
                dummyid++;
            }
       }
       catch(Exception e)
       {
           e.printStackTrace();
       }
    }//GEN-LAST:event_DummyjMenuActionPerformed

   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu DummyjMenu;
    private javax.swing.JMenuItem addMenuItem;
    private javax.swing.JMenuItem byIdMenuItem;
    private javax.swing.JMenuItem byvaccineMenuItem;
    private javax.swing.JMenu clientsMenu;
    private javax.swing.JMenu displayMenu;
    private javax.swing.JMenuItem exitMenuItem;
    private javax.swing.JMenu fileMenu;
    private javax.swing.JDesktopPane frmMDI;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JMenuItem removeMenuItem;
    private javax.swing.JMenuItem saveMenuItem;
    private javax.swing.JMenuItem searchMenuItem;
    // End of variables declaration//GEN-END:variables

}
