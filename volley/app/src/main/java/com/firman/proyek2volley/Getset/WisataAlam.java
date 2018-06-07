package com.firman.proyek2volley.Getset;

public class WisataAlam {
    private int id_pariwisata;
    private String nama;
    private String deskripsi;
    private String gambar;

    public WisataAlam(int id_pariwisata, String nama, String deskripsi, String gambar) {
        this.id_pariwisata = id_pariwisata;
        this.nama = nama;
        this.deskripsi = deskripsi;
        this.gambar = gambar;
    }

    public int getId() {
        return id_pariwisata;
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
