/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package graphcoursework.application;

import graphcoursework.components.*;
import graphcoursework.graph.*;

import static debug.Debug.*;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentListener;
import java.awt.event.ContainerListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class Main extends javax.swing.JFrame {

    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField widthField;
    private javax.swing.JButton dijkstraButton;
    private javax.swing.JTextField distanseField;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JButton treeButton;
    private javax.swing.JCheckBox orientedCheckBox;
    private javax.swing.JButton paintGraphButton;
    
    private Graph graph;
    
    public static Color TREEANDMINIMUMCOLOR = new Color(204, 0, 0);
    
    public Main() {
        super("Graph Course Work");
        initComponents();
    }
    
    private void initGraph(JPanel jp) {
        this.graph = new Graph(jp, widthField);
        graph.setOriented(orientedCheckBox.isSelected());
    }
    
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        widthField = new javax.swing.JTextField();
        dijkstraButton = new javax.swing.JButton();
        distanseField = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        treeButton = new javax.swing.JButton();
        orientedCheckBox = new javax.swing.JCheckBox();
        paintGraphButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        
        jLabel1.setText("Длина пути:");
        jButton1.setText("Соединить");
        jButton2.setText("Очистить");
        jButton3.setText("tst");
        dijkstraButton.setText("Кратчайший путь");
        jLabel2.setText("Длина пути:");
        treeButton.setText("Остов");
        paintGraphButton.setText("Раскрасить");
        orientedCheckBox.setText("Ориентированность");
        
        initGraph(jPanel2);
        //--------------------------------------------DONT TOUCH
        setSize(900, 500);
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
                .addComponent(treeButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(dijkstraButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(distanseField, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(orientedCheckBox)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                .addComponent(widthField, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
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
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(widthField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dijkstraButton)
                    .addComponent(distanseField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(treeButton)
                    .addComponent(orientedCheckBox))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDelete(evt);
            }
        });
        
        treeButton.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                treeButtonClick(evt);
            }
        });
        
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonConnect(evt);
            }
        });
        
        dijkstraButton.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dijkstraButtonClick(evt);
            }
        });
        
        jPanel2.setLayout(null);
        
        jPanel2.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println("mouseClicked JPanel2");
                if (e.getButton() == 3) {
                    graph.addPoint(e.getX(), e.getY());
                }
                if (e.getButton() == 1) {
                    graph.deselectAll();
                }
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
        
        widthField.addKeyListener(new KeyListener() {

            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyPressed(KeyEvent e) {
            }

            @Override
            public void keyReleased(KeyEvent e) {
                int buf = 0;
                try {
                    buf = Integer.parseInt(((JTextField)e.getSource()).getText());
                } catch(Exception ex) {
                    buf = Integer.MAX_VALUE;
                }  
                graph.syncWidthField(buf);
            }
        });
        
        orientedCheckBox.addItemListener(new ItemListener() {

            @Override
            public void itemStateChanged(ItemEvent e) {
                jCheckBoxChange(e);
            }
        });
        
    }
    
    private void dijkstraButtonClick(java.awt.event.ActionEvent evt) {                                         
        //GraphPoint[] gps =  graph.getSelectedPoints();
//        GraphElement[] ges;// = GraphElement[0];
//        if (gps.length == 2) {
//            ges = graph.getDijkstraPath(gps[0], gps[1]);
//        } else {
//            return;
//        }
        
        GraphElement[] ges = graph.getDijkstraPath();
        
        if (ges == null) {
            distanseField.setText("Infinit");
            return;
        }
        int dist = 0;
        for (int i = 0; i < ges.length; i++) {
            ges[i].getComponent().setColor(TREEANDMINIMUMCOLOR);
            if (GraphLine.class.isInstance(ges[i])) {
                dist += ((GraphLine)ges[i]).getWeight();
            }
        }
        distanseField.setText(dist + "");
    }
    
    private void jButtonConnect(java.awt.event.ActionEvent evt) {  
        graph.addLine();
    }
    
    private void jButtonDelete(java.awt.event.ActionEvent evt) {                                         
        jPanel2.removeAll();
        jPanel2.repaint();
        this.graph = new Graph(jPanel2, widthField);
    }
    
    private void treeButtonClick(java.awt.event.ActionEvent evt) {                                         
        GraphElement[] ges = graph.getMinimalSpanningTree();
        if (ges == null) return;
        for (int i = 0; i < ges.length; i++) {
            ges[i].getComponent().setColor(TREEANDMINIMUMCOLOR);
        }
    }
    
    public static void main(String[] args) {
        Main m = new Main();
        m.setVisible(true);
        //m.graph.TEST_FUNC();
    }
    
    private void jCheckBoxChange(ItemEvent evt) {
        this.graph.setOriented(evt.getStateChange()==1);
    }
    
}
