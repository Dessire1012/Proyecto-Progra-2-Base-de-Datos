package Proyecto;

import java.awt.Color;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTextPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultStyledDocument;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyleContext;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

/**
 *
 * @author dessi
 */
public class PaginaPrincipal extends javax.swing.JFrame {

    /**
     * Creates new form PaginaPrincipal
     */
    public PaginaPrincipal() {
        initComponents();
        colors();
        this.setExtendedState(MAXIMIZED_BOTH);
        adminU.cargarArchivo();
        adminU.getListaU();

        usuarios = adminU.getListaU();

        adminD.cargarArchivo();
        adminD.getListaDir();

        directorios = adminD.getListaDir();

        for (Directorios direc : adminD.getListaDir()) {
            if (!direc.getTablas().isEmpty()) {
                for (Tabla t : direc.getTablas()) {
                    adminsT.add(new AdminTabla(t.getDirectorio()));
                }

                for (int i = 0; i < direc.getTablas().size(); i++) {
                    adminsT.get(i).setListaT(direc.getTablas());
                }
            }
        }

        if (!adminD.getListaDir().isEmpty()) {
            modeloARBOL = (DefaultTreeModel) jTree_Bases.getModel();
            raiz = (DefaultMutableTreeNode) modeloARBOL.getRoot();

            for (Directorios direc : adminD.getListaDir()) {
                DefaultMutableTreeNode _base = new DefaultMutableTreeNode(direc);
                if (!direc.getTablas().isEmpty()) {
                    for (Tabla tabla : direc.getTablas()) {
                        DefaultMutableTreeNode _tabla = new DefaultMutableTreeNode(tabla);
                        _base.add(_tabla);
                    }
                }
                raiz.add(_base);
                modeloARBOL.reload();
            }
        }

    }

    private int UltimoCaracter(String texto, int index) {
        while (--index >= 0) {
            //  \\W = [A-Za-Z0-9]
            if (String.valueOf(texto.charAt(index)).matches("\\W")) {
                break;
            }
        }
        return index;
    }

    private int PrimerCaracter(String texto, int index) {
        while (index < texto.length()) {
            if (String.valueOf(texto.charAt(index)).matches("\\W")) {
                break;
            }
            index++;
        }
        return index;
    }

