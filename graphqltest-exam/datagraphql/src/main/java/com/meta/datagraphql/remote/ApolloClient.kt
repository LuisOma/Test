package com.meta.datagraphql.remote

import com.apollographql.apollo3.ApolloClient

object ApolloClient : NetworkClientProvider<ApolloClient> {

    override fun getBaseUrl() = "https://apollo-fullstack-tutorial.herokuapp.com/graphql"

    override fun getClient(): ApolloClient {
        return ApolloClient.Builder()
            .serverUrl(getBaseUrl())
            .build()
    }
}