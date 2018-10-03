/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFileChooser;
import javax.swing.filechooser.*;
import models.Models_bloc;
import views.Views_bloc;
/**
 *
 * @author PC 10
 */
public class Controllers_bloc implements ActionListener{
    private final Models_bloc models_bloc;
    private final Views_bloc views_bloc;
    FileFilter filtro = new FileNameExtensionFilter("Archivos adty","adty");

   
     public Controllers_bloc (Models_bloc models_bloc, Views_bloc views_bloc){
        this.models_bloc = models_bloc;
        this.views_bloc = views_bloc;
        views_bloc.JMI_Read.addActionListener((ActionListener) this);
        views_bloc.JMI_Write.addActionListener((ActionListener) this);
        views_bloc.JMI_Encrypt.addActionListener((ActionListener) this);
        views_bloc.JMI_Decrypt.addActionListener((ActionListener) this);
        initView();
    }
     
      
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==views_bloc.JMI_Read){
            JFileChooser file=new JFileChooser();
            file.addChoosableFileFilter(filtro);
            file.showOpenDialog(null);
            models_bloc.readFile(models_bloc.getPath());      
            views_bloc.JTA_Txt.setText(models_bloc.getMessage());
        }else if(e.getSource()==views_bloc.JMI_Write){
            JFileChooser file=new JFileChooser();
            file.addChoosableFileFilter(filtro);
            file.showSaveDialog(null);
            models_bloc.setPath(""+file.getSelectedFile());
            models_bloc.setMessage(views_bloc.JTA_Txt.getText());
            models_bloc.writeFile(models_bloc.getPath(), models_bloc.getMessage());
        }else if(e.getSource()==views_bloc.JMI_Encrypt){
            JFileChooser file=new JFileChooser();
            file.addChoosableFileFilter(filtro);
            file.showSaveDialog(null);
            models_bloc.setPath(""+file.getSelectedFile());
            models_bloc.setMessage(views_bloc.JTA_Txt.getText());
            models_bloc.writeFileEncrypted(models_bloc.getPath(), models_bloc.getMessage());
        }else if(e.getSource()==views_bloc.JMI_Decrypt){
            JFileChooser file=new JFileChooser();
            file.addChoosableFileFilter(filtro);
            file.showOpenDialog(null);
            models_bloc.readFileDecrypted(models_bloc.getPath());      
            views_bloc.JTA_Txt.setText(models_bloc.getMessage());
        }
    }
     private void initView() {
        views_bloc.setTitle("Block de notas");
        views_bloc.setResizable(false);
        views_bloc.setLocationRelativeTo(null);
        views_bloc.setVisible(true);
    }
}
