package br.com.cassiopaixao.forum.mapper

interface Mapper<T, U> {
    fun map(t: T): U
}