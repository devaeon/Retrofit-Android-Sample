package com.devaeon.retrofit.model

import com.google.gson.annotations.SerializedName


/**
 * Represents a web link associated with a project.
 *
 * @property name The name of the web link (e.g., "browse").
 * @property url The URL path of the web link.
 * @property target Specifies how the link should be opened (e.g., "_blank").
 */
data class WebLink(
    @SerializedName("name") val name: String,
    @SerializedName("url") val url: String,
    @SerializedName("target") val target: String
)

/**
 * Represents a project fetched from the Eclipse API.
 *
 * @property id The unique identifier of the project (e.g., "4diac/org.eclipse.4diac.examples").
 * @property state The current state of the project (e.g., "READ_ONLY" or "ACTIVE").
 * @property webLinks A list of associated web links for the project.
 */
data class Project(
    @SerializedName("id") val id: String,
    @SerializedName("state") val state: String,
    @SerializedName("web_links") val webLinks: List<WebLink>
)


