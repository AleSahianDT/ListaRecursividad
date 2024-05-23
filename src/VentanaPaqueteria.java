import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
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
    private JButton totalPaquetesButton;
    private JButton totalPesoButton;
    private JComboBox comboBox3;
    private JButton totalPesoPorCiudadButton;
    private JList list1;
    private JButton modificarButton;
    private JTextField textField3;
    private JButton button1;
    private Lista paquetes = new Lista();
    public VentanaPaqueteria(){
        quemarDatos();
        agregarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    paquetes.adicionarElemento(new Paqueteria(Integer.parseInt(spinner1.getValue().toString()),
                            Double.parseDouble(textField2.getText()),
                            comboBox2.getSelectedItem().toString(),
                            comboBox1.getSelectedItem().toString(),
                            textField1.getText()));
                    JOptionPane.showMessageDialog(null,"Paquete Agregado");
                    limpiarDatos();
                    System.out.println(paquetes.listarPaquetes());
                }catch(Exception ex){
                    JOptionPane.showMessageDialog(null,ex.getMessage());
                }
            }
        });
        totalPaquetesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null,"El total de paquetes es \n"+
                    paquetes.sumarTotalPaquetes());
            }
        });
        totalPesoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null,"El peso total del paquete es \n"+
                        paquetes.sumarTotalPeso());
            }
        });
        totalPesoPorCiudadButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null,"El peso total del paquete en la ciudad" +comboBox3.getSelectedItem().toString()+
                        "es \n"+paquetes.sumarTotalPesoCiudad(comboBox3.getSelectedItem().toString()));
            }
        });
        list1.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if(list1.getSelectedIndex()!=-1){
                    int indice = list1.getSelectedIndex();
                    Paqueteria pa = paquetes.getServiEntrega().get(indice);
                    spinner1.setValue(pa.getTrancking());
                    textField2.setText(""+pa.getPeso());
                    comboBox2.setSelectedItem(pa.getCiudadRecepcion());
                    comboBox1.setSelectedItem(pa.getCiudadEntrega());
                    textField1.setText(pa.getCedulaReceptor());
                }
            }
        });
    }
    public void limpiarDatos() {
        spinner1.setValue(0);
        textField2.setText("");
        comboBox2.setSelectedIndex(0);
        comboBox1.setSelectedIndex(0);
        textField1.setText("");
        comboBox3.setSelectedIndex(0);
    }
    public void quemarDatos(){
        try{
            paquetes.adicionarElemento(new Paqueteria(123,25,"Quito","Cuenca","1111111111"));
            paquetes.adicionarElemento(new Paqueteria(456,50,"Guayaquil","Cuenca","1010101010"));
            paquetes.adicionarElemento(new Paqueteria(789,10,"Cuenca","Santo Domingo","1212121212"));
        }catch(Exception e){
            //vacio
        }
    }
    public void LlenarJList(){
        DefaultListModel dlm = new DefaultListModel();
        for(Paqueteria pa: paquetes.getServiEntrega())
            dlm.addElement(pa);
        list1.setModel(dlm);
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
