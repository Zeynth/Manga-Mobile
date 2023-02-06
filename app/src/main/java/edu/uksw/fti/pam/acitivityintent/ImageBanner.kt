package edu.uksw.fti.pam.acitivityintent

data class ImageBanner(
    val imgUri:Int
)

val ImageBannerList = listOf(
    ImageBanner(
        R.drawable.onepiecebanner
    ),
    ImageBanner(
        R.drawable.jujutsubanner
    ),
    ImageBanner(
        R.drawable.kimetsubanner
    )
)