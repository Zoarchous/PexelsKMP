package com.innowise.pexelskmp.android.photo_list

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import com.innowise.pexelskmp.domain.photo.model.Photo
import com.innowise.pexelskmp.domain.photo.useCases.GetCuratedPhotosUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PhotoListViewModel @Inject constructor(
    private val getCuratedPhotosUseCase: GetCuratedPhotosUseCase,
) : ViewModel() {
    var photosState: Flow<PagingData<Photo>>? = null
    fun loadCuratedPhotos() = viewModelScope.launch {
        Log.d("!!!", "Called")
        photosState = getCuratedPhotosUseCase.getCuratedPhotos()
    }
}