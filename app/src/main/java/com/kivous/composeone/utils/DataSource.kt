package com.kivous.composeone.utils

data class User(
    val description: String? = null
)

fun userData(): List<User> {
    return listOf(
        User(
            "Lorem Ipsum is simply dummy text of the printing and typesetting industry." + " Lorem Ipsum typesetting, remaining essentially unchanged. It was popularised in " + "the 1960s with the release of Letraset sheets containing."
        ),
        User(
            "Lorem Ipsum is simply dummy text of the printing and typesetting industry." + " Lorem Ipsum typesetting, remaining essentially unchanged. It was popularised in " + "the 1960s with the release of Letraset sheets containing."
        ),
        User(
            "Lorem Ipsum is simply dummy text of the printing and typesetting industry." + " Lorem Ipsum typesetting, remaining essentially unchanged. It was popularised in " + "the 1960s with the release of Letraset sheets containing."
        ),
        User(
            "Lorem Ipsum is simply dummy text of the printing and typesetting industry." + " Lorem Ipsum typesetting, remaining essentially unchanged. It was popularised in " + "the 1960s with the release of Letraset sheets containing."
        ),
        User(
            "Lorem Ipsum is simply dummy text of the printing and typesetting industry." + " Lorem Ipsum typesetting, remaining essentially unchanged. It was popularised in " + "the 1960s with the release of Letraset sheets containing."
        ),
        User(
            "Lorem Ipsum is simply dummy text of the printing and typesetting industry." + " Lorem Ipsum typesetting, remaining essentially unchanged. It was popularised in " + "the 1960s with the release of Letraset sheets containing."
        ),
    )
}