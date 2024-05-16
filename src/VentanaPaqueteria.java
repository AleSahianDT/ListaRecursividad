import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaPaqueteria {
    private JPanel ventana;
    private JTabbedPane tabbedPane1;
    private JSpinner spinner1;
    private JComboBox comboBox1;
    private JComboBox comboBox2;
    private JTextField textField1;
    private JButton agregarButton;
    private JTextField textField2;
    private Lista paquetes = new Lista();
    public VentanaPaqueteria(){

        agregarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    paquetes.adicionarElemento(new Paqueteria(Integer.parseInt(spinner1.getValue().toString()),
                            Double.parseDouble(textField1.getText()),
                            comboBox1.getSelectedItem().toString(),
                            comboBox2.getSelectedItem().toString(),
                            textField2.getText()));
                    JOptionPane.showMessageDialog(null,"Paquete Agregado");
                    System.out.println(paquetes.listarPaquetes());
                }catch(Exception ex){
                    JOptionPane.showMessageDialog(null,ex.getMessage());
                }
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("VentanaPaqueteria");
        frame.setContentPane(new VentanaPaqueteria().ventana);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setSize(500,500);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
    }
}
