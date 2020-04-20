package id.bas.news

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.item_news.view.*

class AdapterNews (val list: ArrayList<DataItem>)
    : RecyclerView.Adapter<AdapterNews.MyHolder> ()
{
    inner class MyHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdapterNews.MyHolder {
       val view = LayoutInflater.from(parent.context).inflate(R.layout.item_news, parent, false)
        return MyHolder(view)
         }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: AdapterNews.MyHolder, position: Int) {
        holder.itemView.tv_judul.text = list[position].namaBerita

        Glide.with(holder.itemView.context)
            .load(list[position].urlImage)
            .into(holder.itemView.img_news)

        holder.itemView.setOnClickListener {
            val intent = Intent(holder.itemView.context,
                DetailActivity::class.java
                )

            intent.putExtra("JUDUL",list[position].namaBerita)
            intent.putExtra("DETAIL",list[position].isiBerita)
            intent.putExtra("IMG",list[position].urlImage)
            holder.itemView.context.startActivity(intent)

        }



    }

}