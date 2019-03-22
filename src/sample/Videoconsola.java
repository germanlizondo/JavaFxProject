package sample;

public class Videoconsola extends Product {

    private float capacitat;
    private float pes;
    private int ram;
    private String cpu;
    private String gpu;

    public Videoconsola(int referencia, String nom, float preu, String marca, String model, int quantitat, float capacitat, float pes, int ram, String cpu, String gpu) {
        super(referencia, nom, preu, marca, model, quantitat);
        this.capacitat = capacitat;
        this.pes = pes;
        this.ram = ram;
        this.cpu = cpu;
        this.gpu = gpu;
    }

    /**
     * Sets new pes.
     *
     * @param pes New value of pes.
     */
    public void setPes(float pes) {
        this.pes = pes;
    }

    /**
     * Sets new gpu.
     *
     * @param gpu New value of gpu.
     */
    public void setGpu(String gpu) {
        this.gpu = gpu;
    }

    /**
     * Gets cpu.
     *
     * @return Value of cpu.
     */
    public String getCpu() {
        return cpu;
    }

    /**
     * Gets gpu.
     *
     * @return Value of gpu.
     */
    public String getGpu() {
        return gpu;
    }

    /**
     * Gets pes.
     *
     * @return Value of pes.
     */
    public float getPes() {
        return pes;
    }

    /**
     * Sets new capacitat.
     *
     * @param capacitat New value of capacitat.
     */
    public void setCapacitat(float capacitat) {
        this.capacitat = capacitat;
    }

    /**
     * Sets new cpu.
     *
     * @param cpu New value of cpu.
     */
    public void setCpu(String cpu) {
        this.cpu = cpu;
    }

    /**
     * Gets capacitat.
     *
     * @return Value of capacitat.
     */
    public float getCapacitat() {
        return capacitat;
    }

    /**
     * Sets new ram.
     *
     * @param ram New value of ram.
     */
    public void setRam(int ram) {
        this.ram = ram;
    }

    /**
     * Gets ram.
     *
     * @return Value of ram.
     */
    public int getRam() {
        return ram;
    }





}
