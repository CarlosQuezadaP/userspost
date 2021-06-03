package com.example.userposts.di

import com.example.userposts.viewmodels.PostViewModel
import com.example.userposts.viewmodels.UserViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val userViewmodel = module {
    viewModel {
        UserViewModel(get())
    }
}

val userPostsViewmodel = module {
    viewModel {
        PostViewModel(get())
    }
}
