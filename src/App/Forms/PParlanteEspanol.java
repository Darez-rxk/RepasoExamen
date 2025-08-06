// Clase corregida: PParlanteEspanol.java
package App.Forms;

import App.CustomerControl.PatButton;
import App.CustomerControl.PatLabel;
import App.CustomerControl.PatTextBox;
import App.Utils.IAStyle;
import BusinessLogic.BLFactory;
import DataAccess.DAO.DAOPersona;
import DataAccess.DTO.DTOPersona;
import java.awt.*;
import java.awt.event.*;
import java.util.List;
import javax.swing.*;

public class PParlanteEspanol extends JPanel implements ActionListener {
    private BLFactory<DTOPersona> blfPersona = new BLFactory<>(DAOPersona::new);
    private DTOPersona dtoPersona;
    private Integer regAct = 1, regMax = 0;

    private PatLabel lblTitulo = new PatLabel("PARLANTE ESPAÑOL - PERSONA"),
                     lblIdPersona = new PatLabel("IdPersona:"),
                     lblCedula = new PatLabel("Cédula:"),
                     lblNombre = new PatLabel("Nombre:"),
                     lblIdioma = new PatLabel("Idioma:"),
                     lblTotalReg = new PatLabel("0 de 0");

    private PatTextBox txtIdPersona = new PatTextBox(),
                       txtCedula = new PatTextBox(),
                       txtNombre = new PatTextBox(),
                       txtIdioma = new PatTextBox();

    private PatButton btnPageIni = new PatButton("<<"),
                      btnPageAnt = new PatButton("<"),
                      btnPageSig = new PatButton(">"),
                      btnPageFin = new PatButton(">>"),
                      btnRowIni = new PatButton("↤"),
                      btnRowAnt = new PatButton("↑"),
                      btnRowSig = new PatButton("↓"),
                      btnRowFin = new PatButton("↦"),
                      btnNuevo = new PatButton("Nuevo"),
                      btnGuardar = new PatButton("Guardar"),
                      btnCancelar = new PatButton("Cancelar"),
                      btnEliminar = new PatButton("Eliminar");

    private JPanel pnlTabla = new JPanel(),
                   pnlBtnRow = new JPanel(new FlowLayout()),
                   pnlBtnPage = new JPanel(new FlowLayout()),
                   pnlBtnCRUD = new JPanel(new FlowLayout());

    public PParlanteEspanol() {
        try {
            initcomponent();
            loadRowData();
            showRowData();
            showDataTable();

            btnRowIni.addActionListener(this);
            btnRowAnt.addActionListener(this);
            btnRowSig.addActionListener(this);
            btnRowFin.addActionListener(this);

            btnNuevo.addActionListener(e -> btnNuevoClick());
            btnGuardar.addActionListener(e -> btnGuardarClick());
            btnEliminar.addActionListener(e -> btnEliminarClick());
            btnCancelar.addActionListener(e -> btnCancelarClick());
        } catch (Exception e) {
            IAStyle.showMsg("Error al cargar los datos: " + e.getMessage());
        }
    }

