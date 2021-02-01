package jjtelechea.example.basesatejuapp.data.api.response

import jjtelechea.example.basesatejuapp.data.api.serializer.ChampionListSerializer
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ChampionResponseDTO(
    @SerialName("type") val type: String,
    @SerialName("format") val format: String,
    @SerialName("version") val version: String,
    @Serializable(with = ChampionListSerializer::class)
    @SerialName("data") val data: List<ChampionDTO>,
)

@Serializable
data class ChampionDTO(
    @SerialName("version") val version: String?,
    @SerialName("id") val id: String?,
    @SerialName("key") val key: String?,
    @SerialName("name") val name: String?,
    @SerialName("title") val title: String?,
    @SerialName("blurb") val blurb: String?,
    @SerialName("info") val info: ChampionInfoDTO?,
    @SerialName("image") val image: ChampionImageDTO?,
    @SerialName("tags") val tags: List<String>?,
    @SerialName("partype") val parType: String?,
    @SerialName("stats") val stats: ChampionStatsDTO?
)

@Serializable
data class ChampionInfoDTO(
    @SerialName("attack") val attack: Int?,
    @SerialName("defense") val defense: Int?,
    @SerialName("magic") val magic: Int?,
    @SerialName("difficulty") val difficulty: Int?,
)

@Serializable
data class ChampionImageDTO(
    @SerialName("full") val full: String?,
    @SerialName("sprite") val sprite: String?,
    @SerialName("group") val group: String?,
    @SerialName("x") val x: Int?,
    @SerialName("y") val y: Int?,
    @SerialName("w") val width: Int?,
    @SerialName("h") val height: Int?,
)

@Serializable
data class ChampionStatsDTO(
    @SerialName("hp") val hitPoints: Float?,
    @SerialName("hpperlevel") val hitPointsPerLevel: Float?,
    @SerialName("mp") val manaPoints: Float?,
    @SerialName("mpperlevel") val manaPointsPerLevel: Float?,
    @SerialName("movespeed") val movementSpeed: Int?,
    @SerialName("armor") val armor: Int?,
    @SerialName("armorperlevel") val armorPerLevel: Float?,
    @SerialName("spellblock") val spellBlock: Float?,
    @SerialName("spellblockperlevel") val spellBlockPerLevel: Float?,
    @SerialName("attackrange") val attackRange: Int?,
    @SerialName("hpregen") val hitPointsRegeneration: Float?,
    @SerialName("hpregenperlevel") val hitPointsRegenerationPerLevel: Float?,
    @SerialName("mpregen") val manaRegeneration: Float?,
    @SerialName("mpregenperlevel") val manaRegenerationPerLevel: Float?,
    @SerialName("crit") val critical: Float?,
    @SerialName("critperlevel") val criticalPeLevel: Float?,
    @SerialName("attackdamage") val attackDamage: Float?,
    @SerialName("attackdamageperlevel") val attackDamagePerLevel: Float?,
    @SerialName("attackspeedperlevel") val attackSpeedPerLevel: Float?,
    @SerialName("attackspeed") val attackSpeed: Float?,
)