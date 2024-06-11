
package ventana;

import javax.swing.*;
import javax.swing.table.TableCellEditor;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class ButtonEditor extends DefaultCellEditor {
    protected JButton button;
    private String label;
    private boolean isPushed;
    private inicial frame;

    public ButtonEditor(JCheckBox checkBox, inicial frame) {
        super(checkBox);
        this.frame = frame;
        button = new JButton();
        button.setOpaque(true);
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                fireEditingStopped();
            }
        });
    }

    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        label = (value == null) ? "" : value.toString();
        button.setText(label);
        isPushed = true;
        return button;
    }

    @Override
    public Object getCellEditorValue() {
        if (isPushed) {
            int selectedRow = frame.tablaa.getSelectedRow();
            if (label.equals("Abrir")) {
                // Acción del botón "Abrir"
                JOptionPane.showMessageDialog(button, "Chat con: " + frame.modelo.getValueAt(selectedRow, 1));
            } else if (label.equals("Eliminar")) {
                // Acción del botón "Eliminar"
                frame.modelo.removeRow(selectedRow);
            }
        }
        isPushed = false;
        return new String(label);
    }

    @Override
    public boolean stopCellEditing() {
        isPushed = false;
        return super.stopCellEditing();
    }

    @Override
    protected void fireEditingStopped() {
        super.fireEditingStopped();
    }
}  

