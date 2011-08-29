/*
 * DataBaseWriterUIMAINView.java
 */

package databasewriteruimain;

import org.jdesktop.application.Action;
import org.jdesktop.application.ResourceMap;
import org.jdesktop.application.SingleFrameApplication;
import org.jdesktop.application.FrameView;
import org.jdesktop.application.TaskMonitor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;
import javax.swing.Icon;
import javax.swing.JDialog;
import javax.swing.JFrame;
import java.io.*;
import java.util.*;

/**
 * The application's main frame.
 */
public class DataBaseWriterUIMAINView extends FrameView {

    public DataBaseWriterUIMAINView(SingleFrameApplication app) {
        super(app);

        initComponents();

        // status bar initialization - message timeout, idle icon and busy animation, etc
       
    }


    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainPanel = new javax.swing.JPanel();
        panel_files = new javax.swing.JPanel();
        label_destination = new javax.swing.JLabel();
        text_destination = new javax.swing.JTextField();
        label_source = new javax.swing.JLabel();
        text_source = new javax.swing.JTextField();
        button_source_browse = new javax.swing.JButton();
        button_destination_browse = new javax.swing.JButton();
        tabbedPane_main = new javax.swing.JTabbedPane();
        panel_operations = new javax.swing.JPanel();
        button_run = new javax.swing.JButton();
        panel_progress = new javax.swing.JPanel();
        scroll_progress = new javax.swing.JScrollPane();
        textarea_progress = new javax.swing.JTextArea();
        button_progress_clear = new javax.swing.JButton();
        dialog_file = new javax.swing.JFileChooser();

        mainPanel.setMaximumSize(mainPanel.getPreferredSize());
        mainPanel.setName("mainPanel"); // NOI18N
        mainPanel.setPreferredSize(new java.awt.Dimension(626, 480));

        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(databasewriteruimain.DataBaseWriterUIMAINApp.class).getContext().getResourceMap(DataBaseWriterUIMAINView.class);
        panel_files.setBorder(javax.swing.BorderFactory.createTitledBorder(resourceMap.getString("panel_files.border.title"))); // NOI18N
        panel_files.setName("panel_files"); // NOI18N

        label_destination.setText(resourceMap.getString("label_destination.text")); // NOI18N
        label_destination.setName("label_destination"); // NOI18N

        text_destination.setName("text_destination"); // NOI18N

        label_source.setText(resourceMap.getString("label_source.text")); // NOI18N
        label_source.setName("label_source"); // NOI18N

        text_source.setName("text_source"); // NOI18N

