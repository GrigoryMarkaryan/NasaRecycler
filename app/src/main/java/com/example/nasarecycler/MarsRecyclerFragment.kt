package com.example.nasarecycler

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.GridLayoutManager
import com.bumptech.glide.Glide
import com.example.nasarecycler.databinding.FragmentMarsRecyclerBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MarsRecyclerFragment : Fragment() {
    private var _binding: FragmentMarsRecyclerBinding? = null
    val binding get() = _binding!!

    val myViewModel = MarsViewModel()

    val photoAdapter = MarsPhotoAdapter()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMarsRecyclerBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        lifecycleScope.launchWhenStarted {
//            photoAdapter.getPhotos()
//        }

        lifecycleScope.launchWhenCreated {
            photoAdapter.getPhotos()
        }

//        lifecycleScope.launch {
//            repeatOnLifecycle(Lifecycle.State.CREATED) {
//                photoAdapter.getPhotos()
//            }
//        }

//        viewLifecycleOwner.lifecycleScope.launch {
//            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
//                photoAdapter.getPhotos()
//            }
//        }

        binding.recycler.layoutManager = GridLayoutManager(
            requireContext(),
            3,
            GridLayoutManager.VERTICAL,
            false
        )

        binding.recycler.adapter = photoAdapter

        binding.btn.setOnClickListener {
            lifecycleScope.launchWhenCreated {
                photoAdapter.getPhotos()
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}