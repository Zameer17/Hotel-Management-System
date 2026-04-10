package jdbc_progams;

import java.awt.Color;
import java.awt.Font;
import java.sql.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.math.BigDecimal;

public class ManageEmployees extends javax.swing.JFrame {

    // Constructor
    public ManageEmployees() {
        setTitle("Employees");
        initComponents();
        setLocationRelativeTo(null);
        loadEmployees();
         styleEmployeeTable();
         Color btnColor = new Color(70, 130, 180); // Steel blue
        Color btnText = Color.WHITE;
        JButton[] buttons = {jButton1};
        for (JButton btn : buttons) {
            btn.setBackground(btnColor);
            btn.setForeground(btnText);
            btn.setFocusPainted(false);
            btn.setBorder(BorderFactory.createEmptyBorder(5, 15, 5, 15));
        }
        
    }

    private void styleEmployeeTable() {
    // Colors from your UI theme
    Color btnColor = new Color(70, 130, 180);   // Steel Blue
    Color btnText = Color.WHITE;
    Color bgColor = new Color(230, 245, 255);   // Light background
    Color lblText = new Color(0, 51, 102);      // Dark Blue text

    // Table Background & Foreground
    jTable1.setBackground(Color.WHITE);
    jTable1.setForeground(Color.BLACK);
    jTable1.setRowHeight(28);

    // Table Header
    jTable1.getTableHeader().setBackground(btnColor);
    jTable1.getTableHeader().setForeground(btnText);
    jTable1.getTableHeader().setFont(new java.awt.Font("Segoe UI", java.awt.Font.BOLD, 14));
    jTable1.getTableHeader().setOpaque(false);

    // Grid Lines
    jTable1.setShowGrid(true);
    jTable1.setGridColor(new Color(200, 200, 200));

    // Row Alternating Backgrounds
    jTable1.setDefaultRenderer(Object.class, new javax.swing.table.DefaultTableCellRenderer() {
        @Override
        public java.awt.Component getTableCellRendererComponent(
                javax.swing.JTable table, Object value, boolean isSelected,
                boolean hasFocus, int row, int column) {

            java.awt.Component c = super.getTableCellRendererComponent(
                    table, value, isSelected, hasFocus, row, column);

            if (!isSelected) {
                if (row % 2 == 0) {
                    c.setBackground(new Color(245, 245, 245)); // light gray
                } else {
                    c.setBackground(Color.WHITE);
                }
                c.setForeground(Color.BLACK);
            } else {
                c.setBackground(new Color(70, 130, 180)); // highlight same as button color
                c.setForeground(Color.WHITE);
            }
            return c;
        }
    });
}

    // Load Employee Data into JTable
    private void loadEmployees() {
        DefaultTableModel df = (DefaultTableModel) jTable1.getModel();
        df.setRowCount(0); // clear old data

        try (Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/", "name", "password");
             PreparedStatement pst = con.prepareStatement("SELECT * FROM employees");
             ResultSet rs = pst.executeQuery()) {

            while (rs.next()) {
                String employeeId = rs.getString("employee_id");       // VARCHAR
                String firstName = rs.getString("first_name");         // VARCHAR
                String lastName = rs.getString("last_name");           // VARCHAR
                String position = rs.getString("position");            // VARCHAR
                BigDecimal salary = rs.getBigDecimal("salary");        // DECIMAL(10,2)
                Date hireDate = rs.getDate("hire_date");               // DATE
                String password = rs.getString("password");            // VARCHAR

                df.addRow(new Object[]{
                    employeeId, firstName, lastName, position,
                    salary, hireDate, password
                });
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this,
                    "Load Employees Error: " + e.getMessage(),
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Employee ID", "First Name", "Last Name", "Position", "Salary", "Hire Date", "Password"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jButton1.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        jButton1.setText("Back");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(495, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(467, 467, 467))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(27, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        DashboardUi dashboard = new DashboardUi();
        dashboard.setVisible(true);

        // Close current ManageRooms window
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> new ManageEmployees().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
