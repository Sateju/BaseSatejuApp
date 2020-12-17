package jjtelechea.example.basesatejuapp.data.api.mapper

import jjtelechea.example.basesatejuapp.data.api.response.SatejuPostDTO
import jjtelechea.example.basesatejuapp.data.database.entity.SatejuPostEntity

fun SatejuPostDTO.toSatejuPostEntity() = SatejuPostEntity(
    id = id,
    title = title,
    body = body
)