        button_source_browse.setText(resourceMap.getString("button_source_browse.text")); // NOI18N
        button_source_browse.setName("button_source_browse"); // NOI18N
        button_source_browse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_source_browseActionPerformed(evt);
            }
        });

        button_destination_browse.setText(resourceMap.getString("button_destination_browse.text")); // NOI18N
        button_destination_browse.setName("button_destination_browse"); // NOI18N
        button_destination_browse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_destination_browseActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panel_filesLayout = new javax.swing.GroupLayout(panel_files);
        panel_files.setLayout(panel_filesLayout);
        panel_filesLayout.setHorizontalGroup(
            panel_filesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_filesLayout.createSequentialGroup()
                .addGroup(panel_filesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel_filesLayout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(label_source)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(text_source, javax.swing.GroupLayout.PREFERRED_SIZE, 398, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panel_filesLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(label_destination)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(text_destination, javax.swing.GroupLayout.DEFAULT_SIZE, 398, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panel_filesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(button_source_browse, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(button_destination_browse, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        panel_filesLayout.setVerticalGroup(
            panel_filesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_filesLayout.createSequentialGroup()
                .addGroup(panel_filesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(label_source)
                    .addComponent(text_source, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(button_source_browse))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panel_filesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(label_destination)
                    .addComponent(text_destination, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(button_destination_browse))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tabbedPane_main.setName("tabbedPane_main"); // NOI18N

        panel_operations.setName("panel_operations"); // NOI18N

        button_run.setBackground(resourceMap.getColor("button_run.background")); // NOI18N
        button_run.setFont(resourceMap.getFont("button_run.font")); // NOI18N
        button_run.setForeground(resourceMap.getColor("button_run.foreground")); // NOI18N
        button_run.setText(resourceMap.getString("button_run.text")); // NOI18N
        button_run.setName("button_run"); // NOI18N
        button_run.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_runActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panel_operationsLayout = new javax.swing.GroupLayout(panel_operations);
        panel_operations.setLayout(panel_operationsLayout);
        panel_operationsLayout.setHorizontalGroup(
            panel_operationsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_operationsLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(button_run, javax.swing.GroupLayout.DEFAULT_SIZE, 581, Short.MAX_VALUE)
                .addContainerGap())
        );
        panel_operationsLayout.setVerticalGroup(
            panel_operationsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_operationsLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(button_run, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tabbedPane_main.addTab(resourceMap.getString("panel_operations.TabConstraints.tabTitle"), panel_operations); // NOI18N

        panel_progress.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), resourceMap.getString("panel_progress.border.title"))); // NOI18N
        panel_progress.setFocusable(false);
        panel_progress.setName("panel_progress"); // NOI18N

        scroll_progress.setName("scroll_progress"); // NOI18N

        textarea_progress.setColumns(20);
        textarea_progress.setRows(5);
        textarea_progress.setName("textarea_progress"); // NOI18N
        scroll_progress.setViewportView(textarea_progress);

        button_progress_clear.setText(resourceMap.getString("button_progress_clear.text")); // NOI18N
        button_progress_clear.setName("button_progress_clear"); // NOI18N
        button_progress_clear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_progress_clearActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panel_progressLayout = new javax.swing.GroupLayout(panel_progress);
        panel_progress.setLayout(panel_progressLayout);
        panel_progressLayout.setHorizontalGroup(
            panel_progressLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_progressLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel_progressLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(scroll_progress, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 574, Short.MAX_VALUE)
                    .addComponent(button_progress_clear, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 574, Short.MAX_VALUE))
                .addContainerGap())
        );
        panel_progressLayout.setVerticalGroup(
            panel_progressLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_progressLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(scroll_progress, javax.swing.GroupLayout.DEFAULT_SIZE, 209, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(button_progress_clear)
                .addContainerGap())
        );

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tabbedPane_main, javax.swing.GroupLayout.DEFAULT_SIZE, 606, Short.MAX_VALUE)
                    .addComponent(panel_files, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panel_progress, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panel_files, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tabbedPane_main, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panel_progress, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        dialog_file.setApproveButtonText(resourceMap.getString("dialog_file.approveButtonText")); // NOI18N
        dialog_file.setBackground(resourceMap.getColor("dialog_file.background")); // NOI18N
        dialog_file.setDialogTitle(resourceMap.getString("dialog_file.dialogTitle")); // NOI18N
        dialog_file.setName("dialog_file"); // NOI18N
        dialog_file.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dialog_fileActionPerformed(evt);
            }
        });

        setComponent(mainPanel);
    }// </editor-fold>//GEN-END:initComponents
