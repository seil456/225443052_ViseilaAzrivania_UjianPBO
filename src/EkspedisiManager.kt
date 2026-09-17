class EkspedisiManager {
    private val daftarPaket: MutableList<Paket> = mutableListOf()
    fun terimaPaket(paket: Paket) {
        daftarPaket.add(paket)
    }

    fun lacakPaket(resi: String) {
        val paket = daftarPaket.find { it.nomorResi == resi }
        if (paket != null) {
            paket.tampilkanInfo()

            when (paket) {
                is PaketEkspres -> println("Catatan: Ini adalah Paket Ekspres dengan biaya asuransi.")
                is PaketFragile -> println("Catatan: Ini adalah Paket Fragile (Pecah Belah) dengan packing kayu.")
                else -> println("Catatan: Ini adalah Paket Reguler.")
            }
        } else {
            println("Paket dengan nomor resi $resi tidak ditemukan.")
        }
    }

    fun tampilkanSemuaPaket() {
        if (daftarPaket.isEmpty()) {
            println("Belum ada paket di dalam sistem.")
        } else {
            for (paket in daftarPaket) {
                paket.tampilkanInfo()
                println("-----------------------------------")
            }
        }
    }

    fun hitungTotalPendapatan(): Double {
        var total = 0.0
        for (paket in daftarPaket) {
            total += paket.hitungBiaya()
        }
        return total
    }
}