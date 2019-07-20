package br.com.devlfernando.pokermao.repository

import br.com.devlfernando.pokermao.api.PokemonService
import br.com.devlfernando.pokermao.model.Health
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


/**

 * Criado por Luis Fernando F. Araujo em 2019-07-20

 **/

class PokemonRepoImpl(private val pokemonService: PokemonService) : PokemonRepo {
    override fun checkHealth(onComplete: () -> Unit, onError: (t: Throwable) -> Unit) {
        pokemonService
                .checkHealth()
                .enqueue(object:Callback<Health> {
                    override fun onFailure(call: Call<Health>, t: Throwable) {
                        onError(t)
                    }

                    override fun onResponse(call: Call<Health>, response: Response<Health>) {
                        if(response.isSuccessful)
                            onComplete()
                        else
                            onError(Throwable("Não foi possível realizar a requisição"))
                    }
                })
    }
}

