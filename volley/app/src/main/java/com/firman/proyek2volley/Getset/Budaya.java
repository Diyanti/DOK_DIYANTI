package com.firman.proyek2volley.Getset;

/**
 * Created by Firmanvsly on 25/03/2018.
 */

public class Budaya {
    private int id_budaya;
    private String nama;
    private String deskripsi;
    private String gambar;

    public Budaya(int id_budaya, String nama, String deskripsi, String gambar) {
        this.id_budaya = id_budaya;
        this.nama = nama;
        this.deskripsi = deskripsi;
        this.gambar = gambar;
    }

    public int getId() {
        return id_budaya;
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
