package jjtelechea.example.basesatejuapp.data.api

import jjtelechea.example.basesatejuapp.data.api.response.SatejuCommentDTO
import jjtelechea.example.basesatejuapp.data.api.response.SatejuPostDTO
import retrofit2.http.GET
import retrofit2.http.Query

interface SatejuService {

    @GET("posts")
    fun getPosts() : List<SatejuPostDTO>

    @GET("comments")
    fun getComments(@Query("postId") id: Int): List<SatejuCommentDTO>
}