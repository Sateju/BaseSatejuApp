package jjtelechea.example.basesatejuapp.data.api.response

data class SatejuComment(
    val postId: Int,
    val id: Int,
    val name: String,
    val email: String,
    val body: String
)