package com.example.prueba;

public class It {

    private int idPlatformOrigin;
    private int idCoin;
    private int idPlatfomDestiny;
    private int idProducto;
    private double mount;
    private int quantity;
    private String nameClient;
    private int idClient;

    public It(){}
    public It(int idPlatformOrigin, int idCoin, int idPlatfomDestiny, int idProducto, double mount, int quantity, String nameClient, int idClient) {
        this.idPlatformOrigin = idPlatformOrigin;
        this.idCoin = idCoin;
        this.idPlatfomDestiny = idPlatfomDestiny;
        this.idProducto = idProducto;
        this.mount = mount;
        this.quantity = quantity;
        this.nameClient = nameClient;
        this.idClient = idClient;
    }

    public int getIdPlatformOrigin() {
        return idPlatformOrigin;
    }

    public void setIdPlatformOrigin(int idPlatformOrigin) {
        this.idPlatformOrigin = idPlatformOrigin;
    }

    public int getIdCoin() {
        return idCoin;
    }

    public void setIdCoin(int idCoin) {
        this.idCoin = idCoin;
    }

    public int getIdPlatfomDestiny() {
        return idPlatfomDestiny;
    }

    public void setIdPlatfomDestiny(int idPlatfomDestiny) {
        this.idPlatfomDestiny = idPlatfomDestiny;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public double getMount() {
        return mount;
    }

    public void setMount(double mount) {
        this.mount = mount;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getNameClient() {
        return nameClient;
    }

    public void setNameClient(String nameClient) {
        this.nameClient = nameClient;
    }

    public int getIdClient() {
        return idClient;
    }

    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }
}
