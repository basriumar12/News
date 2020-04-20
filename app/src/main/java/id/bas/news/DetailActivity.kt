package id.bas.news

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebChromeClient
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_detail.*
import kotlinx.android.synthetic.main.item_news.*
import kotlinx.android.synthetic.main.item_news.img_news
import kotlinx.android.synthetic.main.item_news.tv_judul

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        tv_judul.text = intent.getStringExtra("JUDUL")
        val img = intent.getStringExtra("IMG")

        Glide.with(this).load(img).into(img_news)
        web.webChromeClient = WebChromeClient()
        web.settings.javaScriptEnabled = true
        web.loadData(intent.getStringExtra("DETAIL"),
            "text/html","UTF-8")
    }
}
