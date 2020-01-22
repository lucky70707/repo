package pizza.summersolutions.popularmovieskotlin

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MoviesApi {
    companion object{
        private const val baseUrl = "https://api.themoviedb.org/3/discover/"
        //api key 5594a89abcc1d72c9754d36bc3ce1dd0

       fun  createApi(): MoviesApiService{
            val okHttpClient = OkHttpClient.Builder()
                .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)).build()

           val moviesApi = Retrofit.Builder()
               .baseUrl(baseUrl)
               .client(okHttpClient)
               .addConverterFactory(GsonConverterFactory.create())
               .build()

           return moviesApi.create(MoviesApiService::class.java)
        }
    }
}