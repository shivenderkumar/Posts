package com.example.posts.presentationlayer
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.annotation.NonNull
import androidx.recyclerview.widget.RecyclerView
import com.example.posts.R
import com.example.posts.data.model.PostItem
import java.util.ArrayList

class PostsAdapter(
    private val postList:ArrayList<PostItem>,
    private val context: Context,
    private val clickListener: (PostItem) -> Unit,
) : RecyclerView.Adapter<PostsAdapter.PostViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(
            R.layout.card_post_item,
            parent, false
        )
        return PostViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        holder.bind(postList.get(position), clickListener)
    }

    override fun getItemCount(): Int {
        return postList.size
    }

    class PostViewHolder(itemView:View) : RecyclerView.ViewHolder(itemView) {
        fun bind(item: PostItem, clickListener: (PostItem) -> Unit){
            var postTitleTV : TextView
            postTitleTV= itemView.findViewById<TextView>(R.id.textview_post_title)
            postTitleTV.text = item.title
            itemView.setOnClickListener{
                clickListener(item)
            }
        }
    }
}