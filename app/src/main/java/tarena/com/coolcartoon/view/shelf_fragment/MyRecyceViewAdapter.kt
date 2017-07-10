package tarena.com.coolcartoon.view.shelf_fragment

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import tarena.com.coolcartoon.R
import tarena.com.coolcartoon.model.Book

/**
 * Created by tarena on 2017/7/7.
 */
class MyRecyceViewAdapter(var context: Context) : RecyclerView.Adapter<MyRecyceViewAdapter.ViewHolder>() {

    lateinit var dataList:Array<Book>
    override fun getItemCount(): Int {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
        var view: View = View.inflate(parent!!.context, R.layout.recycleview_item,null)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
        holder?.tvTitle!!.text = dataList[position].name
        holder.tvReadState.text= dataList[position].type
        //日期先写死
        holder.tvDate.text = dataList[position].lastUpdate.toString()
        Glide.with(context).load(dataList[position].coverImg).into(holder?.ivphoto)
        holder.btnContinue.setOnClickListener {
        }
    }

    class ViewHolder : RecyclerView.ViewHolder {
        var tvTitle: TextView
        var tvDate: TextView
        var tvReadState: TextView
        var ivphoto: ImageView
        var btnContinue: Button
        constructor(itemView: View?) : super(itemView) {
            tvTitle = itemView!!.findViewById(R.id.tv_title)
            tvDate = itemView.findViewById(R.id.tv_date)
            tvReadState = itemView.findViewById(R.id.tvReadState)
            ivphoto = itemView.findViewById(R.id.iv_photo)
            btnContinue = itemView.findViewById(R.id.btn_continue)
        }
    }
    fun addData(data:Array<Book>) {
        dataList = data
    }

}

