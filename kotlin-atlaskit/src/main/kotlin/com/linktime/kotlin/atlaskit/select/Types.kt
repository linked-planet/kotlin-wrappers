package com.linktime.kotlin.atlaskit.select

import kotlin.js.Json

data class SelectOption(val label: String, val value: String)

data class SelectStyles(
    val clearIndicator: (Json, dynamic) -> Json = provided,
    val container: (Json, dynamic) -> Json = provided,
    val control: (Json, dynamic) -> Json = provided,
    val dropdownIndicator: (Json, dynamic) -> Json = provided,
    val group: (Json, dynamic) -> Json = provided,
    val groupHeading: (Json, dynamic) -> Json = provided,
    val indicatorsContainer: (Json, dynamic) -> Json = provided,
    val indicatorSeparator: (Json, dynamic) -> Json = provided,
    val input: (Json, dynamic) -> Json = provided,
    val loadingIndicator: (Json, dynamic) -> Json = provided,
    val loadingMessage: (Json, dynamic) -> Json = provided,
    val menu: (Json, dynamic) -> Json = provided,
    val menuList: (Json, dynamic) -> Json = provided,
    val menuPortal: (Json, dynamic) -> Json = provided,
    val multiValue: (Json, dynamic) -> Json = provided,
    val multiValueLabel: (Json, dynamic) -> Json = provided,
    val multiValueRemove: (Json, dynamic) -> Json = provided,
    val noOptionsMessage: (Json, dynamic) -> Json = provided,
    val option: (Json, dynamic) -> Json = provided,
    val placeholder: (Json, dynamic) -> Json = provided,
    val singleValue: (Json, dynamic) -> Json = provided,
    val valueContainer: (Json, dynamic) -> Json = provided
) {
    private companion object {
        val provided: (Json, dynamic) -> Json = { provided, _ -> provided }
    }
}