//C:\Users\Thomas Ibarra\Documents\NetBeansProjects\AlbumWriter1\dist\test.dat

    private void button_runActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_runActionPerformed
        textarea_progress.setText("\n");
        textarea_progress.append("Beginning Process.\n");
        try{
            textarea_progress.setText("\n");
            textarea_progress.append("Beginning Process.\n");
            BufferedReader dataInput = new BufferedReader(new InputStreamReader(new DataInputStream(new FileInputStream(new File(text_source.getText())))));
            PrintWriter dataOutput = new PrintWriter(new File(text_destination.getText()));


            ArrayList rawInput = new ArrayList(0);
            try{
                String dataOnInput;
                while((dataOnInput = dataInput.readLine()) != null) {
                    String buffer = dataOnInput;
                    rawInput.add(buffer);
                    textarea_progress.append("Read Line: " + buffer + "\n");
                }
            } catch(Exception e){
                textarea_progress.append("Read Failure.\n");
                textarea_progress.append(e.getMessage()+"\n");
            }
            
            dataInput.close();
            textarea_progress.append("Input Closed. \n");
            ArrayList bufferedInput = new ArrayList(0);

            for(int i = 0; i < rawInput.size(); i++){
                bufferedInput.add(rawInput.get(i));
                textarea_progress.append("Adding Line [" + i + "] to buffer." + "\n");
            }

            textarea_progress.append("\n\nBegin Duplicate Check.  (Pass 1)\n\n\n");

            for(int i = 0; i < rawInput.size(); i++){

                textarea_progress.append("Starting Duplicate Check: Line [" + i + "]." + "\n");

                for(int j = 0; j < bufferedInput.size(); j++){
                    if(j != i){
                        StringTokenizer strknRaw = new StringTokenizer(String.valueOf(rawInput.get(i)));
                        StringTokenizer strknBuf = new StringTokenizer(String.valueOf(bufferedInput.get(j)));
                        boolean isAStupidCopy = false;
                        if(strknBuf.countTokens() > 1){
                            if(strknRaw.nextToken().equalsIgnoreCase(strknBuf.nextToken()) && strknRaw.nextToken().equalsIgnoreCase(strknBuf.nextToken())){
                                bufferedInput.remove(j);
                                rawInput.remove(j);
                                isAStupidCopy = true;
                                textarea_progress.append("Duplicate Removed: Buffer Line [" + j + "]" + "\n");
                            }
                        }else if(strknRaw.nextToken().equalsIgnoreCase(strknBuf.nextToken())){
                                bufferedInput.remove(j);
                                rawInput.remove(j);
                                isAStupidCopy = true;
                                textarea_progress.append("Duplicate Removed: Buffer Line [" + j + "]" + "\n");
                        }
                        else {
                            isAStupidCopy = false;
                        }
                        
                    }
                }
                textarea_progress.append("Duplicate Check on Line [" + i + "] complete." + "\n");
            }

            textarea_progress.append("\n\nBegin Duplicate Check.  (Pass 2)\n\n\n");

            for(int i = 0; i < rawInput.size(); i++){

                textarea_progress.append("Starting Duplicate Check: Line [" + i + "]." + "\n");

                for(int j = 0; j < bufferedInput.size(); j++){
                    if(j != i){
                        StringTokenizer strknRaw = new StringTokenizer(String.valueOf(rawInput.get(i)));
                        StringTokenizer strknBuf = new StringTokenizer(String.valueOf(bufferedInput.get(j)));
                        boolean isAStupidCopy = false;
                        if(strknBuf.countTokens() > 1){
                            if(strknRaw.nextToken().equalsIgnoreCase(strknBuf.nextToken()) && strknRaw.nextToken().equalsIgnoreCase(strknBuf.nextToken())){
                                bufferedInput.remove(j);
                                rawInput.remove(j);
                                isAStupidCopy = true;
                                textarea_progress.append("Duplicate Removed: Buffer Line [" + j + "]" + "\n");
                            }
                        }else if(strknRaw.nextToken().equalsIgnoreCase(strknBuf.nextToken())){
                                bufferedInput.remove(j);
                                rawInput.remove(j);
                                isAStupidCopy = true;
                                textarea_progress.append("Duplicate Removed: Buffer Line [" + j + "]" + "\n");
                        }
                        else {
                            isAStupidCopy = false;
                        }

                    }
                }
                textarea_progress.append("Duplicate Check on Line [" + i + "] complete." + "\n");
            }

            textarea_progress.append("\n\nBegin Duplicate Check.  (Pass 3)\n\n\n");

            for(int i = 0; i < rawInput.size(); i++){

                textarea_progress.append("Starting Duplicate Check: Line [" + i + "]." + "\n");

                for(int j = 0; j < bufferedInput.size(); j++){
                    if(j != i){
                        StringTokenizer strknRaw = new StringTokenizer(String.valueOf(rawInput.get(i)));
                        StringTokenizer strknBuf = new StringTokenizer(String.valueOf(bufferedInput.get(j)));
                        boolean isAStupidCopy = false;
                        if(strknBuf.countTokens() > 1){
                            if(strknRaw.nextToken().equalsIgnoreCase(strknBuf.nextToken()) && strknRaw.nextToken().equalsIgnoreCase(strknBuf.nextToken())){
                                bufferedInput.remove(j);
                                rawInput.remove(j);
                                isAStupidCopy = true;
                                textarea_progress.append("Duplicate Removed: Buffer Line [" + j + "]" + "\n");
                            }
                        }else if(strknRaw.nextToken().equalsIgnoreCase(strknBuf.nextToken())){
                                bufferedInput.remove(j);
                                rawInput.remove(j);
                                isAStupidCopy = true;
                                textarea_progress.append("Duplicate Removed: Buffer Line [" + j + "]" + "\n");
                        }
                        else {
                            isAStupidCopy = false;
                        }

                    }
                }
                textarea_progress.append("Duplicate Check on Line [" + i + "] complete." + "\n");
            }
            
            textarea_progress.append("Begin File Write." + "\n");


            for(int i = 0; i < bufferedInput.size(); i++){
                dataOutput.println(bufferedInput.get(i));
                textarea_progress.append("Line [" + i +"] Successfully Printed. " + "\n");
            }
            
            dataOutput.close();
            textarea_progress.append("File Closed.\n");

            textarea_progress.append("Process Completed. \n\n");
        } catch(Exception e){
            textarea_progress.append("Process Failed.\n\n");
            textarea_progress.append(e.getMessage()+"\n\n");
        }
    }//GEN-LAST:event_button_runActionPerformed

    private void button_progress_clearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_progress_clearActionPerformed
        textarea_progress.setText("");
    }//GEN-LAST:event_button_progress_clearActionPerformed

    private void dialog_fileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dialog_fileActionPerformed
        if(dialog_file.getDialogType() == dialog_file.SAVE_DIALOG){
            text_destination.setText(dialog_file.getSelectedFile().getPath());
        } else if(dialog_file.getDialogType() == dialog_file.OPEN_DIALOG){
            text_source.setText(dialog_file.getSelectedFile().getPath());
        } else { /* wtf */ }
    }//GEN-LAST:event_dialog_fileActionPerformed

    private void button_source_browseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_source_browseActionPerformed
       dialog_file.showOpenDialog(mainPanel);
    }//GEN-LAST:event_button_source_browseActionPerformed

    private void button_destination_browseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_destination_browseActionPerformed
        dialog_file.showSaveDialog(mainPanel);
    }//GEN-LAST:event_button_destination_browseActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton button_destination_browse;
    private javax.swing.JButton button_progress_clear;
    private javax.swing.JButton button_run;
    private javax.swing.JButton button_source_browse;
    private javax.swing.JFileChooser dialog_file;
    private javax.swing.JLabel label_destination;
    private javax.swing.JLabel label_source;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JPanel panel_files;
    private javax.swing.JPanel panel_operations;
    private javax.swing.JPanel panel_progress;
    private javax.swing.JScrollPane scroll_progress;
    private javax.swing.JTabbedPane tabbedPane_main;
    private javax.swing.JTextField text_destination;
    private javax.swing.JTextField text_source;
    private javax.swing.JTextArea textarea_progress;
    // End of variables declaration//GEN-END:variables


}
