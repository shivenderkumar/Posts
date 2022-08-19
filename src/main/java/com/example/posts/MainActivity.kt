package com.example.posts

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.example.posts.data.model.PostItem
import com.example.posts.databinding.ActivityMainBinding
import com.example.posts.di.PostApplication
import com.example.posts.fragments.PostDialogFragment
import com.example.posts.presentationlayer.PostsAdapter
import com.example.posts.viewmodel.PostViewModel
import com.example.posts.viewmodel.PostViewModelFactory
import javax.inject.Inject

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var postViewModel: PostViewModel
    @Inject
    lateinit var postViewModelFactory: PostViewModelFactory

    lateinit var postRV: RecyclerView
    lateinit var postAdapter: PostsAdapter
    lateinit var postArrayList: ArrayList<PostItem>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        (application as PostApplication).applicationComponent.inject(this)
        postViewModel = ViewModelProvider(this,postViewModelFactory).get(PostViewModel::class.java)

        postRV = binding.recyclerview
        postArrayList = ArrayList<PostItem>()
        postAdapter = PostsAdapter(postArrayList,this, { selectedPostItem: PostItem ->
            listItemClicked(selectedPostItem)
        })
        postRV.adapter = postAdapter

        postViewModel.postsLiveData.observe( this,{
            Log.i("MYTAG2", it.toString())
            postArrayList.clear()
            postAdapter.notifyDataSetChanged()
            postArrayList.addAll(it)
            postAdapter.notifyDataSetChanged()
        })

    }

    private fun listItemClicked(postItem: PostItem) {
//        Toast.makeText(this, "clicked " + postItem.id, Toast.LENGTH_SHORT)
//            .show()
        val postdialogFragment = PostDialogFragment()
        val args = Bundle()
        args.putInt("userId", postItem.userId)
        args.putInt("id", postItem.id)
        args.putString("title", postItem.title)
        args.putString("body", postItem.body)
        postdialogFragment.setArguments(args)
        postdialogFragment.show(supportFragmentManager, "My Fragment")
    }
}