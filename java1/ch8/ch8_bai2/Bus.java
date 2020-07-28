package ch8_bai2;

public class Bus extends Car {

    private String tuyenXe;

    public String getTuyenXe() {
        return tuyenXe;
    }

    public void setTuyenXe(String tuyenXe) {
        this.tuyenXe = tuyenXe;
    }

    public Bus() {
    }

    public Bus(String tuyenXe) {
        this.tuyenXe = tuyenXe;
    }

    public Bus(String tuyenXe, String bienSo, String mauXe, int soChoNgoi) {
        super(bienSo, mauXe, soChoNgoi);
        this.tuyenXe = tuyenXe;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append(String.format("%-20s%s%n", "Tuyen xe:", getTuyenXe()));
        sb.append(String.format("%-20s%s%n", "Bien so:", getBienSo()));
        sb.append(String.format("%-20s%s%n", "Mau xe:", getMauXe()));
        sb.append(String.format("%-20s%s%n", "So cho ngoi:", getSoChoNgoi()));
        sb.append(String.format("%-20s%s%n", "Phi:", dongPhi()));

        return sb.toString();
    }

    @Override
    public double dongPhi() {
        return getSoChoNgoi() * 1000;
    }
}
