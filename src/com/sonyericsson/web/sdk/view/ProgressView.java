/* License (MIT)
 * Copyright 2009 Sony Ericsson Mobile Communications AB
 * website: http://developer.sonyericsson.com/
 * Permission is hereby granted, free of charge, to any person obtaining
 * a copy of this software and associated documentation files (the
 * Software), to deal in the Software without restriction, including
 * without limitation the rights to use, copy, modify, merge, publish,
 * distribute, sublicense, and/or sell copies of the Software, and to
 * permit persons to whom the Software is furnished to do so, subject to
 * the following conditions:
 *
 * The above copyright notice and this permission notice shall be
 * included in all copies or substantial portions of the Software.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
 * EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF
 * MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 * NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE
 * LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION
 * OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION
 * WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package com.sonyericsson.web.sdk.view;

import com.sonyericsson.web.sdk.view.dialog.DialogListener;
import java.awt.Frame;
import java.util.Enumeration;

import javax.swing.JDialog;

import org.jdesktop.application.Action;

import com.sonyericsson.web.sdk.model.ApplicationModel;
import com.sonyericsson.web.sdk.model.Event;
import com.sonyericsson.web.sdk.model.ModelListener;
import com.sonyericsson.web.sdk.model.Prompt;
import com.sonyericsson.web.sdk.model.PromptListener;
import com.sonyericsson.web.sdk.model.Settings;
import com.sonyericsson.web.sdk.resources.Config;
import com.sonyericsson.web.sdk.resources.Resources;
import com.sun.awt.AWTUtilities;

/**
 * activity indicator for long-time operations 
 */
public class ProgressView extends JDialog implements ModelListener, PromptListener, DialogListener {

  private Prompt prompt;
  private PromptDialog passwordDialog;
  private String platform;
  private String divider;
  private String action;

  /** Creates new form ProgressView */
  public ProgressView(Frame parent, Enumeration<ApplicationModel> applicationModels, String information, Settings settings) {
    super(parent, Config.NAME, true);
    setUndecorated(true);
    try {
      AWTUtilities.setWindowOpaque(this, false);
    } catch (Throwable t) {
    }
    while (applicationModels.hasMoreElements()) {
      ApplicationModel applicationModel = applicationModels.nextElement();
      applicationModel.addListener(this);
      applicationModel.setPromptListener(this);
    }
    initComponents();
    setIconImage(Resources.getLogo());
    platformLabel.setText(information);
    progressScrollPane.setVisible(false);
    setSize(800, 200);
    setLocation(parent.getX() + (parent.getWidth() - getWidth()) / 2, parent.getY() + (parent.getHeight() - 700) / 2);
  }

