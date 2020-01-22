package pizza.summersolutions.popularmovieskotlin



class MoviesRepository {
    private val moviesApi:MoviesApiService = MoviesApi.createApi()
    fun getMovies(year: Int) = moviesApi.getMoviesInYear(year)
}