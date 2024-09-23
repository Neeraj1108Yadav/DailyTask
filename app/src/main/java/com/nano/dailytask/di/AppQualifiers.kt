package com.nano.dailytask.di

import javax.inject.Qualifier

/**
 * Created By Neeraj Yadav on 23/09/24
 */

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class QualifierLocalRepo

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class QualifierNetworkRepo

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class QualifierProductRepo