    private void showDataTable() {
        String[] header = {"IDPersona", "Idioma", "Estado"};
        Object[][] data = new Object[regMax][3];

        try {
            List<DTOPersona> personas = blfPersona.getAll();
            for (int i = 0; i < personas.size(); i++) {
                DTOPersona p = personas.get(i);
                data[i][0] = p.getIdPersona();
                data[i][1] = p.getIdioma();
                data[i][2] = p.getEstado();
            }
        } catch (Exception e) {
            IAStyle.showMsgError("Error al cargar la tabla: " + e.getMessage());
        }

        JTable table = new JTable(data, header);
        table.setShowHorizontalLines(true);
        table.setGridColor(Color.lightGray);
        table.setRowSelectionAllowed(true);
        table.setPreferredScrollableViewportSize(new Dimension(450, 150));

        pnlTabla.removeAll();
        pnlTabla.add(new JScrollPane(table));

        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int row = table.rowAtPoint(e.getPoint());
                if (row >= 0) {
                    try {
                        int id = Integer.parseInt(table.getModel().getValueAt(row, 0).toString());
                        dtoPersona = blfPersona.getById(id);
                        regAct = id;
                        showRowData();
                    } catch (Exception ex) {
                        IAStyle.showMsgError("Error al seleccionar fila: " + ex.getMessage());
                    }
                }
            }
        });
    }

    private void btnNuevoClick() {
        dtoPersona = null;
        showRowData();
    }

    private void btnGuardarClick() {
        boolean isNull = dtoPersona == null;
        try {
            if (IAStyle.showConfirmYesNo("¿Seguro que desea " + (isNull ? "AGREGAR ?" : "ACTUALIZAR ?"))) {
                if (isNull)
                    dtoPersona = new DTOPersona();
                
                
                dtoPersona.setIdPersona(Integer.parseInt(txtIdPersona.getText()));
                dtoPersona.setCedula(txtCedula.getText());
                dtoPersona.setNombre(txtNombre.getText());
                dtoPersona.setIdioma(txtIdioma.getText());

                boolean ok = isNull ? blfPersona.add(dtoPersona) : blfPersona.upd(dtoPersona);
                IAStyle.showMsg(ok ? "Registro guardado correctamente." : "Registro fallido");
                loadRowData();
                showRowData();
                showDataTable();
            }
        } catch (Exception e) {
            IAStyle.showMsgError(e.getMessage());
        }
    }

    private void btnEliminarClick() {
        try {
            if (dtoPersona != null && IAStyle.showConfirmYesNo("¿Seguro que desea ELIMINAR ?")) {
                if (!blfPersona.del(dtoPersona.getIdPersona())) {
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

    private void btnCancelarClick() {
        try {
            loadRowData();
            showRowData();
        } catch (Exception e) {}
    }

    private void loadRowData() throws Exception {
        regAct = 1;
        dtoPersona = blfPersona.getById(regAct);
        regMax = blfPersona.getMaxReg();
    }

    private void showRowData() {
        boolean isNull = dtoPersona == null;
        txtIdPersona.setText(isNull ? "" : dtoPersona.getIdPersona().toString());
        txtCedula.setText(isNull ? "" : dtoPersona.getCedula());
        txtNombre.setText(isNull ? "" : dtoPersona.getNombre());
        txtIdioma.setText(isNull ? "" : dtoPersona.getIdioma());
        lblTotalReg.setText(regAct + " de " + regMax);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object src = e.getSource();
        if (src == btnRowIni) regAct = 1;
        else if (src == btnRowAnt) regAct = Math.max(1, regAct - 1);
        else if (src == btnRowSig) regAct = Math.min(regMax, regAct + 1);
        else if (src == btnRowFin) regAct = regMax;

        try {
            dtoPersona = blfPersona.getById(regAct);
            showRowData();
        } catch (Exception ex) {}
    }

    private void initcomponent() {
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        txtIdPersona.setEnabled( true);
        txtIdPersona.setBorderLine();
        txtCedula.setBorderLine();
        txtNombre.setBorderLine();
        txtIdioma.setBorderLine();

        pnlBtnPage.add(btnPageIni);
        pnlBtnPage.add(btnPageAnt);
        pnlBtnPage.add(new PatLabel("Page:( "));
        pnlBtnPage.add(lblTotalReg);
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

        gbc.gridy = 0; gbc.gridx = 0; gbc.gridwidth = 2;
        add(lblTitulo, gbc);

        gbc.gridy = 1; gbc.gridx = 0; gbc.gridwidth = 1;
        add(new JLabel("Sección de datos:"), gbc);
        gbc.gridx = 1;
        add(pnlBtnPage, gbc);

        gbc.gridy = 2; gbc.gridx = 0; gbc.gridwidth = 3;
        gbc.ipady = 150; gbc.ipadx = 450;
        pnlTabla.add(new Label("Loading data..."));
        add(pnlTabla, gbc);
        gbc.ipady = 1; gbc.ipadx = 1;

        gbc.gridy = 3; gbc.gridx = 0; gbc.gridwidth = 3;
        gbc.insets = new Insets(50, 0, 0, 0);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        add(Box.createRigidArea(new Dimension(0, 0)), gbc);

        gbc.insets = new Insets(10, 0, 0, 0);

        gbc.gridy = 4; gbc.gridx = 0; gbc.gridwidth = 1;
        add(lblIdPersona, gbc);
        gbc.gridx = 1;
        add(txtIdPersona, gbc);

        gbc.gridy = 5; gbc.gridx = 0;
        add(lblCedula, gbc);
        gbc.gridx = 1;
        add(txtCedula, gbc);

        gbc.gridy = 6; gbc.gridx = 0;
        add(lblNombre, gbc);
        gbc.gridx = 1;
        add(txtNombre, gbc);

        gbc.gridy = 7; gbc.gridx = 0;
        add(lblIdioma, gbc);
        gbc.gridx = 1;
        add(txtIdioma, gbc);

        gbc.gridy = 8; gbc.gridx = 0; gbc.gridwidth = 3;
        gbc.insets = new Insets(30, 0, 0, 0);
        add(pnlBtnCRUD, gbc);
    }
}