    private void colors() {

        final StyleContext cont = StyleContext.getDefaultStyleContext();

        //COLORES 
        final AttributeSet attblue = cont.addAttribute(cont.getEmptySet(), StyleConstants.Foreground, new Color(0, 0, 255));

        //STYLO 
        DefaultStyledDocument doc = new DefaultStyledDocument() {
            public void insertString(int offset, String str, AttributeSet a) throws BadLocationException {
                super.insertString(offset, str, a);

                String text = getText(0, getLength());
                int before = UltimoCaracter(text, offset);
                if (before < 0) {
                    before = 0;
                }
                int after = PrimerCaracter(text, offset + str.length());
                int wordL = before;
                int wordR = before;

                while (wordR <= after) {
                    if (wordR == after || String.valueOf(text.charAt(wordR)).matches("\\W")) {
                        if (text.substring(wordL, wordR).matches("(\\W)*(CREATE|DROP|"
                                + "SELECT|FROM|WHERE|AND|OR|GRANT|DATABASE|TO|INSERT|"
                                + "INTO|VALUES|TABLE|UPDATE|SET|DELETE|TRUNCATE)")) {
                            setCharacterAttributes(wordL, wordR - wordL, attblue, false);
                        }
                        wordL = wordR;

                    }
                    wordR++;
                }
            }

            public void romeve(int offs, int len) throws BadLocationException {
                super.remove(offs, len);

                String text = getText(0, getLength());
                int before = UltimoCaracter(text, offs);
                if (before < 0) {
                    before = 0;
                }
            }
        };

        JTextPane txt = new JTextPane(doc);
        String temp = jTextPane1.getText();
        jTextPane1.setStyledDocument(txt.getStyledDocument());
        jTextPane1.setText(temp);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu_Jtree = new javax.swing.JPopupMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jDialog1_Login = new javax.swing.JDialog();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTextField1_Usuario = new javax.swing.JTextField();
        jTextField2_Contrase??a = new javax.swing.JTextField();
        jButton1_login = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jDialog2_Registro = new javax.swing.JDialog();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jTextField1_UsuarioR = new javax.swing.JTextField();
        jTextField2_ContraR = new javax.swing.JTextField();
        jDialog3_CrearUsuario = new javax.swing.JDialog();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jRadioButton_GU = new javax.swing.JRadioButton();
        jRadioButton_Create = new javax.swing.JRadioButton();
        jRadioButton_Select = new javax.swing.JRadioButton();
        jRadioButton_Insert = new javax.swing.JRadioButton();
        jRadioButton_Delete = new javax.swing.JRadioButton();
        jRadioButton_Drop = new javax.swing.JRadioButton();
        jButton3 = new javax.swing.JButton();
        jTextField_NombreCU = new javax.swing.JTextField();
        jTextField_ContraCU = new javax.swing.JTextField();
        jDialog4_EliminarUsuario = new javax.swing.JDialog();
        jLabel14 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jDialog5_CrearTabla = new javax.swing.JDialog();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jButton6 = new javax.swing.JButton();
        jTextField_nombreTabla = new javax.swing.JTextField();
        jDialog6_ListaSQL = new javax.swing.JDialog();
        jLabel17 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTree_Bases = new javax.swing.JTree();
        jPanel1 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jToolBar1 = new javax.swing.JToolBar();
        jButton_ = new javax.swing.JButton();
        jButton_Guardar = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTextPane1 = new javax.swing.JTextPane();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable = new javax.swing.JTable();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu_Usuarios = new javax.swing.JMenu();
        jMenuItem_Login = new javax.swing.JMenuItem();
        jMenuItem_Logout = new javax.swing.JMenuItem();
        jMenuItem_CrearUsuario = new javax.swing.JMenuItem();
        jMenuItem4_Eliminar = new javax.swing.JMenuItem();
        jMenu_CrearBase = new javax.swing.JMenu();

        jMenuItem1.setIcon(new javax.swing.ImageIcon("C:\\Users\\dessi\\Downloads\\Uni\\4 Semestre\\Programaci??n II\\Progra2Proyecto\\Iconos\\icons8-eliminar-carpeta-16.png")); // NOI18N
        jMenuItem1.setText("Eliminar Base");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jPopupMenu_Jtree.add(jMenuItem1);

        jMenuItem2.setIcon(new javax.swing.ImageIcon("C:\\Users\\dessi\\Downloads\\Uni\\4 Semestre\\Programaci??n II\\Progra2Proyecto\\Iconos\\icons8-ver-detalles-16.png")); // NOI18N
        jMenuItem2.setText("Crear Tabla");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jPopupMenu_Jtree.add(jMenuItem2);

        jMenuItem3.setIcon(new javax.swing.ImageIcon("C:\\Users\\dessi\\Downloads\\Uni\\4 Semestre\\Programaci??n II\\Progra2Proyecto\\Iconos\\icons8-a??adir-usuario-grupo-mujer-hombre-16.png")); // NOI18N
        jMenuItem3.setText("Usuarios de la Base");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jPopupMenu_Jtree.add(jMenuItem3);

        jDialog1_Login.setTitle("Login");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Log In");
        jLabel1.setToolTipText("");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("Usuario:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setText("Contrase??a:");

        jButton1_login.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton1_login.setText("Aceptar");
        jButton1_login.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1_loginMouseClicked(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton1.setText("Registrarme");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jDialog1_LoginLayout = new javax.swing.GroupLayout(jDialog1_Login.getContentPane());
        jDialog1_Login.getContentPane().setLayout(jDialog1_LoginLayout);
        jDialog1_LoginLayout.setHorizontalGroup(
            jDialog1_LoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialog1_LoginLayout.createSequentialGroup()
                .addGroup(jDialog1_LoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jDialog1_LoginLayout.createSequentialGroup()
                        .addGap(56, 56, 56)
                        .addComponent(jButton1_login, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jDialog1_LoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jDialog1_LoginLayout.createSequentialGroup()
                            .addGap(150, 150, 150)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jDialog1_LoginLayout.createSequentialGroup()
                            .addGap(49, 49, 49)
                            .addGroup(jDialog1_LoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGap(33, 33, 33)
                            .addGroup(jDialog1_LoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jTextField2_Contrase??a, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jTextField1_Usuario, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDialog1_LoginLayout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(79, Short.MAX_VALUE))
        );
        jDialog1_LoginLayout.setVerticalGroup(
            jDialog1_LoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialog1_LoginLayout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(jLabel1)
                .addGap(54, 54, 54)
                .addGroup(jDialog1_LoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextField1_Usuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(106, 106, 106)
                .addGroup(jDialog1_LoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTextField2_Contrase??a, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 74, Short.MAX_VALUE)
                .addGroup(jDialog1_LoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1_login)
                    .addComponent(jButton1))
                .addGap(55, 55, 55))
        );

        jDialog2_Registro.setTitle("Registro");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel4.setText("Registro");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel5.setText("Usuario:");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel6.setText("Contrase??a:");

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton2.setText("Aceptar");
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton2MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jDialog2_RegistroLayout = new javax.swing.GroupLayout(jDialog2_Registro.getContentPane());
        jDialog2_Registro.getContentPane().setLayout(jDialog2_RegistroLayout);
        jDialog2_RegistroLayout.setHorizontalGroup(
            jDialog2_RegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialog2_RegistroLayout.createSequentialGroup()
                .addGroup(jDialog2_RegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jDialog2_RegistroLayout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addGroup(jDialog2_RegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel5))
                        .addGap(38, 38, 38)
                        .addGroup(jDialog2_RegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField1_UsuarioR, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField2_ContraR, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jDialog2_RegistroLayout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jButton2))))
                    .addGroup(jDialog2_RegistroLayout.createSequentialGroup()
                        .addGap(170, 170, 170)
                        .addComponent(jLabel4)))
                .addContainerGap(71, Short.MAX_VALUE))
        );
        jDialog2_RegistroLayout.setVerticalGroup(
            jDialog2_RegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialog2_RegistroLayout.createSequentialGroup()
                .addGap(65, 65, 65)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 64, Short.MAX_VALUE)
                .addGroup(jDialog2_RegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jTextField1_UsuarioR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(77, 77, 77)
                .addGroup(jDialog2_RegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(jTextField2_ContraR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(80, 80, 80)
                .addComponent(jButton2)
                .addGap(49, 49, 49))
        );

        jDialog3_CrearUsuario.setTitle("Crear usuario");

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel9.setText("Crear Usuario");

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel10.setText("Nombre:");

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel11.setText("Contrase??a:");

        jRadioButton_GU.setText("Gesti??n de U.");

        jRadioButton_Create.setText("Create");

        jRadioButton_Select.setText("Select");

        jRadioButton_Insert.setText("Insert");

        jRadioButton_Delete.setText("Delete");

        jRadioButton_Drop.setText("Drop");

        jButton3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton3.setText("Crear");
        jButton3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton3MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jDialog3_CrearUsuarioLayout = new javax.swing.GroupLayout(jDialog3_CrearUsuario.getContentPane());
        jDialog3_CrearUsuario.getContentPane().setLayout(jDialog3_CrearUsuarioLayout);
        jDialog3_CrearUsuarioLayout.setHorizontalGroup(
            jDialog3_CrearUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialog3_CrearUsuarioLayout.createSequentialGroup()
                .addGroup(jDialog3_CrearUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jDialog3_CrearUsuarioLayout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addGroup(jDialog3_CrearUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11)
                            .addComponent(jLabel10))
                        .addGroup(jDialog3_CrearUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jDialog3_CrearUsuarioLayout.createSequentialGroup()
                                .addGap(14, 14, 14)
                                .addGroup(jDialog3_CrearUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel9)
                                    .addComponent(jTextField_NombreCU, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jDialog3_CrearUsuarioLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTextField_ContraCU, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jDialog3_CrearUsuarioLayout.createSequentialGroup()
                        .addGap(118, 118, 118)
                        .addGroup(jDialog3_CrearUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jRadioButton_GU)
                            .addComponent(jRadioButton_Create)
                            .addComponent(jRadioButton_Select))
                        .addGap(56, 56, 56)
                        .addGroup(jDialog3_CrearUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jRadioButton_Drop)
                            .addComponent(jRadioButton_Delete)
                            .addComponent(jRadioButton_Insert))))
                .addContainerGap(70, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDialog3_CrearUsuarioLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(174, 174, 174))
        );
        jDialog3_CrearUsuarioLayout.setVerticalGroup(
            jDialog3_CrearUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialog3_CrearUsuarioLayout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(jLabel9)
                .addGap(36, 36, 36)
                .addGroup(jDialog3_CrearUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(jTextField_NombreCU, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addGroup(jDialog3_CrearUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel11)
                    .addComponent(jTextField_ContraCU, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(47, 47, 47)
                .addGroup(jDialog3_CrearUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioButton_GU)
                    .addComponent(jRadioButton_Insert))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jDialog3_CrearUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioButton_Create)
                    .addComponent(jRadioButton_Delete))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jDialog3_CrearUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioButton_Select)
                    .addComponent(jRadioButton_Drop))
                .addGap(30, 30, 30)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(33, Short.MAX_VALUE))
        );

        jDialog4_EliminarUsuario.setTitle("Eliminar Usuario");

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel14.setText("Eliminar Usuarios");

        jButton5.setText("Eliminar");
        jButton5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton5MouseClicked(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Nombre", "Contrase??a"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane5.setViewportView(jTable1);

        javax.swing.GroupLayout jDialog4_EliminarUsuarioLayout = new javax.swing.GroupLayout(jDialog4_EliminarUsuario.getContentPane());
        jDialog4_EliminarUsuario.getContentPane().setLayout(jDialog4_EliminarUsuarioLayout);
        jDialog4_EliminarUsuarioLayout.setHorizontalGroup(
            jDialog4_EliminarUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDialog4_EliminarUsuarioLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel14)
                .addGap(133, 133, 133))
            .addGroup(jDialog4_EliminarUsuarioLayout.createSequentialGroup()
                .addGroup(jDialog4_EliminarUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jDialog4_EliminarUsuarioLayout.createSequentialGroup()
                        .addGap(189, 189, 189)
                        .addComponent(jButton5))
                    .addGroup(jDialog4_EliminarUsuarioLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jDialog4_EliminarUsuarioLayout.setVerticalGroup(
            jDialog4_EliminarUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialog4_EliminarUsuarioLayout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(jLabel14)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(jButton5)
                .addContainerGap(22, Short.MAX_VALUE))
        );

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel15.setText("Crear Tabla");

        jLabel16.setText("Nombre de la Tabla:");

        jButton6.setText("Aceptar");
        jButton6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton6MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jDialog5_CrearTablaLayout = new javax.swing.GroupLayout(jDialog5_CrearTabla.getContentPane());
        jDialog5_CrearTabla.getContentPane().setLayout(jDialog5_CrearTablaLayout);
        jDialog5_CrearTablaLayout.setHorizontalGroup(
            jDialog5_CrearTablaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialog5_CrearTablaLayout.createSequentialGroup()
                .addGroup(jDialog5_CrearTablaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jDialog5_CrearTablaLayout.createSequentialGroup()
                        .addGap(160, 160, 160)
                        .addComponent(jButton6))
                    .addGroup(jDialog5_CrearTablaLayout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addGroup(jDialog5_CrearTablaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel16)
                            .addComponent(jTextField_nombreTabla, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jDialog5_CrearTablaLayout.createSequentialGroup()
                        .addGap(130, 130, 130)
                        .addComponent(jLabel15)))
                .addContainerGap(43, Short.MAX_VALUE))
        );
        jDialog5_CrearTablaLayout.setVerticalGroup(
            jDialog5_CrearTablaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialog5_CrearTablaLayout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(jLabel15)
                .addGap(41, 41, 41)
                .addComponent(jLabel16)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTextField_nombreTabla, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                .addComponent(jButton6)
                .addGap(44, 44, 44))
        );

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel17.setText("Lista Sentencias SQL");

        jTextArea1.setEditable(false);
        jTextArea1.setColumns(20);
        jTextArea1.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N
        jTextArea1.setRows(5);
        jTextArea1.setText("CREATE DATABASE nombre_base_datos\n\nDROP DATABASE nombre_base_datos\n\nGRANT DATABASE nombre_base_da TO usuario\n\nCREATE TABLE nombre_tabla(campo1, campo2, campo3???.campo-n)\n\nINSERT INTO nombre_tabla VALUES(valor1, valor2, valor3??????valorn)\n\nSELECT campo1, campo2.. Campo-n FROM nombre_tabla (WHERE campox= algo)\n\nSELECT x.campo1, x.campo2, y.campo5 FROM tabla1 x, tabla2 y WHERE x.campo1=y.campo1\n\nUPDATE nombre_tabla SET Campox=algo WHERE campoy=algo\n\nDELETE FROM nombre_tabla WHERE campox=algo\n\nTRUNCATE TABLE Nombre_Tabla\n\nDROP TABLE nombre_tabla");
        jScrollPane2.setViewportView(jTextArea1);

        javax.swing.GroupLayout jDialog6_ListaSQLLayout = new javax.swing.GroupLayout(jDialog6_ListaSQL.getContentPane());
        jDialog6_ListaSQL.getContentPane().setLayout(jDialog6_ListaSQLLayout);
        jDialog6_ListaSQLLayout.setHorizontalGroup(
            jDialog6_ListaSQLLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialog6_ListaSQLLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDialog6_ListaSQLLayout.createSequentialGroup()
                .addContainerGap(198, Short.MAX_VALUE)
                .addComponent(jLabel17)
                .addGap(190, 190, 190))
        );
        jDialog6_ListaSQLLayout.setVerticalGroup(
            jDialog6_ListaSQLLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialog6_ListaSQLLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel17)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 457, Short.MAX_VALUE)
                .addContainerGap())
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("P??gina Principal");

        jTree_Bases.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        javax.swing.tree.DefaultMutableTreeNode treeNode1 = new javax.swing.tree.DefaultMutableTreeNode("Bases de datos");
        jTree_Bases.setModel(new javax.swing.tree.DefaultTreeModel(treeNode1));
        jTree_Bases.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTree_BasesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTree_Bases);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel7.setText("Usuario:");

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel8.setText("Base de datos:");

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel12.setText("_");

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel13.setText("_");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8))
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel12))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(jLabel13))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jToolBar1.setRollover(true);

        jButton_.setIcon(new javax.swing.ImageIcon("C:\\Users\\dessi\\Downloads\\Uni\\4 Semestre\\Programaci??n II\\Progra2Proyecto\\Iconos\\icons8-ver-detalles-16.png")); // NOI18N
        jButton_.setText("Lista SQL");
        jButton_.setFocusable(false);
        jButton_.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton_.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton_.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton_MouseClicked(evt);
            }
        });
        jToolBar1.add(jButton_);

        jButton_Guardar.setIcon(new javax.swing.ImageIcon("C:\\Users\\dessi\\Downloads\\Uni\\4 Semestre\\Programaci??n II\\Progra2Proyecto\\Iconos\\icons8-guardar-16.png")); // NOI18N
        jButton_Guardar.setText("Guardar");
        jButton_Guardar.setFocusable(false);
        jButton_Guardar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton_Guardar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton_Guardar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton_GuardarMouseClicked(evt);
            }
        });
        jToolBar1.add(jButton_Guardar);

        jTextPane1.setEditable(false);
        jTextPane1.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jScrollPane4.setViewportView(jTextPane1);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, 873, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 873, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(163, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                    .addGap(0, 43, Short.MAX_VALUE)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        jTabbedPane1.addTab("SQL", jPanel2);

        jTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane3.setViewportView(jTable);

        jMenu_Usuarios.setIcon(new javax.swing.ImageIcon("C:\\Users\\dessi\\Downloads\\Uni\\4 Semestre\\Programaci??n II\\Progra2Proyecto\\Iconos\\icons8-men??-de-usuario-femenino-16.png")); // NOI18N
        jMenu_Usuarios.setText("Usuarios");

        jMenuItem_Login.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem_Login.setIcon(new javax.swing.ImageIcon("C:\\Users\\dessi\\Downloads\\Uni\\4 Semestre\\Programaci??n II\\Progra2Proyecto\\Iconos\\icons8-usuario-hombre-verificado-16.png")); // NOI18N
        jMenuItem_Login.setText("Log in");
        jMenuItem_Login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem_LoginActionPerformed(evt);
            }
        });
        jMenu_Usuarios.add(jMenuItem_Login);

        jMenuItem_Logout.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_B, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem_Logout.setIcon(new javax.swing.ImageIcon("C:\\Users\\dessi\\Downloads\\Uni\\4 Semestre\\Programaci??n II\\Progra2Proyecto\\Iconos\\icons8-salir-redondeado-16.png")); // NOI18N
        jMenuItem_Logout.setText("Log Out");
        jMenuItem_Logout.setEnabled(false);
        jMenuItem_Logout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem_LogoutActionPerformed(evt);
            }
        });
        jMenu_Usuarios.add(jMenuItem_Logout);

        jMenuItem_CrearUsuario.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem_CrearUsuario.setIcon(new javax.swing.ImageIcon("C:\\Users\\dessi\\Downloads\\Uni\\4 Semestre\\Programaci??n II\\Progra2Proyecto\\Iconos\\icons8-a??adir-usuario-grupo-mujer-hombre-16.png")); // NOI18N
        jMenuItem_CrearUsuario.setText("Crear Usuarios");
        jMenuItem_CrearUsuario.setEnabled(false);
        jMenuItem_CrearUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem_CrearUsuarioActionPerformed(evt);
            }
        });
        jMenu_Usuarios.add(jMenuItem_CrearUsuario);

        jMenuItem4_Eliminar.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_D, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem4_Eliminar.setIcon(new javax.swing.ImageIcon("C:\\Users\\dessi\\Downloads\\Uni\\4 Semestre\\Programaci??n II\\Progra2Proyecto\\Iconos\\icons8-eliminar-usuaria-16.png")); // NOI18N
        jMenuItem4_Eliminar.setText("Elimanar Usuarios");
        jMenuItem4_Eliminar.setEnabled(false);
        jMenuItem4_Eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4_EliminarActionPerformed(evt);
            }
        });
        jMenu_Usuarios.add(jMenuItem4_Eliminar);

        jMenuBar1.add(jMenu_Usuarios);

        jMenu_CrearBase.setIcon(new javax.swing.ImageIcon("C:\\Users\\dessi\\Downloads\\Uni\\4 Semestre\\Programaci??n II\\Progra2Proyecto\\Iconos\\icons8-agregar-carpeta-16.png")); // NOI18N
        jMenu_CrearBase.setText("Crear Base");
        jMenu_CrearBase.setEnabled(false);
        jMenu_CrearBase.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu_CrearBaseMouseClicked(evt);
            }
        });
        jMenuBar1.add(jMenu_CrearBase);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTabbedPane1)
                    .addComponent(jScrollPane3))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 341, Short.MAX_VALUE))
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem_LoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem_LoginActionPerformed
        //ABRIR LOGIN

        jDialog1_Login.pack();
        jDialog1_Login.setLocationRelativeTo(this);
        jDialog1_Login.setModal(true);
        jDialog1_Login.setVisible(true);
    }//GEN-LAST:event_jMenuItem_LoginActionPerformed

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        //ABRIR REGISTRO

        jDialog2_Registro.pack();
        jDialog2_Registro.setLocationRelativeTo(jDialog1_Login);
        jDialog2_Registro.setModal(true);
        jDialog1_Login.setVisible(false);
        jDialog2_Registro.setVisible(true);
    }//GEN-LAST:event_jButton1MouseClicked

    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseClicked

        //REGISTRO
        String usuario = jTextField1_UsuarioR.getText();
        String contrase??a = jTextField2_ContraR.getText();
        boolean registrar = false;

        if (usuarios.isEmpty()) {

            try {
                usuarios.add(new Usuarios(usuario, contrase??a, true, true, true, true, true, true));
                adminU.setListaU(usuarios);
                adminU.escribirArchivo();

                jDialog2_Registro.setVisible(false);
                jTextField1_UsuarioR.setText("");
                jTextField2_ContraR.setText("");
                JOptionPane.showMessageDialog(this, "Usuario registrado");
                jMenuItem_Logout.setEnabled(true);
                jMenuItem_Login.setEnabled(false);
                jMenu_CrearBase.setEnabled(true);
                jMenuItem_CrearUsuario.setEnabled(true);
                jMenuItem4_Eliminar.setEnabled(true);
                jLabel12.setText(usuario);
                jTextPane1.setEditable(true);
            } catch (IOException ex) {
                Logger.getLogger(PaginaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            }

        } else {
            adminU.cargarArchivo();
            for (Usuarios usu : adminU.getListaU()) {
                if (!usu.getNombre().equals(usuario)) {
                    registrar = true;
                }
            }

            if (registrar == false) {
                JOptionPane.showMessageDialog(this, "Ese nombre ya esta en uso");
            } else {
                try {
                    usuarios.add(new Usuarios(usuario, contrase??a, true, true, true, true, true, true));
                    adminU.setListaU(usuarios);
                    adminU.escribirArchivo();

                    jDialog2_Registro.setVisible(false);
                    jTextField1_UsuarioR.setText("");
                    jTextField2_ContraR.setText("");
                    JOptionPane.showMessageDialog(this, "Usuario registrado");
                    jMenuItem_Logout.setEnabled(true);
                    jMenuItem_Login.setEnabled(false);
                    jMenu_CrearBase.setEnabled(true);
                    jMenuItem_CrearUsuario.setEnabled(true);
                    jMenuItem4_Eliminar.setEnabled(true);
                    jLabel12.setText(usuario);
                    jTextPane1.setEditable(true);
                } catch (IOException ex) {
                    Logger.getLogger(PaginaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }


    }//GEN-LAST:event_jButton2MouseClicked

    private void jButton1_loginMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1_loginMouseClicked
        //LOGIN

        String usuario = jTextField1_Usuario.getText();
        String contra = jTextField2_Contrase??a.getText();
        boolean login = false;

        for (Usuarios u : usuarios) {
            if (usuario.equals(u.getNombre()) && contra.equals(u.getContrase??a())) {

                jDialog1_Login.setVisible(false);
                jTextField1_Usuario.setText("");
                jTextField2_Contrase??a.setText("");
                JOptionPane.showMessageDialog(this, "Usuario Encontrado");
                jMenuItem_Logout.setEnabled(true);
                jMenuItem_Login.setEnabled(false);
                jMenu_CrearBase.setEnabled(true);
                jLabel12.setText(usuario);
                jTextPane1.setEditable(true);

                if (u.isGestionUsuarios() == true) {
                    jMenuItem_CrearUsuario.setEnabled(true);
                    jMenuItem4_Eliminar.setEnabled(true);
                }

                adminD.cargarArchivo();

                for (Directorios d : adminD.getListaDir()) {
                    for (Usuarios usuariosDir : d.getListaU()) {
                        if (usuariosDir.getNombre().equals(usuario)) {
                            jLabel13.setText(d.getDirectorio().getName());
                        }
                    }
                }

                login = true;
            }
        }

        if (login == false) {
            JOptionPane.showMessageDialog(this, "Usuario no encontrado");
        }
    }//GEN-LAST:event_jButton1_loginMouseClicked

    private void jMenu_CrearBaseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu_CrearBaseMouseClicked
        //CREAR BASE DE DATOS

        if (!jLabel12.getText().equals("_")) {

            JFileChooser fileChooser = new JFileChooser("./");
            int seleccion = fileChooser.showSaveDialog(this);
            modeloARBOL = (DefaultTreeModel) jTree_Bases.getModel();
            raiz = (DefaultMutableTreeNode) modeloARBOL.getRoot();

            if (seleccion == JFileChooser.APPROVE_OPTION) {
                File dir = fileChooser.getSelectedFile();

                adminD.cargarArchivo();

                for (Usuarios usuario : usuarios) {
                    if (usuario.getNombre().equals(jLabel12.getText())) {
                        ArrayList<Usuarios> u = new ArrayList();
                        u.add(usuario);
                        directorios.add(new Directorios(dir, u, tablas));
                        adminD.setListaDir(directorios);
                        adminD.escribirArchivo();
                    }
                }

                boolean fueCreado = dir.mkdir();

                if (fueCreado) {
                    JOptionPane.showMessageDialog(this, "Base de datos creado exitosamente");

                    DefaultMutableTreeNode _base = new DefaultMutableTreeNode(fileChooser.getSelectedFile().getName());
                    raiz.add(_base);
                    modeloARBOL.reload();
                    jLabel13.setText(fileChooser.getSelectedFile().getName());

                } else {
                    JOptionPane.showMessageDialog(this,
                            "La Base de Datos no ha sido creada");
                }
            }
        }
    }//GEN-LAST:event_jMenu_CrearBaseMouseClicked

    private void jMenuItem_CrearUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem_CrearUsuarioActionPerformed
        //ABRIR VENTANA DE CREAR USUARIOS

        jDialog3_CrearUsuario.pack();
        jDialog3_CrearUsuario.setLocationRelativeTo(this);
        jDialog3_CrearUsuario.setModal(true);
        jDialog3_CrearUsuario.setVisible(true);
    }//GEN-LAST:event_jMenuItem_CrearUsuarioActionPerformed

    private void jButton3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton3MouseClicked
        //CREAR USUARIO

        String nombre = jTextField_NombreCU.getText();
        String contrase??a = jTextField_ContraCU.getText();
        boolean gestionU = jRadioButton_GU.isSelected();
        boolean create = jRadioButton_Create.isSelected();
        boolean select = jRadioButton_Select.isSelected();
        boolean insert = jRadioButton_Insert.isSelected();
        boolean delete = jRadioButton_Delete.isSelected();
        boolean drop = jRadioButton_Drop.isSelected();
        boolean creado = false;

        adminU.cargarArchivo();
        for (Usuarios usuario : adminU.getListaU()) {
            if (!usuario.getNombre().equals(nombre)) {
                creado = true;
            }
        }

        if (creado) {
            usuarios.add(new Usuarios(nombre, contrase??a, gestionU, create, select, insert, delete, drop));
            adminU.setListaU(usuarios);
            try {
                adminU.escribirArchivo();
            } catch (IOException ex) {
                Logger.getLogger(PaginaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            }

            jTextField_NombreCU.setText("");
            jTextField_ContraCU.setText("");
            jRadioButton_GU.setSelected(false);
            jRadioButton_Create.setSelected(false);
            jRadioButton_Select.setSelected(false);
            jRadioButton_Insert.setSelected(false);
            jRadioButton_Delete.setSelected(false);
            jRadioButton_Drop.setSelected(false);

            JOptionPane.showMessageDialog(this, "Usuario creado");
        } else {
            JOptionPane.showMessageDialog(this, "Ese nombre ya esta en uso");
        }

        adminD.cargarArchivo();
        for (Directorios d : adminD.getListaDir()) {
            if (d.getDirectorio().getName().equals(jLabel13.getText())) {
                d.getListaU().add(new Usuarios(nombre, contrase??a, gestionU, create, select, insert, delete, drop));
            }
        }
        adminD.escribirArchivo();


    }//GEN-LAST:event_jButton3MouseClicked

    private void jMenuItem_LogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem_LogoutActionPerformed
        //LOG OUT

        jMenuItem_Logout.setEnabled(false);
        jMenuItem_Login.setEnabled(true);
        jMenu_CrearBase.setEnabled(false);
        jMenuItem4_Eliminar.setEnabled(false);

        if (jMenuItem_CrearUsuario.isEnabled()) {
            jMenuItem_CrearUsuario.setEnabled(false);
        }

        jLabel12.setText("_");
        jLabel13.setText("_");
    }//GEN-LAST:event_jMenuItem_LogoutActionPerformed

    private void jTree_BasesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTree_BasesMouseClicked
        //ABRIR POPUPMENU

        if (evt.isMetaDown()) {
            //seleccionar un nodo con click derecho
            int row = jTree_Bases.getClosestRowForLocation(
                    evt.getX(), evt.getY());
            jTree_Bases.setSelectionRow(row);
            Object v1 = jTree_Bases.getSelectionPath().getLastPathComponent();
            nodo_seleccionado = (DefaultMutableTreeNode) v1;

            if (nodo_seleccionado.getUserObject() instanceof Directorios) {
                Directorios directorio_Seleccionado = (Directorios) nodo_seleccionado.getUserObject();
                jPopupMenu_Jtree.show(evt.getComponent(),
                        evt.getX(), evt.getY());
            }
        }

        int row = jTree_Bases.getClosestRowForLocation(
                evt.getX(), evt.getY());
        jTree_Bases.setSelectionRow(row);
        Object v1 = jTree_Bases.getSelectionPath().getLastPathComponent();
        nodo_seleccionado = (DefaultMutableTreeNode) v1;

        if (nodo_seleccionado.getUserObject() instanceof Tabla) {
            Tabla tabla_Seleccionado = (Tabla) nodo_seleccionado.getUserObject();
            JTableHeader tableHeader = jTable.getTableHeader();
            TableColumnModel tableColumnModel = tableHeader.getColumnModel();
            DefaultTableModel tablaModelo = (DefaultTableModel) jTable.getModel();
            tablaModelo.setColumnCount(tabla_Seleccionado.getAtributos().size());
            for (int i = 0; i < tabla_Seleccionado.getAtributos().size(); i++) {
                TableColumn tableColumn = tableColumnModel.getColumn(i);
                tableColumn.setHeaderValue(tabla_Seleccionado.getAtributos().get(i));
            }

            tableHeader.repaint();
            tablaModelo.setRowCount(0);

            if (!tabla_Seleccionado.getValues().isEmpty()) {
                String[] newrow = new String[tabla_Seleccionado.getAtributos().size()];

                for (int i = 0; i < tabla_Seleccionado.getAtributos().size(); i++) {
                    newrow[i] = tabla_Seleccionado.getValues().get(i);
                }
                tablaModelo.addRow(newrow);

            }

        }


    }//GEN-LAST:event_jTree_BasesMouseClicked

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        //ELIMINAR BASE

        adminD.cargarArchivo();
        adminD.getListaDir();
        boolean permiso = false;

        for (Directorios directorio : adminD.getListaDir()) {
            if (directorio.getDirectorio().getName().equals(((Directorios) nodo_seleccionado.getUserObject()).getDirectorio().getName())) {
                for (Usuarios usuario : directorio.getListaU()) {
                    if (usuario.getNombre().equals(jLabel12.getText())) {
                        permiso = true;
                        if (usuario.isDelete() == true) {
                            int resp = JOptionPane.showConfirmDialog(this, "Eliminar Base", "Confirmar",
                                    JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                            if (resp == JOptionPane.NO_OPTION) {

                            } else if (resp == JOptionPane.YES_OPTION) {
                                JOptionPane.showMessageDialog(this, "Base Eliminada");
                                modeloARBOL.removeNodeFromParent(nodo_seleccionado);
                                for (int i = 0; i < directorios.size(); i++) {
                                    if (directorios.get(i).getDirectorio().getName().equals(directorio.getDirectorio().getName())) {
                                        directorios.get(i).getDirectorio().delete();
                                        directorios.remove(i);
                                    }
                                }
                            }

                        } else {
                            JOptionPane.showMessageDialog(this, "Usted no tiene permiso para borrar la Base");
                        }
                    }
                }
            }
        }

        adminD.setListaDir(directorios);
        adminD.escribirArchivo();
        if (permiso == false) {
            JOptionPane.showMessageDialog(this, "Usted no tiene acceso a esta Base");
        }

    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        //ABRIR VENTANA DE CREAR TABLA
        jDialog5_CrearTabla.pack();
        jDialog5_CrearTabla.setLocationRelativeTo(this);
        jDialog5_CrearTabla.setModal(true);
        jDialog5_CrearTabla.setVisible(true);

    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        //MOSTRAR USUARIOS DE LA BASE
        for (Directorios directorio : adminD.getListaDir()) {
            if (directorio.getDirectorio().getName().equals(((Directorios) nodo_seleccionado.getUserObject()).getDirectorio().getName())) {
                JOptionPane.showMessageDialog(this, directorio.getListaU());
            }
        }

    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem4_EliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4_EliminarActionPerformed
        //ABRIR VENTANA DE ELIMINAR USUARIO
        adminD.cargarArchivo();
        boolean permiso = false;
        DefaultTableModel tablaM = (DefaultTableModel) jTable1.getModel();
        tablaM.setRowCount(0);

        for (Directorios drctr : adminD.getListaDir()) {
            if (drctr.getDirectorio().getName().equals(jLabel13.getText())) {
                for (Usuarios us : drctr.getListaU()) {
                    Object[] newrow = {us.getNombre(), us.getContrase??a()};

                    tablaM.addRow(newrow);

                    if (jLabel12.getText().equals(us.getNombre())) {
                        if (us.isGestionUsuarios() == true) {
                            permiso = true;
                        }
                    }
                }
            }
        }

        if (permiso) {
            jDialog4_EliminarUsuario.pack();
            jDialog4_EliminarUsuario.setLocationRelativeTo(this);
            jDialog4_EliminarUsuario.setModal(true);
            jDialog4_EliminarUsuario.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(this, "Usted no tiene permiso para eliminar usuarios");
        }


    }//GEN-LAST:event_jMenuItem4_EliminarActionPerformed

    private void jButton5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton5MouseClicked
        // ELIMINAR USUARIO
        if (jTable1.getSelectedRow() >= 0) {
            String nombre = (String) (jTable1.getValueAt(jTable1.getSelectedRow(), 0));
            String contrase??a = (String) (jTable1.getValueAt(jTable1.getSelectedRow(), 1));

            for (Directorios drctr : adminD.getListaDir()) {
                if (drctr.getDirectorio().getName().equals(jLabel13.getText())) {
                    for (Usuarios us : drctr.getListaU()) {
                        if (nombre.equals(us.getNombre()) && contrase??a.equals(us.getContrase??a())) {
                            int resp = JOptionPane.showConfirmDialog(this, "Eliminar Usuario", "Confirmar",
                                    JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                            if (resp == JOptionPane.NO_OPTION) {

                            } else if (resp == JOptionPane.YES_OPTION) {
                                for (int i = 0; i < directorios.size(); i++) {
                                    if (directorios.get(i).toString().equals(drctr.toString())) {
                                        for (int j = 0; j < drctr.getListaU().size(); j++) {
                                            if (drctr.getListaU().get(j).getNombre().equals(nombre)) {
                                                directorios.get(i).getListaU().remove(j);
                                            }
                                        }
                                    }
                                }

                                adminD.cargarArchivo();
                                adminD.setListaDir(directorios);
                                adminD.escribirArchivo();

                                JOptionPane.showMessageDialog(this, "Usuario eliminado");

                                DefaultTableModel modelo
                                        = (DefaultTableModel) jTable1.getModel();
                                modelo.removeRow(jTable1.getSelectedRow());
                                jTable1.setModel(modelo);
                            }
                        }
                    }
                }
            }

        }
    }//GEN-LAST:event_jButton5MouseClicked

    private void jButton6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton6MouseClicked
        //CREAR TABLA
        String nombreDir = nodo_seleccionado.getUserObject().toString();

        AdminTabla admT = new AdminTabla("./" + nombreDir + "./" + jTextField_nombreTabla.getText() + ".txt");
        adminsT.add(admT);

        Date fecha = new Date();
        SimpleDateFormat sd = new SimpleDateFormat("dd/MM/yyyy");
        admT.addListaT(new Tabla(jTextField_nombreTabla.getText(), jLabel12.getText(), sd.format(fecha)));
        admT.getListaT().get(0).setDirectorio("./" + nombreDir + "./" + jTextField_nombreTabla.getText() + ".txt");

        try {
            admT.escribirArchivo();
            DefaultMutableTreeNode _tabla = new DefaultMutableTreeNode(admT.getListaT().get(0));

            nodo_seleccionado.add(_tabla);
            modeloARBOL.reload();

            for (Directorios d : directorios) {
                if (d.getDirectorio().getName().equals(nombreDir)) {
                    d.addTabla(admT.getListaT().get(0));
                }
            }

            adminD.cargarArchivo();
            adminD.setListaDir(directorios);
            adminD.escribirArchivo();

            JOptionPane.showMessageDialog(this, "Tabla Creada");
            jTextField_nombreTabla.setText("");

        } catch (IOException ex) {
            Logger.getLogger(PaginaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_jButton6MouseClicked

    private void jButton_MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton_MouseClicked
        //ABRIR LISTA SQL
        jDialog6_ListaSQL.pack();
        jDialog6_ListaSQL.setLocationRelativeTo(this);
        jDialog6_ListaSQL.setModal(true);
        jDialog6_ListaSQL.setVisible(true);

    }//GEN-LAST:event_jButton_MouseClicked

    private void jButton_GuardarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton_GuardarMouseClicked
        String texto = jTextPane1.getText();
        Scanner sc = new Scanner(texto);
        sc.useDelimiter(" ");
        ArrayList<String> sentencias = new ArrayList();

        while (sc.hasNext()) {
            sentencias.add(sc.next());
        }

        if (sentencias.get(0).equals("CREATE") && sentencias.get(1).equals("DATABASE")) {
            String nombre = sentencias.get(2);

            File carpeta = new File("./" + nombre);
            if (!carpeta.exists()) {
                if (carpeta.mkdirs()) {
                    modeloARBOL = (DefaultTreeModel) jTree_Bases.getModel();
                    raiz = (DefaultMutableTreeNode) modeloARBOL.getRoot();

                    adminD.cargarArchivo();

                    for (Usuarios usuario : usuarios) {
                        if (usuario.getNombre().equals(jLabel12.getText())) {

                            ArrayList<Usuarios> u = new ArrayList();
                            u.add(usuario);
                            directorios.add(new Directorios(carpeta, u, tablas));
                            adminD.setListaDir(directorios);
                            adminD.escribirArchivo();
                        }
                    }

                    for (Directorios dir : directorios) {
                        if (dir.getDirectorio().getName().equals(nombre)) {
                            DefaultMutableTreeNode _base = new DefaultMutableTreeNode(dir);
                            raiz.add(_base);
                            modeloARBOL.reload();
                        }

                    }

                    jLabel13.setText(nombre);
                } else {

                }
            }
        }

        if (sentencias.get(0).equals("DROP") && sentencias.get(1).equals("DATABASE")) {
            String nombre = sentencias.get(2);
            adminD.cargarArchivo();
            adminD.getListaDir();
            boolean permiso = false;
            boolean borrar = false;

            for (Directorios directorio : adminD.getListaDir()) {
                if (directorio.getDirectorio().getName().equals(nombre)) {
                    for (Usuarios usuario : directorio.getListaU()) {
                        if (usuario.getNombre().equals(jLabel12.getText())) {
                            permiso = true;
                            if (usuario.isDelete() == true) {
                                borrar = true;

                                int resp = JOptionPane.showConfirmDialog(this, "Eliminar Base", "Confirmar",
                                        JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                                if (resp == JOptionPane.NO_OPTION) {

                                } else if (resp == JOptionPane.YES_OPTION) {
                                    JOptionPane.showMessageDialog(this, "Base Eliminada");
                                    for (int i = 0; i < directorios.size(); i++) {
                                        if (directorios.get(i).getDirectorio().getName().equals(directorio.getDirectorio().getName())) {
                                            directorios.get(i).getDirectorio().delete();
                                            directorios.remove(i);
                                        }
                                    }
                                    jLabel13.setText("_");

                                    adminD.cargarArchivo();
                                    adminD.setListaDir(directorios);
                                    adminD.escribirArchivo();

                                    raiz.removeAllChildren();
                                    if (!adminD.getListaDir().isEmpty()) {
                                        modeloARBOL = (DefaultTreeModel) jTree_Bases.getModel();
                                        raiz = (DefaultMutableTreeNode) modeloARBOL.getRoot();

                                        for (Directorios direc : adminD.getListaDir()) {
                                            DefaultMutableTreeNode _base = new DefaultMutableTreeNode(direc);
                                            if (!direc.getTablas().isEmpty()) {
                                                for (Tabla tabla : direc.getTablas()) {
                                                    DefaultMutableTreeNode _tabla = new DefaultMutableTreeNode(tabla.getNombre());
                                                    _base.add(_tabla);
                                                    raiz.add(_base);
                                                    modeloARBOL.reload();
                                                }
                                            }

                                        }
                                    }

                                }
                            }
                        }
                    }
                }
            }

            if (permiso == false) {
                JOptionPane.showMessageDialog(this, "Usted no tiene acceso a esta Base");
            }

            if (borrar == false) {
                JOptionPane.showMessageDialog(this, "Usted no tiene permiso para borrar la Base");
            }
        }

        if (sentencias.get(0).equals("GRANT") && sentencias.get(1).equals("DATABASE") && sentencias.get(3).equals("TO")) {
            for (Directorios d : directorios) {
                if (d.getDirectorio().getName().equals(sentencias.get(2))) {
                    for (Usuarios usuario : usuarios) {
                        if (usuario.getNombre().equals(sentencias.get(4))) {
                            d.addU(usuario);
                        }
                    }
                }
            }

            adminD.cargarArchivo();
            adminD.setListaDir(directorios);
            adminD.escribirArchivo();
        }

        if (sentencias.get(0).equals("CREATE") && sentencias.get(1).equals("TABLE") && sentencias.size() == 3) {

            String nombreDir = jLabel13.getText();

            AdminTabla admT = new AdminTabla("./" + nombreDir + "./" + sentencias.get(2) + ".txt");
            adminsT.add(admT);

            Date fecha = new Date();
            SimpleDateFormat sd = new SimpleDateFormat("dd/MM/yyyy");
            admT.addListaT(new Tabla(sentencias.get(2), jLabel12.getText(), sd.format(fecha)));
            admT.getListaT().get(0).setDirectorio("./" + nombreDir + "./" + sentencias.get(2) + ".txt");

            try {
                admT.escribirArchivo();

                for (Directorios d : directorios) {
                    if (d.getDirectorio().getName().equals(nombreDir)) {
                        d.addTabla(admT.getListaT().get(0));
                    }
                }

                adminD.cargarArchivo();
                adminD.setListaDir(directorios);
                adminD.escribirArchivo();

                raiz.removeAllChildren();
                if (!adminD.getListaDir().isEmpty()) {
                    modeloARBOL = (DefaultTreeModel) jTree_Bases.getModel();
                    raiz = (DefaultMutableTreeNode) modeloARBOL.getRoot();

                    for (Directorios direc : adminD.getListaDir()) {
                        DefaultMutableTreeNode _base = new DefaultMutableTreeNode(direc);
                        if (!direc.getTablas().isEmpty()) {
                            for (Tabla tabla : direc.getTablas()) {
                                DefaultMutableTreeNode _tabla = new DefaultMutableTreeNode(tabla);
                                _base.add(_tabla);
                                raiz.add(_base);
                                modeloARBOL.reload();
                            }
                        }

                    }
                }

                JOptionPane.showMessageDialog(this, "Tabla Creada");
                jTextField_nombreTabla.setText("");

            } catch (IOException ex) {
                Logger.getLogger(PaginaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        if (sentencias.get(0).equals("CREATE") && sentencias.get(1).equals("TABLE") && sentencias.size() > 3) {
            String nombreDir = jLabel13.getText();

            AdminTabla admT = new AdminTabla("./" + nombreDir + "./" + sentencias.get(2) + ".txt");
            adminsT.add(admT);

            Date fecha = new Date();
            SimpleDateFormat sd = new SimpleDateFormat("dd/MM/yyyy");
            admT.addListaT(new Tabla(sentencias.get(2), jLabel12.getText(), sd.format(fecha)));
            admT.getListaT().get(0).setDirectorio("./" + nombreDir + "./" + sentencias.get(2) + ".txt");

            StringBuilder NuevaS4 = new StringBuilder(sentencias.get(3));
            NuevaS4.deleteCharAt(0);
            NuevaS4.deleteCharAt(sentencias.get(3).length() - 2);

            admT.getListaT().get(0).addAtributo(NuevaS4.toString());

            //SENTENCIAS!!
            for (int i = 4; i < sentencias.size(); i++) {
                StringBuilder NuevaS = new StringBuilder(sentencias.get(i));
                NuevaS.deleteCharAt(sentencias.get(i).length() - 1);
                admT.getListaT().get(0).addAtributo(NuevaS.toString());
            }

            try {
                admT.escribirArchivo();

                for (Directorios d : directorios) {
                    if (d.getDirectorio().getName().equals(nombreDir)) {
                        d.addTabla(admT.getListaT().get(0));
                    }
                }

                adminD.cargarArchivo();
                adminD.setListaDir(directorios);
                adminD.escribirArchivo();

                raiz.removeAllChildren();
                if (!adminD.getListaDir().isEmpty()) {
                    modeloARBOL = (DefaultTreeModel) jTree_Bases.getModel();
                    raiz = (DefaultMutableTreeNode) modeloARBOL.getRoot();

                    for (Directorios direc : adminD.getListaDir()) {
                        DefaultMutableTreeNode _base = new DefaultMutableTreeNode(direc);
                        if (!direc.getTablas().isEmpty()) {
                            for (Tabla tabla : direc.getTablas()) {
                                DefaultMutableTreeNode _tabla = new DefaultMutableTreeNode(tabla);
                                _base.add(_tabla);
                                raiz.add(_base);
                                modeloARBOL.reload();
                            }
                        }

                    }
                }

                JOptionPane.showMessageDialog(this, "Tabla Creada");
                jTextField_nombreTabla.setText("");

            } catch (IOException ex) {
                Logger.getLogger(PaginaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            }

            JTableHeader tableHeader = jTable.getTableHeader();
            TableColumnModel tableColumnModel = tableHeader.getColumnModel();
            DefaultTableModel tablaModelo = (DefaultTableModel) jTable.getModel();
            tablaModelo.setColumnCount(admT.getListaT().get(0).getAtributos().size());
            for (int i = 0; i < admT.getListaT().get(0).getAtributos().size(); i++) {
                TableColumn tableColumn = tableColumnModel.getColumn(i);
                tableColumn.setHeaderValue(admT.getListaT().get(0).getAtributos().get(i));

            }

            tableHeader.repaint();

        }

        if (sentencias.get(0).equals("INSERT") && sentencias.get(1).equals("INTO") && sentencias.get(3).equals("VALUES")) {
            boolean permiso = false;
            boolean insert = false;
            int num = sentencias.size() - 4;
            String[] newrow = new String[num];

            adminD.cargarArchivo();
            for (Directorios directorio : directorios) {
                if (directorio.getDirectorio().getName().equals(jLabel13.getText())) {
                    for (Usuarios usuario : directorio.getListaU()) {
                        if (usuario.getNombre().equals(jLabel12.getText())) {
                            permiso = true;
                            if (usuario.isInsert() == true) {
                                insert = true;
                                for (Tabla tabla : directorio.getTablas()) {

                                    if (tabla.getNombre().equals(sentencias.get(2))) {

                                        StringBuilder NuevaS5 = new StringBuilder(sentencias.get(4));
                                        NuevaS5.deleteCharAt(0);
                                        NuevaS5.deleteCharAt(sentencias.get(4).length() - 2);
                                        tabla.addValue(NuevaS5.toString());
                                        newrow[0] = NuevaS5.toString();

                                        for (int i = 5; i < sentencias.size(); i++) {
                                            StringBuilder NuevaS = new StringBuilder(sentencias.get(i));
                                            NuevaS.deleteCharAt(sentencias.get(i).length() - 1);
                                            tabla.addValue(NuevaS.toString());
                                        }

                                    }
                                }
                            }
                        }
                    }
                }
            }
            adminD.setListaDir(directorios);
            adminD.escribirArchivo();

            for (AdminTabla adminTabla : adminsT) {
                if (adminTabla.getListaT().get(0).toString().equals(sentencias.get(2))) {
                    for (Directorios d : directorios) {
                        if (d.getDirectorio().getName().equals(jLabel13.getText())) {
                            adminTabla.setListaT(d.getTablas());
                            try {
                                adminTabla.escribirArchivo();
                                System.out.println(adminTabla.getListaT().get(0).getValues());
                            } catch (IOException ex) {
                                Logger.getLogger(PaginaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                    }
                }
            }
            DefaultTableModel tablaModelo = (DefaultTableModel) jTable.getModel();
            tablaModelo.setRowCount(0);

            for (AdminTabla adminTabla : adminsT) {
                if (adminTabla.getListaT().get(0).toString().equals(sentencias.get(2))) {
                    for (Directorios d : directorios) {
                        if (d.getDirectorio().getName().equals(jLabel13.getText())) {
                            if (!adminTabla.getListaT().get(0).getValues().isEmpty()) {
                                newrow = new String[adminTabla.getListaT().get(0).getAtributos().size()];

                                for (int i = 0; i < adminTabla.getListaT().get(0).getAtributos().size(); i++) {

                                    newrow[i] = adminTabla.getListaT().get(0).getValues().get(i);

                                }
                                tablaModelo.addRow(newrow);

                            }
                        }
                    }

                }
            }

            if (permiso == false) {
                JOptionPane.showMessageDialog(this, "Usted no tiene acceso a esta Base");
            }

            if (insert == false) {
                JOptionPane.showMessageDialog(this, "Usted no puede insertar en esta Base de datos");
            }

        }

        if (sentencias.get(0).equals("DROP") && sentencias.get(1).equals("TABLE")) {
            for (Directorios dir : directorios) {
                if (dir.getDirectorio().getName().equals(jLabel13.getText())) {
                    for (Usuarios usuario : usuarios) {
                        if (usuario.getNombre().equals(jLabel12.getText())) {
                            if (usuario.isDrop()) {

                                int resp = JOptionPane.showConfirmDialog(this, "Eliminar Tabla", "Confirmar",
                                        JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                                if (resp == JOptionPane.NO_OPTION) {

                                } else if (resp == JOptionPane.YES_OPTION) {
                                    for (int i = 0; i < dir.getTablas().size(); i++) {
                                        if (dir.getTablas().get(i).getNombre().equals(sentencias.get(2))) {
                                            for (AdminTabla aT : adminsT) {
                                                if (aT.getListaT().get(0).equals(dir.getTablas().get(i).getNombre())) {
                                                    aT.getArchivo().delete();
                                                }
                                            }
                                            dir.getTablas().remove(i);
                                        }
                                    }
                                }

                            } else {
                                System.out.println("Usted no tiene permiso para eliminar tablas");
                            }
                        }
                    }
                }
            }
        }

        adminD.cargarArchivo();
        adminD.setListaDir(directorios);
        adminD.escribirArchivo();

        raiz.removeAllChildren();
        if (!adminD.getListaDir().isEmpty()) {
            modeloARBOL = (DefaultTreeModel) jTree_Bases.getModel();
            raiz = (DefaultMutableTreeNode) modeloARBOL.getRoot();

            for (Directorios direc : adminD.getListaDir()) {
                DefaultMutableTreeNode _base = new DefaultMutableTreeNode(direc);
                if (!direc.getTablas().isEmpty()) {
                    for (Tabla tabla : direc.getTablas()) {
                        DefaultMutableTreeNode _tabla = new DefaultMutableTreeNode(tabla.getNombre());
                        _base.add(_tabla);
                    }
                }
                raiz.add(_base);
                modeloARBOL.reload();

            }
        }

        jTextPane1.setText("");
    }//GEN-LAST:event_jButton_GuardarMouseClicked

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
                if ("Windows Classic".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(PaginaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PaginaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PaginaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PaginaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PaginaPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton1_login;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton_;
    private javax.swing.JButton jButton_Guardar;
    private javax.swing.JDialog jDialog1_Login;
    private javax.swing.JDialog jDialog2_Registro;
    private javax.swing.JDialog jDialog3_CrearUsuario;
    private javax.swing.JDialog jDialog4_EliminarUsuario;
    private javax.swing.JDialog jDialog5_CrearTabla;
    private javax.swing.JDialog jDialog6_ListaSQL;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4_Eliminar;
    private javax.swing.JMenuItem jMenuItem_CrearUsuario;
    private javax.swing.JMenuItem jMenuItem_Login;
    private javax.swing.JMenuItem jMenuItem_Logout;
    private javax.swing.JMenu jMenu_CrearBase;
    private javax.swing.JMenu jMenu_Usuarios;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPopupMenu jPopupMenu_Jtree;
    private javax.swing.JRadioButton jRadioButton_Create;
    private javax.swing.JRadioButton jRadioButton_Delete;
    private javax.swing.JRadioButton jRadioButton_Drop;
    private javax.swing.JRadioButton jRadioButton_GU;
    private javax.swing.JRadioButton jRadioButton_Insert;
    private javax.swing.JRadioButton jRadioButton_Select;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField1_Usuario;
    private javax.swing.JTextField jTextField1_UsuarioR;
    private javax.swing.JTextField jTextField2_ContraR;
    private javax.swing.JTextField jTextField2_Contrase??a;
    private javax.swing.JTextField jTextField_ContraCU;
    private javax.swing.JTextField jTextField_NombreCU;
    private javax.swing.JTextField jTextField_nombreTabla;
    private javax.swing.JTextPane jTextPane1;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JTree jTree_Bases;
    // End of variables declaration//GEN-END:variables
    ArrayList<Usuarios> usuarios = new ArrayList();
    AdminUsuarios adminU = new AdminUsuarios("./Usuarios.txt");
    DefaultTreeModel modeloARBOL;
    DefaultMutableTreeNode raiz;
    ArrayList<Directorios> directorios = new ArrayList();
    AdminDirectorio adminD = new AdminDirectorio("./Directorios.cmb");
    DefaultMutableTreeNode nodo_seleccionado;
    ArrayList<Tabla> tablas = new ArrayList();
    ArrayList<AdminTabla> adminsT = new ArrayList();

}
