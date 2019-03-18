package sample;

public class Tauleta extends Product {

    private int pntPolzades;
    private String pantalla;
    private Procesador procesador;
    private String resPantalla;

    public Tauleta(int referencia, String nom, float preu, boolean garantia, String marca, String model, int pntPolzades, String pantalla, Procesador procesador, String resPantalla) {
        super(referencia, nom, preu, garantia, marca, model);
        this.pntPolzades = pntPolzades;
        this.pantalla = pantalla;
        this.procesador = procesador;
        this.resPantalla = resPantalla;
    }

    /**
     * Gets resPantalla.
     *
     * @return Value of resPantalla.
     */
    public String getResPantalla() {
        return resPantalla;
    }

    /**
     * Sets new resPantalla.
     *
     * @param resPantalla New value of resPantalla.
     */
    public void setResPantalla(String resPantalla) {
        this.resPantalla = resPantalla;
    }

    /**
     * Gets procesador.
     *
     * @return Value of procesador.
     */
    public Procesador getProcesador() {
        return procesador;
    }

    /**
     * Gets pntPolzades.
     *
     * @return Value of pntPolzades.
     */
    public int getPntPolzades() {
        return pntPolzades;
    }

    /**
     * Sets new pntPolzades.
     *
     * @param pntPolzades New value of pntPolzades.
     */
    public void setPntPolzades(int pntPolzades) {
        this.pntPolzades = pntPolzades;
    }

    /**
     * Gets pantalla.
     *
     * @return Value of pantalla.
     */
    public String getPantalla() {
        return pantalla;
    }

    /**
     * Sets new procesador.
     *
     * @param procesador New value of procesador.
     */
    public void setProcesador(Procesador procesador) {
        this.procesador = procesador;
    }

    /**
     * Sets new pantalla.
     *
     * @param pantalla New value of pantalla.
     */
    public void setPantalla(String pantalla) {
        this.pantalla = pantalla;
    }



    class Procesador{

        private String nombre;
        private float hz;
        private int generacion;
        private int arquitectura;

        public Procesador(String nombre, float hz, int generacion, int arquitectura) {
            this.nombre = nombre;
            this.hz = hz;
            this.generacion = generacion;
            this.arquitectura = arquitectura;
        }

        /**
         * Gets arquitectura.
         *
         * @return Value of arquitectura.
         */
        public int getArquitectura() {
            return arquitectura;
        }

        /**
         * Gets nombre.
         *
         * @return Value of nombre.
         */
        public String getNombre() {
            return nombre;
        }

        /**
         * Sets new nombre.
         *
         * @param nombre New value of nombre.
         */
        public void setNombre(String nombre) {
            this.nombre = nombre;
        }

        /**
         * Gets generacion.
         *
         * @return Value of generacion.
         */
        public int getGeneracion() {
            return generacion;
        }

        /**
         * Gets Hz.
         *
         * @return Value of Hz.
         */
        public float getHz() {
            return hz;
        }

        /**
         * Sets new arquitectura.
         *
         * @param arquitectura New value of arquitectura.
         */
        public void setArquitectura(int arquitectura) {
            this.arquitectura = arquitectura;
        }

        /**
         * Sets new generacion.
         *
         * @param generacion New value of generacion.
         */
        public void setGeneracion(int generacion) {
            this.generacion = generacion;
        }

        /**
         * Sets new Hz.
         *
         * @param hz New value of Hz.
         */
        public void setHz(float hz) {
            this.hz = hz;
        }
    }
}
