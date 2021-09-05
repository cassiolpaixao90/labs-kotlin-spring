package br.com.cassiopaixao.forum.exceptions

import java.lang.RuntimeException

class NotFoundException(message: String?) : RuntimeException(message)
