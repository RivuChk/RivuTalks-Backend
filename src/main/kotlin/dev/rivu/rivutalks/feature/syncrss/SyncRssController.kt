package dev.rivu.rivutalks.feature.syncrss

import com.fasterxml.jackson.databind.DeserializationFeature
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.json.JsonMapper
import com.fasterxml.jackson.dataformat.xml.XmlMapper
import com.fasterxml.jackson.module.kotlin.KotlinModule
import dev.rivu.rivutalks.feature.blogs.BlogsService
import dev.rivu.rivutalks.feature.blogs.models.AddBlog
import dev.rivu.rivutalks.feature.blogs.models.AddSite
import dev.rivu.rivutalks.feature.blogs.models.BlogListResponse
import dev.rivu.rivutalks.feature.syncrss.model.RSSFeed
import dev.rivu.rivutalks.response.HttpResponse
import dev.rivu.rivutalks.response.Success
import dev.rivu.rivutalks.utils.handleResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.net.URL
import java.text.SimpleDateFormat

class SyncRssController(
    //private val parser: Parser<RivuChannel>,
    private val blogsService: BlogsService
) {

    suspend fun getAllRss(): HttpResponse<BlogListResponse> = handleResponse {
        getRss("https://rivu.dev/rss")
        getRss("https://rivu.life/rss")
        Success(BlogListResponse(blogsService.getAllBlogs()))
    }

    suspend fun getRss(urlStr: String) {
        val url = URL(urlStr)
        val rssFeedStream = withContext(Dispatchers.IO) {
            url.openStream()
        }

        try {
            val dateFormatter = SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss zzzz")

            val kotlinModule = KotlinModule.Builder()
                .build()

            val xmlMapper = XmlMapper()
            val jsonMapper: ObjectMapper = JsonMapper.builder()
                .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
                .addModule(kotlinModule)
                .build()

            val json: String = jsonMapper.writeValueAsString(xmlMapper.readTree(rssFeedStream))

            val rssFeedObject = jsonMapper.readValue(json, RSSFeed::class.java)

            val channel = rssFeedObject.channel

            val items = channel?.item?.map {
                AddBlog(
                    title = it.title ?: "",
                    summary = it.description ?: "",
                    featureImage = it.content?.url ?: "",
                    url = it.link ?: "",
                    publishDate = dateFormatter.parse(it.pubDate).toInstant().toEpochMilli(),
                    site = AddSite(
                        title = channel.title ?: "",
                        url = urlStr.substringBefore("/rss"),
                        description = channel.description ?: ""
                    )
                )
            }

            if (items != null && items.isNotEmpty()) {
                blogsService.addBlogs(items)
            }

        } finally {
            withContext(Dispatchers.IO) {
                rssFeedStream.close()
            }
        }

    }
}