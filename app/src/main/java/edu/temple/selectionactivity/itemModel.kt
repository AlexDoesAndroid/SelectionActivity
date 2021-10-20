package edu.temple.selectionactivity

import androidx.lifecycle.LiveData

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel


class itemModel: ViewModel() {

    val itemLiveData: MutableLiveData<Item> = MutableLiveData<Item>()

    fun getItem(): LiveData<Item>? {
        itemLiveData
        return itemLiveData
    }

    fun setItem(_item : Item){
        itemLiveData
        itemLiveData.value = _item
    }




}