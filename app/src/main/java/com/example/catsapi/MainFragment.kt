package com.example.catsapi

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.catsapi.data.CatsAdapter
import com.example.catsapi.databinding.FragmentMainBinding

class MainFragment : Fragment() {
    private var _binding: FragmentMainBinding? = null
    private val mBinding get() = _binding!!
//    lateinit var mViewModel: MainViewModel
    private lateinit var mAdapter: CatsAdapter


//    override fun onAttach(context: Context) {
//        val prefs = PreferenceManager.getDefaultSharedPreferences(requireContext())
//        SORT = prefs.getString("preference_sort", "Price").toString()
//        FILTER = prefs.getString("preference_filter", "id NOT NULL").toString()
//        TYPE_DATABASE = when(prefs.getBoolean("database", false)) {
//            false -> TYPE_CURSOR
//            true -> TYPE_ROOM
//        }
//        Log.i("123", "DATABASE: $TYPE_DATABASE")
//        super.onAttach(context)
//    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {


        _binding = FragmentMainBinding.inflate(layoutInflater, container, false)
        setHasOptionsMenu(true)

        mAdapter = CatsAdapter()

        LinearLayoutManager(requireContext(), RecyclerView.VERTICAL,false).apply { mBinding.catsList.layoutManager = this }

        mBinding.catsList.adapter = mAdapter


//        mBinding.fab.setOnClickListener {
//            findNavController().navigate(R.id.action_mainFragment_to_addCarFragment)
//        }

        return mBinding.root
    }




    override fun onDestroyView() {
        super.onDestroyView()
//        mViewModel.readAllData.removeObservers(viewLifecycleOwner)
        mBinding.catsList.adapter = null
        _binding = null
    }
}