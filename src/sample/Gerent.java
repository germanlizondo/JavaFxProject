package sample;

public class Gerent extends Empleat {

    private Encargado<Tauleta,Videoconsola> productosEncargado = new Encargado<>();
    private Encargado<Gerent,Vendedor> empleadosEncargado = new Encargado<>();



    public Gerent(String nom, String cognom, int edad, int seguretatsocial) {
        super(nom, cognom, edad, seguretatsocial);
    }

    public void encargarseDeProductos(Tauleta tauleta,Videoconsola videoconsola){
        this.productosEncargado.setObejto1(tauleta);
        this.productosEncargado.setObjeto2(videoconsola);
    }

    public void encargarseDeEmpleados(Gerent gerent,Vendedor vendedor){
        this.empleadosEncargado.setObejto1(gerent);
        this.empleadosEncargado.setObjeto2(vendedor);
    }
    public class Encargado<T,E>{

        private T obejto1;
        private E objeto2;


        public T getObejto1() {
            return obejto1;
        }

        public void setObejto1(T obejto1) {
            this.obejto1 = obejto1;
        }

        public E getObjeto2() {
            return objeto2;
        }

        public void setObjeto2(E objeto2) {
            this.objeto2 = objeto2;
        }
    }
}
