/*
 * Shane Smyth
 * Manage Entries GUI - search, show and delete
 */
package wellbuddymentalhealth;

// ArrayList is a list that can grow
import java.util.ArrayList;
// JOptionPane shows popup messages
import javax.swing.JOptionPane;

public class GUI_ManageEntries extends javax.swing.JFrame {
    
    public GUI_ManageEntries() {
        // builds the buttons and labels
        initComponents();
        // show how many entries are saved
        ArrayList<MoodEntry> list =
            // getManager is the shared manager
            MentalHealthData.getManager()
                // getEntries returns every entry
                .getEntries();
        // setText changes the label on screen
        lblStatus.setText("Entries: "
            // size() is the number of entries
            + list.size());
    }

    // show a list of entries in one message
    private void showEntries(
            ArrayList<MoodEntry> list) {
        // setText updates the count label
        lblStatus.setText("Entries: "
            // size() is how many we were given
            + list.size());
        // .isEmpty is the same as == 0 means the list is empty
        if (list.isEmpty()) {
            // a popup to tell the user
            JOptionPane.showMessageDialog(
                this, "There are no entries.");
            // return stops the method here
            return;
        }
        // build one string for the dialog
        // start with an empty string
        String text = "";
        // index loop, one entry at a time
        for (int i = 0; i < list.size(); i++) {
            // get(i) takes the entry at index i
            MoodEntry e = list.get(i);
            // getSummary is overridden
            // in StressMoodEntry
            // so stress entries show their score
            // (this is polymorphism)
            text = text + e.getSummary();
            // \n starts a new line in the popup
            text = text + "\n";
        }
        // one popup shows the whole list
        JOptionPane.showMessageDialog(
            this, text);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        lblAppTitle = new javax.swing.JLabel();
        lblSectionTitle = new javax.swing.JLabel();
        lblPreview = new javax.swing.JLabel();
        lblSearchDate = new javax.swing.JLabel();
        lblStatus = new javax.swing.JLabel();
        lblHint = new javax.swing.JLabel();
        btnSearch = new javax.swing.JButton();
        btnShowAll = new javax.swing.JButton();
        btnDeleteEntry = new javax.swing.JButton();
        btnRecordMood = new javax.swing.JButton();
        btnMentalHealthMenu = new javax.swing.JButton();
        btnMainMenu = new javax.swing.JButton();
        txtSearchDate = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("WellBuddy - Manage Entries");
        lblAppTitle.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        lblAppTitle.setText("WellBuddy");
        lblSectionTitle.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        lblSectionTitle.setText("Manage Entries");
        lblPreview.setFont(new java.awt.Font("Helvetica Neue", 0, 12)); // NOI18N
        lblPreview.setText("Search, view or delete your mood entries.");
        lblSearchDate.setFont(new java.awt.Font("Helvetica Neue", 0, 12)); // NOI18N
        lblSearchDate.setText("Search date (DD/MM/YYYY)");
        lblStatus.setFont(new java.awt.Font("Helvetica Neue", 0, 12)); // NOI18N
        lblStatus.setText("Entries");
        lblHint.setFont(new java.awt.Font("Helvetica Neue", 0, 12)); // NOI18N
        lblHint.setText("Type a date, then Search or Delete.");
        btnSearch.setText("Search");
        btnSearch.addActionListener(this::btnSearchActionPerformed);
        btnShowAll.setText("Show All");
        btnShowAll.addActionListener(this::btnShowAllActionPerformed);
        btnDeleteEntry.setText("Delete Entry");
        btnDeleteEntry.addActionListener(this::btnDeleteEntryActionPerformed);
        btnRecordMood.setText("Record Mood");
        btnRecordMood.addActionListener(this::btnRecordMoodActionPerformed);
        btnMentalHealthMenu.setText("Mental Health Menu");
        btnMentalHealthMenu.addActionListener(this::btnMentalHealthMenuActionPerformed);
        btnMainMenu.setText("Main Menu");
        btnMainMenu.addActionListener(this::btnMainMenuActionPerformed);
        txtSearchDate.addActionListener(this::txtSearchDateActionPerformed);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
            .addGap(24, 24, 24)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblAppTitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(lblSectionTitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(lblPreview, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(lblSearchDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(layout.createSequentialGroup()
            .addComponent(txtSearchDate, javax.swing.GroupLayout.PREFERRED_SIZE, 240, Short.MAX_VALUE)
            .addGap(12, 12, 12)
            .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(8, 8, 8)
            .addComponent(btnShowAll, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(lblStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 600, Short.MAX_VALUE)
            .addComponent(lblHint, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(layout.createSequentialGroup()
            .addComponent(btnRecordMood, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(24, 24, Short.MAX_VALUE)
            .addComponent(btnDeleteEntry, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
            .addComponent(btnMentalHealthMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(24, 24, Short.MAX_VALUE)
            .addComponent(btnMainMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addGap(24, 24, 24)));
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
            .addGap(20, 20, 20)
            .addComponent(lblAppTitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(6, 6, 6)
            .addComponent(lblSectionTitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(8, 8, 8)
            .addComponent(lblPreview, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(26, 26, 26)
            .addComponent(lblSearchDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(8, 8, 8)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
            .addComponent(txtSearchDate, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(btnShowAll, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGap(16, 16, 16)
            .addComponent(lblStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(12, 12, 12)
            .addComponent(lblHint, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(12, 12, 12)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
            .addComponent(btnRecordMood, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(btnDeleteEntry, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGap(20, 20, 20)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
            .addComponent(btnMentalHealthMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(btnMainMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGap(20, 20, 20)));
        pack();
    }// </editor-fold>//GEN-END:initComponents

    // button for search
    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        // get the date from the text box
        // getText() reads what the user typed
        String date = txtSearchDate.getText();
        // .equals compares Strings, not ==
        if (date.equals("")) {
            // "" means they typed nothing
            JOptionPane.showMessageDialog(
                this, "Type a date to search for.");
            // return stops the method here
            return;
        }
        // all is every saved entry
        ArrayList<MoodEntry> all =
            MentalHealthData.getManager()
                .getEntries();
        ArrayList<MoodEntry> found =
            // empty list to hold the matches
            new ArrayList<>();
        // linear search through the list
        // index loop, one entry at a time
        for (int i = 0; i < all.size(); i++) {
            // get(i) is the entry at position i
            MoodEntry e = all.get(i);
            // .equals compares the two dates
            if (e.getDate().equals(date)) {
                // add puts the match into found
                found.add(e);
            }
        }
        // .isEmpty is the same == 0 means nothing matched
        if (found.isEmpty()) {
            JOptionPane.showMessageDialog(
                this, "No entries found for "
                + date + ".");
            // leave here, do not show a list
            return;
        }
        // show only the matching entries
        showEntries(found);
    }//GEN-LAST:event_btnSearchActionPerformed

    // button for show all
    private void btnShowAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnShowAllActionPerformed
        // setText("") clears the search box
        txtSearchDate.setText("");
        // show every saved entry again
        showEntries(MentalHealthData
            .getManager().getEntries());
    }//GEN-LAST:event_btnShowAllActionPerformed

    // button for delete entry
    private void btnDeleteEntryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteEntryActionPerformed
        // use the search box, or ask for a date
        // getText() reads the search box
        String date = txtSearchDate.getText();
        // empty box, so ask in a popup
        if (date.equals("")) {
            date = JOptionPane.showInputDialog(
                this, "Enter the date to delete");
        }
        // Cancel on a dialog returns null
        if (date == null) {
            // stop, do not delete anything
            return;
        }
        // they pressed OK with no date
        if (date.equals("")) {
            JOptionPane.showMessageDialog(
                this, "Type a date to delete.");
            return;
        }
        ArrayList<MoodEntry> list =
            MentalHealthData.getManager()
                .getEntries();
        // find the first entry on that date
        // null means we have not found one yet
        MoodEntry entry = null;
        // index loop, one entry at a time
        for (int i = 0; i < list.size(); i++) {
            MoodEntry e = list.get(i);
            // still looking for the first match
            if (entry == null
                    // .equals compares the dates
                    && e.getDate().equals(date)) {
                // keep this one as the match
                entry = e;
            }
        }
        // still null, so nothing matched
        if (entry == null) {
            JOptionPane.showMessageDialog(
                this, "No entry found for "
                + date + ".");
            return;
        }
        // confirm before it is removed
        String ans =
            JOptionPane.showInputDialog(
                this, "Type yes to delete");
        // Cancel was pressed, ans is null
        if (ans == null) {
            return;
        }
        // ignores capitals, e.g. Yes or YES
        if (ans.equalsIgnoreCase("yes")) {
            MentalHealthData.getManager()
                .removeEntry(entry);
            // takes it out of the ArrayList
            // and saves the file
            JOptionPane.showMessageDialog(
                this, "Entry deleted.");
            // get the list after the delete
            ArrayList<MoodEntry> left =
                MentalHealthData.getManager()
                    .getEntries();
            // update the count on the label
            lblStatus.setText("Entries: "
                + left.size());
        }
    }//GEN-LAST:event_btnDeleteEntryActionPerformed

    // button for record mood
    private void btnRecordMoodActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRecordMoodActionPerformed
        GUI_RecordMood nextScreen = new GUI_RecordMood();
        nextScreen.setLocationRelativeTo(this);
        nextScreen.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnRecordMoodActionPerformed

    // button to mental health menu
    private void btnMentalHealthMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMentalHealthMenuActionPerformed
        GUI_MoodManager nextScreen = new GUI_MoodManager();
        nextScreen.setLocationRelativeTo(this);
        nextScreen.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnMentalHealthMenuActionPerformed

    // button to main menu
    private void btnMainMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMainMenuActionPerformed
        wellbuddy.GUI_Home nextScreen = new wellbuddy.GUI_Home();
        nextScreen.setLocationRelativeTo(this);
        nextScreen.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnMainMenuActionPerformed

    // search date
    private void txtSearchDateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSearchDateActionPerformed
        // Enter in the box runs the search
        // this calls the Search button method
        btnSearchActionPerformed(evt);
    }//GEN-LAST:event_txtSearchDateActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDeleteEntry;
    private javax.swing.JButton btnMainMenu;
    private javax.swing.JButton btnMentalHealthMenu;
    private javax.swing.JButton btnRecordMood;
    private javax.swing.JButton btnSearch;
    private javax.swing.JButton btnShowAll;
    private javax.swing.JLabel lblAppTitle;
    private javax.swing.JLabel lblHint;
    private javax.swing.JLabel lblPreview;
    private javax.swing.JLabel lblSearchDate;
    private javax.swing.JLabel lblSectionTitle;
    private javax.swing.JLabel lblStatus;
    private javax.swing.JTextField txtSearchDate;
    // End of variables declaration//GEN-END:variables
}
