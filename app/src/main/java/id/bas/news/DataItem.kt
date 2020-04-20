package id.bas.news

import com.google.gson.annotations.SerializedName

data class DataItem(

	@field:SerializedName("")
	val jsonMember: String? = null,

	@field:SerializedName("nama_berita")
	val namaBerita: String? = null,

	@field:SerializedName("keterangan")
	val keterangan: String? = null,

	@field:SerializedName("sumber")
	val sumber: String? = null,

	@field:SerializedName("tanggal")
	val tanggal: String? = null,

	@field:SerializedName("timestamp")
	val timestamp: String? = null,

	@field:SerializedName("isi_berita")
	val isiBerita: String? = null,

	@field:SerializedName("url_image")
	val urlImage: String? = null
)