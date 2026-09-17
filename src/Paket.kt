open class Paket (
    val nomorResi: String,
    val pengirim: String,
    val penerima: String,
    val beratKg: Double
) {
    var status: StatusPengiriman = StatusPengiriman.MenungguDiproses
        private set
    open fun hitungBiaya(): Double {
        return beratKg * 10000.0
    }
    fun updateStatus(statusBaru: StatusPengiriman){
        this.status = statusBaru
    }
    open fun tampilkanInfo() {
        println("Nomor Resi: $nomorResi")
        println("Pengirim: $pengirim")
        println("Penerima: $penerima")
        val deskripsiStatus = when (val s = status) {
            is StatusPengiriman.MenungguDiproses -> "Menunggu Diproses"
            is StatusPengiriman.DalamPerjalanan -> "Dalam Perjalanan (Kurir: ${s.namaKurir})"
            is StatusPengiriman.Terkirim -> "Terkirim kepada ${s.namaPenerima} (${s.waktuSelesai})"
            is StatusPengiriman.Gagal -> "Gagal (${s.alasan})"
        }

        println("Status Saat Ini: $deskripsiStatus")
        println("Biaya Pengiriman: ${hitungBiaya()}")
    }
}