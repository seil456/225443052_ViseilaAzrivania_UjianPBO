fun main() {
    val manager = EkspedisiManager()

    val paket1 = PaketReguler("REG001", "Andi", "Budi", 2.0)
    val paket2 = PaketReguler("REG002", "Siti", "Dewi", 1.5)
    val paket3 = PaketEkspres("EXP001", "Joko", "Rini", 3.0, 5000.0)
    val paket4 = PaketFragile("FRG001", "Ahmad", "Siska", 2.0, 15000.0)

    manager.terimaPaket(paket1)
    manager.terimaPaket(paket2)
    manager.terimaPaket(paket3)
    manager.terimaPaket(paket4)

    paket1.updateStatus(StatusPengiriman.DalamPerjalanan("Kurir Andi"))
    paket2.updateStatus(StatusPengiriman.Terkirim("Penerima Budi", "14:30 WIB"))
    paket3.updateStatus(StatusPengiriman.Gagal("Alamat tidak ditemukan"))

    println("=== INFORMASI SEMUA PAKET ===")
    manager.tampilkanSemuaPaket()

    println("\n=== PENGUJIAN LACAK PAKET & SMART CASTING ===")
    manager.lacakPaket("EXP001")
    println()
    manager.lacakPaket("FRG001")

    println("\n=== TOTAL PENDAPATAN ===")
    val totalPendapatan = manager.hitungTotalPendapatan()
    println("Total Pendapatan Seluruh Ekspedisi: Rp$totalPendapatan")
}