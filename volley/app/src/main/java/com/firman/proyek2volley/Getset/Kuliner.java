package com.firman.proyek2volley.Getset;

public class Kuliner {
    private int id_kuliner;
    private String nama;
    private String deskripsi;
    private String gambar;

    public Kuliner(int id_kuliner, String nama, String deskripsi, String gambar) {
        this.id_kuliner = id_kuliner;
        this.nama = nama;
        this.deskripsi = deskripsi;
        this.gambar = gambar;
    }

    public int getId() {
        return id_kuliner;
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
