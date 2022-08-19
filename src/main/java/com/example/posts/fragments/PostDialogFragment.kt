package com.example.posts.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.annotation.Nullable
import androidx.fragment.app.DialogFragment
import com.example.posts.R


class PostDialogFragment() :     DialogFragment(){
    lateinit var userIdTV : TextView
    lateinit var idTV : TextView
    lateinit var titleTV : TextView
    lateinit var bodyTV : TextView

    @Nullable
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView: View = inflater.inflate(R.layout.fragment_postitem, container)

        userIdTV = rootView.findViewById(R.id.userid_textview)
        idTV = rootView.findViewById(R.id.id_textview)
        titleTV = rootView.findViewById(R.id.title_textview)
        bodyTV = rootView.findViewById(R.id.body_textview)

        userIdTV.text = arguments?.getInt("userId").toString()
        idTV.text = arguments?.getInt("id").toString()
        titleTV.text = arguments?.getString("title")
        bodyTV.text = arguments?.getString("body")

        this.dialog!!.setTitle("TV Shows")
        return rootView
    }

//    private fun setupView(view: View) {
//        view.text = arguments?.getString(KEY_TITLE)
//        view.tvSubTitle.text = arguments?.getString(KEY_SUBTITLE)
//    }

}





