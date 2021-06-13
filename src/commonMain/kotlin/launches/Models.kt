package com.haroldadmin.spacexkmp.launches

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

public enum class DatePrecision {
    half, quarter, year, month, day, hour
}

@Serializable
public data class Failure(
    val time: Long?,
    val altitude: Long?,
    val reason: String?
)

@Serializable
public data class Fairings(
    val reused: Boolean?,
    val recoveryAttempt: Boolean?,
    val recovered: Boolean?,
    val ships: List<String>
)

@Serializable
public data class Core(
    val core: String?,
    val flight: Int?,
    val gridfins: Boolean?,
    val legs: Boolean?,
    val reused: Boolean?,
    @SerialName("landing_attempt")
    val landingAttempt: Boolean?,
    @SerialName("landing_success")
    val landingSuccess: Boolean?,
    @SerialName("landing_type")
    val landingType: String?,
    val landpad: String?
)

@Serializable
public data class LaunchPatch(
    val small: String?,
    val large: String?
)

@Serializable
public data class RedditLinks(
    val campaign: String?,
    val launch: String?,
    val media: String?,
    val recovery: String?,
)

@Serializable
public data class FlickrLinks(
    val small: List<String>?,
    val original: List<String>?,
)

@Serializable
public data class LaunchLinks(
    val patch: LaunchPatch?,
    val reddit: RedditLinks,
    val flickr: FlickrLinks,
    val presskit: String?,
    val webcast: String?,
    @SerialName("youtube_id")
    val youtubeId: String?,
    val article: String?,
    val wikipedia: String?,
)

@Serializable
public data class Launch(
    val id: String,
    @SerialName("flight_number")
    val flightNumber: Int,
    val name: String,
    @SerialName("date_utc")
    val dateUtc: String,
    @SerialName("date_unix")
    val dateUnix: Long,
    @SerialName("date_local")
    val dateLocal: String,
    @SerialName("date_precision")
    val datePrecision: DatePrecision,
    @SerialName("static_fire_date_utc")
    val staticFireDateUtc: String?,
    @SerialName("static_fire_date_unix")
    val staticFireDateUnix: Long?,
    val tdb: Boolean,
    val net: Boolean,
    val window: Long?,
    val rocket: String?,
    val success: Boolean?,
    val failures: List<Failure>?,
    val upcoming: Boolean,
    val details: String?,
    val fairings: Fairings?,
    val crew: List<String>?,
    val ships: List<String>?,
    val capsules: List<String>?,
    val payloads: List<String>?,
    val launchpad: String?,
    val cores: List<Core>?,
    val links: LaunchLinks?,
    @SerialName("auto_update")
    val autoUpdate: Boolean
)
