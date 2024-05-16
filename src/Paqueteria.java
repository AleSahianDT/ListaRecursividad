public class Paqueteria {
    private int trancking;
    private double peso;
    private String ciudadEntrega;
    private String ciudadRecepcion;
    private String cedulaReceptor;
    private String estado;

    public Paqueteria(int trancking, double peso, String ciudadEntrega, String ciudadRecepcion, String cedulaReceptor) {
        this.trancking = trancking;
        this.peso = peso;
        this.ciudadEntrega = ciudadEntrega;
        this.ciudadRecepcion = ciudadRecepcion;
        this.cedulaReceptor = cedulaReceptor;
        this.estado = "Receptado";
    }

    public int getTrancking() {
        return trancking;
    }

    public void setTrancking(int trancking) {
        this.trancking = trancking;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public String getCiudadEntrega() {
        return ciudadEntrega;
    }

    public void setCiudadEntrega(String ciudadEntrega) {
        this.ciudadEntrega = ciudadEntrega;
    }

    public String getCiudadRecepcion() {
        return ciudadRecepcion;
    }

    public void setCiudadRecepcion(String ciudadRecepcion) {
        this.ciudadRecepcion = ciudadRecepcion;
    }

    public String getCedulaReceptor() {
        return cedulaReceptor;
    }

    public void setCedulaReceptor(String cedulaReceptor) {
        this.cedulaReceptor = cedulaReceptor;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "-----PAQUETERIA-----"+
                "\nNumero de tracking: "+trancking+
                "\nPeso: "+peso+
                "\nCiudad de entrega: "+ciudadEntrega+
                "\nCiudad de receptcion: "+ciudadRecepcion+
                "\nCedula del receptor: "+cedulaReceptor+
                "\nEstado: "+estado;
    }
}
