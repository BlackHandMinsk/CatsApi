package com.example.catsapi.ui

import android.graphics.drawable.AnimationDrawable
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import androidx.paging.ExperimentalPagingApi
import androidx.recyclerview.widget.GridLayoutManager

import com.example.catsapi.databinding.FragmentMainBinding
import com.example.catsapi.ui.adapter.CatsAdapter
import kotlinx.coroutines.launch


@ExperimentalPagingApi
class MainFragment : Fragment() {
    private var _binding: FragmentMainBinding? = null
    private val mBinding get() = _binding!!
    private  var mAdapter: CatsAdapter = CatsAdapter()
    @ExperimentalPagingApi
    private lateinit var mainViewModel:MainViewModel



    @ExperimentalPagingApi
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMainBinding.inflate(layoutInflater, container, false)
        setHasOptionsMenu(true)
        //mAdapter = CatsAdapter()
        initMembers()
        setUpViews(view)
        fetchCatGoImagesLiveData()
        backgroundAnimation()


        return mBinding.root
    }

    private fun backgroundAnimation() {
        val animationDrawable: AnimationDrawable = mBinding.mainLayout.background as AnimationDrawable
        animationDrawable.apply {
            setEnterFadeDuration(1000)
            setExitFadeDuration(3000)
            start()
        }
    }


    override fun onDestroyView() {
        super.onDestroyView()
        mBinding.catsList.adapter = null
        _binding = null
    }

    @ExperimentalPagingApi
    private fun initMembers() {
        mainViewModel = defaultViewModelProviderFactory.create(MainViewModel::class.java)
    }

    private fun setUpViews(view: View?) {
        mBinding.catsList.layoutManager = GridLayoutManager(context, 2)
        mBinding.catsList.adapter = mAdapter
    }


    private fun fetchCatGoImagesLiveData() {
    mainViewModel.fetchCatGoImagesLiveData().observe(viewLifecycleOwner, Observer {
        lifecycleScope.launch {
            mAdapter.submitData(it)
        }
    })
}
}

