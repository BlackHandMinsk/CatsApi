package com.example.catsapi

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.viewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.OnScrollListener
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.catsapi.adapter.CatsAdapter
import com.example.catsapi.data.ApiData
import com.example.catsapi.databinding.FragmentMainBinding
import com.example.catsapi.data.ApiRequest
import com.example.catsapi.data.BASE_URL
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import retrofit2.Retrofit


class MainFragment : Fragment() {
    private var _binding: FragmentMainBinding? = null
    private val mBinding get() = _binding!!
    private lateinit var mAdapter: CatsAdapter
    private val catViewModel by viewModels<CatViewModel>()




    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {


        _binding = FragmentMainBinding.inflate(layoutInflater, container, false)
        setHasOptionsMenu(true)

        mAdapter = CatsAdapter()

//        LinearLayoutManager(
//            requireContext(),
//            RecyclerView.VERTICAL,
//            false
//        ).apply { mBinding.catsList.layoutManager = this }

        GridLayoutManager(
            requireContext(),2
        ).apply { mBinding.catsList.layoutManager = this }

        mBinding.catsList.adapter = mAdapter


        catViewModel.items.observe(viewLifecycleOwner, Observer {
            it ?: return@Observer
            mAdapter.addItems(it)
        })



        mBinding.floatingActionButton.setOnClickListener {
            catViewModel.items.observe(viewLifecycleOwner, Observer {
                it ?: return@Observer
                mAdapter.addItems(it)
            })
        }

        return mBinding.root
    }


    override fun onDestroyView() {
        super.onDestroyView()
        mBinding.catsList.adapter = null
        _binding = null
    }
}
