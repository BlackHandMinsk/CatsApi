package com.example.catsapi.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.example.catsapi.R
import com.example.catsapi.databinding.FragmentCatInfoBinding
import com.example.catsapi.databinding.FragmentMainBinding


class CatInfoFragment : Fragment(){

    private var _binding: FragmentCatInfoBinding? = null
    private val mBinding get() = _binding!!
    private val args by navArgs<CatInfoFragmentArgs>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentCatInfoBinding.inflate(layoutInflater, container, false)
        setHasOptionsMenu(true)
        mBinding.textView.setText(args.url)






        return mBinding.root
    }







    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}