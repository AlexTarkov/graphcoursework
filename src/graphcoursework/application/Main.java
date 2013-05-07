/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package graphcoursework.application;

import graphcoursework.components.*;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentListener;
import java.awt.event.ContainerListener;


public class Main extends javax.swing.JFrame {

    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField jTextField1;
    
    public Main() {
        super("Graph Course Work");
        initComponents();
    }
    
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        
        jLabel1.setText("distanse:");
        jButton1.setText("connect");
        jButton2.setText("clear");
        jButton3.setText("tst");
        
        setSize(600, 400);
        jPanel2.setBackground(Color.white);
        
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this.getContentPane());
        this.setLayout(layout);
        
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        
        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 64, Short.MAX_VALUE)
                .addComponent(jButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(jButton3))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
                
        
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonTest(evt);
            }
        });
        
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDelete(evt);
            }
        });
        
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonConnect(evt);
            }
        });
        
        jPanel2.setLayout(null);
        
        //jPanel2.add;
        
        jPanel2.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent e) {
                //System.out.println("mouseClicked - " + e.getButton());
                //System.out.println("mouseClicked - " + e.getX() + " : " + e.getY());
                System.out.println("mouseClicked JPanel2");
                if (e.getButton() == 3) {
                    GraphPointComponent gp = new GraphPointComponent(e.getX(), e.getY());
                    JPanelAddGraphPoint(jPanel2, gp);
                }
                if (e.getButton() == 1) {
                    JPanelDeselectAll(jPanel2);
                }
            }

            @Override
            public void mousePressed(MouseEvent e) {
                System.out.println("mousePressed - " + e.getButton());
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                System.out.println("mouseReleased - " + e.getButton());
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                System.out.println("mouseEntered - " + e.getButton());
            }

            @Override
            public void mouseExited(MouseEvent e) {
                System.out.println("mouseExited - " + e.getButton());
            }
        });
        
    }
    
    private void jButtonTest(java.awt.event.ActionEvent evt) {                                         
        
        //jPanel2.setLayout(null);
        
        System.out.println("jButtonTestClick");
        GraphPointComponent gp = new GraphPointComponent(50, 50);
        gp.setSelect(true);
        Component c = jPanel2.add(gp);
        
        // IT WORK
        //jPanel2.getComponents()[0].setSize(jPanel2.getWidth(), jPanel2.getHeight());
        ////jPanel2.getComponents()[0].setSize(new Dimension(30, 30));
        //jPanel2.getComponents()[0].setLocation(0, 0);
        c.setLocation(gp.getLocation());
        c.setSize(gp.getSize());
        
        //jPanel2.getComponents()[0].setSize(30, 30);
        
        //jPanel2.add(new JButton("test2"));
        jPanel2.repaint();
        System.out.println(jPanel2.getComponentCount());
    }
    
    private void jButtonConnect(java.awt.event.ActionEvent evt) {                                         
        GraphPointComponent g1 = null, g2 = null, gb;
        for (Component cp : jPanel2.getComponents()) {
            if (GraphPointComponent.class.isInstance(cp)) {
                gb = (GraphPointComponent)cp;
                if (gb.getSelect()) {
                    g1 = (g1 == null) ? gb : g1;
                    g2 = ((g2 == null) && (g1 != gb)) ? gb : g2;
                }
            }
        }
        GraphLineComponent gl = new GraphLineComponent(g1, g2);
        JPanelAddGraphLine(jPanel2, gl);
        //jPanel2.repaint();
    }
    
    private void jButtonDelete(java.awt.event.ActionEvent evt) {                                         
        jPanel2.removeAll();
        jPanel2.repaint();
    }
    
    public static void main(String[] args) {
        new Main().setVisible(true);
    }
    
    private void JPanelAddGraphPoint(JPanel jp, GraphPointComponent gp) {
        System.out.println("JPanelAddGraphPoint");
        Component cp = jp.add(gp);
        cp.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent e) {
                GraphPointComponent gp = (GraphPointComponent)e.getSource();
                Container parent = gp.getParent();
                System.out.println("ComponentClick!!!");
                if (e.getButton() == 1) {
                    gp.changeSelect();
                }
                if (e.getButton() == 3) {
                    gp.remove();
                }
                parent.repaint();
            }

            @Override
            public void mousePressed(MouseEvent e) {
                //System.out.println("mousePressed - " + e.getButton());
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                //System.out.println("mouseReleased - " + e.getButton());
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                //System.out.println("mouseEntered - " + e.getButton());
            }

            @Override
            public void mouseExited(MouseEvent e) {
                //System.out.println("mouseExited - " + e.getButton());
            }
        });
        cp.setLocation(gp.getLocation());
        cp.setSize(gp.getSize());
        jp.repaint();
    }
    
    private void JPanelAddGraphLine(JPanel jp, GraphLineComponent gl) {
        System.out.println("JPanelAddGraphLine");
        Component cp = jp.add(gl);
        cp.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println("ComponentLineClick");
            }

            @Override
            public void mousePressed(MouseEvent e) {
                //System.out.println("mousePressed - " + e.getButton());
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                //System.out.println("mouseReleased - " + e.getButton());
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                //System.out.println("mouseEntered - " + e.getButton());
            }

            @Override
            public void mouseExited(MouseEvent e) {
                //System.out.println("mouseExited - " + e.getButton());
            }
        });
        cp.setLocation(gl.getLocation());
        cp.setSize(gl.getSize());
        System.out.println(gl.getSize());
        jp.repaint();
    }
    
    private void JPanelDeselectAll(JPanel jp) {
        GraphPointComponent gp;
        for (Component cp : jp.getComponents()) {
            if (GraphPointComponent.class.isInstance(cp)) {
                gp = (GraphPointComponent)cp;
                gp.setSelect(false);
            }
        }
        jp.repaint();
    }
    
}
