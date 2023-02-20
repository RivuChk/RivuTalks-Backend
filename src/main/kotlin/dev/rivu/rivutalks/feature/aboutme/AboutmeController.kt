package dev.rivu.rivutalks.feature.aboutme

import dev.rivu.rivutalks.feature.aboutme.model.AboutMeResponse
import dev.rivu.rivutalks.response.HttpResponse
import dev.rivu.rivutalks.response.Success
import dev.rivu.rivutalks.utils.handleResponse

class AboutmeController {
    suspend fun getAboutMe(): HttpResponse<AboutMeResponse> = handleResponse {


        Success(
            AboutMeResponse(
                headline = "India's first GDE (Google Dev Expert) for Kotlin | Android Architect @ Viacom18 | Ex @ Meesho, Gojek Tech, Paytm Chat, Paytm Insider, Paytm Movies, BYJU'S | Tech Speaker | Author",
                aboutMeDetails = """Rivu Chakraborty, is an ADHDer (diagnosed) who may be on the Autism (undiagnosed, yet) spectrum as well. He is a community person, an Android & Kotlin developer, one of the early adopters of Kotlin. **India's first GDE (Google Developers Expert) for Kotlin [(https://developers.google.com/community/experts/directory/profile/profile-rivu-chakraborty)](https://developers.google.com/community/experts/directory/profile/profile-rivu-chakraborty)**.

Rivu is currently working as **Senior Manager / Android Architect** at **[Viacom18](https://www.viacom18.com/)**.
He has previously worked with many leading startups in India and South-East Asia as listed below.
- As **SDE-4 / Lead Engineer (Android)** at **[Meesho (FashNear Technologies Pvt. Ltd.)](https://meesho.io/)**. 
- As **Senior Android Developer - L3** at **[Gojek (GoProducts Engineering India LLP)](https://www.gojek.io/)**.
- As **Android Architect** at **[Paytm Insider & Paytm (Chat, Movies, Events)](https://paytm.com/)**.
- As **Sr. Software Engineer (Android)** at **[BYJU'S The Learning App](https://byjus.com/)**.

He has authored multiple Kotlin and Android Development books including [Reactive Programming in Kotlin](https://www.packtpub.com/application-development/reactive-programming-kotlin), [Functional Kotlin](https://www.packtpub.com/application-development/functional-kotlin), [Hands-On Data Structures and Algorithms with Kotlin](https://www.packtpub.com/application-development/hands-data-structures-and-algorithms-kotlin) etc.

Rivu considers himself a Kotlin and Android enthusiast cum evangelist. He has been using Kotlin since December 2015. Rivu created the **KotlinKolkata User Group** and before moving out to Bangalore, he had been the lead organiser for both **Kotlin Kolkata User Group** and **GDG Kolkata**. He now co-organizes **BlrKotlin** and volunteers for **BlrDroid** events.

Along with organising events, he also speaks at events, conferences and meetups.

### For more details on him, and to read his blogs, please visit [rivu.dev](https://rivu.dev) and [rivu.life](https://rivu.life)
                """.trimIndent(),
            )
        )
    }
}