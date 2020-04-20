package id.bas.news

import com.google.gson.annotations.SerializedName

data class ResponseNews(

	@field:SerializedName("data")
	val data: List<DataItem?>? = null,

	@field:SerializedName("status")
	val status: String? = null
)