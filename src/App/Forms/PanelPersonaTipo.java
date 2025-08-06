package App.Forms;

import App.CustomerControl.PatButton;
import App.CustomerControl.PatLabel;
import App.CustomerControl.PatTextBox;
import App.Utils.IAStyle;
import BusinessLogic.BLFactory;
import DataAccess.DAO.DAOPersonaTipo;
import DataAccess.DTO.DTOPersonaTipo;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.Box;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class PanelPersonaTipo extends JPanel implements ActionListener{
    private BLFactory<DTOPersonaTipo> blfPersonaTipo = new BLFactory<>(DAOPersonaTipo::new);
    private DTOPersonaTipo dtoPersonaTipo = new DTOPersonaTipo();
     //public static final long serialVersionUID = 1L;
    private Integer regAct = 0
                  ,regMax=0;


        public PanelPersonaTipo() {
        
        try {
            initcomponent();
            loadRowData();
            showRowData();
            showDataTable();
            btnRowIni.addActionListener(this);
            btnRowAnt.addActionListener(this);
            btnRowSig.addActionListener(this);
            btnRowFin.addActionListener(this);

            btnNuevo.addActionListener(e ->btnNuevoClick() );
            btnGuardar.addActionListener(e ->btnGuardarClick() );
            btnEliminar.addActionListener(e ->btnEliminarClick() );
            btnCancelar.addActionListener(e ->btnCancelarClick() );



            // btnPageIni.addActionListener(e -> {
            //     regAct=1;
            //     dtoPersonaTipo =blfPersonaTipo.getById(regAct);
            //     showRowData();
            // });
        } catch (Exception e) {
            
            IAStyle.showMsg("error al cargar los datos de tipo persona"+e.getMessage());
        }
        showRowData();
    }
        void showDataTable() {
            String[] header = { "IDPT", "Tipo", "Estado" };
            Object[][] data = new Object[regMax][3];
            int index = 0;
        
            try {
                for (DTOPersonaTipo o : blfPersonaTipo.getAll()) {
                    data[index][0] = o.getIdPersonaTipo();
                    data[index][1] = o.getTipo();
                    data[index][2] = o.getEstado();
                    index++;
                }
            } catch (Exception e) {
                IAStyle.showMsgError("Error al cargar la tabla: " + e.getMessage());
            }
        
            JTable table = new JTable(data, header);
            table.setShowHorizontalLines(true);
            table.setGridColor(Color.lightGray);
            table.setRowSelectionAllowed(true);
            table.setColumnSelectionAllowed(false);
            table.setPreferredScrollableViewportSize(new Dimension(450, 150));
            table.setFillsViewportHeight(true);
        
            pnlTabla.removeAll();
            pnlTabla.add(new JScrollPane(table));
        
            table.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    int row = table.rowAtPoint(e.getPoint());
                    int col = table.columnAtPoint(e.getPoint());
                    
                    if (row >= 0 && col >= 0) {
                        
                            String strId = table.getModel().getValueAt(row, 0).toString();
                            regAct = Integer.parseInt(strId);
                        try {  
                            dtoPersonaTipo  = blfPersonaTipo.getById(regAct);
                            showRowData( ); // Asegúrate de que este método exista en la clase exterior
                        
                            System.out.println("Tabla.Selected: " + strId);
                        } catch (Exception ex) {
                            IAStyle.showMsgError("Error al seleccionar fila: " + ex.getMessage());
                        }
                    }
                }
            });
        }

        private void  btnNuevoClick() {
            dtoPersonaTipo = null;
            showRowData();
        }
        private void btnGuardarClick() {
                boolean isDTOnuLL = (dtoPersonaTipo == null);
                try {
                    if (IAStyle.showConfirmYesNo("¿Seguro que desea " + ((isDTOnuLL) ? "AGREGAR ?" : "ACTUALIZAR ?"))) {
                        if (isDTOnuLL)
                            dtoPersonaTipo = new DTOPersonaTipo(txtTipoPersona.getText().trim());
                        else
                            dtoPersonaTipo.setTipo(txtTipoPersona.getText());
                    
                        if ((isDTOnuLL) ? blfPersonaTipo.add(dtoPersonaTipo)
                                        : blfPersonaTipo.upd(dtoPersonaTipo)) {
                            IAStyle.showMsg("Registro guardado correctamente.");
                        } else {
                            IAStyle.showMsgError("Registro fallido");
                        }
                    
                        loadRowData();
                        showRowData();
                        showDataTable();
                    }
                } catch (Exception e) {
                    IAStyle.showMsgError (e.getMessage());
                }
            }
        
        private void btnEliminarClick()  {
            try {
                if (IAStyle.showConfirmYesNo("¿Seguro que desea ELIMINAR ? ")) {
                    if (!blfPersonaTipo.del(dtoPersonaTipo.getIdPersonaTipo())) {
                        throw new Exception("Error al eliminar ....!");
                    }
                    loadRowData();
                    showRowData();
                    showDataTable();
                }
            } catch (Exception e) {
                IAStyle.showMsgError(e.getMessage());
            }
        }
        private void  btnCancelarClick() {
            try {
                if (dtoPersonaTipo ==null)
                loadRowData();
                showRowData();

            } catch (Exception e) {
            }
        }

        private void loadRowData() throws Exception{
       regAct           = 1;
       dtoPersonaTipo   =blfPersonaTipo.getById(regAct);
       regMax           = blfPersonaTipo.getMaxReg();
       
            }
    
        private void showRowData () {
        boolean isDTOnull = (dtoPersonaTipo== null|| dtoPersonaTipo.getIdPersonaTipo() ==null);
        txtIdTipo.setText        ((isDTOnull)? " ":dtoPersonaTipo.getIdPersonaTipo().toString());
        txtTipoPersona.setText   ((isDTOnull)? " ":dtoPersonaTipo.getTipo().toString());
        lblTotalReg.setText      ((regAct.toString())+" de "+regMax);
         }
            @Override
        public void actionPerformed(ActionEvent e) {
        Object src = e.getSource();
        if (src == btnRowIni) {
            regAct = 1;
        } else if (src == btnRowAnt) {
            regAct = Math.max(1, regAct - 1);
        } else if (src == btnRowSig) {
            regAct = Math.min(regMax, regAct + 1);
        } else if (src == btnRowFin) {
            regAct = regMax;
        }
        try {
            dtoPersonaTipo =blfPersonaTipo.getById(regAct);
            showRowData();
        } catch (Exception ex) { }

        }
        private void initcomponent() {
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

            txtIdTipo.setEnabled(false);
            txtIdTipo.setBorderLine();
            txtTipoPersona.setBorderLine();

            pnlBtnPage.add(btnPageIni);
            pnlBtnPage.add(btnPageAnt);
            pnlBtnPage.add(new PatLabel("Page:( "));
            pnlBtnPage.add(lblTotalReg); // cambiar
            pnlBtnPage.add(new PatLabel(") "));
            pnlBtnPage.add(btnPageSig);
            pnlBtnPage.add(btnPageFin);

            pnlBtnRow.add(btnRowIni);
            pnlBtnRow.add(btnRowAnt);
            pnlBtnRow.add(lblTotalReg);
            pnlBtnRow.add(btnRowSig);
            pnlBtnRow.add(btnRowFin);

            pnlBtnCRUD.add(btnNuevo);
            pnlBtnCRUD.add(btnGuardar);
            pnlBtnCRUD.add(btnCancelar);
            pnlBtnCRUD.add(btnEliminar);
            pnlBtnCRUD.setBorder(IAStyle.createBorderRect());

            gbc.insets = new Insets(5, 5, 5, 5);

            gbc.gridy = 0;
            gbc.gridx = 0;
            gbc.gridwidth = 2;
            add(lblTitulo, gbc);

            gbc.gridy = 1;
            gbc.gridx = 0;
            gbc.gridwidth = 1;
            add(new JLabel(" Sección de datos: "), gbc);
            gbc.gridy = 1;
            gbc.gridx = 1;
            add(pnlBtnPage, gbc);

            gbc.gridy = 2;
            gbc.gridx = 0;
            gbc.gridwidth = 3;
            gbc.ipady = 150;
            gbc.ipadx = 450;
            pnlTabla.add(new Label("Loading data..."));
            add(pnlTabla, gbc);

            gbc.ipady = 1;
            gbc.ipadx = 1;
            
            gbc.gridy = 3;
            gbc.gridwidth = 3;
            gbc.gridx = 0;

            gbc.insets = new Insets(50, 0, 0, 0); // Ajusta el valor superior a 50
            gbc.fill = GridBagConstraints.HORIZONTAL;
            add(Box.createRigidArea(new Dimension(0, 0)), gbc);

            gbc.insets = new Insets(10, 0, 0, 0);

            gbc.gridy = 4;
            gbc.gridx = 0;
            gbc.gridwidth = 1;
            add(new JLabel("Seccion de Registro "), gbc);
            gbc.gridy = 4;
            gbc.gridx = 1;
            add(pnlBtnRow, gbc);

            gbc.gridy = 5;
            gbc.gridx = 0;
            add(lblIdPersonaTipo, gbc);
            gbc.gridx = 1;
            gbc.gridy = 5;
            gbc.fill = GridBagConstraints.HORIZONTAL;
            gbc.gridwidth = GridBagConstraints.REMAINDER;
            add(txtIdTipo, gbc);


            gbc.gridy = 6;
            gbc.gridx = 0;
            add(lblTipoPersona, gbc);
            gbc.gridy = 6;
            gbc.gridx = 1;
            gbc.fill = GridBagConstraints.HORIZONTAL;
            gbc.gridwidth = GridBagConstraints.REMAINDER;
            add(txtTipoPersona, gbc);

            gbc.gridy = 7;
            gbc.gridx = 0;
            gbc.gridwidth = 3;
            gbc.insets = new Insets(30, 0, 0, 0);
            gbc.fill = GridBagConstraints.HORIZONTAL;
            add(pnlBtnCRUD, gbc);

;

        
       
            }
            //#region
            // Etiquetas personalizadas (PatLabel)
        private PatLabel
            lblTitulo   = new PatLabel("Personas Tipo"),
            lblIdPersonaTipo   = new PatLabel("Código: "),
            lblTipoPersona   = new PatLabel("TipoPersona: "),
            lblTotalReg = new PatLabel("0 de 0");
        
        // Cajas de texto personalizadas (PatTextBox)
        private PatTextBox
            txtIdTipo   = new PatTextBox(),
            txtTipoPersona   = new PatTextBox();
        
        // Botones personalizados (PatButton)
        private PatButton
            btnPageIni  = new PatButton("<<"),
            btnPageAnt  = new PatButton("<"),
            btnPageSig  = new PatButton(">"),
            btnPageFin  = new PatButton(">>"),
        
            btnRowIni   = new PatButton("↤"),
            btnRowAnt   = new PatButton("↑"),
            btnRowSig   = new PatButton("↓"),
            btnRowFin   = new PatButton("↦"),
        
            btnNuevo    = new PatButton("Nuevo"),
            btnGuardar  = new PatButton("Guardar"),
            btnCancelar = new PatButton("Cancelar"),
            btnEliminar = new PatButton("Eliminar");
        
        // Paneles con FlowLayout
        private JPanel
            pnlTabla    = new JPanel(),
            pnlBtnRow   = new JPanel(new FlowLayout()),
            pnlBtnPage  = new JPanel(new FlowLayout()),
            pnlBtnCRUD  = new JPanel(new FlowLayout());
            //#endregion
            }