  /** This method is called from within the constructor to
   * initialize the form.
   * WARNING: Do NOT modify this code. The content of this method is
   * always regenerated by the Form Editor.
   */
  @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {

    roundedRectanglePanel1 = new com.sonyericsson.web.sdk.view.panel.RoundedRectanglePanel();
    containerPanel = new javax.swing.JPanel();
    mainPanel = new javax.swing.JPanel();
    progressPanel = new javax.swing.JPanel();
    platformLabel = new javax.swing.JLabel();
    progressBar = new javax.swing.JProgressBar();
    jToggleButton1 = new javax.swing.JToggleButton();
    progressScrollPane = new javax.swing.JScrollPane();
    progressTextArea = new javax.swing.JTextArea();
    buttonPanel = new javax.swing.JPanel();
    closeButton = new javax.swing.JButton();
    jSeparator1 = new javax.swing.JSeparator();

    setMinimumSize(new java.awt.Dimension(400, 50));
    setName("Form"); // NOI18N

    roundedRectanglePanel1.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));
    roundedRectanglePanel1.setName("roundedRectanglePanel1"); // NOI18N
    roundedRectanglePanel1.setLayout(new java.awt.BorderLayout());

    containerPanel.setName("containerPanel"); // NOI18N
    containerPanel.setOpaque(false);
    containerPanel.setLayout(new java.awt.BorderLayout());

    mainPanel.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 5, 5));
    mainPanel.setMinimumSize(new java.awt.Dimension(110, 110));
    mainPanel.setName("mainPanel"); // NOI18N
    mainPanel.setOpaque(false);
    mainPanel.setPreferredSize(new java.awt.Dimension(110, 110));
    mainPanel.setLayout(new java.awt.BorderLayout());

    progressPanel.setName("progressPanel"); // NOI18N
    progressPanel.setOpaque(false);
    progressPanel.setLayout(new java.awt.BorderLayout());

    org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(com.sonyericsson.web.sdk.controller.WebSDK.class).getContext().getResourceMap(ProgressView.class);
    platformLabel.setFont(resourceMap.getFont("platformLabel.font")); // NOI18N
    platformLabel.setText(resourceMap.getString("platformLabel.text")); // NOI18N
    platformLabel.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 5, 5));
    platformLabel.setName("platformLabel"); // NOI18N
    progressPanel.add(platformLabel, java.awt.BorderLayout.PAGE_START);

    progressBar.setForeground(resourceMap.getColor("progressBar.foreground")); // NOI18N
    progressBar.setToolTipText(resourceMap.getString("progressBar.toolTipText")); // NOI18N
    progressBar.setName("progressBar"); // NOI18N
    progressPanel.add(progressBar, java.awt.BorderLayout.CENTER);

    mainPanel.add(progressPanel, java.awt.BorderLayout.PAGE_START);

    javax.swing.ActionMap actionMap = org.jdesktop.application.Application.getInstance(com.sonyericsson.web.sdk.controller.WebSDK.class).getContext().getActionMap(ProgressView.class, this);
    jToggleButton1.setAction(actionMap.get("toggleProgressTextArea")); // NOI18N
    jToggleButton1.setIcon(resourceMap.getIcon("jToggleButton1.icon")); // NOI18N
    jToggleButton1.setText(resourceMap.getString("jToggleButton1.text")); // NOI18N
    jToggleButton1.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 0, 10, 0));
    jToggleButton1.setBorderPainted(false);
    jToggleButton1.setContentAreaFilled(false);
    jToggleButton1.setFocusPainted(false);
    jToggleButton1.setName("jToggleButton1"); // NOI18N
    jToggleButton1.setRolloverIcon(resourceMap.getIcon("jToggleButton1.rolloverIcon")); // NOI18N
    jToggleButton1.setRolloverSelectedIcon(resourceMap.getIcon("jToggleButton1.rolloverSelectedIcon")); // NOI18N
    jToggleButton1.setSelectedIcon(resourceMap.getIcon("jToggleButton1.selectedIcon")); // NOI18N
    mainPanel.add(jToggleButton1, java.awt.BorderLayout.LINE_END);

    containerPanel.add(mainPanel, java.awt.BorderLayout.PAGE_START);

    progressScrollPane.setBackground(resourceMap.getColor("progressScrollPane.background")); // NOI18N
    progressScrollPane.setBorder(null);
    progressScrollPane.setViewportBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 5, 5));
    progressScrollPane.setName("progressScrollPane"); // NOI18N

    progressTextArea.setColumns(20);
    progressTextArea.setRows(5);
    progressTextArea.setToolTipText(resourceMap.getString("progressTextArea.toolTipText")); // NOI18N
    progressTextArea.setBorder(null);
    progressTextArea.setName("progressTextArea"); // NOI18N
    progressScrollPane.setViewportView(progressTextArea);

    containerPanel.add(progressScrollPane, java.awt.BorderLayout.CENTER);

    roundedRectanglePanel1.add(containerPanel, java.awt.BorderLayout.CENTER);

    buttonPanel.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 5, 5));
    buttonPanel.setName("buttonPanel"); // NOI18N
    buttonPanel.setOpaque(false);
    buttonPanel.setLayout(new java.awt.BorderLayout());

    closeButton.setAction(actionMap.get("finnished")); // NOI18N
    closeButton.setIcon(resourceMap.getIcon("closeButton.icon")); // NOI18N
    closeButton.setText(resourceMap.getString("closeButton.text")); // NOI18N
    closeButton.setBorder(null);
    closeButton.setBorderPainted(false);
    closeButton.setContentAreaFilled(false);
    closeButton.setFocusPainted(false);
    closeButton.setName("closeButton"); // NOI18N
    closeButton.setRolloverIcon(resourceMap.getIcon("closeButton.rolloverIcon")); // NOI18N
    buttonPanel.add(closeButton, java.awt.BorderLayout.LINE_END);

    jSeparator1.setName("jSeparator1"); // NOI18N
    buttonPanel.add(jSeparator1, java.awt.BorderLayout.PAGE_START);

    roundedRectanglePanel1.add(buttonPanel, java.awt.BorderLayout.PAGE_END);

    getContentPane().add(roundedRectanglePanel1, java.awt.BorderLayout.CENTER);

    pack();
  }// </editor-fold>//GEN-END:initComponents
  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JPanel buttonPanel;
  private javax.swing.JButton closeButton;
  private javax.swing.JPanel containerPanel;
  private javax.swing.JSeparator jSeparator1;
  private javax.swing.JToggleButton jToggleButton1;
  private javax.swing.JPanel mainPanel;
  private javax.swing.JLabel platformLabel;
  private javax.swing.JProgressBar progressBar;
  private javax.swing.JPanel progressPanel;
  private javax.swing.JScrollPane progressScrollPane;
  private javax.swing.JTextArea progressTextArea;
  private com.sonyericsson.web.sdk.view.panel.RoundedRectanglePanel roundedRectanglePanel1;
  // End of variables declaration//GEN-END:variables

  @Override
  public void changed(Event event) {
    String message = event.getMessage();
    int progress = event.getProgress();
    if (platform == null || !platform.equals(event.getPlatform())) {
      platform = event.getPlatform();
      divider = " ======== ";
      progressTextArea.append(divider + platform + divider + "\n");
    }
    if (action == null || !action.equals(event.getAction())) {
      action = event.getAction();
      progressTextArea.append(action + "\n");
      progressBar.setStringPainted(true);
      progressBar.setString(action);
    }
    if (message != null) {
      progressTextArea.append(message + "\n");
    }
    progressBar.setValue(progress);
    platformLabel.setText(platform);
  }

  @Action
  public void toggleProgressTextArea() {
    System.out.println("toggleProgressTextArea");
    boolean visible = progressScrollPane.isVisible();
    System.out.println(visible);
    progressScrollPane.setVisible(!visible);
    if (visible) {
      setSize(800, 200);
    } else {
      setSize(800, 700);
    }
  }

  public void prompt(Prompt prompt) {
    System.out.println("prompt");
    this.prompt = prompt;
    passwordDialog = new PromptDialog(this, prompt.getTitle(), prompt.getInformation(), prompt.getValue(), true);
    passwordDialog.setDialogListener(this);
    passwordDialog.setVisible(true);
  }

  public void ok() {
    prompt.setValue(passwordDialog.getValue());
    prompt.finished();
  }

  public void cancel() {
    prompt.finished();
  }
}
