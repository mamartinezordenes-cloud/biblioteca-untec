package model;

public class Prestamo {
    private int id;
    private int idLibro;
    private String tituloLibro;
    private String usuario;
    private String fechaPrestamo;
    private String estado; // 'ACTIVO' o 'DEVUELTO'

    public Prestamo() {}

    public Prestamo(int id, int idLibro, String tituloLibro, String usuario, String fechaPrestamo, String estado) {
        this.id = id;
        this.idLibro = idLibro;
        this.tituloLibro = tituloLibro;
        this.usuario = usuario;
        this.fechaPrestamo = fechaPrestamo;
        this.estado = estado;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public int getIdLibro() { return idLibro; }
    public void setIdLibro(int idLibro) { this.idLibro = idLibro; }

    public String getTituloLibro() { return tituloLibro; }
    public void setTituloLibro(String tituloLibro) { this.tituloLibro = tituloLibro; }

    public String getUsuario() { return usuario; }
    public void setUsuario(String usuario) { this.usuario = usuario; }

    public String getFechaPrestamo() { return fechaPrestamo; }
    public void setFechaPrestamo(String fechaPrestamo) { this.fechaPrestamo = fechaPrestamo; }

    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }
}
