package App.Forms;

import App.CustomerControl.PatButton;
import App.CustomerControl.PatLabel;
import App.CustomerControl.PatTextBox;
import App.Utils.IAStyle;
import BusinessLogic.BLFactory;
import DataAccess.DAO.DAOPersonaTipo;
import DataAccess.DTO.DTOPersonaTipo;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Box;
import javax.swing.JLabel;
import javax.swing.JPanel;

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
            btnRowIni.addActionListener(this);
            btnRowAnt.addActionListener(this);
            btnRowSig.addActionListener(this);
            btnRowFin.addActionListener(this);

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
    private void loadRowData() throws Exception{
       regAct           = 1;
       dtoPersonaTipo   =blfPersonaTipo.getById(regAct);
       regMax           = blfPersonaTipo.getMaxReg();
       
            }
    private void showRowData () {
        txtIdTipo.setText        (dtoPersonaTipo.getIdPersonaTipo().toString());
        txtTipoPersona.setText   (dtoPersonaTipo.getTipo());
        lblTotalReg.setText      ((regAct.toString())+"de"+regMax);
         }
            @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==btnRowIni)
            regAct=1;
        if(e.getSource()==btnRowAnt && (regAct > 1))
            regAct--;
        if(e.getSource()==btnRowSig && (regAct < regMax))
            regAct++;
        if (e.getSource() ==btnRowFin)
        regAct = regMax;
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



        

            }
