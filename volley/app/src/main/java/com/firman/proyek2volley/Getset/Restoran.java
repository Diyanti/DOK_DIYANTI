package com.firman.proyek2volley.Getset;

public class Restoran {
    private int id_restoran;
    private String nama;
    private String deskripsi;
    private String gambar;

    public Restoran(int id_restoran, String nama, String deskripsi, String gambar) {
        this.id_restoran = id_restoran;
        this.nama = nama;
        this.deskripsi = deskripsi;
        this.gambar = gambar;
    }

    public int getId() {
        return id_restoran;
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
