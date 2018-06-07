package com.firman.proyek2volley.Getset;

public class Travel {
    private int id_travel;
    private String nama;
    private String deskripsi;
    private String gambar;

    public Travel(int id_travel, String nama, String deskripsi, String gambar) {
        this.id_travel = id_travel;
        this.nama = nama;
        this.deskripsi = deskripsi;
        this.gambar = gambar;
    }

    public int getId() {
        return id_travel;
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
