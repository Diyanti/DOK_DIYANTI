package com.firman.proyek2volley.Getset;

public class Hotel {
    private int id_hotel;
    private String nama;
    private String deskripsi;
    private String gambar;

    public Hotel(int id_hotel, String nama, String deskripsi, String gambar) {
        this.id_hotel = id_hotel;
        this.nama = nama;
        this.deskripsi = deskripsi;
        this.gambar = gambar;
    }

    public int getId() {
        return id_hotel;
    }

    public String getNama() {
        return nama;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public String getGambar() {
        return gambar;
    }
}
