package com.firman.proyek2volley.Getset;

public class Kegiatan {
    private int id_kegiatan;
    private String nama;
    private String tanggal;
    private String tempat;
    private String deskripsi;
    private String gambar;

    public Kegiatan(int id_kegiatan, String nama, String tanggal, String tempat, String deskripsi, String gambar) {
        this.id_kegiatan = id_kegiatan;
        this.nama = nama;
        this.tanggal = tanggal;
        this.tempat = tempat;
        this.deskripsi = deskripsi;
        this.gambar = gambar;
    }

    public int getId() {
        return id_kegiatan;
    }

    public String getNama() {
        return nama;
    }

    public String getTanggal() {
        return tanggal;
    }

    public String getTempat() {
        return tempat;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public String getGambar() {
        return gambar;
    }
}
