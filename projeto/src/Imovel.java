public class Imovel {
    private Endereco endereco;
    private String disponibilidade;
    private double area;
    private int codigo;
    private double valor;
    private String status;

    public Imovel(Endereco endereco, String disponibilidade, double area, int codigo, double valor, String status) {
        this.endereco = endereco;
        this.disponibilidade = disponibilidade;
        this.area = area;
        this.codigo = codigo;
        this.valor = valor;
        this.status = status;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public String getDisponibilidade() {
        return disponibilidade;
    }

    public void setDisponibilidade(String disponibilidade) {
        this.disponibilidade = disponibilidade;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
