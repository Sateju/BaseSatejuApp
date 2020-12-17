package jjtelechea.example.basesatejuapp.data.api.response

data class SatejuCommentDTO(
    val postId: Int,
    val id: Int,
    val name: String,
    val email: String,
    val body: String
)