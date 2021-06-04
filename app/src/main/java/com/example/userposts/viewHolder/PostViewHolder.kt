package com.example.userposts.viewHolder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.dominio.model.UserPostsDomain
import kotlinx.android.synthetic.main.post_list_item.view.*

class PostViewHolder(itemView: View):RecyclerView.ViewHolder(itemView) {


    fun bindTo(postsDomain: UserPostsDomain){
        itemView.apply {
            title.text = postsDomain.title
            body.text = postsDomain.body
        }
    }
}
