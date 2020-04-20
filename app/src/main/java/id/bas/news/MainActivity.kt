package id.bas.news

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rv_news.layoutManager = GridLayoutManager(this, 1)
        getData()
    }

    private fun getData() {
        ApiRetrofit.create().getNews("1pbg0fV8rYGKc2tYSL04un80zvTg7vvYLlB4yk-PjQkQ",
            "1")
            .enqueue(object : Callback<ResponseNews> {
                override fun onFailure(call: Call<ResponseNews>?, t: Throwable?) {
                    //untuk terima result error
                    Toast.makeText(this@MainActivity,"Error terima data",Toast.LENGTH_LONG).show()
                }

                override fun onResponse(
                    call: Call<ResponseNews>?,
                    response: Response<ResponseNews>?
                ) {

                    //terima result sukses
                    Log.e("TAG","sukses terima data ${Gson().toJson(response?.body()?.data)}")
                    val adapter = AdapterNews(response?.body()?.data as ArrayList<DataItem>)
                    rv_news.adapter = adapter
                    adapter.notifyDataSetChanged()


                }
            })
    }


}
