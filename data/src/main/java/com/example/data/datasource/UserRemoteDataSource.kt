package com.example.data.datasource

import com.example.data.converters.Converters
import com.example.data.source.remote.retrofit.WebServiceApi
import com.example.dominio.datasource.IUserDomainRemoteDataSource
import com.example.dominio.model.UserDomain
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.withContext


class UserRemoteDataSource(private val webServiceApi: WebServiceApi) : IUserDomainRemoteDataSource {

    private var converters: Converters

    init {
        converters = Converters()
    }

    override suspend fun getUsers(): List<UserDomain> {

        var users: List<UserDomain> = listOf()

        if (webServiceApi.getUser().isSuccessful) {
            users = webServiceApi.getUser().body()?.let {
                it.let {
                    it.map {
                        converters.userDtoToDomain(it)
                    }
                }
            } ?: listOf()
        }

        users.forEach {
            withContext(Dispatchers.IO) {
                async {
                    val postByUser = webServiceApi.getAllPostsUser(it.id)
                    it.posts = postByUser.body().let {
                        it?.map {
                            converters.userPostsDtoToDomain(it)
                        } ?: listOf()
                    }
                }.await()
            }
        }
        return users
    }

}
