package {{cookiecutter.package_name}}.model

import kotlinx.serialization.Serializable

@Serializable
data class SampleModel(
        val id: String,
        val data: String,
        val detailsText: String
)