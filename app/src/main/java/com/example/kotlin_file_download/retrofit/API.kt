package com.example.kotlin_file_download.retrofit


import retrofit2.Call
import retrofit2.http.*
import java.io.File


interface API {
    @FormUrlEncoded
    @POST("NoticeDownloadS")
    fun getFileType(@Field("id") id: String?): retrofit2.Call<String>


}