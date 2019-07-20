package br.com.devlfernando.pokermao.api

import br.com.devlfernando.pokermao.model.Health
import retrofit2.Call
import retrofit2.http.GET


/**

 * Criado por Luis Fernando F. Araujo em 2019-07-20

 **/

interface PokemonService {
    @GET("/api/pokemon/health")
    fun checkHealth() : Call<Health>
}