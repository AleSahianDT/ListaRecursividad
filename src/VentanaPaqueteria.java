import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

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
    private JButton modificarEstadoButton;
    private JButton ordenarPorBurbujaButton;
    private JTextArea textArea1;
    private JTextArea textArea2;
    private JButton ordenarPorInsercciónButton;
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
                    llenarJList();
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
                if (!e.getValueIsAdjusting()) {
                    llenarJList();
                    int indice = list1.getSelectedIndex();
                    if (indice != -1) {
                        Paqueteria pa = paquetes.getServiEntrega().get(indice);
                        spinner1.setValue(pa.getTrancking());
                        textField2.setText(String.valueOf(pa.getPeso()));
                        comboBox2.setSelectedItem(pa.getCiudadRecepcion());
                        comboBox1.setSelectedItem(pa.getCiudadEntrega());
                        textField1.setText(pa.getCedulaReceptor());
                    }
                }
            }
        });
        ordenarPorBurbujaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }

        //FUNCIONES
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

    public void llenarJList(){
        DefaultListModel dlm = new DefaultListModel();
        for(Paqueteria pa: paquetes.getServiEntrega())
            dlm.addElement(pa);
        list1.setModel(dlm);
    }

    public void ordenarBurbuja(int array[]){
        List<Paqueteria> paqueteriauxiliar;
        paqueteriauxiliar = paquetes.getServiEntrega();
        int size = paqueteriauxiliar.size();
        //Ejecutar bucle dos veces
        for (int i=0; i < size -1; i++) {
            //Registo de intercambios
            boolean swapped = true;
            for (int trancking = 0; trancking < size - i - 1; trancking++) {
                //Orden descendiente
                if (array[trancking] > array[trancking+1]) {
                    //Intercambio
                    int temp= array[trancking];
                    array[trancking] = array[trancking+1];
                    array[trancking+1] = temp;

                    swapped = false;
                }
            }
            //Si no ha habido intercambio
            if (swapped == true)
                break;
        }
    }

    //MAIN
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
