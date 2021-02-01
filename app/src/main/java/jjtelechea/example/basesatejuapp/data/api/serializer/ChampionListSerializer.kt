package jjtelechea.example.basesatejuapp.data.api.serializer

import jjtelechea.example.basesatejuapp.data.api.response.ChampionDTO
import kotlinx.serialization.builtins.ListSerializer
import kotlinx.serialization.json.JsonArray
import kotlinx.serialization.json.JsonElement
import kotlinx.serialization.json.JsonObject
import kotlinx.serialization.json.JsonTransformingSerializer

/**
 * Custom serializer because the API Json has the list with {} instead of [].
 */
object ChampionListSerializer : JsonTransformingSerializer<List<ChampionDTO>>
    (ListSerializer(ChampionDTO.serializer())) {

    override fun transformDeserialize(element: JsonElement): JsonElement {
        return JsonArray((element as JsonObject).values.map { it })
    }
}